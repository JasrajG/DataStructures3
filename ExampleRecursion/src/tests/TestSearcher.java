package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.RecursiveMethods;

public class TestSearcher {

	@Test
	public void test_binary_search_0() {
		RecursiveMethods rm = new RecursiveMethods();
		
		int[] a0 = {};
		int[] a5 = {1, 2, 3, 4, 5};
		
		assertFalse(rm.binarySearch(a0, 5));
		
		assertTrue(rm.binarySearch(a5, 3));
		assertTrue(rm.binarySearch(a5, 1));
		assertTrue(rm.binarySearch(a5, 5));
		
		assertFalse(rm.binarySearch(a5, 0));
		assertFalse(rm.binarySearch(a5, 6));
	}

}
