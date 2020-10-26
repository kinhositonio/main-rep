package liferayTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MethodsRep {
	
	//method to change language to Br
	public void changeLang (WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_kldx___menu")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_kldx______menu__portugues_2d_brasil__1")).click();
		Thread.sleep(2000);
	}
	
	// method to fill name
	public void fillName(String name, WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector(
				".col-md-7 .ddm-field-text"))
				.sendKeys(name);
		Thread.sleep(2000);
	}

	// method to fill date
	public void fillDate(WebDriver driver) throws InterruptedException {
		// open calendar
		driver.findElement(By.cssSelector(
				".lexicon-icon-calendar"))
				.click();
		Thread.sleep(1000);
		// fill calendar
				driver.findElement(By.cssSelector(
						".outside:nth-child(1)"))
						.click();
				Thread.sleep(2000);
	}

	// method to fill answer
	public void fillAnswer(String answer, WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector(
				".col-md-12 > .form-group > .ddm-field-text"))
				.sendKeys(answer);
		Thread.sleep(2000);
	}

	// method to click on submit
	public void submitForm(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector(".btn-primary"))
				.click();
		Thread.sleep(1000);
	}
	
	//method to clear fields
	// options name/date/answer
	public void clearField (String entry, WebDriver driver) throws InterruptedException {
		if (entry == "name") {	
			driver.findElement(By.cssSelector(".col-md-7 .ddm-field-text")).clear();
			Thread.sleep(1000);
		} else if (entry == "date") {
			driver.findElement(By.cssSelector(".input-group-inset")).clear();
			Thread.sleep(1000);
		} else if (entry == "answer"){
		driver.findElement(By.cssSelector(".col-md-12 > .form-group > .ddm-field-text")).clear();
		Thread.sleep(1000);}
	}

}
