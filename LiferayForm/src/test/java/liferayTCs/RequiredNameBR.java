package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RequiredNameBR {

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
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Informa��es enviadas com sucesso!"));
		
		//check "date" and "answer" are warning about the Required info
		assertTrue("'Required date' is missing",((driver.findElement(By.cssSelector(".col-md-5 .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));
		assertTrue("'Required answer' is missing",((driver.findElement(By.cssSelector(".col-md-12 > .form-group .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));
		
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
		
		
		//1. try to submit without fill name field

		methodsRep.fillDate(driver);
		methodsRep.fillAnswer("Lorem Ipsum", driver);	
		
		//try to submit without name
		methodsRep.submitForm(driver);
		
		//check form was not submited with empty fields
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Informa��es enviadas com sucesso!"));
		
		//check if warning is shown on empty field
		assertTrue("'Required name' is missing",((driver.findElement(By.cssSelector(".col-md-7 .form-feedback-item"))).getText()).contains("Este campo � obrigat�rio."));
		
		// 2. Clear "date" and "answer" fields and try to submit form only with "name" field filled
		
		//Clear fields
		methodsRep.clearField("date", driver);
		methodsRep.clearField("answer", driver);
		
		//fill name
		methodsRep.fillName("Joaquim Sitonio", driver);
		
		//try to submit only with "name" filled
		methodsRep.submitForm(driver);
		
	}
}
