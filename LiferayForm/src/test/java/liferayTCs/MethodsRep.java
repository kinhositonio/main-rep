package liferayTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MethodsRep {

	// method to fill name
	public void fillName(String name, WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/input"))
				.sendKeys(name);
		Thread.sleep(1000);
	}

	// method to fill date
	public void fillDate(WebDriver driver) throws InterruptedException {
		// open calendar
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/div/button"))
				.click();
		Thread.sleep(1000);
		// fill calendar
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div[1]/div[1]"))
				.click();
		Thread.sleep(1000);
	}

	// method to fill answer
	public void fillAnswer(String answer, WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/textarea"))
				.sendKeys("lorem ipsum");
		Thread.sleep(1000);
	}

	// method to click on submit
	public void submitForm(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[2]/button"))
				.click();
		Thread.sleep(1000);
	}
	
	//method to clear fields
	// options name/date/answer
	public void clearField (String entry, WebDriver driver) throws InterruptedException {
		if (entry == "name") {	
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[1]/div/input")).clear();
			Thread.sleep(1000);
		} else if (entry == "date") {
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/input[1]")).clear();
			Thread.sleep(1000);
		} else if (entry == "answer"){
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[2]/div/div/textarea")).clear();
		Thread.sleep(1000);}
	}

}
