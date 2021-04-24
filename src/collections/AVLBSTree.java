package collections;

import java.io.Serializable;
import java.util.List;

public class AVLBSTree<K extends Comparable<K>, V> extends BinarySearchTree<K, V> implements BalancedBSTree<K, V>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005016605184816284L;

	public AVLBSTree() {
		super();
	}
	



	@Override
	public Node<K, V> add(Node<K, V> node, K key, V value) {
		Node<K, V> x = super.add(node, key, value);
		x.height = 1 + Math.max(height(x.left), height(x.right));
		return balance(x);
	}

	

	/**
	 * Restores the AVL tree property of the subtree.
	 * 
	 * @param x the subtree
	 * @return the subtree with restored AVL property
	 */
	private Node<K, V> balance(Node<K, V> x) {
		if (balanceFactor(x) < -1) {
			if (balanceFactor(x.right) > 0) {
				x.right = rotateRight(x.right);
			}
			x = rotateLeft(x);
		} else if (balanceFactor(x) > 1) {
			if (balanceFactor(x.left) < 0) {
				x.left = rotateLeft(x.left);
			}
			x = rotateRight(x);
		}
		return x;
	}

	/**
	 * Returns the balance factor of the subtree. The balance factor is defined as
	 * the difference in height of the left subtree and right subtree, in this
	 * order. Therefore, a subtree with a balance factor of -1, 0 or 1 has the AVL
	 * property since the heights of the two child subtrees differ by at most one.
	 * 
	 * @param x the subtree
	 * @return the balance factor of the subtree
	 */
	protected int balanceFactor(Node<K, V> x) {
		return height(x.left) - height(x.right);
	}

	
}