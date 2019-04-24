package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GetCountofWomen {
	@Test
	public void getoff() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(4000);
		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("rings");
		Actions act =new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		act.moveToElement(driver.findElement(By.id("Gender-form"))).perform();
		String womenItemsCount=driver.findElement(By.xpath("//section[@id='Gender-form']/descendant::form/div/div/span[@data-displayname='women']/span[@class='items-count']")).getText();
		System.out.println("Count of Women Rings: "+womenItemsCount);
		driver.close();
	}
}
