package JunitLesson1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass1 {
	
	public String test;
	
	@Before
	public void setup(){
		System.out.println("running setup");
	}
	
	@Test
	public void firstTest(){
		System.out.println("this is the first test");
	}
	@Test
	public void compareStrings(){
		
		String str1="abc3de";
		String str2="abcde";
		
//		Assert.assertEquals(str1, str2);
		
		
		try {
			if(str1.equals(str2)==false){
				Assert.fail("Test failed because...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("nir is right");
		
	}

}
