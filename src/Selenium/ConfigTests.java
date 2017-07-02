package Selenium;

import org.junit.Test;

public class ConfigTests extends BasicTest {

	@Test
	public void testUseProp() {
		System.out.println(configService.getProperty("sut.url"));
	}

}
