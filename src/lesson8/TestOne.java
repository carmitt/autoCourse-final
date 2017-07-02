package lesson8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Lesosn6Drill.Phone;

public class TestOne extends BasicTest {
	
	@Before
	public void setup(){
		super.setup();
	}
	
	@Test
	public void test1(){
		String a="abbbb";
		String b="Abbbb";
		Assert.assertEquals(a, b);
		Assert.assertEquals(a, b.toLowerCase());
	}
	
	@Test
	public void test2(){
		int one = 0;
		int two = 0;
		Assert.assertEquals(one, two);
		
	}
	
	@Test
	public void test3(){
		String[]strA=new String[]{"a","b","e"};
		String[]strB=new String[]{"a","c",""};
		Assert.assertArrayEquals(strA, strB);
		
	}
	
	@Test
	public void test4(){
		Phone  phone=new Phone();
		Assert.assertNotNull(phone);
	}
	
	@Test
	public void test5(){
		
		Assert.fail("Failing tests");
	}
	
	@Test
	public void test6(){
		
	}
	

}
