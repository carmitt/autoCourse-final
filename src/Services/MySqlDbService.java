package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MySqlDbService {
	
	
	private Connection connection;

	public void initConn(){
		
		Connection conn = null;
//
//		try {
//			
//			
//			
//			MysqlDataSource dataSource = new MysqlDataSource();
//			dataSource.setUser("omers");
//			dataSource.setPassword("tamar2010");
//			dataSource.setServerName("autocourse.c8x9phtygmfu.us-west-2.rds.amazonaws.com");
//
//			dataSource.setDatabaseName("autoCourse");
//
//			conn = dataSource.getConnection();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
	}
	
	public String insertUpdateQuery(String sql) throws SQLException {
		// TODO Auto-generated method stub

		String value = null;

		try {
			openConn();

			java.sql.Statement statement = connection.createStatement();

			statement.execute(sql, Statement.RETURN_GENERATED_KEYS);

			ResultSet keyset = statement.getGeneratedKeys();

			if (keyset.next()) {
				// System.out.println(keyset.getLong(1));

				if (keyset.getString(1) != null) {
					value = String.valueOf(keyset.getLong(1));
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}
	
	private void openConn() {
		if (connection == null) {
//			connection = initConn();
		}
	}
	

}
