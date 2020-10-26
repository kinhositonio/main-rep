package liferayTCs;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeBR {
	
	private WebDriver driver;
	MethodsRep methodsRep = new MethodsRep();
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\joaqu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@After
	public void tearDown() throws Exception {
		//check confirmation text
		assertTrue("Submit was not sent",((driver.findElement(By.xpath("/html"))).getText()).contains("Informações enviadas com sucesso!"));
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
		
		//check if "party rock" is present
		assertTrue("'party rock' was not found",((driver.findElement(By.xpath("/html"))).getText()).contains("party rock"));
		
		methodsRep.fillName("Joaquim Sitonio",driver);
		
		methodsRep.fillDate(driver);
		
		methodsRep.fillAnswer("Lorem Ipsum",driver);
		
		methodsRep.submitForm(driver);		
	
	}

}
