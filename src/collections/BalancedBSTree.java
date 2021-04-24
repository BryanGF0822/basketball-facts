package collections;

import java.util.List;

public interface BalancedBSTree<K extends Comparable<K>, V> {
	public Node<K, V>add(K key,V value);
	public List<V> search(K key);
	public void delete(K key);
	public boolean contains(K key);
	
}
