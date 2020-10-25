package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RequiredName {

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
		
		//check "date" and "answer" are warning about the Required info
		assertTrue("'Required date' is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div"))).getText()).contains("This field is required."));
		assertTrue("'Required answer' is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/div/div"))).getText()).contains("This field is required."));
		
		//check "name" is not warning
		assertFalse("'Required name' should not appear",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]"))).getText()).contains("This field is required."));
		
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		//open site
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		driver.manage().window().maximize();
		
		
		//1. try to submit without fill name field

		//fill date
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/form/select[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div[1]/div[1]")).click();
		Thread.sleep(1000);
		//fill answer
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/textarea")).sendKeys("lorem ipsum");
		Thread.sleep(1000);
		
		//try to submit without name
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[2]/button")).click();
		Thread.sleep(1000);
		
		//check form was not submited with empty fields
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Information sent successfully!"));
		
		//check if warning is shown on empty field
		assertTrue("'Required name' is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/div/div"))).getText()).contains("This field is required."));
		
		// 2. Clear "date" and "answer" fields and try to submit form only with "name" field filled
		
		//Clear fields
		//date
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/input[1]")).clear();
		Thread.sleep(1000);
		//answer
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/textarea")).clear();
		Thread.sleep(1000);
		
		//fill name
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/input")).sendKeys("Joaquim Sitonio");
		Thread.sleep(1000);
		
		//try to submit only with "name" filled
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[2]/button")).click();
		Thread.sleep(1000);
		
	}
}
