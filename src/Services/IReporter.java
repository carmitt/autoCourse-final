package Services;

import TestObjects.TestLog;

public interface IReporter {

	public int saveTestLog(TestLog testlog) throws Exception;
	
	public String getTestLog(TestLog testlog) throws Exception;
	


	

}
