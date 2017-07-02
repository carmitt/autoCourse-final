package Selenium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import enums.ByTypes;

import lesson8.SuperClass.autoUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Lesson27 extends BasicTest {

	@Test
	public void uploadFile() throws Exception {
		webdriver.openUrl("http://the-internet.herokuapp.com/upload");

		webdriver.getElementBy(ByTypes.id, "file-upload")
				.sendKeys(System.getProperty("user.dir") + "\\files\\headerHtml.txt");

		System.out.println();

	}

	@Test
	public void testSendHttpRequest() throws Exception {
		sendHttpRequest(null, "http://52.176.41.55:5555/", "GET", null);
	}
	
	@Test
	public void testSendMail(){
		
		List<String>mail=generateEmails(100);
		
		
	}

	public List<String> generateEmails(int size) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < size; i++) {
			list.add(RandomStringUtils.randomAlphabetic(10) + "@mailinator.com");
		}

		return list;
	}

	@Test
	public void compareScr() {

		// Screenshot scrShot = webdriver.takeAshot(webdriver.getElementBy(type,
		// value), name);

//		compareScr(webdriver.getScreenshot(element, ignoreXpath), baseLineImage);
	}

	public static void takeBaseLineImage(String baseLineName, WebElement element, WebDriver driver,
			String ignoreElementXpath) throws Exception {

		Screenshot shot = null;

		if (ignoreElementXpath != null) {
			shot = new AShot().addIgnoredElement(By.xpath(ignoreElementXpath)).takeScreenshot(driver, element);
		} else {
			shot = new AShot().takeScreenshot(driver, element);
		}

		File output = new File(System.getProperty("user.dir") + "/files/baseLine/" + baseLineName + ".png");
		ImageIO.write(shot.getImage(), "png", output);
	}

	public static String compareScr(Screenshot current, File baseLineImage) throws Exception {

		ImageDiff diff = null;
		try {

			if (baseLineImage == null) {
				Assert.fail("baseline image file is null");
			}

			System.out.println("baseline file name: " + baseLineImage.getAbsolutePath());

			BufferedImage baseLine = ImageIO.read(baseLineImage);

			diff = new ImageDiffer().makeDiff(new Screenshot(baseLine), current);

			System.out.println(diff.hasDiff());

			if (diff.hasDiff()) {

				File output = new File("diff" + RandomStringUtils.randomAlphabetic(6) + ".png");
				//
				ImageIO.write(diff.getMarkedImage(), "png", output);

				String outputPath = System.getProperty("user.dir") + "//files//" + output.getName();

				Services.Utils.fileUtils.copyFile(output, outputPath);

				return outputPath;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static String sendHttpRequest(String token, String endPoint, String requestMethod, String json)
			throws Exception {
		URL url = new URL(endPoint);
		HttpURLConnection connection = null;
		OutputStreamWriter streamWriter = null;

		String result = null;

		int responseCode = 0;

		try {
			connection = (HttpURLConnection) url.openConnection();

			if (token != null) {
				connection.setRequestProperty("Authorization", "Bearer " + token);
			}

			connection.setDoOutput(true);

			connection.setRequestMethod(requestMethod);

			if (json != null) {
				connection.setRequestProperty("Content-Type", "application/json");
				OutputStream os = connection.getOutputStream();
				os.write(json.getBytes());
				os.flush();
			}

			responseCode = connection.getResponseCode();

			StringWriter stringWriter = new StringWriter();

			IOUtils.copy(connection.getInputStream(), stringWriter);

			result = stringWriter.toString();

			System.out.println(result);

		} catch (Exception E) {
			System.out.println(E.getMessage());
		}

		return result;

	}

	@Test
	public void testQuestions() {
		// open page and login

		List<WebElement> questiuonContainerList = webdriver
				.getElementsByXpath("//span[@class='lo-question-feedback__button-text']");
		// for (int i=0;i<questiuonContainerList.size();i++
		//
		String[] results = new String[questiuonContainerList.size()];

		int index = 0;

		for (WebElement element : questiuonContainerList) {

			try {
				element.click();

			} catch (Exception e) {
				results[index] = "Failed to click in element in index: " + index + " Exception: " + e.getMessage();

				testlog.addAction("Failed ...", false);
			}
			index++;

		}

	}

}
