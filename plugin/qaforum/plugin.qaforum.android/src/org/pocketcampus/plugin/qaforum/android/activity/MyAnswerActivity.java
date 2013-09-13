package org.pocketcampus.plugin.qaforum.android.activity;

import org.json.JSONException;
import org.json.JSONObject;
import org.pocketcampus.plugin.qaforum.R;
import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginView;
import org.pocketcampus.plugin.qaforum.android.QAforumController;
import org.pocketcampus.plugin.qaforum.android.iface.IQAforumView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
/**
 * MyAnswerActivity - show my answer information.
 * 
 * This class shows the detailed information of 
 * one answer.
 *  
 * @author Susheng <susheng.shi@epfl.ch>
 * 
 */
public class MyAnswerActivity extends PluginView implements IQAforumView {
	private String msg;
	private JSONObject dataJsonObject;

	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return QAforumController.class;
	}

	@Override
	protected void onDisplay(Bundle savedInstanceState,
			PluginController controller) {

		if (getIntent().getExtras() != null) {
			msg = getIntent().getStringExtra("data");
			System.out.println(msg);
			try {
				dataJsonObject = new JSONObject(msg);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		//new version, which displays the view in three parts: question, answer, feedback
		setContentView(R.layout.qaforum_my_answer);
		
		TextView questionContent = (TextView) findViewById(R.id.TextView01);
		TextView questionTopic = (TextView) findViewById(R.id.textView3);
		TextView questionTag = (TextView) findViewById(R.id.textView4);
		TextView questionAuthor = (TextView) findViewById(R.id.textView5);
		TextView questionTime = (TextView) findViewById(R.id.textView6);
		
		TextView answerContent= (TextView) findViewById(R.id.textView7);
		TextView answerTime = (TextView) findViewById(R.id.textView8);
		
		TextView feedbackContent = (TextView) findViewById(R.id.textView10);
		TextView feedbackRate = (TextView) findViewById(R.id.textView11);
		
		try {
			questionContent.setText(dataJsonObject.getString("content"));
			questionTopic.setText(getResources().getString(R.string.qaforum_detail_topic)+": "+dataJsonObject.getString("topicid"));
			questionTag.setText(getResources().getString(R.string.qaforum_question_tags)+dataJsonObject.getString("tags"));
			questionAuthor.setText(getResources().getString(R.string.qaforum_by)+dataJsonObject.getString("asker"));
			questionTime.setText(dataJsonObject.getString("time"));
			
			answerContent.setText(dataJsonObject.getString("answer"));
			answerTime.setText(dataJsonObject.getString("answertime"));
			
			feedbackContent.setText(dataJsonObject.getString("feedback"));
			feedbackRate.setText(dataJsonObject.getString("rate"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Old version, which is inconsistant to other views.
		/*
		setContentView(R.layout.qaforum_list_main);

		TextView subTitleTextView = (TextView) findViewById(R.id.standard_titled_layout_title);
		subTitleTextView.setText(getString(R.string.qaforum_details_title));

		LinearLayout l = (LinearLayout) findViewById(R.id.mylayout1);
		LayoutInflater linflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		try {
			for (int i = 0; i < 9; i++) {
				View customView = linflater.inflate(R.layout.qaforum_one_item,
						null);

				TextView titleTextView = (TextView) customView
						.findViewById(R.id.TextView01);
				TextView contentTextView = (TextView) customView
						.findViewById(R.id.textView1);
				switch (i) {
				case 0:
					titleTextView.setText(getResources().getString(R.string.qaforum_question_single));
					contentTextView.setText(dataJsonObject.getString("content"));
					break;
				case 1:
					titleTextView.setText(getResources().getString(R.string.qaforum_detail_askname));
					contentTextView.setText(dataJsonObject.getString("asker"));
					break;
				case 2:
					titleTextView.setText(getResources().getString(R.string.qaforum_detail_topic));
					contentTextView
							.setText(dataJsonObject.getString("topicid"));
					break;
				case 3:
					titleTextView.setText(getResources().getString(R.string.qaforum_tags));
					contentTextView.setText(dataJsonObject.getString("tags"));
					break;
				case 4:
					titleTextView.setText(getResources().getString(R.string.qaforum_detail_asktime));
					contentTextView.setText(dataJsonObject.getString("time"));
					break;
				case 5:
					titleTextView.setText(getResources().getString(R.string.qaforum_answer));
					contentTextView.setText(dataJsonObject.getString("answer"));
					break;
				case 6:
					titleTextView.setText(getResources().getString(R.string.qaforum_detail_answertime));
					contentTextView.setText(dataJsonObject
							.getString("answertime"));
					break;
				case 7:
					titleTextView.setText(getResources().getString(R.string.qaforum_feedback));
					contentTextView.setText(dataJsonObject
							.getString("feedback"));
					break;
				case 8:
					titleTextView.setText(getResources().getString(R.string.qaforum_detail_rate));
					contentTextView.setText(dataJsonObject.getString("rate"));
					break;
				case 9:
					titleTextView.setText(getResources().getString(R.string.qaforum_detail_feedbacktime));
					contentTextView.setText(dataJsonObject
							.getString("feedbacktime"));
					break;
				default:
					break;
				}
				l.addView(customView);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		*/
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void networkErrorHappened() {
		Toast.makeText(
				getApplicationContext(),
				getResources().getString(
						R.string.qaforum_connection_error_happened),
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void gotRequestReturn() {
	}

	@Override
	public void messageDeleted() {
	}
	
	@Override
	public void loadingFinished() {
	}

	@Override
	public void authenticationFailed() {
		Toast.makeText(getApplicationContext(), getResources().getString(
				R.string.sdk_authentication_failed), Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void userCancelledAuthentication() {
		finish();
	}
}