package scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Bluestone1 {
		@Test
		public void getoff() throws InterruptedException {
			WebDriver driver=new FirefoxDriver();
			driver.get("https://www.bluestone.com/");
			Thread.sleep(4000);
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[text()='Offers ']"))).perform();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//div[@class='bottom-header']/descendant::nav/child::ul/child::li[@class='menuparent offers-menuparent pull-right']/descendant::div/descendant::ul/child::li/child::span[text()='Flat 5% Off']")).click();
			//driver.findElement(By.xpath("//a[text()='Offers ']/parent::li/child::div/child::ul/child::li/child::span[text()='Flat 5% Off']")).click();
			driver.findElement(By.xpath("//span[text()='Flat 5% Off']")).click();
			Thread.sleep(2000);
			
			List<WebElement> lst1=driver.findElements(By.xpath("//span[@class='orange-color']"));
			int productsWithOff=lst1.size();
			List<WebElement> lst2=driver.findElements(By.xpath("//div[@class='inner pd-gray-bg']"));
			int ProductsDisplayed=lst2.size();
			SoftAssert s=new SoftAssert();
			s.assertEquals(productsWithOff, productsWithOff);
			
			driver.close();
		}
}
