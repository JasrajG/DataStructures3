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
	
	public boolean check(BSTNode<E> root) {
		
		if (root.isExternal()) {
			return true;
		}
		return checkHelper1(root.getLeft(), root.getKey()) && checkHelper2(root.getRight(), root.getKey()) && check(root.getLeft()) && check(root.getRight());
	}
	
	
	private boolean checkHelper1(BSTNode<E> child, int n) {
		
		if (child.isExternal()) {
			return true;
		}
		
		else {
			return child.getKey()<n && checkHelper1(child.getLeft(),n) && checkHelper1(child.getRight(),n);
		}
	}
	
	private boolean checkHelper2(BSTNode<E> child, int n) {
		
		if (child.isExternal()) {
			return true;
		}
		
		else {
			return child.getKey()>n && checkHelper2(child.getLeft(),n) && checkHelper2(child.getRight(),n);
		}
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
		BSTNode<E> result = search(n, k);
		if (result.isExternal()){
			
			result.setKey(k);
			result.setValue(v);
			
			BSTNode<E> LExNode = new BSTNode<E>();
			BSTNode<E> RExNode = new BSTNode<E>();
			
			result.setLeft(LExNode);
			result.setRight(RExNode);
			LExNode.setParent(result);
			RExNode.setParent(result);
		}
		
		else {
			
			result.setValue(v);
		}
	}
	
	/*
	 * Exercise: Given a BST rooted at node `n`,
	 * 	delete the entry (key-value pair) with key `k` from the BST, if it exists.
	 */
	public void delete(BSTNode<E> n, int k) {
		
		BSTNode<E> result = search(n, k);
		

		
		
		//key is not in our BST
		if (result.isExternal()) {
			//do nothing
		}
		
		//results children are both external nodes
		else if (result.getLeft().isExternal() && result.getRight().isExternal() ){
			
			result.setLeft(null);
			result.setRight(null);
			
			result.setValue(null);
			result.setKey(-1);
	
		}
		//if only one of the children is external, didn't code for it explicitily since above case should catch it, but keep it in mind
		else if (result.getLeft().isExternal()){
			BSTNode<E> resultParent = result.getParent();
			
			if(resultParent==null) {
				result.setKey(result.getRight().getKey());
				result.setValue(result.getRight().getValue());
				
				result.setLeft(result.getRight().getLeft());
				result.setRight(result.getRight().getRight());
			}
			
			else if (resultParent.getLeft()==result) {
				resultParent.setLeft(result.getRight());
				result.getRight().setParent(resultParent);
				
			}
			
			else {
				resultParent.setRight(result.getRight());
				result.getRight().setParent(resultParent);
			}
			
		}
		
		
		else if (result.getRight().isExternal()) {
			BSTNode<E> resultParent = result.getParent();
			
			if(resultParent==null) {
				result.setKey(result.getLeft().getKey());
				result.setValue(result.getLeft().getValue());
				
				result.setRight(result.getLeft().getRight());
				result.setLeft(result.getLeft().getLeft());
			}
			
			else if (resultParent.getLeft()==result) {
				resultParent.setLeft(result.getLeft());
				result.getLeft().setParent(resultParent);
				
			}
			
			else {
				resultParent.setRight(result.getLeft());
				result.getLeft().setParent(resultParent);
			}
		}
		
		//final case, the removed node has two child internal nodes
		
		else {
			//find rightmost Node in LT
			BSTNode<E> current = result.getLeft();
			while(current.getRight().isInternal()) {
				current = current.getRight();
			}
			
			result.setKey(current.getKey());
			result.setValue(current.getValue());
			
			
			//remove current
			
			if (current.getLeft().isExternal()){
				
				current.setLeft(null);
				current.setRight(null);
				
				current.setValue(null);
				current.setKey(-1);
		
			}
			
			else {
				BSTNode<E> currentParent = current.getParent();
				
				
				
				if (current == currentParent.getLeft()) {
					currentParent.setLeft(current.getLeft());
					current.getLeft().setParent(currentParent);
				}
				
				else {
					currentParent.setRight(current.getLeft());
					current.getLeft().setParent(currentParent);
				}
				
			}
		
		
		
		
		}
	}
	
}	
