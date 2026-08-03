package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	  TestMergeSorter.class,
	  TestQuickSorter.class,
	  TestSearcher.class
	}) 

public class TestAll {

}
