package org.pocketcampus.plugin.camipro.android;

import java.util.Date;
import java.util.List;

import org.pocketcampus.R;
import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginView;
import org.pocketcampus.plugin.camipro.android.iface.ICamiproModel;
import org.pocketcampus.plugin.camipro.android.iface.ICamiproView;
import org.pocketcampus.plugin.camipro.shared.CardLoadingWithEbankingInfo;
import org.pocketcampus.plugin.camipro.shared.CardStatistics;
import org.pocketcampus.plugin.camipro.shared.Transaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CamiproMainView extends PluginView implements ICamiproView {

	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return CamiproController.class;
	}

	@Override
	protected void onDisplay(Bundle savedInstanceState, PluginController controller) {
		// Get and cast the controller and model
		mController = (CamiproController) controller;
		mModel = (CamiproModel) controller.getModel();

		// The StandardLayout is a RelativeLayout with a TextView in its center.
		//mLayout = new StandardLayout(this);

		// The ActionBar is added automatically when you call setContentView
		//setContentView(mLayout);
		setContentView(R.layout.camipro_main);

		//mLayout.setText("Loading");
		//refreshAll();
	}
	
	@Override
	protected void handleIntent(Intent aIntent) {
		// If we were pinged by auth plugin, then we must read the sessId
		if(aIntent != null && Intent.ACTION_VIEW.equals(aIntent.getAction())) {
			Uri aData = aIntent.getData();
			if(aData != null && "pocketcampus-authenticate".equals(aData.getScheme())) {
				String sessId = aData.getQueryParameter("sessid");
				mController.setCamiproCookie(sessId);
				refreshAll();
			}
		}
		// Otherwise continue normal start-up
		// Check if we are not signed in then ping the auth plugin
		if(mController.getCamiproCookie() == null) {
			Intent authIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("pocketcampus-authenticate://authentication.plugin.pocketcampus.org/do_auth?service=camipro"));
			startActivity(authIntent);
		}
	}

	@Override
	public void transactionsUpdated() {
		List<Transaction> ltb = mModel.getTransactions();
		ListView lv = (ListView) findViewById(R.id.camipro_list);

		// Create an adapter for the data
		lv.setAdapter(new TransactionAdapter(getApplicationContext(), R.layout.camipro_transaction, ltb));
	}

	@Override
	public void balanceUpdated() {
		TextView balance = (TextView) findViewById(R.id.camipro_balance_number);
		balance.setText(formatMoney(mModel.getBalance()));

		// Last update
		String date = new Date().toLocaleString();
		balance = (TextView) findViewById(R.id.camipro_balance_date_text);
		balance.setText(date);
	}

	@Override
	public void cardLoadingWithEbankingInfoUpdated() {
		CardLoadingWithEbankingInfo i = mModel.getCardLoadingWithEbankingInfo();
		
		TextView tv = (TextView) findViewById(R.id.camipro_ebanking_paid_to_text);
		tv.setText(i.getIPaidTo());

		tv = (TextView) findViewById(R.id.camipro_ebanking_account_number_text);
		tv.setText(i.getIAccountNumber());

		tv = (TextView) findViewById(R.id.camipro_ebanking_ref_number_text);
		tv.setText(i.getIReferenceNumber());
	}

	@Override
	public void cardStatisticsUpdated() {
		CardStatistics s = mModel.getCardStatistics();
		
		TextView tv = (TextView) findViewById(R.id.camipro_ebanking_1month_text);
		tv.setText(formatMoney(s.getITotalPaymentsLastMonth()));

		tv = (TextView) findViewById(R.id.camipro_ebanking_3months_text);
		tv.setText(formatMoney(s.getITotalPaymentsLastThreeMonths()));

		tv = (TextView) findViewById(R.id.camipro_ebanking_average_text);
		tv.setText(formatMoney(s.getITotalPaymentsLastThreeMonths() / 3.0));
	}

	
	private void refreshAll() {
		mController.refreshBalanceAndTransactions();
		mController.refreshStatsAndLoadingInfo();
	}
	
	private static String formatMoney(double money) {
		return String.format("CHF %.2f", money);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.camipro_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		
		if(item.getItemId() == R.id.camipro_refresh) {			
			refreshAll();
		}
		

		return true;
	}
	
	@Override
	public void networkErrorHappened() {
		Toast.makeText(getApplicationContext(), "Network error!", Toast.LENGTH_SHORT).show();
	}

	private CamiproController mController;
	private ICamiproModel mModel;

	
	
	
	
	
	
		
		
	// TODO remove this class from here
	
	public class TransactionAdapter extends ArrayAdapter<Transaction> {
		private LayoutInflater li_;
		//private java.text.DateFormat df_; // Used to format the date
		private Context context_;
	
		// Colors
		private int minus_;
		private int plus_;
		
		/**
		 * Adapter constructor
		 * @param context The Camipro plugin
		 * @param textViewResourceId Layout for a row in the list
		 * @param transactions List of transactions
		 */
		public TransactionAdapter(Context context, int textViewResourceId, List<Transaction> transactions) {
			super(context, textViewResourceId, transactions);
			li_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			//df_ = DateFormat.getDateFormat(context);
			context_ = context;
	
			minus_ = context_.getResources().getColor(R.color.camipro_minus);
			plus_ = context_.getResources().getColor(R.color.camipro_plus);
		}
	
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
	        if (v == null) {
	            v = li_.inflate(R.layout.camipro_transaction, null);
	        }
	        Transaction t = getItem(position);
	        
	        TextView tv;
	
	        tv = (TextView)v.findViewById(R.id.camipro_item_date);
	        tv.setText(t.getIDate());
	        
	        tv = (TextView)v.findViewById(R.id.camipro_item_description);
	        tv.setText(t.getIPlace());
	        
	        tv = (TextView)v.findViewById(R.id.camipro_item_amount);
	        tv.setText(formatMoney(t.getIAmount()));
	        tv.setTextColor(t.getIAmount() < 0.0 ? minus_ : plus_);
	        
	        return v;
		}
	}









	
}
