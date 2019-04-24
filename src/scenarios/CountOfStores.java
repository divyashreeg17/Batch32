package scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CountOfStores {
		@Test
		public void verify() throws InterruptedException {
			WebDriver driver=new FirefoxDriver();
			driver.get("https://www.bluestone.com/");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[text()='Visit Our Stores']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<WebElement> stores=driver.findElements(By.xpath("//div[@class='store-city ']/descendant::div[@class='map-wrap']"));
			System.out.println("Number of locations: "+ stores.size());
			driver.close();
		}
}
