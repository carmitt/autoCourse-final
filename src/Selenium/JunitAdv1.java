package Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;

import Interfaces.myTestParams;

public class JunitAdv1 {
	
	
	
	@Rule
	public Timeout timeout=Timeout.seconds(5);
	
	
	@Rule
	public TestName testName=new TestName();
	
	@Before
	public void setup(){
		
		System.out.println("This is the name of the test: "+testName.getMethodName());
		
		System.out.println("Class name: "+this.getClass().getSimpleName());
		
		System.out.println("this is the setup");
	}
	
	
	@BeforeClass
	public static void classSetup(){
		System.out.println("Before all tests");
	}
	@Test
	@myTestParams(browsers={"ie","chrome"})
	public void test1(){
		System.out.println("test 1");
	}
	
	@Test
	@myTestParams(browser="firefox")
	public void test2(){
		System.out.println("test 2");
	}
	
	@Test
	public void longTest() throws Exception{
		Thread.sleep(6000);
	}
	
	@After
	public void tearDown(){
		System.out.println("after");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("After class");
	}
}
