package scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Bluestone {
	@Test
	public void getMenu() throws Throwable {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.bluestone.com/");
		Thread.sleep(4000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Rings ']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Diamond Rings']")).click();
		List<WebElement> lst=driver.findElements(By.xpath("//div[@id='grid-view-result']/descendant::li/child::div[@class='inner pd-gray-bg']/child::div/descendant::span[@class='b-price-wrapper']/descendant::span[@class='new-price']"));
		for(WebElement wb: lst) {
			System.out.println(wb.getText());
		}
		act.moveToElement(driver.findElement(By.xpath("//section[@class='block sort-by pull-right']"))).perform();
		driver.findElement(By.xpath("//div[@id='view-sort-by']/descendant::a[text()='Price High to Low ']")).click();
		
		List<WebElement> lst1=driver.findElements(By.xpath("//div[@id='grid-view-result']/descendant::li/child::div[@class='inner pd-gray-bg']/child::div/descendant::span[@class='b-price-wrapper']/descendant::span[@class='new-price']"));
		for(WebElement wb: lst1) {
			System.out.println(wb.getText());
		}
		
		Thread.sleep(2000);
		driver.close();
	}

}
