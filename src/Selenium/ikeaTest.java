package Selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Interfaces.myTestParams;
import PageObjects.ikeaPageObjects.IkeaHomePageObject;
import enums.ByTypes;

public class ikeaTest extends BasicTest {

	IkeaHomePageObject ikeaHome;

	@Before
	public void setup() throws Exception {

		super.setup();
		ikeaHome = new IkeaHomePageObject(webdriver);
	}

	@Test
	@myTestParams(url = "http://www.myCompany-%env%.com")
	public void testFuncUrlNumber1() {

		openUrl();

	}
	@Test
	@myTestParams(url = "http://www.fddsfdsf00000ds.com")
	public void testFuncUrlNumber2() {

		openUrl();

	}

	private void openUrl() {
		if (sut_url == null) {
			sut_url = configService.getProperty("sut.url");
		}
		else{
			sut_url.replace("%env%", env);
		}
		webdriver.openUrl(sut_url);
	}

	@Test
	public void testCalcTime() throws Exception {
		webdriver.openUrl("http://www.google.klum");

		webdriver.getElementBy(ByTypes.xpath, "//div[@class='aaaa']").click();

		long start = System.currentTimeMillis();

		webdriver.getElementBy(ByTypes.xpath, "//div[@class='waitFor...']");

		long finish = System.currentTimeMillis();

		long result = finish - start;

		System.out.println("took : " + result / 1000);

		// testlog.addAction(actionName);
	}

	@Test
	public void ikeaSearchTest() throws Exception {
		webdriver.openUrl("https://www.ikea.co.il/");

		String mkt = "20169559";

		// best practice: the item id will be generated from db/external file
		ikeaHome.searchItem(mkt);

		// String actualPrice=ikeaHome.getPriceString();

		// actualPrice=actualPrice.replace(" ₪", "");

		// Assert.assertTrue(actualPrice.equals("695"));

		Assert.assertEquals("695", ikeaHome.getPriceString());

		ikeaHome.addToWishList();

		ikeaHome.openWishlist();

		Assert.assertTrue(ikeaHome.CheckMKT(mkt));

		System.out.println();
	}

}
