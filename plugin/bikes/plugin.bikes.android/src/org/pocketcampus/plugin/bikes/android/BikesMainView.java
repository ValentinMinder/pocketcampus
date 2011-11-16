package org.pocketcampus.plugin.bikes.android;

import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginView;
import org.pocketcampus.android.platform.sdk.ui.labeler.ILabeler;
import org.pocketcampus.android.platform.sdk.ui.layout.StandardLayout;
import org.pocketcampus.android.platform.sdk.ui.list.LabeledListViewElement;
import org.pocketcampus.plugin.bikes.android.iface.IBikesView;
import org.pocketcampus.plugin.bikes.shared.BikeEmplacement;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BikesMainView extends PluginView implements IBikesView{

	private BikesController mController;
	private BikesModel mModel;
	
	private LabeledListViewElement mList;
	private StandardLayout mLayout;
	
	private OnItemClickListener oicl;

	/**
	 * Called once the view is connected to the controller.
	 * If you don't implement <code>getMainControllerClass()</code> 
	 * then the controller given here will simply be <code>null</code>.
	 */
	@Override
	protected void onDisplay(Bundle savedInstanceState, PluginController controller) {
		// Get and cast the controller and model
		mController = (BikesController) controller;
		mModel = (BikesModel) controller.getModel();
		
		mLayout = new StandardLayout(this);
		setContentView(mLayout);
		
		mController.getAvailableBikes();
		mLayout.setText("Loading");
		
		oicl = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View arg1, int pos, long arg3) {
				BikeEmplacement be = (BikeEmplacement) adapter.getItemAtPosition(pos);
				
				String ab;
				if(be.availableQuantity> 0)
					ab = "available bike";
				else
					ab = "availables bikes";
				
				String ep;
				if(be.empty > 0)
					ep = "empty bike slot";
				else
					ep = "empty bike slots";
				
				String msg = be.designation + " is at:\n" +
							"Lat: " + be.geoLat + "\n" +
							"Lon: " + be.geoLng + "\n" +
							"and has " + be.availableQuantity + ab +"\n" +
							"and " + be.empty + ep;
				
				Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
				toast.show();
			}
			
		};
		
		displayData();
		
	}
	
	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return BikesController.class;
	}
	
	private void displayData(){

		if(mModel.getAvailablesBikes().size() > 0)
			mLayout.setText("");
		
		
		TextView mText = new TextView(this);
		mText.setText("Place      available bikes");
		mText.setId(42);
		RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		textParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		mText.setLayoutParams(textParams);
		
		mList = new LabeledListViewElement(this, mModel.getAvailablesBikes(), labeler);
		mList.setOnItemClickListener(oicl);
		RelativeLayout.LayoutParams listParams = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		listParams.addRule(RelativeLayout.BELOW, mText.getId());
		mList.setLayoutParams(listParams);
		
		
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		mLayout.setLayoutParams(layoutParams);
		mLayout.addView(mText);
		mLayout.addView(mList);
		
	}
	
	ILabeler<BikeEmplacement> labeler = new ILabeler<BikeEmplacement>(){
		@Override
		public String getLabel(BikeEmplacement obj) {
			String nice;
			nice = obj.designation + " " + obj.availableQuantity; 
			return nice;
		}
	};

	@Override
	public void networkErrorHappened() {
		Toast toast = Toast.makeText(getApplicationContext(), "Network error!", Toast.LENGTH_SHORT);
		toast.show();
		
		mLayout.setText("Please try again later.");
	}

	@Override
	public void bikeListUpdated() {
		//Toast toast = Toast.makeText(getApplicationContext(), mModel.getAvailablesBikes().get(0).toString(), Toast.LENGTH_SHORT);
		//toast.show();
		displayData();
		
	}
	
}