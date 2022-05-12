package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableCount {

	public static void main(String[] args)  
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement table1 = driver.findElement(By.xpath("//div[@class='render']/table"));
		List<WebElement> rows1 = table1.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		int sizeOfColumn=0;
		for(int i=0;i<rows1.size();i++)
		{
			List<WebElement> columns1= rows1.get(i).findElements(By.tagName("td"));
			sizeOfColumn = columns1.size();
			for(int j=0;j<columns1.size();j++)
			{
				System.out.println(columns1.get(j).getText());
			}
		}
		System.out.println("Number of Rows in Table 1 (table body) :: "+rows1.size());
		System.out.println("Number of Columns in Table 1 :: "+sizeOfColumn);
		WebElement table2 = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		List<WebElement> rows2 = table2.findElements(By.tagName("tr"));
		for(int i=0;i<rows2.size();i++)
		{
			List<WebElement> columns2= rows2.get(i).findElements(By.tagName("td"));
			sizeOfColumn = columns2.size();
		}
		System.out.println("Number of Rows in Table 2 :: "+rows2.size());
		System.out.println("Number of Columns in Table 2 :: "+sizeOfColumn);
		driver.close();
	}

}