package calender_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calender1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://flights.qedgetech.com");
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.name("dob")).click();
		
		String dob="1/Aug/1947";
		String temp[]= dob.split("/");
		String date= temp[0];
		String month= temp[1];
		String year= temp[2];
		Select mlist=new Select(driver.findElement(By.className("ui-datepicker-month")));
		mlist.selectByVisibleText(month);
		Select ylist=new Select(driver.findElement(By.className("ui-datepicker-year")));
		ylist.selectByVisibleText(year);
		WebElement daytable= driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> rows,cols;
		rows=daytable.findElements(By.tagName("tr"));
		
		
		for(int i=1;i<rows.size();i++)
		  {
			cols=rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cols.size();j++)
			{
				String dt=cols.get(j).getText();
				if(dt.equals(date))
				{
					cols.get(j).click();
					break;
				}
			}
		  }
		
		
		
		
	}

}
