package Selenium;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Services.Utils.fileUtils;
import enums.ByTypes;

public class MyFirstTestClass extends BasicTest {

	@Test
	public void myFirstSeleniumTest() throws Exception {
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/loginPage.jsp");

		// webdriver.getElementByXpath("//input[@name='q']").sendKeys("baaaa");
		//
		// webdriver.getElementByXpath("//input[@name='q']").sendKeys(Keys.ENTER);

		loginPage.enterUserName("Qwery");

		loginPage.enterPassword("123456");

		loginPage.clickOnSubmit();

		System.out.println("ddd");
	}

	@Test
	public void testPrintTableContent() throws Exception {

		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/table.html");

		List<WebElement> cells = webdriver.getElementsByXpath("//table[@class='table']//tr//td");

		for (int i = 0; i < cells.size(); i++) {
			System.out.println("Text in cell " + i + " :" + cells.get(i).getText());
		}
	}

	@Test
	public void testScreenShot() throws Exception {
		webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/table.html");

		// webdriver.printScreen("error_");

		webdriver.getElementBy(ByTypes.id, "dsss");
	}

	@Test
	public void testAddCookie() throws Exception {
		webdriver.openUrl("http://www.google.co.il");

		webdriver.addCookie("automation", "test_s+vg");

		Assert.assertTrue(webdriver.isCookiesExist("automation", "test_svg"));

		System.out.println();
	}

	@Test
	public void addItem() throws Exception {
		// webdriver.openUrl("http://auto-course.us-west-2.elasticbeanstalk.com/addItemToCatalog.jsp");
		//
		// addItem.selectCategory("Toys");

		String str = "aaaaa";

		str = str + "3333";
		// '//div[@class='aaaa333']
		String xpath = "//div[@class='" + str + "']";

	}

	@Test
	public void poc() throws Exception {
		System.out.println(fileUtils.getCurrentDateTime());

		testlog.addStep("first step");
		
		webdriver.openUrl("http://www.ynet.co.il");
		
		testlog.addAction("check that the button bla bla appears");
		
//		loginPage.enterPassword("dddd");
		
		
		
		testlog.addStep("second st             ep");
		
		testlog.addAction("dssasadsad");
		
		System.out.println("this is the secon");
	}

}
