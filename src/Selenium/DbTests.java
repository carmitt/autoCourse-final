package Selenium;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class DbTests extends BasicTest {

	@Test
	public void testDbInsert() {

		// generate random data

		List<String[]> list = new ArrayList<String[]>();

		for (int i = 0; i < 20; i++) {
			String[] arr = new String[5];

			for (int j = 0; j < 5; j++) {
				arr[j] = RandomStringUtils.randomAlphanumeric(10);
			}
			list.add(arr);
		}

		dbservice.insertToCollection("tests", "automation", list);

	}

}
