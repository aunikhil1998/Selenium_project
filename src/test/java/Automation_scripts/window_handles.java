package Automation_scripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class window_handles {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=22636");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[.='Google']")).click();
		String pid=driver.getWindowHandle();
		System.out.println(pid);
		Set<String> pcid=driver.getWindowHandles();
		System.out.println(pcid);
	}

}
