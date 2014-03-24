package org.pocketcampus.plugin.freeroom.android;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.pocketcampus.android.platform.sdk.core.IView;
import org.pocketcampus.android.platform.sdk.core.PluginModel;
import org.pocketcampus.plugin.freeroom.R;
import org.pocketcampus.plugin.freeroom.android.iface.IFreeRoomModel;
import org.pocketcampus.plugin.freeroom.android.iface.IFreeRoomView;
import org.pocketcampus.plugin.freeroom.shared.ActualOccupation;
import org.pocketcampus.plugin.freeroom.shared.FRRoom;
import org.pocketcampus.plugin.freeroom.shared.Occupancy;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

/**
 * FreeRoomModel - The Model that stores the data of this plugin.
 * <p>
 * This is the Model associated with the FreeRoom plugin. It stores the data
 * required for the correct functioning of the plugin. Some data is persistent
 * (none at the moment!) Other data are temporary.
 * <p>
 * 
 * @author FreeRoom Project Team - Julien WEBER <julien.weber@epfl.ch> and
 *         Valentin MINDER <valentin.minder@epfl.ch>
 * 
 */
public class FreeRoomModel extends PluginModel implements IFreeRoomModel {

	/**
	 * Keys to persistent storage
	 */
	private final String FAVORITES_ROOMS_KEY = "FAVORITES_ROOMS_KEY";
	private final String FORBIDDEN_ROOMS_KEY = "FORBIDDEN_ROOMS_KEY";

	public final int COLOR_CHECK_OCCUPANCY_DEFAULT = Color.WHITE;
	public final int COLOR_CHECK_OCCUPANCY_FREE = Color.GREEN;
	public final int COLOR_CHECK_OCCUPANCY_OCCUPIED = Color.RED;
	public final int COLOR_CHECK_OCCUPANCY_ATLEASTONCE = Color.YELLOW;

	/**
	 * 
	 * Reference to the Views that need to be notified when the stored data
	 * changes.
	 */
	IFreeRoomView mListeners = (IFreeRoomView) getListeners();

	/** List of <code>FRRoom</code>'s obtained from the freeroom query **/
	private Set<FRRoom> mFreeRoomResult = new HashSet<FRRoom>();
	private TreeMap<String, List<FRRoom>> sortedRooms = new TreeMap<String, List<FRRoom>>();
	private ArrayList<String> buildings = new ArrayList<String>();
	/** List of suggestions for the check occupancy search view */
	private List<FRRoom> mAutoCompleteSuggestions = new ArrayList<FRRoom>();
	// TODO: not used NOW
	/** Used to specify the displayed <code>FRRoom</code> in the results view */
	private FRRoom mSelectedFRRoom;
	/**
	 * Ordered list of <code>Occupancy</code>'s displayed in the check occupancy
	 */
	private List<Occupancy> mListCheckedOccupancyRoom = new ArrayList<Occupancy>();

	private LinkedHashSet<FRRoom> mLinkedHashSetCheckedRoom = new LinkedHashSet<FRRoom>();

	private Context context;

	/**
	 * Constructor with reference to the context.
	 * 
	 * We need the context to be able to instantiate the SharedPreferences
	 * object in order to use persistent storage.
	 * 
	 * @param context
	 *            is the Application Context.
	 */
	public FreeRoomModel(Context context) {
		this.context = context;
	}

	/**
	 * Returns the Type of the Views associated with this plugin.
	 */
	@Override
	protected Class<? extends IView> getViewInterface() {
		return IFreeRoomView.class;
	}

	/**
	 * Returns the registered listeners to by notified.
	 */
	public IFreeRoomView getListenersToNotify() {
		return mListeners;
	}

	/**
	 * Getter for the results of the request
	 * 
	 * @return Set of FRRoom
	 */
	public Set<FRRoom> getFreeRoomResults() {
		return mFreeRoomResult;
	}

	public TreeMap<String, List<FRRoom>> getFreeRoomResultsFilteredByBuildings() {
		return sortedRooms;
	}

	public List<String> getFreeRoomResultsBuildings() {
		return buildings;
	}

	public FRRoom getFreeRoomResult(int group, int child) {
		if (group < 0 || group >= buildings.size()) {
			return null;
		}
		String building = buildings.get(group);
		List<FRRoom> list = sortedRooms.get(building);
		if (list != null && child >= 0 && child < list.size()) {
			return list.get(child);
		}
		return null;
	}

	/**
	 * Setter for the results of a freeroom request
	 * 
	 * @param results
	 *            the result for the specific freeroom search
	 */
	public void setFreeRoomResults(Set<FRRoom> results) {
		mFreeRoomResult = results;
		sortedRooms = sortFRRoomsByBuildingsAndFavorites(mFreeRoomResult, true);
		mListeners.freeRoomResultsUpdated();
	}

	/**
	 * Gets the currently selected <code>FRRoom</code>
	 */
	public FRRoom getSelectedFRRoom() {
		return mSelectedFRRoom;
	}

