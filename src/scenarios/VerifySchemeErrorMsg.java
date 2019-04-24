package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class VerifySchemeErrorMsg {
	@Test
	public void verify() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@class='menuparent repb nav-goldmine-link']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='tahLpSubmit']")).click();
		WebElement errorMsg=driver.findElement(By.xpath("//ul[@id='amount_error']"));
		if(errorMsg.isDisplayed())
			System.out.println("Error msg is Displayed");
		driver.close();
	}
}
