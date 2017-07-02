package Services;

import java.util.ArrayList;
import java.util.List;

import org.bson.BsonJavaScript;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDbService {

	MongoClient mongoClient;

	public MongoDbService() {
		
		System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\Omers\\Documents\\smongostore");
		System.setProperty("javax.net.ssl.trustStorePassword", "tamar2010");
		mongoClient = new MongoClient("ec2-54-191-193-124.us-west-2.compute.amazonaws.com", 27017);
	}

	public String insertToCollection(String collectionName, String dbName, List<String[]> values) {
		BasicDBObject basicDBObject = new BasicDBObject();
		// basicDBObject.put("database", dbName);
		// basicDBObject.put("table", collectionName);

		String newId = null;

		BasicDBObject insertDetails = new BasicDBObject();

		ObjectId id;
		try {
			for (int i = 0; i < values.size(); i++) {

				insertDetails.put(values.get(i)[0], values.get(i)[1]);

			}

			basicDBObject.put("detail", insertDetails);

			DB db = mongoClient.getDB(dbName);

			DBCollection collection = db.getCollection(collectionName);

			collection.insert(basicDBObject);

			newId = basicDBObject.get("_id").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newId;
	}

	public List<String[]> getCollection(String dbName, String collectionName, String[] fields) {

		List<String[]> list = new ArrayList<String[]>();

		DB db = mongoClient.getDB(dbName);

		DBCollection collection = db.getCollection(collectionName);

		// BasicDBObject find = new BasicDBObject("testName", methodName);

		DBCursor cursor = collection.find();

		while (cursor.hasNext()) {
			BasicDBObject basicDBObject = (BasicDBObject) cursor.next();

			String[] arr = new String[fields.length];

			for (int i = 0; i < fields.length; i++) {

				arr[i] = basicDBObject.getString(fields[i]);

			}

			list.add(arr);

		}

		return list;

	}

}
