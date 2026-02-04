package Automation_scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class date_picker {
	
	//selecting future dates
	static void futuredate(WebDriver driver,String month,String year,String date) {
		while(true) {
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentmonth.equals(month) && currentyear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
		List<WebElement> alldate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement dt:alldate) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}
	
	//selecting previous dates
	static void previousdate(WebDriver driver,String month,String year,String date) {
		while(true) {
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentmonth.equals(month) && currentyear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
		}
		List<WebElement> alldate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement dt:alldate) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		
		String year="2023";
		String month="December";
		String date="25";
		
		driver.findElement(By.id("datepicker")).click();
		
		//calling the method
		previousdate(driver, month, year, date);
		driver.quit();
			
		
		
	}

}
