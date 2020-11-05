package testNG.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGPractice {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void openChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	@Parameters({ "url" })
	public void navigateToURL(String url) {
		driver.get(url);
		String actualTitleString = driver.getTitle();
		String expectedTitleString = "TEK SCHOOL";
		softAssert.assertEquals(actualTitleString, expectedTitleString);
		softAssert.assertAll();
	}

	@Test(dependsOnMethods = "navigateToURL")
	public void myAccountIsPresent() throws InterruptedException {
		WebElement myAccountElement = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
		softAssert.assertTrue(myAccountElement.isDisplayed());
		myAccountElement.click();
		softAssert.assertAll();

	}

	@Test(dependsOnMethods = "myAccountIsPresent")
	@Parameters({ "userName", "password" })
	public void loginToMyAccount(String userName, String password) {
		WebElement logIn = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		logIn.click();

		WebElement userNameField = driver.findElement(By.xpath("//input[@id='input-email']"));
		userNameField.sendKeys(userName);

		WebElement passwordField = driver.findElement(By.xpath("//input[@id='input-password']"));
		passwordField.sendKeys(password);

	}

	@AfterTest
	public void afterMethod() {
		driver.quit();
	}
}
