package sorters;
import java.util.ArrayList;
import java.util.List;

public class MergeSorter implements Sorter {
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
			int middle = list.size() / 2;
			
			List<Integer> left = list.subList(0, middle);
			List<Integer> right = list.subList(middle, list.size());
			
			List<Integer> sortedLeft = sort(left);
			List<Integer> sortedRight = sort(right);
			
			sortedList = merge(sortedLeft, sortedRight);
		}
		return sortedList;
	}
	
	// Assumption: left and right are both sorted.
	public List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> mergedList = new ArrayList<>();
		if(left.isEmpty() || right.isEmpty()) {
			mergedList.addAll(left);
			mergedList.addAll(right);
		}
		else {
			int i = 0;
			int j = 0;
			while(i < left.size() && j < right.size()) { 
				if(left.get(i) <= right.get(j)) {
					mergedList.add(left.get(i));
					i ++;
				}
				else {
					mergedList.add(right.get(j));
					j ++;
				}	
			}
			/* If i >= left.size(), then this for loop is skipped. */
			for(int k = i; k < left.size(); k ++) {
				mergedList.add(left.get(k));
			}
			/* If j >= right.size(), then this for loop is skipped. */
			for(int k = j; k < right.size(); k ++) {
				mergedList.add(right.get(k));
			}
		}
		return mergedList;
	}
}
