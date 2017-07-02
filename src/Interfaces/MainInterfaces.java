package Interfaces;

import java.util.ArrayList;
import java.util.List;

public class MainInterfaces {

	public static void main(String[] args) {
		Writer writer = null;
		
		String fileType=getFileType();
		if(fileType.equals("HTML")){
			writer=new HtmlWriterImpl();
		}
		else if(fileType.equals("CSV")){
			writer=new CSVWriter();
		}
		
		List<String>arrList = new ArrayList<String>();
		
		writer.save(arrList);

	}

	private static String getFileType() {
		// TODO Auto-generated method stub
		return null;
	}

}
