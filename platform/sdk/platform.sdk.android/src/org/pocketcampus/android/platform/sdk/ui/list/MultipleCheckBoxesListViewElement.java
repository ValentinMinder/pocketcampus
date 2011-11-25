package org.pocketcampus.android.platform.sdk.ui.list;

import java.util.List;

import org.pocketcampus.android.platform.sdk.ui.adapter.MultipleCheckBoxesArrayAdapter;
import org.pocketcampus.android.platform.sdk.ui.element.Element;
import org.pocketcampus.android.platform.sdk.ui.labeler.ILabeler;

import android.content.Context;
import android.widget.ListView;

/**
 * ListView that displays a list of Item along with two CheckBoxes each, that
 * allows the user to check one or none of them, which will express if he likes
 * or dislike an item.
 * 
 * @author Oriane <oriane.rodriguez@epfl.ch>
 * 
 */
public class MultipleCheckBoxesListViewElement extends ListView implements Element {
	private MultipleCheckBoxesArrayAdapter mAdapter;

	public MultipleCheckBoxesListViewElement(Context context,
			List<? extends Object> items, ILabeler labeler) {
		super(context);

//		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
//				LayoutParams.FILL_PARENT);
//		setLayoutParams(params);

		mAdapter = new MultipleCheckBoxesArrayAdapter(context, items, labeler);
		setAdapter(mAdapter);
	}

	/**
	 * Sets the click listener for the positive CheckBox
	 * 
	 * @param clickListener
	 *            The click listener created in the application
	 */
	public void setOnCheckBoxClickListener(OnItemClickListener clickListener) {
		mAdapter.setOnCheckBoxClickListener(clickListener);
	}

}