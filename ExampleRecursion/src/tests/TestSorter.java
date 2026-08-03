package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sorters.MergeSorter;
import sorters.Sorter;

public abstract class TestSorter {
	
	protected abstract Sorter someSorter();

	@Test
	public void testSortEmptyList() {
		List<Integer> list = new ArrayList<>();
		Sorter sorter = someSorter();
		List<Integer> sortedList = sorter.sort(list);
		assertTrue(sortedList.isEmpty());
	}
	
	@Test
	public void testSortEvenList() {
		List<Integer> list = new ArrayList<>();
		Sorter sorter = someSorter();
		int n = 10;
		
		for(int i = n; i > 0; i --) {
			list.add(3 * i);
		}
		
		List<Integer> sortedList = sorter.sort(list);
		assertTrue(sortedList.size() == n);
		for(int i = 1; i <= n; i ++) {
			assertTrue(sortedList.get(i - 1) == 3 * i);
		}
	}
	
	@Test
	public void testSortOddList() {
		List<Integer> list = new ArrayList<>();
		Sorter sorter = someSorter();
		int n = 11;
		
		for(int i = n; i > 0; i --) {
			list.add(3 * i);
		}
		
		List<Integer> sortedList = sorter.sort(list);
		assertTrue(sortedList.size() == n);
		for(int i = 1; i <= n; i ++) {
			assertTrue(sortedList.get(i - 1) == 3 * i);
		}
	}
	
	@Test
	public void testMerge() {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(7);
		list1.add(9);
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		list2.add(10);
		MergeSorter mergeSorter = new MergeSorter();
		List<Integer> list3 = mergeSorter.merge(list1, list2);
		assertTrue(list3.size() == 10);
		assertTrue(list3.get(0) == 1);
		assertTrue(list3.get(1) == 2);
		assertTrue(list3.get(2) == 3);
		assertTrue(list3.get(3) == 4);
		assertTrue(list3.get(4) == 5);
		assertTrue(list3.get(5) == 6);
		assertTrue(list3.get(6) == 7);
		assertTrue(list3.get(7) == 8);
		assertTrue(list3.get(8) == 9);
		assertTrue(list3.get(9) == 10);
	}
}
