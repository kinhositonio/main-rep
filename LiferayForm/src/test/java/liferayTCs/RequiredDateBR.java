package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RequiredDateBR {

	private WebDriver driver;
	MethodsRepBR methodsRep = new MethodsRepBR();
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joaqu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		
		//check form was not submited with empty fields
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Informa��es enviadas com sucesso!"));
		
		//check "name" and "answer" are warning about the Required info
		assertTrue("'Required name' is missing",((driver.findElement(By.cssSelector(".col-md-7 .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));
		assertTrue("'Required answer' is missing",((driver.findElement(By.cssSelector(".col-md-12 > .form-group .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));
		
		//check date is not warning
		assertFalse("'Required date' should not appear",((driver.findElement(By.cssSelector(".col-md-5 .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));
		
		//check name and answer warnings
		assertFalse("'Required name' should not appear",((driver.findElement(By.cssSelector(".col-md-7 .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));
		assertFalse("'Required answer' should not appear",((driver.findElement(By.cssSelector(".col-md-12 > .form-group .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));
				
		driver.quit();
		
	}

	@Test
	public void test() throws InterruptedException {

		//open site
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		driver.manage().window().maximize();
		
		//change to PT-BR
		methodsRep.changeLang(driver);
		driver.navigate().refresh();
		
		
		//1. try to submit without fill date field

		methodsRep.fillName("Joaquim Sitonio", driver);
		methodsRep.fillAnswer("Lorem Ipsum", driver);
		
		//try to submit without date
		methodsRep.submitForm(driver);

		//check form was not submited with empty fields
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Informa��es enviadas com sucesso!"));
				
		//check if warning is shown on empty field
		assertTrue("'Required date' is missing",((driver.findElement(By.cssSelector(".col-md-5 .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));

		// 2. Clear "name" and "answer" fields and try to submit form only with "date" field filled
		
		//Clear fields
		methodsRep.clearField("name", driver);
		methodsRep.clearField("answer", driver);
		
		//fill calendar
		methodsRep.fillDate(driver);
		
		//try to submit only with calendar filled
		methodsRep.submitForm(driver);
	}
}
