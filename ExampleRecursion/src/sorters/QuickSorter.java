package sorters;

import java.util.ArrayList;
import java.util.List;

public class QuickSorter implements Sorter {

	@Override
	public List<Integer> sort(List<Integer> list) {
		List<Integer> sortedList;
		if(list.size() == 0) {
			sortedList = new ArrayList<>();
		}
		else if(list.size() == 1) {
			sortedList = new ArrayList<>();
			sortedList.add(list.get(0));
		}
		else {
			int pivotIndex = list.size() - 1; // alternative: list.size() / 2;
			int pivotValue = list.get(pivotIndex);
			
			List<Integer> left = allLessThanOrEqualTo(pivotIndex, list);
			List<Integer> right = allLargerThan(pivotIndex, list);
			
			List<Integer> sortedLeft = sort(left);
			List<Integer> sortedRight = sort(right);
			
			sortedList = new ArrayList<>();
			sortedList.addAll(sortedLeft);
			sortedList.add(pivotValue);
			sortedList.addAll(sortedRight);
		}
		return sortedList;
	}
	
	private List<Integer> allLessThanOrEqualTo(int pivotIndex, List<Integer> list) {
		List<Integer> sublist = new ArrayList<>();
		int pivotValue = list.get(pivotIndex);
		for(int i = 0; i < list.size(); i ++) {
			int v = list.get(i);
			if(i != pivotIndex && v <= pivotValue) {
				sublist.add(v);
			}
		}
		return sublist;
	}
	
	private List<Integer> allLargerThan(int pivotIndex, List<Integer> list) {
		List<Integer> sublist = new ArrayList<>();
		int pivotValue = list.get(pivotIndex);
		for(int i = 0; i < list.size(); i ++) {
			int v = list.get(i);
			if(i != pivotIndex && v > pivotValue) {
				sublist.add(v);
			}
		}
		return sublist;
	}
}
