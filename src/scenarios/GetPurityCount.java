package scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GetPurityCount {
	@Test
	public void getCount() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(4000);
		
		//driver.findElement(By.xpath("//a[text()='Rings ']")).click();
		
		Actions act =new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//section[@id='Gold Purity-form']")));
		//driver.findElement(By.xpath("//section[@id='Gold Purity-form']/div[@class='content']/descendant::form/descendant::div[@class='form-item last']")).click();
		driver.findElement(By.id("search_query_top_elastic_search")).sendKeys("rings");
		act.sendKeys(Keys.ENTER).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@title='Click for More Filters']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement wb=driver.findElement(By.xpath("//section[@id='Gold Purity-form']/descendant::form[@id='gold purity']/div/div[@class='form-item last']/span/span[@class='items-count']"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(wb.getText());
		driver.close();
		
	}
}
