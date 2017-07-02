package Selenium;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.Description;

import Interfaces.myTestParams;
import Services.Utils.fileUtils;

public class JunitAdvanceedTest {

	GenericWebDriver webdriver;

	@BeforeClass
	public static void beforeAllTests() {

		// example
		fileUtils.deleteTestFolder();

		System.out.println("Before all tests in the class");
	}

	@Before
	public void setup() {
		System.out.println("setup");
	}

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void starting(Description description) {
			if (description.getAnnotation(myTestParams.class) != null) {
				myTestParams params = description.getAnnotation(myTestParams.class);
				System.out.println(params.testTimeOut());

				if (params.testTimeOut() != 600) {
					System.setProperty("customTimeout", String.valueOf(params.testTimeOut()));
				} else {
					System.setProperty("customTimeout", "600");
				}
			} else {
				System.setProperty("customTimeout", "600");
			}

			super.starting(description);
		}

	};

	@Rule
	public TestName name = new TestName();

	@Rule
	public Timeout testTimeOut = Timeout.seconds(Integer.getInteger(System.getProperty("customTimeout")));

	@Test

	public void test1() {
		System.out.println(this.getClass().getSimpleName());
	}

	@Test

	@myTestParams(testTimeOut = 100)
	public void test2() throws InterruptedException {

	}

	@AfterClass
	public static void classTearDown() {
		System.out.println("after class");
	}

}
