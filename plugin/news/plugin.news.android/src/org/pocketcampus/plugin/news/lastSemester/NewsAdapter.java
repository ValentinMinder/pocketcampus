package org.pocketcampus.plugin.news.lastSemester;
//package org.pocketcampus.plugin.news.android;
//
////import org.pocketcampus.R;
////import org.pocketcampus.plugin.logging.Tracker;
//
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.preference.PreferenceManager;
//import android.text.Html;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
///**
// * Adapter used by the ListView to display the feeds
// * 
// * @status complete
// * 
// * @author Jonas, Johan
// *
// */
//public class NewsAdapter extends BaseAdapter implements INewsListener {
//
//	private NewsProvider newsProvider_;
//
//	// Selected item, will be shown bigger than the others
//	private int selectedItem_ = -1;
//
//	// Misc
//	private LayoutInflater mInflater_;
//	private Context context_;
//	private boolean showImage_;
//
//	/**
//	 * Adapter constructor
//	 * @param context Context of the application
//	 * @param items Items that have to be on the list
//	 */
//	public NewsAdapter(Context context, NewsProvider newsProvider) {
//		super();
//		this.context_ = context;
//		
//		this.showImage_ = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(NewsPreference.SHOW_IMG, true);
//		
//		mInflater_ = LayoutInflater.from(context);
//		
//		newsProvider_ = newsProvider;
//		newsProvider_.addNewsListener(this);
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		View v = convertView;
//		if (v == null) {
//			v = mInflater_.inflate(R.layout.news_newsentry, null);
//			
//			if(!showImage_) {
//				v.findViewById(R.id.news_item_image).setVisibility(View.GONE);
//			}
//		}
//
//		// The item to display
//		final NewsItem newsItem = getItem(position);
//
//		if (newsItem != null) {
//			TextView tv;
//
//			tv = (TextView) v.findViewById(R.id.news_item_title);
//			tv.setText(Html.fromHtml(newsItem.getTitle()));
//
//			tv = (TextView) v.findViewById(R.id.news_item_description);
//			
//			tv.setText(newsItem.getFormatedDescription());
//			tv.setMaxLines(selectedItem_ == position ? 15 : 2); // Bigger if the item is selected
//
//			LoaderNewsImageView liv = (LoaderNewsImageView) v.findViewById(R.id.news_item_image);
//			if(showImage_) {
//				liv.setTag(newsItem); // This view shows this NewsItem
//				liv.setNewItem(newsItem);
//			}
//
//			// "Read more" textview, shown only on the selected item
//			TextView more = (TextView) v.findViewById(R.id.news_readmore);
//			
//			if(selectedItem_ == position) {
//				
//				more.setVisibility(View.VISIBLE);
//
//				more.setOnClickListener(new OnClickListener() {
//					@Override
//					public void onClick(View v) {
//
//						Tracker.getInstance().trackPageView("news/viewItem");
//						
//						Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(newsItem.getLink()));
//						context_.startActivity(i);
//					}
//				});
//
//			} else {
//				more.setVisibility(View.GONE);
//			}
//
//		}
//
//		return v;
//
//	}
//
//	/**
//	 * Sets the item that has been selected, to show it bigger
//	 * @param position
//	 */
//	public void setClickedItem(int position) {
//		if(selectedItem_ == position) {
//			selectedItem_ = -1;
//		} else {
//			selectedItem_ = position;
//		}
//
//		// Recompute the view
//		this.notifyDataSetChanged();
//	}
//
//
//	@Override
//	public int getCount() {
//		return newsProvider_.getCount();
//	}
//
//	@Override
//	public NewsItem getItem(int position) {
//		return newsProvider_.getItem(position);
//	}
//
//	@Override
//	public long getItemId(int position) {
//		return newsProvider_.getItemId(position);
//	}
//
//	@Override
//	public void newsRefreshing() {}
//
//	@Override
//	public void newsRefreshed() {
//		this.notifyDataSetChanged();
//	}
//
//
//}