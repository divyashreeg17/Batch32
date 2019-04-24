package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyPrices {
	@Test
	public void getoff() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("rings");
		Actions act =new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//ul[@id='product_list_ui']/li[1]")).click();
		SoftAssert s= new SoftAssert();
		String actualPrice= driver.findElement(By.xpath("//span[@id='discountedPriceSpan']")).getText();
		System.out.println(actualPrice);
		s.assertEquals(actualPrice, "16,054", "matched");
		
		String originalPrice= driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();
		System.out.println(originalPrice);
		s.assertEquals(originalPrice, "17,838", "matched");
		String discountPrice= driver.findElement(By.xpath("//div[@id='offer']")).getText();
		System.out.println(discountPrice);
		
		driver.close();
	}
}
