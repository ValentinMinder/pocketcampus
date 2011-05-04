package org.pocketcampus.plugin.food.pictures;

/**
 * In charge of taking a picture and sending it out to the server.
 * Activity won't actually be displaying anything, just waiting to handle 
 * the Android camera activity result.
 *  
 * @author Elodie
 * @status working
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.pocketcampus.core.communication.DataRequest;
import org.pocketcampus.core.communication.RequestParameters;
import org.pocketcampus.plugin.food.FoodPlugin;
import org.pocketcampus.shared.plugin.food.Meal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

public class PictureTaker {
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1337;
	private static Uri imageUri;
	private static Meal meal_;
	private static Activity context_;
	private static PictureType type_;

	public PictureTaker(Activity callingActivity, Meal meal, PictureType type) {
		context_ = callingActivity;
		meal_ = meal;
		type_ = type;
	}

	public void takePicture() {
		// define the file-name to save photo taken by Camera activity
		String fileName = "new-photo-name.jpg";
		// create parameters for Intent with filename
		ContentValues values = new ContentValues();
		values.put(MediaStore.Images.Media.TITLE, fileName);
		values.put(MediaStore.Images.Media.DESCRIPTION,
				"Image capture by camera");
		// imageUri is the current activity attribute, define and save it for
		// later usage (also in onSaveInstanceState)
		imageUri = context_.getContentResolver().insert(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
		// create new Intent
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
		context_.startActivityForResult(intent,
				CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	}

	public static void onActivityResult(int requestCode, int resultCode,
			Intent data, boolean takingMealPicture) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				Bitmap myBitmap = null;
				if (data != null) {
					/*
					 * The following solves a problem encountered with Samsung,
					 * which gives resulting picture inside the bundle
					 */
					Bundle extras = data.getExtras();
					if (extras != null) {
						Log.d("Data extras", data.getExtras().keySet()
								.toString());
						Set<String> keySet = extras.keySet();
						for (String s : keySet) {
							Object path = extras.get(s);
							if (path instanceof Bitmap) {
								myBitmap = (Bitmap) path;
							}
							Log.d("Data extras", "key " + s);
							Log.d("Data extras", "path " + path.getClass());
						}
					}
				} else {
					/*
					 * On other phones, we get the uri to the image which was
					 * stored on the phone
					 */
					File myImage = convertImageUriToFile(imageUri, context_);
					myImage.setLastModified((new Date()).getTime());

					BitmapFactory.Options options = new BitmapFactory.Options();
					options.inSampleSize = 1;
					myBitmap = BitmapFactory.decodeFile(myImage
							.getAbsolutePath(), options);
				}

				ByteArrayOutputStream bytes = new ByteArrayOutputStream();

				myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
				myBitmap.recycle();

				// Send picture to server
				submitPicture(bytes.toByteArray(), meal_, type_);
				try {
					bytes.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (resultCode == Activity.RESULT_CANCELED) {
				Toast.makeText(context_, "Picture was not taken",
						Toast.LENGTH_SHORT);
			} else {
				Toast.makeText(context_, "Picture was not taken",
						Toast.LENGTH_SHORT);
			}
		}
	}

	/**
	 * Convert a Uri on the phone to the actual file where the picture is
	 * stored.
	 */
	public static File convertImageUriToFile(Uri imageUri, Activity activity) {
		Cursor cursor = null;
		try {
			String[] proj = { MediaStore.Images.Media.DATA,
					MediaStore.Images.Media._ID,
					MediaStore.Images.ImageColumns.ORIENTATION };
			cursor = activity.managedQuery(imageUri, proj, // Which columns to
					// return
					null, // WHERE clause; which rows to return (all rows)
					null, // WHERE clause selection arguments (none)
					null); // Order-by clause (ascending by name)
			int file_ColumnIndex = cursor
					.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			if (cursor.moveToFirst()) {
				return new File(cursor.getString(file_ColumnIndex));
			}
			return null;
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}

	// Submit picture to the server.
	private static void submitPicture(byte[] picture, Meal m, PictureType type) {
		class SubmitPictureRequest extends DataRequest {
			@Override
			protected void doInUiThread(String result) {
				if (result.contains("true")) {
					
				} else {
					
				}
			}
		}

		Gson gson = new Gson();
		String jsonPicture = gson.toJson(picture);
		String deviceId = Settings.Secure.ANDROID_ID;

		RequestParameters params = new RequestParameters();
		params.addParameter("meal", Integer.toString(m.hashCode()));
		params.addParameter("deviceId", deviceId);
		params.addParameter("pictureArray", jsonPicture);

		FoodPlugin.getFoodRequestHandler().execute(new SubmitPictureRequest(),
				"setPicture", (RequestParameters) params);
	}

	public enum PictureType {
		Meal, Queue
	}
}
