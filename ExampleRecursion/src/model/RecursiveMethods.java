package model;

public class RecursiveMethods {

	public boolean binarySearch(int[] sorted, int key) { 
		return binarySearchHelper(sorted, 0, sorted.length - 1, key);
	} 
	
	public boolean binarySearchHelper(int[] sorted, int from, int to, int key) { 
		if(from > to) { /* base case 1: empty range */
			return false;
		} 
		else if(from == to) { /* base case 2: range of one element */
			return sorted[from] == key;
		} 
		else {
			int middle = (from + to) / 2;
			int middleValue = sorted[middle];
			
			if(key < middleValue) { 
				return binarySearchHelper(sorted, from, middle - 1, key);
			} 
			else if (key > middleValue) { 
				return binarySearchHelper(sorted, middle + 1, to, key);
			} 
			else  { 
				return true; 
			}
		}
	}
	
	/*
	 * Assumption: 'disks' denote names of disks that
	 * are sorted in increasing sizes, to simulate 
	 * a stack of increasing-sized disks.
	 * For example, {"A", "B", "C"} means that
	 * "A" is the smallest disk on the top, and
	 * "C" is the biggest disk on the bottom. 
	 * There are 3 pegs. 
	 */
	public static void towerOfHanoi(String[] disks) {
		tohHelper(disks, 0, disks.length - 1, 1, 3);
	}
	
	/*
	 * towerOfHanoiHelper(disks, from, to, p1, p2) means
	 * to move {disks[from], disks[from+1], ..., disks[to]} from peg p1 to peg p2, 
	 * using peg (6 - p1 - p2) as the intermediate peg. 
	 */
	public static void tohHelper(String[] disks, int from, int to, int p1, int p2) {
		if(from > to) {
			
		}
		else if(from == to) {
			System.out.println("move disk " + disks[to] + " from peg " + p1 + " to peg " + p2);
		}
		else {
			int intermediate = 6 - p1 - p2;
			tohHelper(disks, from, to - 1, p1, intermediate);
			System.out.println("move disk " + disks[to] + " from peg " + p1 + " to peg " + p2);
			tohHelper(disks, from, to - 1, intermediate, p2);
		}
	}
}