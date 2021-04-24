package collections;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeNode<K extends Comparable<? super K>, V> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3073345467094967068L;

	/** Parent node */
	protected BinarySearchTreeNode<K, V> parent;

	/** Left child */
	protected BinarySearchTreeNode<K, V> left;

	/** Right child */
	protected BinarySearchTreeNode<K, V> right;

	/** V, the data that the Node encapsulates */
	protected List<V> values;

	/** K, the key */
	protected K key;

	protected int height;

	/**
	 * The data that Node encapsulates
	 * 
	 * @param data, an object of a class K,V that implements Comparable interface
	 */
	public BinarySearchTreeNode(K key, V data) {
		this.values = new LinkedList<V>();
		this.values.add(data);
		this.left = null;
		this.right = null;
		this.parent = null;
		this.key = key;
		this.height = 0;
	}
}
