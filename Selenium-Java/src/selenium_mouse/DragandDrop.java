package selenium_mouse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://jqueryui.com");
		driver.findElement(By.linkText("Droppable")).click();
		String  mw=driver.getWindowHandle();
		// Handling I_Frames........................
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement srcfile=driver.findElement(By.id("draggable"));
		WebElement targetfile=driver.findElement(By.id("droppable"));
		Actions ac=new Actions(driver);
		ac.dragAndDrop(srcfile, targetfile);
		ac.build().perform();
        driver.switchTo().window(mw); //Return to Main Window..........
        driver.findElement(By.linkText("Download")).click();
	}

}
