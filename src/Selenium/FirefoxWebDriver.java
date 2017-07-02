package Selenium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import TestObjects.TestLog;

public class FirefoxWebDriver extends GenericWebDriver {
	
	public void init(String remoteUrl,TestLog testLog) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\OmerS\\Desktop\\selenium\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();

		URL url = new URL(remoteUrl);

		webdriver = new RemoteWebDriver(url, capabilities);

	}

}
