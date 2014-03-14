package org.pocketcampus.plugin.freeroom.android.utils;

import java.util.List;
import java.util.Map;

import org.pocketcampus.plugin.freeroom.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Simple adapter to use with ExpandableListView, all elements are String.
 * 
 * @author FreeFroom Project Team - Julien WEBER <julien.weber@epfl.ch> and
 *         Valentin MINDER <valentin.minder@epfl.ch>
 * 
 */
public class ExpandableSimpleListViewAdapter extends BaseExpandableListAdapter {
	private Context context;
	private List<String> headers;
	private Map<String, List<String>> data;

	public ExpandableSimpleListViewAdapter(Context c, List<String> header,
			Map<String, List<String>> data) {
		this.context = c;
		this.headers = header;
		this.data = data;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		if (groupPosition >= headers.size()) {
			return null;
		}
		List<String> groupList = data.get(headers.get(groupPosition));

		if (childPosition >= groupList.size()) {
			return null;
		}
		return data.get(headers.get(groupPosition)).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		if (groupPosition >= headers.size()) {
			return null;
		}

		ViewHolder vholder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.sdk_separated_list_separation_header, null);
			vholder = new ViewHolder();
			vholder.setTextView((TextView) convertView
					.findViewById(R.id.sdk_separated_list_header_title));
			convertView.setTag(vholder);
		} else {
			vholder = (ViewHolder) convertView.getTag();
		}

		String text = (String) this.getChild(groupPosition, childPosition);

		TextView tv = vholder.getTextView();
		tv.setText(text);
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		if (groupPosition >= data.size()) {
			return 0;
		}

		return data.get(headers.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		if (groupPosition >= data.size()) {
			return null;
		}
		return data.get(headers.get(groupPosition));
	}

	@Override
	public int getGroupCount() {
		return data.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		if (groupPosition >= headers.size()) {
			return null;
		}

		ViewHolder vholder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.sdk_separated_list_separation_header, null);
			vholder = new ViewHolder();
			vholder.setTextView((TextView) convertView
					.findViewById(R.id.sdk_separated_list_header_title));
			convertView.setTag(vholder);
		} else {
			vholder = (ViewHolder) convertView.getTag();
		}

		String text = (String) headers.get(groupPosition);
		TextView tv = vholder.getTextView();
		tv.setText(text);
		return convertView;

	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	public void updateHeader(int id, String value) {
		if (id >= headers.size()) {
			return;
		}

		this.data.put(value, data.remove(headers.get(id)));
		this.headers.set(id, value);
	}

	/**
	 * Class used to keep a view, it saves ressources by avoiding multiple
	 * inflate and findViewById operations.
	 * 
	 */
	private class ViewHolder {
		private TextView tv = null;

		public void setTextView(TextView tv) {
			this.tv = tv;
		}

		public TextView getTextView() {
			return this.tv;
		}
	}
}
