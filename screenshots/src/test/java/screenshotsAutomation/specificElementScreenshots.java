package screenshotsAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class specificElementScreenshots {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup(); 
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(1000);
		
		takeScreenshots("facebooklogotest");
		
		Thread.sleep(1000);
		
		driver.close();

	}
	
	public static void takeScreenshots(String fileName) throws IOException {
		WebElement fb_logo_img = driver.findElement(By.cssSelector(".fb_logo"));
		File f = fb_logo_img.getScreenshotAs(OutputType.FILE);  // Type cast -> driver
		FileUtils.copyFile(f, new File("C:\\Users\\tigerit\\eclipse-workspace\\screenshots\\screenshots\\"+fileName+".jpg"));
	}

}
