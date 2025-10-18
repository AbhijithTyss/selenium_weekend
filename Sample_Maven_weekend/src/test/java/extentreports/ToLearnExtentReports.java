package extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {
	@Test
	public void createReport() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		
		// step 1: create ExtentSaprkReporter object
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReports_"+time+".html");
		
		// step 2: create ExtentReports object
		ExtentReports ereport=new ExtentReports();
		
		// step 3: attach ExtentSaprkReporter to ExtentReports
		ereport.attachReporter(spark);
		
		// step 4: create ExtentTest object
		ExtentTest test = ereport.createTest("createReport");
		
		// step 5: call log(Status,"message")
		test.log(Status.PASS, "message added into report");
		test.log(Status.INFO, "message added");
		
		// step 6: call flush()
		ereport.flush();
	}
}
