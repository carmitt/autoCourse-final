import org.junit.Assert;
import org.junit.Test;

import com.google.common.annotations.VisibleForTesting;

public class JunitLesson1 {
	
	
	@Test
	public void test1(){
		
		Assert.assertTrue(1==1);
	}
	
	@Test
	public void test2(){
		
		Assert.assertTrue(1==2);
	}

}
