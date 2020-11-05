package pageObj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class HotelLoginPageObj extends Base {
	// we are following Page object Design Pattern with implementing Page Factory
	// class
	// to implement Page Factory class we need to create a constructor and use
	// initElements method
	public HotelLoginPageObj() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Sign in')]")
	private WebElement signIn;
	@FindBy(how = How.ID, using = "email")
	private WebElement email;
	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;
	@FindBy(xpath = "//button[@id='SubmitLogin']/span")
	private WebElement signInButton;
	@FindBy(tagName = "a")
	private List<WebElement> allLinks;


	public boolean SignInIsPresent() {
		return signIn.isDisplayed();
	}
	public boolean emailAddressIsPresent() {
		return email.isDisplayed();
	}
	public boolean passwordIsPresent() {
		return password.isDisplayed();
	}
	
	public boolean signInButtonIsPresent() {
		return signIn.isDisplayed();
	}
	public void clickOnSignIn() {
		signIn.click();
	}
	public void enterUserNameAndPassword(String user, String passw) {
		email.sendKeys(user);
		password.sendKeys(passw);
		signIn.click();
	}
	public List<WebElement> PrintoutAllLinks (){
		return allLinks;
		
	}
}
