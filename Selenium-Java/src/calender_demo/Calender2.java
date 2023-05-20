package calender_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calender2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.driver.chromedriver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
		driver.findElement(By.linkText("Create new account")).click();
		Select day=new Select(driver.findElement(By.id("day")));
		day.selectByValue("7");
		Select month=new Select(driver.findElement(By.id("month")));
		month.selectByIndex(3);
		Select year=new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("2010");
	}

}
