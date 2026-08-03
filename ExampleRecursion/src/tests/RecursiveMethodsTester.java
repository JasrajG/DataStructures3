package tests;
import model.RecursiveMethods;

public class RecursiveMethodsTester {

	public static void main(String[] args) {
		/* Tests of towerOfHanoi */
		System.out.println("====================");
		String[] disks = {"A", "B", "C"};
		RecursiveMethods.towerOfHanoi(disks);
	}
}
