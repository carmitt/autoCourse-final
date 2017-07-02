package lesson8;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import JunitLesson2.TestLog;

public class BasicTest {

	String testId;
	String testName;
	TestReporter testReporter;

	public TestLog testlog;
	
	String env;
	
	String userId;
	
	

	@Before
	public void setup() {
		testReporter=new TestReporter();
		
		userId="44334343";
	}

	

	@After
	public void tearDown() {

	}
}