	/**
	 * Sets which <code>FRRoom</code> is currently displayed.
	 */
	public void selectFRRoom(FRRoom choosen_one) {
		mSelectedFRRoom = choosen_one;
	}

	/**
	 * Sets the suggestions to the autocomplete and notifies the listeners.
	 * 
	 * @param listFRRoom
	 */
	public void setAutoCompleteResults(List<FRRoom> listFRRoom) {
		mAutoCompleteSuggestions = listFRRoom;
		mListeners.autoCompletedUpdated();
	}

	/**
	 * Gets the suggestions for the autocomplete
	 */
	public List<FRRoom> getAutocompleteSuggestions() {
		return mAutoCompleteSuggestions;
	}

	/**
	 * Sets the occupancy result for all the rooms and notifies the listeners.
	 * 
	 * @param list
	 */
	public void setOccupancyResultsListOccupancy(List<Occupancy> list) {
		mListCheckedOccupancyRoom = list;
		mListeners.occupancyResultUpdated();
	}

	/**
	 * Gets the list of room checked against occupancy.
	 * 
	 * @return
	 */
	public List<Occupancy> getListCheckedOccupancyRoom() {
		return mListCheckedOccupancyRoom;
	}

	public void setOccupancyResultsLinkedHashSetFRRoom(
			LinkedHashSet<FRRoom> mLinkedHashSet) {
		mLinkedHashSetCheckedRoom = mLinkedHashSet;
	}

	private Occupancy getOccupancy(int mGroupPosition) {
		if (mListCheckedOccupancyRoom != null
				&& mGroupPosition < mListCheckedOccupancyRoom.size()) {
			return mListCheckedOccupancyRoom.get(mGroupPosition);
		}
		// default
		return null;
	}

	private ActualOccupation getActualOccupation(int mGroupPosition,
			int mChildPosition) {

		Occupancy mOccupancy = getOccupancy(mGroupPosition);
		if (mOccupancy != null) {
			List<ActualOccupation> mActualOccupationList = mOccupancy
					.getOccupancy();
			if (mChildPosition < mActualOccupationList.size()) {
				ActualOccupation mActualOccupation = mActualOccupationList
						.get(mChildPosition);
				return mActualOccupation;
			}
		}

		// default
		return null;
	}

	public int getColorOfCheckOccupancyRoom(int mGroupPosition,
			int mChildPosition) {
		ActualOccupation mActualOccupation = getActualOccupation(
				mGroupPosition, mChildPosition);
		if (mActualOccupation != null) {
			if (mActualOccupation.isAvailable()) {
				return COLOR_CHECK_OCCUPANCY_FREE;
			} else {
				return COLOR_CHECK_OCCUPANCY_OCCUPIED;
			}
		}
		// default
		return COLOR_CHECK_OCCUPANCY_DEFAULT;
	}

	public boolean isCheckOccupancyLineClickable(int mGroupPosition,
			int mChildPosition) {
		ActualOccupation mActualOccupation = getActualOccupation(
				mGroupPosition, mChildPosition);
		if (mActualOccupation != null) {
			if (mActualOccupation.isAvailable()) {
				return true;
			} else {
				return false;
			}
		}

		// default
		return false;
	}

	public int getColorOfCheckOccupancyRoom(int mGroupPosition) {
		Occupancy mOccupancy = getOccupancy(mGroupPosition);

		boolean atLeastOneFree = mOccupancy.isIsAtLeastFreeOnce();
		boolean atLeastOneOccupied = mOccupancy.isIsAtLeastOccupiedOnce();

		if (atLeastOneFree) {
			if (atLeastOneOccupied) {
				return COLOR_CHECK_OCCUPANCY_ATLEASTONCE;
			} else {
				return COLOR_CHECK_OCCUPANCY_FREE;
			}
		} else {
			if (atLeastOneOccupied) {
				return COLOR_CHECK_OCCUPANCY_OCCUPIED;
			} else {
				// default
				return COLOR_CHECK_OCCUPANCY_DEFAULT;
			}
		}

	}

	public boolean addRoomFavorites(String uid, String doorCode) {
		return addRoom(uid, doorCode, FAVORITES_ROOMS_KEY);
	}

	public boolean removeRoomFavorites(String uid) {
		return removeRoomByUID(uid, FAVORITES_ROOMS_KEY);
	}

	/**
	 * Checks if the uid is present in the map.
	 * 
	 * @param uid
	 * @return
	 */
	public boolean containRoomFavorites(String uid) {
		return containsRoomByUID(uid, FAVORITES_ROOMS_KEY);
	}

	/**
	 * Return the door code of the room represented by the uid.
	 * 
	 * Return null if the favorite is not in the map.
	 * 
	 * @param uid
	 * @return
	 */
	public String getRoomFavorites(String uid) {
		return getRoomByUID(uid, FAVORITES_ROOMS_KEY);
	}

