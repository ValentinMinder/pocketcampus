//package org.pocketcampus.plugin.map.android.search;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.pocketcampus.plugin.map.android.MapInfo;
//import org.pocketcampus.plugin.map.android.MapPlugin;
//import org.pocketcampus.plugin.map.android.shared.MapElementBean;
//
//import android.R;
//import android.app.ListActivity;
//import android.app.Notification;
//import android.app.ProgressDialog;
//import android.app.SearchManager;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnCancelListener;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.markupartist.android.widget.ActionBar;
//
///**
// * A class used to search map elements and display the result of the search
// * Look at http://developer.android.com/guide/topics/search/search-dialog.html
// * 
// * @author Johan, Jonas
// *
// */
//public class MapSearchActivity extends ListActivity {
//	private ProgressDialog progressDialog_;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.map_search_result);
//		setupActionBar();
//	    handleIntent(getIntent());
//	}
//	
//	private void setupActionBar() {
//		ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
//		actionBar.setTitle(getResources().getText(R.string.app_name));
//	}
//	
//	/**
//	 * Verify the Intent's action and get the query
//	 * @param intent
//	 */
//	private void handleIntent(Intent intent) {
//	    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
//			String query = intent.getStringExtra(SearchManager.QUERY);
//			query = query.trim();
//			searchMap(query);
//	    }
//	}
//	
//	@Override
//	protected void onNewIntent(Intent intent) {
//		super.onNewIntent(intent);
//		setIntent(intent);
//		handleIntent(intent);
//	}
//	
//	/**
//	 * Searches the elements containing the string "query" as title or description
//	 * @param query the text to search
//	 */
//	private void searchMap(String query) {
//		
//		class MapSearchRequest extends DataRequest {
//			
//			private MapSearchActivity a_;
//			private ArrayAdapter<String> results_;
//			private List<MapElementBean> items_;
//			
//			public MapSearchRequest(MapSearchActivity a) {
//				a_ = a;
//			}
//			
//			@Override
//			protected void doInBackgroundThread(String result) {
//				if(result == null) {
//					return;
//				}
//				Log.d("MapSearchActivity", "Response received " + result);
//				
//				//Deserializes the response
//				Type mapElementType = new TypeToken<List<MapElementBean>>(){}.getType();
//				items_ = new ArrayList<MapElementBean>();
//
//				try {
//					items_ = Json.fromJson(result, mapElementType);
//				} catch (Exception e) {
//					Log.e("MapSearchActivity", e.toString());
//					return;
//				}
//				if(items_ == null) {
//					return;
//				}
//
//
//				results_ = new ArrayAdapter<String>(a_, R.layout.map_list);
//				if(items_.size() <= 0) {
//					results_.add(getResources().getString(R.string.search_no_results));
//				} else {
//					for(MapElementBean meb : items_) {
//						results_.add(meb.getTitle());
//					}
//				}
//				
//			}
//
//			@Override
//			protected void doInUiThread(String result) {
//				Log.d("MapSearchActivity", "doInUiThread-> " + result);
//				if(progressDialog_ != null && progressDialog_.isShowing()) {
//					progressDialog_.dismiss();
//				}
//				
//				if(results_ == null) {
//					try {
//						Notification.showToast(getApplicationContext(), R.string.server_connection_error);
//					} catch(Exception e) {
//						Log.e("MapSearchActivity", e.toString());
//					}
//					finish();
//					return;
//				}
//				
//				parseAndDisplayResult(results_, items_);
//			}
//			
//			@Override
//			protected void onCancelled() {
//				super.onCancelled();
//				if(progressDialog_ != null && progressDialog_.isShowing()) {
//					progressDialog_.dismiss();
//				}
//				try {
//					Notification.showToast(getApplicationContext(), R.string.server_connection_error);
//				} catch(Exception e) {
//					Log.e("MapSearchActivity", e.toString());
//				}
//				finish();
//			}
//		}
//		
//		progressDialog_ = new ProgressDialog(this);
//		progressDialog_.setTitle(getResources().getString(R.string.please_wait));
//		progressDialog_.setMessage(getResources().getString(R.string.map_searching));
//		progressDialog_.setCancelable(true);
//		
//		progressDialog_.setOnCancelListener(new OnCancelListener() {
//			@Override
//			public void onCancel(DialogInterface dialog) {
//				finish();
//				
//			}
//		});
//		
//		progressDialog_.show();
//		
//		
//		
//		RequestParameters params = new RequestParameters();
//		params.addParameter("q", query);
//		
//		RequestHandler rh = new RequestHandler(new MapInfo());
//		rh.execute(new MapSearchRequest(this), "search", params);
//	}
//	
//	/**
//	 * Parses the result from JSON and then displays the list of results
//	 * @param results A list containing the results title
//	 * @param items Beans of the items
//	 */
//	private void parseAndDisplayResult(ArrayAdapter<String> results, final List<MapElementBean> items) {
//		
//		if(results != null && results.getCount() == 1 && items != null && items.size() > 0) {
//			startMapActivity(items.get(0));
//			finish();
//		}
//		
//		ListView lv = getListView();
//		lv.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				if(items != null && items.size() > 0) {
//					try {
//						MapElementBean meb = items.get(position); 
//						startMapActivity(meb);
//					} catch (Exception e) {}
//				}
//			}
//		});
//		
//		setListAdapter(results);
//
//	}
//	
//	/**
//	 * Launch the map with the map element to be displayed
//	 * @param meb a map element to be displayed.
//	 */
//	private void startMapActivity(MapElementBean meb) {
//		Intent startMapActivity = new Intent(this, MapPlugin.class);
//		startMapActivity.putExtra("MapElement", meb);
//		//startMapActivity.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP); //had a problem of outofmemory if too many consecutive searches
//		//startMapActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //possible if we dont want the already displayed layers
//		startMapActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//		startActivity(startMapActivity);
//	}
//
//}