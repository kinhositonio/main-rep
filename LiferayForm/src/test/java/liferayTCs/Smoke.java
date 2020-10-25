package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Smoke {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joaqu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@After
	public void tearDown() throws Exception {
		//check confirmation text
		assertTrue("Submit was not sent",((driver.findElement(By.xpath("/html"))).getText()).contains("Information sent successfully!"));
		driver.quit();
		
	}

	@Test
	public void test() throws InterruptedException {

		//open site
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		driver.manage().window().maximize();
		
		//check if "party rock" is present
		assertTrue("'party rock' was not found",((driver.findElement(By.xpath("/html"))).getText()).contains("party rock"));
		
		//fill name text box
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/input")).sendKeys("Joaquim Sitonio");
		Thread.sleep(1000);

		//open calendar
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/button")).click();
		Thread.sleep(1000);
		//fill calendar
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/form/select[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div[1]/div[1]")).click();
		Thread.sleep(1000);
		
		//fill answer text box
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/textarea")).sendKeys("lorem ipsum");
		Thread.sleep(1000);
		
		//submit form
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[2]/button")).click();
		Thread.sleep(1000);
		
		//Some "sleeps" were included to avoid performance issues
		
	
	}

}
