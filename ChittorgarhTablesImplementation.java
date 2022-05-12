package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhTablesImplementation {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
		System.out.println("Security Names:: ");
		List<String> securityNames  = new ArrayList<String>();
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<columns.size();j++)
			{
				if(j==2)
				{
					securityNames.add(columns.get(j).getText());
				}
			}
		}
		System.out.println(securityNames);
		Set<String> securityNamesWithoutDuplicates = new LinkedHashSet<String>();
		securityNamesWithoutDuplicates.addAll(securityNames);
		System.out.println(securityNamesWithoutDuplicates);
		driver.close();
	}

}
