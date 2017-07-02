package lesson6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWebDriver {

	RemoteWebDriver webDriver;

	int defaultTimeOut = 10;

	public GenericWebDriver() throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("start-maximized");

		chromeOptions.addArguments("use-gl");

		chromeOptions.addArguments("ignore-gpu-blacklist");

		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		LoggingPreferences loggingPreferences = new LoggingPreferences();

		loggingPreferences.enable(LogType.BROWSER, Level.ALL);

		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

		this.webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	}

	public void dragAndDropElement(String xpathFrom, String xpathTo) {
		Actions actions = new Actions(webDriver);

		actions.dragAndDrop(webDriver.findElementByXPath(xpathFrom), webDriver.findElementByXPath(xpathTo)).perform();
	}

	public WebElement getElement(String xpath) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, 10, 1000);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		} catch (UnhandledAlertException e) {
			System.out.println("Alert with text: " + getAlertText() + " was presented");
			Assert.fail("Unexpected alert");

		} catch (org.openqa.selenium.NoSuchElementException e) {

		} catch (InvalidElementStateException e) {

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return element;
	}

	/**
	 * Use this method to get alert text, when unexpected alert opens in the
	 * browser
	 * 
	 * @throws Exception
	 */
	public void getUnexpectedAlertDetails() throws Exception {
		String alertText = getAlertText();
	}

	private String getAlertText() {
		WebDriverWait wait = new WebDriverWait(webDriver, defaultTimeOut, 1000);
		String text = null;
		try {
			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				Alert alert = webDriver.switchTo().alert();
				text = alert.getText();
			}
		} catch (Exception e) {
			System.out.println("Could not get alert text. might have timed out");
		}
		return text;
	}

	public WebElement getParentElement(WebElement element) {
		return element.findElement(By.xpath(".."));
	}

	List<WebElement> getElementsByXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10, 1000);

		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public void runJavascript(String script) {
		webDriver.executeScript(script);

	}

	public String getPageHTML() {

		return (String) ((JavascriptExecutor) webDriver).executeScript("document.documentElement.outerHTML");

	}

	public int getScreenButtom() {
		return webDriver.manage().window().getSize().height;
	}

	public void scrollInPage(int y) {
		runJavascript("window.scrollTo(" + y + ", 0);");
	}

	public void openUrl(String string) {
		webDriver.get(string);

	}

	public void addCookie(String cookieName, String cookieVlaue) {
		webDriver.manage().addCookie(new Cookie(cookieName, cookieName));
	}

	public void deleteCookie(String cookieName) {
		Cookie cookie = webDriver.manage().getCookieNamed(cookieName);
		webDriver.manage().deleteCookie(cookie);
	}

	public boolean checkIfCookieExist(String cookieName) {
		Cookie cookie = webDriver.manage().getCookieNamed(cookieName);
		if (cookie == null) {

			return false;
		} else
			return true;
	}

	public void deleteCookies() {
		webDriver.manage().deleteAllCookies();
	}

	public void switchToTab(int tabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());

		System.out.println(tabs.size());

		webDriver.switchTo().window(tabs.get(tabIndex));
	}

}
