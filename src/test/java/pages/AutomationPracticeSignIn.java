package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeSignIn {

    @FindBy(className = "login")
    private WebElement signInButton;

    private WebDriver driver;

    public AutomationPracticeSignIn(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateAccount clickButton(){
        signInButton.click();
        return new CreateAccount(driver);
    }

}
