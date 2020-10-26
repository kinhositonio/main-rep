package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RequiredAnswer {

	private WebDriver driver;
	MethodsRep methodsRep = new MethodsRep();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joaqu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		
		//check form was not submited with empty fields
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Information sent successfully!"));
		
		//check "name" and "date" are warning about the Required info
		assertTrue("'Required name' is missing",((driver.findElement(By.cssSelector(".col-md-7 .form-feedback-item"))).getText()).contains("This field is required."));
		assertTrue("'Required date' is missing",((driver.findElement(By.cssSelector(".col-md-5 .form-feedback-item"))).getText()).contains("This field is required."));
		
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		//open site
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		driver.manage().window().maximize();
		
		
		//1. try to submit without fill answer field

		//fill name
		methodsRep.fillName("Joaquim Sitonio", driver);
		//fill date
		methodsRep.fillDate(driver);
		
		//try to submit without answer
		methodsRep.submitForm(driver);
		
		//check form was not submited with empty fields
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Information sent successfully!"));
		
		//check answer is not warning
		assertTrue("'Required answer' is missing",((driver.findElement(By.cssSelector(".col-md-12 > .form-group .form-feedback-item"))).getText()).contains("This field is required."));
		
		// 2. Clear "name" and "date" fields and try to submit form only with "answer" field filled
		
		//Clear fields
		methodsRep.clearField("name", driver);
		methodsRep.clearField("date", driver);
		
		//fill answer
		methodsRep.fillAnswer("Lorem Ipsum", driver);
		
		//try to submit only with "answer" filled
		methodsRep.submitForm(driver);
		
	}

}
