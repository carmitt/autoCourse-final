package Selenium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeWebDriver extends GenericWebDriver {
	
public void init(String remoteUrl) throws Exception {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\OmerS\\Desktop\\selenium\\MicrosoftWebDriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.edge();

		URL url = new URL(remoteUrl);

		webdriver = new RemoteWebDriver(url, capabilities);

	}

}
