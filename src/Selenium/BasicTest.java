package Selenium;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.logging.LogEntry;

import Interfaces.myTestParams;
import PageObjects.AddItemPageObject;
import PageObjects.LoginPage;
import Services.ConfigFileImpl;
import Services.HtmlReporterImpl;
import Services.IConfigService;
import Services.IReporter;
import Services.MongoDbService;
import TestObjects.TestLog;

public class BasicTest {
	
	
	public String sut_url;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void succeeded(Description description) {

			if (testlog.hasFailures() == false) {
				Assert.fail("Test had some failures");

			}

			super.succeeded(description);
		}

		@Override
		protected void starting(Description description) {

			try {
				if (description.getAnnotation(myTestParams.class) != null) {
					myTestParams param = description.getAnnotation(myTestParams.class);

					if (!param.browser().equals("")) {
						browser = param.browser();
					}
					
					
					if(param.url()!=null){
						sut_url=param.url();
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			super.starting(description);
		}

	};

	GenericWebDriver webdriver;

	LoginPage loginPage;

	AddItemPageObject addItem;

	// ********* test logging

	TestLog testlog;

	IReporter reporter;

	MongoDbService dbservice;

	String browser = null;

	String env;

	public IConfigService configService;

	@Before
	public void setup() throws Exception {

		if (System.getProperty("env") != null) {
			env = System.getProperty("env");
		} else {
			env = "qa";
		}

		configService = new ConfigFileImpl();

		configService.load(env);

		configService.getProperty("sut.url");

		testlog = new TestLog();

		reporter = new HtmlReporterImpl();

		// if (browser.equals("")) {
		// if (System.getProperty("browser") != null) {
		// browser = System.getProperty("browser");
		// } else if (configService.getProperty("browser") != null) {
		// browser = configService.getProperty("browser");
		// }
		// else{
		// browser="chrome";
		// }
		//
		// }
		//
		//

		// }

		// webdriver=new IEWebDriver();

		try {
			webdriver = new GenericWebDriver();

			// webdriver.init("http://localhost:4444/wd/hub", testlog);

			String grid=null;
			
//			if(System.getProperty("ci")!=null){
//				grid=
//			}
			
			webdriver.init("http://52.176.41.55:4444/wd/hub", testlog);
			loginPage = new LoginPage(webdriver);

			addItem = new AddItemPageObject(webdriver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dbservice = new MongoDbService();

	}

	@After
	public void tearDown() throws Exception {

		// List<LogEntry> logs = webdriver.geWeBrowserLogs().getAll();
		//
		// for (int i = 0; i < logs.size(); i++) {
		// System.out.println(logs.get(i).getLevel().toString() + " " +
		// logs.get(i).getMessage());
		// }
		//
		// if (logs.size() == 0) {
		// System.out.println("No logs found");
		// }

		// webdriver.quit();

		reporter.saveTestLog(testlog);
	}

}
