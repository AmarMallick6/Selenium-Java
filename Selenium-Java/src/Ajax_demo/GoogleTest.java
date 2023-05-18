package Ajax_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		driver.get("http://google.com");
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("java");
		Thread.sleep(3000);
		List<WebElement>   slist =driver.findElement(By.className("G43f7e")).findElements(By.tagName("li"));
        System.out.println(slist.size()); //Count the size......
        System.out.println( slist.get(0).getText());
        for(WebElement e:slist)
        {
        	System.out.println(e.getText());
        }
        
        
        
     for(int i=0;i<slist.size();i++) //select a specific data from suggestions........
        {
        	String s= slist.get(i).getText();
        	if(s.contains("javascript"))
        	{
        		slist.get(i).click();
        		break;
        	}
        }
        
       
        
	}

}