	public Map<String, String> getAllRoomMapFavorites() {
		return getAllRoomAsMap(FAVORITES_ROOMS_KEY);
	}

	public Set<String> getAllRoomSetUIDFavorites() {
		Map<String, String> map = getAllRoomMapFavorites();
		return map.keySet();
	}

	public boolean addRoomForbidden(String uid, String doorCode) {
		return addRoom(uid, doorCode, FORBIDDEN_ROOMS_KEY);
	}

	public boolean removeRoomForbidden(String uid) {
		return removeRoomByUID(uid, FORBIDDEN_ROOMS_KEY);
	}

	public boolean containRoomForbidden(String uid) {
		return containsRoomByUID(uid, FORBIDDEN_ROOMS_KEY);
	}

	public String getRoomForbidden(String uid) {
		return getRoomByUID(uid, FORBIDDEN_ROOMS_KEY);
	}

	public Map<String, String> getAllRoomMapForbidden() {
		return getAllRoomAsMap(FORBIDDEN_ROOMS_KEY);
	}

	public Set<String> getAllRoomSetUIDForbidden() {
		Map<String, String> map = getAllRoomMapForbidden();
		return map.keySet();
	}

	public boolean addRoom(String uid, String doorCode, String key) {
		SharedPreferences preferences = context.getSharedPreferences(key,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(uid, doorCode);
		return editor.commit();
	}

	public boolean removeRoomByUID(String uid, String key) {
		SharedPreferences preferences = context.getSharedPreferences(key,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.remove(uid);
		return editor.commit();
	}

	public boolean containsRoomByUID(String uid, String key) {
		SharedPreferences preferences = context.getSharedPreferences(key,
				Context.MODE_PRIVATE);
		return preferences.contains(uid);
	}

	public boolean containsRoomByDoorCode(String doorCode, String key) {
		return getAllRoomAsCollectionDoorCode(key).contains(doorCode);
	}

	public String getRoomByUID(String uid, String key) {
		SharedPreferences preferences = context.getSharedPreferences(key,
				Context.MODE_PRIVATE);
		return preferences.getString(uid, null);
	}

	public Map<String, String> getAllRoomAsMap(String key) {
		SharedPreferences preferences = context.getSharedPreferences(key,
				Context.MODE_PRIVATE);
		return (Map<String, String>) preferences.getAll();
	}

	public Set<String> getAllRoomAsSetUID(String key) {
		Map<String, String> map = getAllRoomAsMap(key);
		return map.keySet();
	}

	public Collection<String> getAllRoomAsCollectionDoorCode(String key) {
		Map<String, String> map = getAllRoomAsMap(key);
		return map.values();
	}

	/**
	 * Returns the building part in mDoorCode.
	 * 
	 * Door codes should be like PH D2 398 with PH the building D2 the zone 398
	 * the number (including floor)
	 * 
	 * It works ONLY if spaces are correctly set!
	 * 
	 * @param mDoorCode
	 * @return
	 */
	public String getBuilding(String mDoorCode) {
		mDoorCode = mDoorCode.trim();
		int firstSpace = mDoorCode.indexOf(" ");
		if (firstSpace > 0) {
			mDoorCode = mDoorCode.substring(0, firstSpace);
		}
		return mDoorCode;
	}

	/**
	 * Sort a given set of rooms by its buildings, the returning map maps
	 * building's name to the list of rooms in this buildings. This also add's a
	 * category named Favorites that contains all the favorites if boolean
	 * wantFavoritesList is true
	 **/
	public TreeMap<String, List<FRRoom>> sortFRRoomsByBuildingsAndFavorites(
			Set<FRRoom> rooms, boolean wantFavoritesList) {
		Iterator<FRRoom> iter = rooms.iterator();
		TreeMap<String, List<FRRoom>> sortedResult = new TreeMap<String, List<FRRoom>>();
		ArrayList<String> buildingsList = new ArrayList<String>();

		ArrayList<FRRoom> roomsFavorites = null;
		if (wantFavoritesList) {
			buildingsList.add(context.getString(R.string.freeroom_result_occupancy_favorites));
			roomsFavorites = new ArrayList<FRRoom>();
		}

		while (iter.hasNext()) {
			FRRoom frRoom = iter.next();
			
			if (wantFavoritesList && containRoomFavorites(frRoom.getUid())) {
				roomsFavorites.add(frRoom);
			}

			String building = getBuilding(frRoom.getDoorCode());

			List<FRRoom> roomsNumbers = sortedResult.get(building);
			if (roomsNumbers == null) {
				buildingsList.add(building);
				roomsNumbers = new ArrayList<FRRoom>();
				sortedResult.put(building, roomsNumbers);
			}
			roomsNumbers.add(frRoom);
		}

		// we leave an empty favorites list!
		if (wantFavoritesList && roomsFavorites.isEmpty()) {
			sortedResult.remove(buildingsList.get(0));
			buildingsList.remove(0);
		}
		return sortedResult;
	}
}
