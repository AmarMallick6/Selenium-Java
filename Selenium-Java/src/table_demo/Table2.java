package table_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.railyatri.in/time-table");
  //Scrip to Read all Trains information present in IRCTC Trains Table............
        WebElement TrainTable= driver.findElement(By.xpath("//div/div/div/div/div/table"));
        List<WebElement> rows,cols;
        rows= TrainTable.findElements(By.tagName("tr"));
       
        for(int i=1;i<rows.size();i++)
        {
        	 cols=rows.get(i).findElements(By.tagName("td"));
        	 for(int j=0;j<cols.size();j++)
        	 {
        		 System.out.println(cols.get(j).getText());
        	 }
        }
        
	}

}
