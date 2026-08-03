package tests;

import sorters.QuickSorter;
import sorters.Sorter;

public class TestQuickSorter extends TestSorter {

	@Override
	protected Sorter someSorter() {
		return new QuickSorter();
	}

}
