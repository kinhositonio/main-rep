package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RequiredFields {

	private WebDriver driver;
	MethodsRep methodsRep = new MethodsRep();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joaqu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		
		//check all fields are required on PT-Br
		assertTrue("Required name is missing",((driver.findElement(By.cssSelector(".col-md-7 .form-feedback-item"))).getText()).contains("Este campo é obrigatório."));
		assertTrue("Required date is missing",((driver.findElement(By.cssSelector(".col-md-5 .form-feedback-item"))).getText()).contains("Este campo é obrigatório."));
		assertTrue("Required answer is missing",((driver.findElement(By.cssSelector(".col-md-12 > .form-group .form-feedback-item"))).getText()).contains("Este campo é obrigatório."));
				
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		//THIS TC COVERS BOTH LANGUAGES
		//open site
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		driver.manage().window().maximize();
		
		//submit with all fields empty
		methodsRep.submitForm(driver);
		
		//check all fields are required on English
		assertTrue("Required name is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/div/div"))).getText()).contains("This field is required."));
		assertTrue("Required date is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div"))).getText()).contains("This field is required."));
		assertTrue("Required answer is missing",((driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/div/div"))).getText()).contains("This field is required."));
				
		
		//change to PT-BR
		methodsRep.changeLang(driver);
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		//submit with all fields empty
		methodsRep.submitForm(driver);
		
	}

}
