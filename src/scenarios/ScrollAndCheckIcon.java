package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScrollAndCheckIcon {
	@Test
	public void getIcon() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(4000);
		
		System.out.println(driver.findElement(By.xpath("//span[@class='logo-icon']")).isDisplayed());
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement icon=driver.findElement(By.xpath("//span[@class='logo-icon']"));
		System.out.println(driver.findElement(By.xpath("//span[@class='logo-icon']")).isDisplayed());
		if(icon.isDisplayed())
			icon.click();
		
		driver.close();
		
	}
}
