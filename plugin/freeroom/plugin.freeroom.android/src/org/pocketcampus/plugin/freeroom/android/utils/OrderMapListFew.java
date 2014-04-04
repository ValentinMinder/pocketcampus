package org.pocketcampus.plugin.freeroom.android.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <code>OrderMapListFew</code> is an <code>OrderMap</code>, therefore a
 * standard <code>Map</code> where the ORDER of the <code>key</code>s is
 * guaranteed. It's also an <code>OrderMap</code>, so the <code>value</code>s
 * are of type <code>List<?></code>, and the type of the <code>value</code>s
 * elements are specified separately as a third parameter.
 * <p>
 * The goal of this implementation is to overrides some methods of superclass,
 * like <code>getChildCount</code>, to make available only the first data of
 * each group.
 * <p>
 * 
 * @author FreeRoom Project Team (2014/05)
 * @author Julien WEBER <julien.weber@epfl.ch>
 * @author Valentin MINDER <valentin.minder@epfl.ch>
 * 
 * @param <K>
 *            the type of the <code>key</code>s
 * @param <V>
 *            the type of the <code>value</code>s, MUST be a
 *            <code>List<?></code>
 * @param <T>
 *            the type of the <code>value</code>s elements
 */
public class OrderMapListFew<K, V, T> extends OrderMapList<K, V, T> {

	/**
	 * The number of elements to make available in each group.
	 */
	private int availableLimit = 3;
	/**
	 * <code>true</code> if all elements are available, <code>false</code> if we
	 * want to limit the number of elements available.
	 */
	private boolean availableAll = false;

	/**
	 * Default constructor.
	 */
	public OrderMapListFew() {
		super();
	}

	/**
	 * Constructor with specific <code>size</code> for optimization.
	 * 
	 * @param size
	 *            expected size of the structure
	 */
	public OrderMapListFew(int size) {
		super(size);
	}

	@Override
	public void clear() {
		// TODO: this method may NOT be concerned by the availability
		super.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.containsKey(value);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.entrySet();
	}

	@Override
	public V get(Object key) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.get(key);
	}

	@Override
	public V get(int index) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.get(index);
	}

	@Override
	public boolean isEmpty() {
		// TODO: this method may NOT be concerned by the availability
		return super.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.keySet();
	}

	@Override
	public List<K> keySetOrdered() {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.keySetOrdered();
	}

	@Override
	public V put(K key, V value) {
		// TODO: this method may NOT be concerned by the availability
		return super.put(key, value);
	}

	// warning: use put to put at the end!!!
	@Override
	public V put(K key, V value, int index) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.put(key, value, index);
	}

	@Override
	public V putGently(K key, V value, int index) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.putGently(key, value, index);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO: this method may NOT be concerned by the availability
		super.putAll(arg0);
	}

	@Override
	public V remove(Object key) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.remove(key);
	}

	@Override
	public V remove(int index) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.remove(index);
	}

	@Override
	public int size() {
		// TODO: this method may NOT be concerned by the availability
		return super.size();
	}

	@Override
	public Collection<V> values() {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.values();
	}

	@Override
	public T getChild(int group, int child) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.getChild(group, child);
	}

	@Override
	public void updateKey(int index, K newKey) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		super.updateKey(index, newKey);
	}

	@Override
	public void updateKey(K oldKey, K newKey) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		super.updateKey(oldKey, newKey);
	}

	@Override
	public K getKey(int index) {
		// TODO: this method seems to be concerned by the availability and needs
		// specific overriding
		return super.getKey(index);
	}

	/*
	 * Overridden to give only a few children, the one that are available.
	 */
	/**
	 * Retrieves the number of <code>child</code>ren AVAILABLE for the specified
	 * <code>group</code>.
	 * 
	 * @param group
	 *            specific <code>group</code> number for which to check the
	 *            number of <code>child</code>ren.
	 * @return the number of <code>child</code>ren AVAILABLE for the specified
	 *         <code>group</code>.
	 */
	@Override
	public int getChildCount(int group) {
		int size = super.getChildCount(group);
		if (availableAll) {
			return size;
		}
		if (availableLimit < size) {
			return availableLimit;
		} else {
			return size;
		}
	}

	/**
	 * Retrieves the number of <code>child</code>ren NON AVAILABLE for the
	 * specified <code>group</code>.
	 * 
	 * @param group
	 *            specific <code>group</code> number for which to check the
	 *            number of <code>child</code>ren.
	 * @return the number of <code>child</code>ren NON AVAILABLE for the
	 *         specified <code>group</code>.
	 */
	public int getChildCountNonAvailable(int group) {
		if (availableAll) {
			return 0;
		} else {
			int size = super.getChildCount(group);
			if (availableLimit < size) {
				return size - availableLimit;
			} else {
				return 0;
			}
		}
	}

	/**
	 * Retrieves the TOTAL number of <code>child</code>ren for the specified
	 * <code>group</code>, no matter if they are available or not.
	 * 
	 * @param group
	 *            specific <code>group</code> number for which to check the
	 *            number of <code>child</code>ren.
	 * @return the TOTAL number of <code>child</code>ren for the specified
	 *         <code>group</code>, available or not.
	 */
	public int getChildCountTotal(int group) {
		return super.getChildCount(group);
	}

	/**
	 * Sets <code>availableAll</code> to the given boolean value.
	 * 
	 * @param availableAll
	 *            new value for <code>availableAll</code>
	 */
	public void setAvailableAll(boolean availableAll) {
		this.availableAll = availableAll;
	}

	/**
	 * Switch <code>availableAll</code> to the opposite of the current boolean
	 * value, change to <code>false</code> if was previously <code>true</code>,
	 * change to <code>true</code> if was previously <code>false</code>.
	 */
	public void setAvailableAllSwitch() {
		this.availableAll = !availableAll;
	}

	/**
	 * Get the value of <code>availableAll</code>.
	 * 
	 * @return the value of <code>availableAll</code>
	 */
	public boolean getAvailableAll() {
		return availableAll;
	}

	/**
	 * Sets <code>availableLimit</code> to the given integer value.
	 * 
	 * @param availableLimit
	 *            new value for <code>availableLimit</code>.
	 */
	public void setAvailableLimit(int availableLimit) {
		this.availableLimit = availableLimit;
	}

	/**
	 * Get the value of <code>availableLimit</code>
	 * 
	 * @return the value of <code>availableLimit</code>
	 */
	public int getAvailableLimit() {
		return availableLimit;
	}
}