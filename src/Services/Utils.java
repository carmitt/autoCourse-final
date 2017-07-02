package Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

	public static class fileUtils {
		
		public static String getFileContent(String path) {

			String content = null;

			try {
				File file = new File(path);
				FileReader reader = null;
				reader = new FileReader(file);

				char[] chars = new char[(int) file.length()];
				reader.read(chars);
				content = new String(chars);
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return content;

		}

		public static void copyFile(File source, String destinationPath) {
			try {
				InputStream in = new FileInputStream(source);
				try {
					OutputStream out = new FileOutputStream(new File(destinationPath));
					try {
						// Transfer bytes from in to out
						byte[] buf = new byte[1024];
						int len;
						while ((len = in.read(buf)) > 0) {
							out.write(buf, 0, len);
						}
					} finally {
						out.close();
					}
				} finally {
					in.close();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public static String getCurrentDateTime() {

			Date date = new Date();
			String formattedDate;
			SimpleDateFormat sdf = null;
			sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			sdf.setTimeZone(TimeZone.getTimeZone("ISRAEL"));

			formattedDate = sdf.format(date);
			return formattedDate;
		}

		public static void deleteTestFolder() {
			// TODO Auto-generated method stub
			
		}

	}

}
