package screenshotsAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotsAutomation {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup(); 
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(1000);
		
		takeScreenshots("facebooktest");
		
		Thread.sleep(1000);
		
		driver.close();

	}
	
	public static void takeScreenshots(String fileName) throws IOException {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // Type cast -> driver
		FileUtils.copyFile(f, new File("C:\\Users\\tigerit\\eclipse-workspace\\screenshots\\screenshots\\"+fileName+".jpg"));
	}

}
