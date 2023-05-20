package calender_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://redbus.in");	
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
        String day="15";
        String month="Aug";
        String year="2025";
       while(true)
       {
    	   String monthyr=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
    	   String []arr= monthyr.split(" ");
    	   String mn=arr[0];
    	   String yr=arr[1];       
    	   if(yr.equals(year)&& mn.equalsIgnoreCase(month) )
    		   break;
    	   else
    		   driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
       }
        List<WebElement> alldt=driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//td"));
        for(WebElement e:alldt)
        {
        	String dt=e.getText();
        	if(dt.equals(day))
        	{
        		e.click();
        		break;
        	}
        
        }
	}

}
