package week4.day1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeafTablesWebpage {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement table = driver.findElement(By.tagName("table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("Row size: "+rows.size());
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<columns.size();j++)
			{
				if((columns.get(j).getText()).equals("Learn to interact with Elements")) 
				{
					System.out.println(columns.get(j).getText()+" : " +columns.get(1).getText()); 
				}
				if((columns.get(j).getText()).equals("20%"))
				{
					columns.get(2).findElement(By.xpath("(//input[@name='vital'])[5]")).click();
				}
			} 
		}
		driver.close();
	}

}
