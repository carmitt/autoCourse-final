package Services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import Services.Utils.fileUtils;
import TestObjects.TestLog;
import enums.ActionStatus;

public class HtmlReporterImpl implements IReporter {

	public int saveTestLog(TestLog testlog) throws Exception {

		String fileName = String.valueOf(System.currentTimeMillis()) + ".html";

		PrintWriter printWriter = new PrintWriter(
				new FileOutputStream(System.getProperty("user.dir") + "\\files\\logs\\" + fileName));

		printWriter.println(addHtmlHeader());

		printWriter.println("<body>");
		for (int i = 0; i < testlog.steps.size(); i++) {
			printWriter.println("<div class='well'  data-toggle='collapse' data-target='#step" + i + "'>"
					+ testlog.steps.get(i).desc + "</div>");

			for (int j = 0; j < testlog.steps.get(i).stepActions.size(); j++) {
				printWriter.println("<div  id='step" + i + "' class='collapse'><div class='well'>"
						+ testlog.steps.get(i).stepActions.get(j).getActionDesc() + "</div></div>");
			}

		}
		printWriter.println("</body>");
		printWriter.close();

		return 0;

	}

	private String addHtmlHeader() {
		// TODO Auto-generated method stub
		return fileUtils.getFileContent(System.getProperty("user.dir") + "/files/headerHtml.txt");
	}

	public String getTestLog(TestLog testlog) throws Exception {

		String html = "";

		html += "<div>Fail reason: " + testlog.getFailReason() + "</div>";

		for (int i = 0; i < testlog.properties.size(); i++) {
			html += "<div>" + testlog.properties.get(i)[0] + ": " + testlog.properties.get(i)[1] + "</div>";
		}

		for (int i = 0; i < testlog.steps.size(); i++) {
			html += "<div>" + testlog.steps.get(i).getDesc() + "</div>";

			for (int j = 0; j < testlog.steps.get(i).stepActions.size(); j++) {
				html += "<div>" + testlog.steps.get(i).stepActions.get(j).getActionDesc() + "</div>";

				if (testlog.steps.get(i).stepActions.get(j).getActionStatus()
						.equals(ActionStatus.Screenshot.toString())) {

					String fileName = testlog.steps.get(i).stepActions.get(j).getActionScreenShot();
					fileName = fileName.substring(fileName.lastIndexOf('/') + 1);

					String url = "http://auto-dash.windward.com:8080/autoDashboard/generateS3Url.jsp?fileName="
							+ fileName;

					html += "<div><a href='" + url + "' target='_blank'>"
							+ testlog.steps.get(i).stepActions.get(j).getActionDesc() + "</a></div>";

				}
			}
		}

		return html;
	}

}
