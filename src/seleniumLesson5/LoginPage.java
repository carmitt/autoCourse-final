package seleniumLesson5;

import org.openqa.selenium.WebElement;

import lesson6.GenericWebDriver;

public class LoginPage extends GenericPageObject {

	private static final String DIV_ID_PASSWORD = "//div[@id='password']";
	private static final String DIV_ID_USERNAME = "//div[@id='username']";

	public LoginPage(GenericWebDriver webDriver) {
		super(webDriver);
	}

	public void enterUserName(String username) {
		getUserNameElement().sendKeys(username);

	}

	private WebElement getUserNameElement() {
		return webDriver.getElement(DIV_ID_USERNAME);
	}

	public void enterPassword(String string) {
		getPasswordElement().sendKeys(string);

	}

	private WebElement getPasswordElement() {
		return webDriver.getElement(DIV_ID_PASSWORD);
	}

	public void submit() {
		// TODO Auto-generated method stub

	}

	public void openPageAndLogin(String userName, String password) {
		webDriver.openUrl("");

		enterUserName(userName);

		enterPassword(password);

		submit();
	}

	public String getTitle() {
		return webDriver.getElement("div[@id='title']").getText();
	}

}
