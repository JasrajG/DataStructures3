package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.BSTNode;
import model.BSTUtilities;

public class TestBST {
	
	@Test
	public void test_binary_search_trees_construction() {
		BSTNode<String> n28 = new BSTNode<>(28, "alan");
		BSTNode<String> n21 = new BSTNode<>(21, "mark");
		BSTNode<String> n35 = new BSTNode<>(35, "tom");
		BSTNode<String> extN1 = new BSTNode<>();
		BSTNode<String> extN2 = new BSTNode<>();
		BSTNode<String> extN3 = new BSTNode<>();
		BSTNode<String> extN4 = new BSTNode<>();
		
		n28.setLeft(n21); n21.setParent(n28);
		n28.setRight(n35); n35.setParent(n28);
		n21.setLeft(extN1); extN1.setParent(n21); 
		n21.setRight(extN2); extN2.setParent(n21);
		n35.setLeft(extN3); extN3.setParent(n35);
		n35.setRight(extN4); extN4.setParent(n35);
		
		BSTUtilities<String> u = new BSTUtilities<>(); 
		ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(n28); 
		assertTrue(inOrderList.size() == 3);
		assertEquals(21, inOrderList.get(0).getKey());
		assertEquals("mark", inOrderList.get(0).getValue());
		assertEquals(28, inOrderList.get(1).getKey());
		assertEquals("alan", inOrderList.get(1).getValue());
		assertEquals(35, inOrderList.get(2).getKey());
		assertEquals("tom", inOrderList.get(2).getValue());
	}
	
	@Test
	public void test_binary_search_trees_search() {
		BSTNode<String> n28 = new BSTNode<>(28, "alan");
		BSTNode<String> n21 = new BSTNode<>(21, "mark");
		BSTNode<String> n35 = new BSTNode<>(35, "tom");
		BSTNode<String> extN1 = new BSTNode<>();
		BSTNode<String> extN2 = new BSTNode<>();
		BSTNode<String> extN3 = new BSTNode<>();
		BSTNode<String> extN4 = new BSTNode<>();
		
		n28.setLeft(n21); n21.setParent(n28);
		n28.setRight(n35); n35.setParent(n28);
		n21.setLeft(extN1); extN1.setParent(n21); 
		n21.setRight(extN2); extN2.setParent(n21);
		n35.setLeft(extN3); extN3.setParent(n35);
		n35.setRight(extN4); extN4.setParent(n35);
		
		BSTUtilities<String> u = new BSTUtilities<>(); 
		/* search existing keys */
		assertTrue(n28 == u.search(n28, 28)); 
		assertTrue(n21 == u.search(n28, 21));
		assertTrue(n35 == u.search(n28, 35));
		/* search non-existing keys */
		assertTrue(extN1 == u.search(n28, 17)); /* *17* < 21 */
		assertTrue(extN2 == u.search(n28, 23)); /* 21 < *23* < 28 */
		assertTrue(extN3 == u.search(n28, 33)); /* 28 < *33* < 35 */
		assertTrue(extN4 == u.search(n28, 38)); /* 35 < *38* */
	}
}
