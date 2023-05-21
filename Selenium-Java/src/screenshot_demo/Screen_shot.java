package screenshot_demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screen_shot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver driver chromedriver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://w3schools.com");
 //FUllScreen Screenshot.................................................
		/* TakesScreenshot ts=(TakesScreenshot) driver;
		 File src= ts.getScreenshotAs(OutputType.FILE);
		 File trgt= new File(".\\Screenshots\\Fullpage.png");
         FileUtils.copyFile(src, trgt);*/
         TakesScreenshot ts=(TakesScreenshot) driver;
         WebElement element=driver.findElement(By.xpath("//div[@class='w3-row w3-padding-32 ws-yellow']//div[@class='w3-col l6 w3-center']"));
		 File src= element.getScreenshotAs(OutputType.FILE);
		 File trgt= new File(".\\Screenshots\\Element.png");
         FileUtils.copyFile(src, trgt);
         driver.close();
		 
	}

}
