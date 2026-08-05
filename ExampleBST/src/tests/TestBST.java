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
	
	
	
	
	@Test
	public void test_insert_into_empty_tree() {
		// Start with an empty tree (just one external node)
		BSTNode<String> root = new BSTNode<>();
		BSTUtilities<String> u = new BSTUtilities<>();
		
		// Insert a new key-value pair
		u.insert(root, 50, "boss");
		
		// Assert that the node is now internal and holds the correct data
		assertTrue(root.isInternal());
		assertEquals(50, root.getKey());
		assertEquals("boss", root.getValue());
		
		// Assert that it created two external children properly linked back to the parent
		assertNotNull(root.getLeft());
		assertTrue(root.getLeft().isExternal());
		assertTrue(root == root.getLeft().getParent());
		
		assertNotNull(root.getRight());
		assertTrue(root.getRight().isExternal());
		assertTrue(root == root.getRight().getParent());
		
		// Assert traversal size
		ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root); 
		assertEquals(1, inOrderList.size());
	}
	
	@Test
	public void test_insert_existing_key_updates_value() {
		// Setup tree
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
		
		// Action: Insert key 21, which already exists ("mark"). Change it to "steve".
		u.insert(n28, 21, "steve");
		
		// Assertions
		assertEquals("steve", n21.getValue()); // Value should be updated
		assertEquals(21, n21.getKey()); // Key remains the same
		
		// Ensure tree structure wasn't altered (size should still be 3)
		ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(n28); 
		assertEquals(3, inOrderList.size());
	}
	
	@Test
	public void test_insert_new_keys_expands_tree() {
		// Setup tree
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
		
		// Action 1: Insert 17 (Should replace extN1, left of 21)
		u.insert(n28, 17, "john");
		
		// Assert Action 1
		assertTrue(extN1.isInternal()); // It should no longer be external
		assertEquals(17, extN1.getKey());
		assertEquals("john", extN1.getValue());
		assertTrue(extN1.getLeft().isExternal()); // Check new external leaves
		assertTrue(extN1.getRight().isExternal());
		assertEquals(extN1, extN1.getLeft().getParent()); // Check parent pointers
		
		// Action 2: Insert 40 (Should replace extN4, right of 35)
		u.insert(n28, 40, "sarah");
		
		// Assert Action 2
		assertTrue(extN4.isInternal());
		assertEquals(40, extN4.getKey());
		assertEquals("sarah", extN4.getValue());
		
		// Verify final tree structure via inOrderTraversal
		// Keys should now be: 17, 21, 28, 35, 40
		ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(n28); 
		assertEquals(5, inOrderList.size());
		
		assertEquals(17, inOrderList.get(0).getKey());
		assertEquals("john", inOrderList.get(0).getValue());
		
		assertEquals(21, inOrderList.get(1).getKey());
		assertEquals(28, inOrderList.get(2).getKey());
		assertEquals(35, inOrderList.get(3).getKey());
		
		assertEquals(40, inOrderList.get(4).getKey());
		assertEquals("sarah", inOrderList.get(4).getValue());
	}
	
	
	// --- HELPER METHOD FOR TESTS ---
		// Builds a standard BST for deletion tests:
		//         50
		//       /    \
		//     30      70
		//    /  \    /  \
		//  20   40  60   80
		private BSTNode<String> createStandardTree(BSTUtilities<String> u) {
			BSTNode<String> root = new BSTNode<>();
			u.insert(root, 50, "fifty");
			u.insert(root, 30, "thirty");
			u.insert(root, 70, "seventy");
			u.insert(root, 20, "twenty");
			u.insert(root, 40, "forty");
			u.insert(root, 60, "sixty");
			u.insert(root, 80, "eighty");
			return root;
		}

		@Test
		public void test_delete_non_existent_key() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = createStandardTree(u);
			
			u.delete(root, 99); // 99 is not in the tree
			
			ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root);
			assertEquals("Tree size should not change", 7, inOrderList.size());
		}

		@Test
		public void test_delete_leaf_node() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = createStandardTree(u);
			
			// 20 is a leaf node
			u.delete(root, 20); 
			
			ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root);
			assertEquals(6, inOrderList.size());
			
			// Verify 20 is gone and order is maintained
			assertEquals(30, inOrderList.get(0).getKey());
			
			// Verify structure: 30's left child should now be an external node
			BSTNode<String> node30 = u.search(root, 30);
			assertTrue(node30.getLeft().isExternal());
		}

		@Test
		public void test_delete_node_with_only_right_child() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = createStandardTree(u);
			
			// First, delete 20 to make 30 a node with ONLY a right child (40)
			u.delete(root, 20);
			
			// Now delete 30
			u.delete(root, 30);
			
			ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root);
			assertEquals(5, inOrderList.size());
			
			// 40 should now be the first element, and it should be the left child of 50
			assertEquals(40, inOrderList.get(0).getKey());
			assertEquals(40, root.getLeft().getKey());
		}

		@Test
		public void test_delete_node_with_only_left_child() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = createStandardTree(u);
			
			// First, delete 40 to make 30 a node with ONLY a left child (20)
			u.delete(root, 40);
			
			// Now delete 30
			u.delete(root, 30);
			
			ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root);
			assertEquals(5, inOrderList.size());
			
			// 20 should now be the first element, and it should be the left child of 50
			assertEquals(20, inOrderList.get(0).getKey());
			assertEquals(20, root.getLeft().getKey());
		}

		@Test
		public void test_delete_node_with_two_children() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = createStandardTree(u);
			
			// 30 has two children: 20 and 40.
			// Its predecessor (rightmost node in left subtree) is 20.
			u.delete(root, 30);
			
			ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root);
			assertEquals(6, inOrderList.size());
			
			// Verify order is strictly maintained
			assertEquals(20, inOrderList.get(0).getKey());
			assertEquals(40, inOrderList.get(1).getKey());
			assertEquals(50, inOrderList.get(2).getKey());
			
			// Structural check: Node previously holding 30 should now hold 20
			assertEquals(20, root.getLeft().getKey());
			assertEquals("twenty", root.getLeft().getValue());
		}
		
		@Test
		public void test_delete_root_with_two_children() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = createStandardTree(u);
			
			// 50 is the root. Its predecessor is 40.
			u.delete(root, 50);
			
			ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root);
			assertEquals(6, inOrderList.size());
			
			// The root node object should now hold the key/value of 40
			assertEquals(40, root.getKey());
			assertEquals("forty", root.getValue());
			
			// Verify order
			assertEquals(20, inOrderList.get(0).getKey());
			assertEquals(30, inOrderList.get(1).getKey());
			assertEquals(40, inOrderList.get(2).getKey()); // This is the root
			assertEquals(60, inOrderList.get(3).getKey());
		}
		
		
		@Test
		public void test_delete_root_with_only_left_child() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = new BSTNode<>();
			
			// Setup: Root has only a left child
			u.insert(root, 50, "fifty");
			u.insert(root, 30, "thirty");
			
			// ACTION: Delete the root
			// NOTE: In your current code, this will throw a NullPointerException!
			u.delete(root, 50);
			
			// Assertions (What SHOULD happen after you fix the bug)
			// Since the method returns void, the root object itself must absorb the left child's data
			assertEquals(30, root.getKey());
			assertEquals("thirty", root.getValue());
			
			ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root);
			assertEquals("Tree should only have 1 node left", 1, inOrderList.size());
		}

		@Test
		public void test_delete_root_with_only_right_child() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = new BSTNode<>();
			
			// Setup: Root has only a right child
			u.insert(root, 50, "fifty");
			u.insert(root, 70, "seventy");
			
			// ACTION: Delete the root
			// NOTE: In your current code, this will also throw a NullPointerException!
			u.delete(root, 50);
			
			// Assertions (What SHOULD happen after you fix the bug)
			assertEquals(70, root.getKey());
			assertEquals("seventy", root.getValue());
			
			ArrayList<BSTNode<String>> inOrderList = u.inOrderTraversal(root);
			assertEquals("Tree should only have 1 node left", 1, inOrderList.size());
		}

		@Test
		public void test_delete_root_with_no_children() {
			BSTUtilities<String> u = new BSTUtilities<>();
			BSTNode<String> root = new BSTNode<>();
			
			// Setup: Root is the only node in the tree
			u.insert(root, 50, "fifty");
			
			// ACTION: Delete the root
			// Your code actually handles this without an NPE, but let's verify it works properly!
			u.delete(root, 50);
			
			// Assertions
			// The root should revert back to being an external node
			assertTrue(root.isExternal());
			assertEquals(-1, root.getKey());
			assertNull(root.getValue());
			
			// Because the tree is empty (root is external), traversal should return null based on your traversal code
			assertNull(u.inOrderTraversal(root));
		}
}
