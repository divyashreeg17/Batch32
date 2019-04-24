package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyNavigationToPaymentPage {
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
		driver.findElement(By.id("contactNumber")).sendKeys("1258764545");
		driver.findElement(By.id("fullname")).sendKeys("Divya");
		driver.findElement(By.id("address")).sendKeys("#24, Ulsoor,bangalore");
		driver.findElement(By.id("postcode_delivery")).sendKeys("570008");
		
		driver.findElement(By.name("_eventId_savePersonalAddressDetails")).click();
		driver.findElement(By.id("nomineeName")).sendKeys("Sathya");
		driver.findElement(By.name("_eventId_checkoutSaveAddressDetails")).click();
		WebElement navigationTag=driver.findElement(By.xpath("//span[@class='checkout-current']"));
		String color=navigationTag.getCssValue("color");
		SoftAssert s=new SoftAssert();
		s.assertEquals(color, "rgb(241, 93, 71)");
		System.out.println(color);
		driver.close();
	}
}
