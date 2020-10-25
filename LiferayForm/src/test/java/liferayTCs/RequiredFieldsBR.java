package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RequiredFieldsBR {

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
		assertFalse("Form was submited with empty fields",((driver.findElement(By.xpath("/html"))).getText()).contains("Informações enviadas com sucesso!"));
		
		//check all fields are required
		assertTrue("Required name is missing",((driver.findElement(By.cssSelector(".col-md-7 .form-feedback-item"))).getText()).contains("Este campo é obrigatório."));
		assertTrue("Required date is missing",((driver.findElement(By.cssSelector(".col-md-5 .form-feedback-item"))).getText()).contains("Este campo é obrigatório."));
		assertTrue("Required answer is missing",((driver.findElement(By.cssSelector(".col-md-12 > .form-group .form-feedback-item"))).getText()).contains("Este campo é obrigatório."));
		
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
		
		methodsRep.submitForm(driver);
	}

}
