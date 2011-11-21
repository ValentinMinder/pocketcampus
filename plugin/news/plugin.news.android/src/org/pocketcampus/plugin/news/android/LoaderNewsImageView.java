package org.pocketcampus.plugin.news.android;

import java.io.IOException;
import java.net.MalformedURLException;

import org.pocketcampus.android.platform.sdk.utils.LoaderImageView;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Free for anyone to use, just say thanks and share :-)
 * 
 * @author Blundell
 * 
 */
public class LoaderNewsImageView extends LinearLayout {

	private static final int COMPLETE = 0;
	private static final int FAILED = 1;

	private Context mContext;
	private Drawable mDrawable;
	private ProgressBar mSpinner;
	private ImageView mImage;

	private NewsItemWithImage mNewsItem;

	/**
	 * This is used when creating the view programatically Once you have
	 * instantiated the view you can call setImageDrawable(url) to change the
	 * image
	 * 
	 * @param context
	 *            the Activity context
	 * @param imageUrl
	 *            the Image URL you wish to load
	 */
	public LoaderNewsImageView(final Context context, NewsItemWithImage newsItem) {
		super(context);
		instantiate(context, newsItem.getNewsItem().getImageUrl());
		this.mNewsItem = newsItem;
	}

	/**
	 * First time loading of the LoaderImageView Sets up the LayoutParams of the
	 * view, you can change these to get the required effects you want
	 */
	private void instantiate(final Context context, final String imageUrl) {
		mContext = context;

		mImage = new ImageView(mContext);
		mImage.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));

		mSpinner = new ProgressBar(mContext);
		mSpinner.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		mSpinner.setPadding(5, 5, 5, 5);

		mSpinner.setIndeterminate(true);

		addView(mSpinner);
		addView(mImage);

		if (imageUrl != null) {
			setImageDrawable(imageUrl);
		}
	}

	/**
	 * Set's the view's drawable, this uses the internet to retrieve the image
	 * don't forget to add the correct permissions to your manifest
	 * 
	 * @param imageUrl
	 *            the url of the image you wish to load
	 */
	public void setImageDrawable(final String imageUrl) {
		mDrawable = null;
		mSpinner.setVisibility(View.VISIBLE);
		mImage.setVisibility(View.GONE);
		new Thread() {
			public void run() {
				try {
					Log.d(LoaderImageView.class.toString(), "Loading "
							+ imageUrl);
					mDrawable = getDrawableFromUrl(imageUrl);
					Log.d(LoaderImageView.class.toString(), "Loaded "
							+ imageUrl);
					imageLoadedHandler.sendEmptyMessage(COMPLETE);
				} catch (MalformedURLException e) {
					imageLoadedHandler.sendEmptyMessage(FAILED);
					Log.d(LoaderImageView.class.toString(), "Could not load "
							+ imageUrl);
				} catch (IOException e) {
					imageLoadedHandler.sendEmptyMessage(FAILED);
					Log.d(LoaderImageView.class.toString(), "Could not load "
							+ imageUrl);
				}
			};
		}.start();
	}

	public void setNoImage() {
		mDrawable = null;
		mSpinner.setVisibility(View.GONE);
		mImage.setVisibility(View.GONE);
	}

	/**
	 * Callback that is received once the image has been downloaded
	 */
	private final Handler imageLoadedHandler = new Handler(new Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			switch (msg.what) {
			case COMPLETE:
				mImage.setImageDrawable(mDrawable);
				mImage.setVisibility(View.VISIBLE);
				mSpinner.setVisibility(View.GONE);
				mNewsItem.setDrawable(((BitmapDrawable) mDrawable).getBitmap());
				break;
			case FAILED:
			default:
				// Could change image here to a 'failed' image
				// otherwise will just keep on spinning
				break;
			}
			return true;
		}
	});

	/**
	 * Pass in an image url to get a drawable object
	 * 
	 * @return a drawable object
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	private static Drawable getDrawableFromUrl(final String url)
			throws IOException, MalformedURLException {
		return Drawable
				.createFromStream(((java.io.InputStream) new java.net.URL(url)
						.getContent()), url);
	}

}
