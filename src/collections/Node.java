package collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Player;

public class Node<K extends Comparable<? super K>, V> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3073345467094967068L;

	/** Parent node */
	protected Node<K, V> parent;

	/** Left child */
	protected Node<K, V> left;

	/** Right child */
	protected Node<K, V> right;

	/** V, the data that the Node encapsulates */
	protected List<V> values;

	/** K, the key */
	protected K key;

	protected int height;
	
	private List<Player> samePlayers;

	/**
	 * The data that Node encapsulates
	 * 
	 * @param data, an object of a class K,V that implements Comparable interface
	 */
	public Node(K key, V data) {
		this.values = new LinkedList<V>();
		this.values.add(data);
		this.left = null;
		this.right = null;
		this.parent = null;
		this.key = key;
		this.height = 0;
		this.samePlayers = new ArrayList<Player>();
		
	}
	
	
	public List<Player> getPlayers(){
		return samePlayers;
	}
}
