package table_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/tools/forex");
		WebElement ctable= driver.findElement(By.className("dataTable"));
   //	Script to count no. of rows & columns in a Table Row...........................
        List<WebElement> rows= ctable.findElements(By.tagName("tr"));
        List<WebElement> cols= rows.get(1).findElements(By.tagName("td"));
        System.out.println("Row Size : "+ rows.size());
        System.out.println("Column Size : "+ cols.size());
  //Script to Read data present in 1st Row of the WebTable........................
        String cname= cols.get(0).getText();
        String crate= cols.get(1).getText();
        System.out.println("Name :"+cname+"    "+"Rate :"+crate);
  //Script to Read All data present in  Rows  & Columns of the WebTable........................     
        List<WebElement> row,column;
        row= ctable.findElements(By.tagName("tr"));
        
        for(int i=1;i<row.size();i++)
        {    
        	 column= row.get(i).findElements(By.tagName("td"));
        	 String name= column.get(0).getText();
             String rate= column.get(1).getText();
             System.out.println("Name :"+name+"    "+"Rate :"+rate);
        }
        
        
        
	}

}
