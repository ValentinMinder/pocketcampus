package org.pocketcampus.android.platform.sdk.ui.labeler;

import android.content.Context;
import android.view.View;

/**
 * 
 * @author elodie <elodienilane.triponez@epfl.ch>
 *
 */
public interface IRatableViewConstructor {
	public View getNewView(Object currentObject, Context context,
			IRatableViewLabeler<? extends Object> labeler,
			/*OnItemClickListener elementListener,
			OnItemClickListener ratingListener,*/ int position);
}
