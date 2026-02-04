/*	1.Application url
	2.entering username
	3.entering password
	4.click on login button
	5.validating home page is displayed or not
	6.click on metric tab
	7.click on team dropdown
	8.Validating list of options from the dropdown
	9.selecting single option from the dropdown
	10.clicking on Date format
	11.validating one month (From date and To date) selected from date format
	12.Validating list of options from the date types
	13.comparing last week is equal or not
	14.clicking on last week from date types
	15.validating last week (From date and To date) selected from date format*/

package Automation_scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Typo_application {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Application url
		driver.get("https://app.typoapp.io/custom-login");
		Thread.sleep(2000);
		
		//entering username
		WebElement username= driver.findElement(By.xpath("//input[@type='email']"));
		username.sendKeys("demo@typoapp.io");
		
		//entering password
		WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("typo@007");
		
		//click on login button
		WebElement loginbutton=driver.findElement(By.xpath("//p[text()='Login']"));
		loginbutton.click();
		
		//validating home page is displayed or not
		String act_title=driver.getTitle();
		if(act_title.equals("Typo")) {
			System.out.println("verification passed landing to the homepage successfully: "+ act_title);
		}else {
			System.out.println("verification failed not landing to the homepage successfully: "+ act_title);

		}
		
		//click on metric tab
		Thread.sleep(3000);
		WebElement click_metrics=driver.findElement(By.xpath("//div[@id='home']"));
		click_metrics.click();
		
		//click on team dropdown
		Thread.sleep(3000);
		WebElement teamdropdown = driver.findElement(By.xpath("//*[@class='form-field']"));
		teamdropdown.click();
		Thread.sleep(3000);
		
		//Validating list of options from the dropdown
		List<WebElement> options=driver.findElements(By.xpath("//div[@id='select-team-1_list']"));
		
		for(WebElement op:options) {
			System.out.println("list of options available in dropdown: "+op.getText());
		}
		
		//selecting single option from the drop_down
		driver.findElement(By.xpath("//div[normalize-space()='Backend Team' and text()='Backend Team']")).click();
		
		//clicking on Date format
		WebElement datepicker = driver.findElement(By.xpath("//*[@class='datepicker']"));
		datepicker.click();
		Thread.sleep(3000);
		
		//validating one month (From date and To date) selected from date format
		List<WebElement> dateoptions=driver.findElements(By.xpath("//*[@class='date-container']"));
		System.out.println("validating count of start date and end date: "+dateoptions.size());
		
		for(WebElement op1:dateoptions) {
			System.out.println("validating start date and end date for month: "+op1.getText());
		}
		
		//Validating list of options from the date type
		List<WebElement> dateoption=driver.findElements(By.xpath("//*[@class='rdrStaticRanges']"));
		for(WebElement op2:dateoption) {
			System.out.println("list of options available in date types: "+op2.getText());
		}
		
		//comparing last week is equal or not
		Thread.sleep(3000);
		WebElement lastweek=driver.findElement(By.xpath("//button[@type='button']/following::p[text()='Last week']"));
		if(lastweek.getText().equals("Last week")) {
			System.out.println("Last week is selected successfully: "+lastweek.getText());
		}else {
			System.out.println("Last week is not selected successfully: "+lastweek.getText());
		}
		
		//clicking on last week from date types
		lastweek.click();
		
		//validating last week (From date and To date) selected from date format
		List<WebElement> weekval=driver.findElements(By.xpath("//*[@class='date-container']"));		
		for(WebElement op3:weekval) {
			System.out.println("validating start date and end date for last week: "+op3.getText());
		}
			
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		driver.quit();
		
}
}
