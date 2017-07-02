package seleniumLesson5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lesson6.GenericWebDriver;

public class LoginPageTests {

	LoginPage loginPage;

	GenericWebDriver webdriver;

	@Before
	public void setup() throws Exception {

		webdriver = new GenericWebDriver();

		loginPage = new LoginPage(webdriver);
	}

	@Test
	public void testLogin() {
		webdriver.openUrl("http://localhost/login.html");

		loginPage.enterUserName("test1234");

		loginPage.enterPassword("123456");

		loginPage.submit();
	}

	@Test
	public void testLogin2() {
		loginPage.openPageAndLogin("aaaa", "123444");

		String currentTitleText = loginPage.getTitle();

		Assert.assertTrue(currentTitleText.equals("bla bla"));
	}

}
