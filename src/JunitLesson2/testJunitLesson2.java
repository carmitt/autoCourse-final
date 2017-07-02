package JunitLesson2;

import org.junit.Test;

import lesson8.BasicTest;

public class testJunitLesson2 extends BasicTest {

	@Test
	public void testLogin() {
		testlog.addStep("Open browser");

		testlog.addStep("Perform login");
	}

}
