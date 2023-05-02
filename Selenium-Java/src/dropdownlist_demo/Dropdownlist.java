package dropdownlist_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdownlist {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://Amazon.com");
		WebElement clist= driver.findElement(By.id("searchDropdownBox"));
		Select cat=new Select(clist);
		
  //Script to select a value from the DropDownList  by using varrious Methods .................................
		cat.selectByIndex(1);
		Thread.sleep(3000);
		cat.selectByVisibleText("Books");
		Thread.sleep(3000);
		cat.selectByValue("search-alias=beauty-intl-ship");
 //Script to handle the exception that occurs , if specified option not present in the dropdownlist...........
		try {
			   cat.selectByVisibleText("Car");
			    
		} catch (Exception e) {
			 System.out.println("Not Available in Productlist");
		}
 //Counting & Reading all options present in a DropDownList using : getOptions()	
	    List<WebElement>  Allcategory= cat.getOptions();
	    int s= Allcategory.size();
		System.out.println(s);
		for(WebElement pname :Allcategory)
		{
			System.out.println(pname.getText());
		}
  //Script to check the specified item present in the DropDownList or not............		
		String item_tobe_check = "software";
		boolean isitempresent = false;
		for(int i=0;i<s;i++)
		{
			if(Allcategory.get(i).getText().equalsIgnoreCase(item_tobe_check))
			{
				isitempresent = true;
				break;
			}
		}
		if(isitempresent)
		{
			System.out.println(item_tobe_check+" is present in the list, test pass");
		}else
		{
			System.out.println(item_tobe_check+" is not present in the list, test fail");
		}
 //Script to check all items present in a dropdownList are displayed in ascending order or not
		String cat1,cat2;
		
		boolean order=true;
		for(int i=1;i<s;i++)
		{
			cat1= Allcategory.get(i-1).getText();
			cat2= Allcategory.get(i).getText();
			if(cat2.compareTo(cat1)<0)
			   {
				 order=false;
				 break;
			   }
		}
		    
		       if(order)
		          {
		    	     System.out.println("Test Pass");
		          }else {
		        	       System.out.println("Test Fail");
		                }
		
		
		
	}

}
