package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src//main//resources//features//HotelBooking.feature",
		glue= {"stepdefs"},
		monochrome = true,
		plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}  
		
		)

public class HotelBookingRunner {
	
	@AfterClass
	public static void writeExtentReport(){
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") +"//src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("UserName", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Appliction Name", "BDDPOM Case Study");
		Reporter.setSystemInfo("Operating System", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Testing");
		
	} 

}
