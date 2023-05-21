package selenium_mouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switch_Window {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Set<String>  windows= driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String w1= it.next(); 
        String w2= it.next();
		//driver.switchTo().window(w2);
		driver.findElement(By.linkText("Why OrangeHRM")).click();
		driver.close();
	}

}
