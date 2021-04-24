package collections;

import java.util.ArrayList;
import java.util.List;

import model.Player;

@SuppressWarnings("rawtypes")
public class TreeNode<K extends Comparable, V> {
    public Color color;
    public K key;
    public V val;
    public TreeNode<K, V> parent;
    public TreeNode<K, V> left;
    public TreeNode<K, V> right;
    private List<Player> samePlayers;

    public TreeNode(){
        // set RED as default
        this.color = Color.RED;
        this.key = null;
        this.val = null;
        this.left = null;
        this.right = null;
        this.samePlayers = new ArrayList<Player>();
    }
    public TreeNode(Color color, K key, V val) {
        this.color = color;
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
        this.samePlayers = new ArrayList<Player>();
    }
    
    public List<Player> getPlayers(){
		return samePlayers;
	}


}