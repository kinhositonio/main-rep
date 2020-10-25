package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RequiredDate {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joaqu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		
		//check form was not submited with empty fields
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Information sent successfully!"));
		
		//check "name" and "answer" are warning about the Required info
		assertTrue("'Required name' is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/div/div"))).getText()).contains("This field is required."));
		assertTrue("'Required answer' is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/div/div"))).getText()).contains("This field is required."));
		
		//check date is not warning
		assertFalse("'Required date' should not appear",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]"))).getText()).contains("This field is required."));
		
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		//open site
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		driver.manage().window().maximize();
		
		
		//1. try to submit without fill date field

		//fill name
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/input")).sendKeys("Joaquim Sitonio");
		Thread.sleep(1000);
		//fill answer
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/textarea")).sendKeys("lorem ipsum");
		Thread.sleep(1000);
		
		//try to submit without date
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[2]/button")).click();
		Thread.sleep(1000);
		
		//check form was not submited with empty fields
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Information sent successfully!"));
				
		//check if warning is shown on empty field
		assertTrue("'Required date' is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div"))).getText()).contains("This field is required."));
		
		// 2. Clear "name" and "answer" fields and try to submit form only with "date" field filled
		
		//Clear fields
		//name
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/input")).clear();
		Thread.sleep(1000);
		//answer
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/textarea")).clear();
		Thread.sleep(1000);
		
		//open calendar
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/button")).click();
		Thread.sleep(1000);
		//fill calendar
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/form/select[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div[1]/div[1]")).click();
		Thread.sleep(1000);
		
		//try to submit only with calendar filled
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[2]/button")).click();
		Thread.sleep(1000);
		
	}
}
