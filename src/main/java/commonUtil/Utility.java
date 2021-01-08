package commonUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static String getScreenshot(WebDriver driver) throws IOException  {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src,dest);
		return path;  
	}

}


