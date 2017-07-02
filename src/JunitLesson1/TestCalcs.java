package JunitLesson1;

import org.junit.Assert;
import org.junit.Test;

public class TestCalcs extends BasicTest {

	@Test
	public void test2PositiveNumbers() {
		Assert.assertTrue(isBelow50(30, 50));
	}
	
	
}
