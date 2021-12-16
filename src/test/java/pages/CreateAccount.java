package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CreateAccount {
    @FindBy(id="email_create")
    private WebElement emailAdress;
    @FindBy (id="SubmitCreate")
    private WebElement createAccount;
    @FindBy (xpath = "//div[@id='create_account_error']")
    public WebElement emailError;


    private WebDriver driver;

    public CreateAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public CompletePersonalInfos setEmailAdress (String email){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(elementToBeClickable(emailAdress));
        emailAdress.sendKeys(email);
        createAccount.click();
        return new CompletePersonalInfos(driver);
    }
    public String EmailError() {
        return emailError.getText();
    }
}

