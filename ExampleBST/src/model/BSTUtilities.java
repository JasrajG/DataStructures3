package model;

import java.util.ArrayList;

public class BSTUtilities<E> {
	
	public ArrayList<BSTNode<E>> inOrderTraversal(BSTNode<E> root) {
		ArrayList<BSTNode<E>> result = null;
		if(root.isInternal()) { 
			result = new ArrayList<>();
			
			if(root.getLeft().isInternal()) {
				result.addAll(inOrderTraversal(root.getLeft()));
			}
			
			result.add(root);
			
			if(root.getRight().isInternal()) {
				result.addAll(inOrderTraversal(root.getRight()));
			}
		} 
		return result;
	}
	
	public BSTNode<E> search(BSTNode<E> p, int k) {
		BSTNode<E> result = null;
		if(p.isExternal()) {
			result = p; /* unsuccessful search */
		}
		else if(p.getKey() == k) {
			result = p; /* successful search */
		}
		else if(k < p.getKey()) {
			result = search(p.getLeft(), k); /* recur on LST */
		}
		else if(k > p.getKey()) {
			result = search(p.getRight(), k); /* recur on RST */
		}
		return result;
	}
	
	/*
	 * Exercise: Given a BST rooted at node `n`,
	 * 	insert an entry (key-value pair) with key `k` and value `v` into the BST.
	 */
	public void insert(BSTNode<E> n, int k, E v) {
		
	}
	
	/*
	 * Exercise: Given a BST rooted at node `n`,
	 * 	delete the entry (key-value pair) with key `k` from the BST, if it exists.
	 */
	public void delete(BSTNode<E> n, int k) {
		
	}
}
