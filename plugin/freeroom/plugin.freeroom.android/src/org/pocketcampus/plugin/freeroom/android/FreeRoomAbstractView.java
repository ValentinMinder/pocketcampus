package org.pocketcampus.plugin.freeroom.android;

import org.pocketcampus.android.platform.sdk.core.PluginController;
import org.pocketcampus.android.platform.sdk.core.PluginView;
import org.pocketcampus.plugin.freeroom.R;
import org.pocketcampus.plugin.freeroom.android.iface.IFreeRoomView;

import android.widget.Toast;

/**
 * FreeRoomAbstractView - An abstract view that handles shared methods among all freeroom views.
 * 
 * This view is NOT intended to be instanciated or even used. It's only there to 
 * group together all commons method among all the views, like network error message.
 * 
 * Be careful to declare there ONLY methods that the views don't need, otherwise no one will
 * warn you if your methods in the view are not declared.
 * 
 * @author FreeRoomSemesterProjectTeam Julien Weber <Julien.Weber@epfl.ch> & Valentin Minder <Valentin.Minder@epfl.ch>
 * 
 */
public abstract class FreeRoomAbstractView extends PluginView implements IFreeRoomView {

	@Override
	protected Class<? extends PluginController> getMainControllerClass() {
		return FreeRoomController.class;
	}

	@Override
	public void networkErrorHappened() {
		Toast.makeText(
				getApplicationContext(),
				getResources().getString(
						R.string.freeroom_connection_error_happened),
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void freeRoomServersDown() {
		Toast.makeText(
				getApplicationContext(),
				getResources().getString(
						R.string.freeroom_error_freeroom_down),
				Toast.LENGTH_SHORT).show();
	}
}
