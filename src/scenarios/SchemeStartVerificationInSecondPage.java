package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SchemeStartVerificationInSecondPage {
	@Test
	public void verify() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@class='menuparent repb nav-goldmine-link']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("amount")).sendKeys("10000");
		driver.findElement(By.id("Email")).sendKeys("divya@gmail.com");
		driver.findElement(By.xpath("//input[@id='tahLpSubmit']")).click();
		
		driver.findElement(By.name("_eventId_savePersonalAddressDetails")).click();
		
		if(driver.findElement(By.id("contactNumber_error")).isDisplayed())
			System.out.println("ContactNumber error is displayed");
		if(driver.findElement(By.id("fullname_error")).isDisplayed())
			System.out.println("Name error is displayed");
		if(driver.findElement(By.id("address_error")).isDisplayed())
			System.out.println("Address error is displayed");
		if(driver.findElement(By.id("postcode_delivery_error")).isDisplayed())
			System.out.println("pincode error is displayed");
		driver.close();
		
	}
}
