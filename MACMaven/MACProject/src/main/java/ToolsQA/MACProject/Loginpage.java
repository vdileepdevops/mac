package ToolsQA.MACProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginpage 
{
	WebDriver driver;

	public void home() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "E://Eclipse//chromedriver87//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://13.234.192.218:65504");	
		driver.findElement(By.name("username")).sendKeys("admin@kapilit.com");
		driver.findElement(By.name("password")).sendKeys("kapil");
//	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='btn btn-b-icon px-3 border-0 btn-block']")).click();
	    Thread.sleep(2000);
	}

}
