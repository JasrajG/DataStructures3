package tests;

import sorters.MergeSorter;
import sorters.Sorter;

public class TestMergeSorter extends TestSorter {
	@Override
	protected Sorter someSorter() {
		return new MergeSorter();
	}
}
