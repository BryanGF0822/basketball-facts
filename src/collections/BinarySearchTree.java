package collections;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;


import model.Player;




/**
 * Implementation of a generic Binary Search Tree in which whenever are
 * duplicate keys, values are stored in a list.
 * 
 * 
 * @param <K,V>, any class that implements the Comparable interface
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements Iterable<List<V>>, Serializable {
	
	private static final long serialVersionUID = 3509254229421105483L;		
		
	

	/** Root node of the tree */
	protected Node<K, V> root;

	protected int size;

	/**
	 * Constructor
	 */
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}

	
	
	

	/**
	 * Searches an element in the tree
	 * 
	 * @param data, K,V
	 * @return Node<K,V> {@link Node}, the node that contains the data searched. If
	 *         not found, returns null
	 */
	public Node<K, V> searchNode(K key) {
		Node<K, V> nodeFound = root;
		boolean found = false;
		if (root != null) {
			while (!found && nodeFound != null) {
				if (key.compareTo(nodeFound.key) < 0)
					nodeFound = nodeFound.left;
				else if (key.compareTo(nodeFound.key) > 0)
					nodeFound = nodeFound.right;
				else
					found = true;
			}
		}
		if (!found)
			nodeFound = null;
		return nodeFound;
	}

	/**
	 * Determines whether an element is in the tree
	 * 
	 * @param key
	 * @return boolean, true if the element is within the tree; otherwise, false.
	 */
	public boolean contains(K key) {
		Node<K, V> found = searchNode(key);
		return (found != null);
	}

	

	/**
	 * 
	 * @param value
	 * @return 
	 */
	public Node<K, V> add(K key, V value) {
		Node<K, V> toAdd = null;
		if (key == null)
			throw new IllegalArgumentException("Key cannot be null");
		else {
			toAdd = add(root, key, value);
			size++;
		}
		return toAdd;
	}

	protected Node<K, V> add(Node<K, V> currentNode, K key, V value) {
		if (currentNode == null)
			return new Node<K, V>(key, value);
		int cmp = key.compareTo(currentNode.key);
		if (cmp < 0) {
			currentNode.left = add(currentNode.left, key, value);
		} else if (cmp > 0) {
			currentNode.right = add(currentNode.right, key, value);
		} else {
			currentNode.values.add(0, value); // Add duplicate element at the beginning in order to avoid extra
												// iterations
		}
		return currentNode;
	}

	public void delete(K key) {
		if (key == null)
			throw new IllegalArgumentException("Null key to delete");
		root = delete(root, key);
	}

	protected Node<K, V> delete(Node<K, V> node, K key) {
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			node.left = delete(node.left, key);
		} else if (cmp > 0) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				Node<K, V> y = node;
				node = getMinimum(y.right);
				node.right = deleteMin(y.right);
				node.left = y.left;
			}
			size--;
		}
		return node;
	}

	public int size() {
		return size;
	}

	public void deleteMin() {
		if (isEmpty())
			throw new NoSuchElementException("called deleteMin() with empty symbol table");
		root = deleteMin(root);
	}

	protected Node<K, V> deleteMin(Node<K, V> x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.height = 1 + Math.max(height(x.left), height(x.right));
		return x;
	}

	public Node<K, V> getMaximum(Node<K, V> localRoot) {
		Node<K, V> currentNode = localRoot;
		while (currentNode.right != null)
			currentNode = currentNode.right;
		return currentNode;
	}

	public Node<K, V> getMinimum(Node<K, V> localRoot) {
		Node<K, V> currentNode = localRoot;
		while (currentNode.left != null)
			currentNode = currentNode.left;
		return currentNode;
	}

	/**
	 * Returns the height of the internal AVL tree. It is assumed that the height of
	 * an empty tree is -1 and the height of a tree with just one node is 0.
	 * 
	 * @return the height of the internal AVL tree
	 */
	public int height() {
		return height(root);
	}

	protected int height(Node<K, V> x) {
		if (x == null)
			return -1;
		return x.height;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public List<V> getRootData() {
		return this.root.values;
	}





	@Override
	public Iterator<List<V>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	
	

	

	
			

			
}
