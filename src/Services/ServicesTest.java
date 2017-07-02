package Services;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ServicesTest {

	@Test
	public void testDbService() throws Exception {
		MySqlDbService dbService = new MySqlDbService();

		dbService.insertUpdateQuery("");
		
		System.out.println("222");
	}

}
