package org.pocketcampus.android.platform.sdk.ui.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.pocketcampus.R;
import org.pocketcampus.android.platform.sdk.ui.labeler.IRatableViewConstructor;
import org.pocketcampus.android.platform.sdk.ui.labeler.IRatableViewLabeler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
	/* App context */
	private Context mContext;

	/* Layout Management */
	private LayoutInflater mInflater;
	private Vector<String> mHeaders;
	private HashMap<String, ? extends Vector<? extends Object>> mChildren;

	/* View Handler */
	private IRatableViewConstructor mViewConstructor;
	private IRatableViewLabeler<? extends Object> mViewLabeler;

	/**
	 * Constructor
	 * 
	 * @param context
	 *            context of the application the list view is in
	 * @param headers
	 *            restaurant full menu represented in the list section.
	 */
	public ExpandableListAdapter(Vector<String> headers,
			HashMap<String, ? extends Vector<? extends Object>> items,
			IRatableViewConstructor viewConstructor,
			IRatableViewLabeler<? extends Object> viewLabeler, Context context) {
		// Cache the LayoutInflate to avoid asking for a new one each time.
		this.mContext = context;
		this.mInflater = LayoutInflater.from(context);
		this.mHeaders = headers;
		this.mChildren = items;
		this.mViewConstructor = viewConstructor;
		this.mViewLabeler = viewLabeler;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		if (mChildren != null && mHeaders != null) {
			return mChildren.get(mHeaders.get(groupPosition))
					.get(childPosition);
		}
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		String section = mHeaders.get(groupPosition);
		return mViewConstructor.getNewView(
				mChildren.get(section).get(childPosition), mContext,
				mViewLabeler, childPosition);
	}

	public int getChildrenCount(int groupPosition) {
		return mChildren.get(mHeaders.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return mHeaders.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return mHeaders.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		ViewHolder holder;

		String currentHeader = mHeaders.get(groupPosition);

		holder = new ViewHolder(mContext, currentHeader,
				mChildren.get(currentHeader), groupPosition, isExpanded);

		return holder;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	private class ViewHolder extends LinearLayout {

		View mView;
		TextView mTitle;
		ImageView mImage;

		public ViewHolder(Context context, String title,
				List<? extends Object> resto, int position, boolean isExpanded) {
			super(context);

			this.setOrientation(VERTICAL);

			mView = mInflater.inflate(R.layout.sdk_separated_list_header_entry,
					null);

			mTitle = (TextView) mView
					.findViewById(R.id.sdk_separated_list_header_title);
			mTitle.setText(title);

			mImage = (ImageView) mView
					.findViewById(R.id.sdk_separated_list_header_arrow);
			if (isExpanded) {
				mImage.setImageDrawable(mContext.getResources().getDrawable(
						R.drawable.sdk_separated_list_header_south_arrow));
			} else {
				mImage.setImageDrawable(mContext.getResources().getDrawable(
						R.drawable.sdk_separated_list_header_east_arrow));
			}

			addView(mView);
		}
	}

}