package model;

/*
 * Template for binary search tree (BSTs).
 * It is assumed that keys are integers.
 * Values stored in nodes are generic. 
 */

public class BSTNode<E> {
	private int key; /* key */
	private E value; /* value */
	
	private BSTNode<E> parent; /* unique parent node */
	private BSTNode<E> left; /* left child node */
	private BSTNode<E> right; /* right child node */
	
	public BSTNode() {
		this.key = -1;
		this.value = null;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	
	public BSTNode(int key, E value) {
		this.key = key;
		this.value = value;
		this.parent = null; 
		this.left = null;
		this.right = null;
	}
	
	public boolean isExternal() {
		return this.getLeft() == null && this.getRight() == null;
	}
	
	public boolean isInternal() {
		return !this.isExternal();
	}
	
	public int getKey() {
		return this.key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public E getValue() {
		return this.value;
	}
	
	public void setValue(E value) {
		this.value = value;
	}
	
	public BSTNode<E> getParent() {
		return this.parent;
	}
	
	public void setParent(BSTNode<E> parent) {
		this.parent = parent;
	}
	
	public BSTNode<E> getLeft() {
		return this.left;
	} 
	
	public void setLeft(BSTNode<E> left) {
		this.left = left;
	}
	
	public BSTNode<E> getRight() {
		return this.right;
	} 
	
	public void setRight(BSTNode<E> right) {
		this.right = right;
	}
}
