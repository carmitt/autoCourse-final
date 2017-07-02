package Selenium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import org.apache.http.impl.conn.LoggingSessionInputBuffer;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Services.Utils.fileUtils;
import TestObjects.TestLog;
import enums.ByTypes;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class GenericWebDriver {

	RemoteWebDriver webdriver;

	TestLog testLog;

	// remote url=address of node/grid
	public void init(String remoteUrl, TestLog testLog) throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		LoggingPreferences loggingPreferences = new LoggingPreferences();

		loggingPreferences.enable(LogType.DRIVER, Level.ALL);

		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

		URL url = new URL(remoteUrl);

		webdriver = new RemoteWebDriver(url, capabilities);

		this.testLog = testLog;

	}

	public LogEntries geWeBrowserLogs() {
		return webdriver.manage().logs().get(LogType.BROWSER);
	}

	// navigates to a url
	public void openUrl(String url) {
		webdriver.get(url);
	}

	public void quit() {
		webdriver.quit();
	}

	public WebElement getElementByXpath(String xpath) throws Exception {
		return getElementBy(ByTypes.xpath, xpath);
	}

	public void hoverOnElement(WebElement element) {
		Actions action = new Actions(webdriver);
		action.moveToElement(element).perform();

	}

	public List<String> getComboBoxValues(String xpath) throws Exception {
		// get thr combobox element
		WebElement comboBoxElement = getElementBy(ByTypes.xpath, xpath);

		// create a combobox element from the webElement
		Select select = new Select(comboBoxElement);

		// creeate a list of webElements from the combobox values
		List<WebElement> comboValues = select.getOptions();

		// creates a list of strings that will hold the text
		List<String> listStr = new ArrayList<String>();

		// iterates over the WebElements list and gets the text from each
		// webElement

		// the same as: (int i=0;i<comboValues.size();i++)
		for (WebElement element : comboValues) {
			listStr.add(element.getText());
		}
		// return the list of strings
		return listStr;
	}

	public void selectComboBoxOptions(String optionVale, String xpath) throws Exception {

		try {
			WebElement comboBox = getElementBy(ByTypes.xpath, xpath);

			Select select = new Select(comboBox);

			select.selectByVisibleText(optionVale);
		} catch (Exception e) {
			printScreen("SelectingFromComboBoxFailed");

			e.printStackTrace();
		}

	}

	public WebElement getElementBy(ByTypes type, String value) {
		return getElementBy(type, value, 10);
	}

	public WebElement getElementBy(ByTypes type, String value, int timeout) {
		return getElementBy(type, value, timeout, false);
	}

	public void typeInAlert(String text) {
		try {
			Alert alert = webdriver.switchTo().alert();

			alert.sendKeys(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public WebElement getElementBy(ByTypes type, String value, int timeout, boolean mandatory) {
		testLog.addStep("Looking for element :" + value);

		WebDriverWait wait = new WebDriverWait(webdriver, timeout, 1000);

		WebElement element = null;

		try {
			switch (type) {
			case xpath:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				break;
			case className:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				break;

			case id:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				break;

			case link:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
				break;

			case name:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			printScreen("ElementNotFound_" + value);

			e.printStackTrace();

			if (mandatory == true) {
				testLog.setTestStatus(false);
				Assert.fail("Failed due to an exception in getting element");
			}
		}

		testLog.addAction("Elemenmt found");

		if (element == null && mandatory == true) {

			testLog.addAction("");
			Assert.fail("Mandatory element " + value + " was not found");
		}
		// if mandatory==true && element==null - than fail the test
		// (Assert.fail("Element not found"))
		return element;

	}

	public List<WebElement> getElementsByXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(webdriver, 10, 1000);

		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

		return list;

	}

	public String printScreen(String prefix) {
		File screenshot = null;

		String newPath = null;

		try {
			WebDriver augmentedDriver = new Augmenter().augment(webdriver);
			screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			newPath = System.getProperty("user.dir") + "\\files\\scr\\" + prefix + screenshot.getName();
			fileUtils.copyFile(screenshot, newPath);

		} catch (WebDriverException e) {

			System.out.println(e.getStackTrace());

		}

		return newPath;
	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		webdriver.manage().addCookie(cookie);
	}

	public boolean isCookiesExist(String name, String value) {
		Cookie cookie = webdriver.manage().getCookieNamed(name);

		if (cookie != null) {
			if (cookie.getValue().equals(value)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void swithcToFrameAndSendKeys(String xpathExpression, String keys, boolean clear, String frameId)
			throws Exception {
		String currentWindow = webdriver.getWindowHandle();
		webdriver.switchTo().frame(frameId);

		WebElement element = webdriver.findElement(By.xpath(xpathExpression));

		element.click();
		if (clear == true) {
			element.clear();
		}

		element.sendKeys(keys);
		webdriver.switchTo().window(currentWindow);
	}

	public void dragAndDrop(String xpathFrom, String xpathTo) {

		Actions actions = new Actions(webdriver);

		WebElement elementFrom = getElementBy(ByTypes.xpath, xpathFrom);

		WebDriverWait wait = new WebDriverWait(webdriver, 10);

		// actions.dragAndDrop(elementFrom,
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTo))))
		// .build().perform();

		actions.clickAndHold(elementFrom).moveByOffset(-300, -300).pause(1000).release().perform();

	}

	public void setImplicitWait() {
		// tells the webdriver to always wait until an element is loaded in the
		// DOM

		// unlike Explicit wait (Using the webDriverWait) it cannot use special
		// conditions

		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public Screenshot getScreenshot(WebElement element, String ignoreXpath) {
		Screenshot shot = new AShot().takeScreenshot(webdriver, element);

		return shot;
	}

	public void takeAshot(WebElement element, String name) throws IOException {
		Screenshot shot = null;

		shot = new AShot().takeScreenshot(webdriver, element);

		File output = new File(System.getProperty("user.dir") + "/files/baseLine/" + name + ".png");
		ImageIO.write(shot.getImage(), "png", output);

	}

	public void clickOnElemenmtWithOffset(WebElement element, int x, int y) {
		Actions build = new Actions(webdriver);

		build.moveToElement(element, x, y).click().build().perform();
	}

}
