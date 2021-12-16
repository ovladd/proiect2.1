package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CompletePersonalInfos {
    @FindBy(id = "id_gender1")
    private WebElement mrButton;
    @FindBy(id = "id_gender2")
    private WebElement mrsButton;
    @FindBy (className = "radio-inline")
    private List<WebElement> selectGender;
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id="days")
    private WebElement dayOfBirth;
    @FindBy(id="months")
    private WebElement monthOfBirth;
    @FindBy(id="years")
    private WebElement yearOfBirth;
    @FindBy(id="newsletter")
    private WebElement newsletterCheckBox;
    @FindBy(id="optin")
    private WebElement offersCheckBox;
    @FindBy(id="company")
    private WebElement companyInput;
    @FindBy(id="address1")
    private WebElement addressInput1;
    @FindBy(id="address2")
    private WebElement addressInput2;
    @FindBy(id="city")
    private WebElement cityInput;
    @FindBy(id="id_state")
    private WebElement stateDropDown;
    @FindBy(id="postcode")
    private WebElement zipPostCodeInput;
    @FindBy(id="id_country")
    private WebElement selectCountry;
    @FindBy(id="other")
    private WebElement otherInfoInput;
    @FindBy(id="phone")
    private WebElement homePhoneInput;
    @FindBy(id="phone_mobile")
    private WebElement mobilePhoneInput;
    @FindBy(id="alias")
    private WebElement addressAliasInput;
    @FindBy(id="submitAccount")
    public WebElement registerButton;
    @FindBy(xpath = "//*[contains(@class,'alert alert-danger')]")
    private WebElement errorMessages;
    @FindBy (xpath = "//p[contains(text(),'You must register at least one phone number.')]")
    private WebElement phoneError;

    private WebDriver driver;

    public CompletePersonalInfos(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInContactForm(String firstName, String lastName, String password, String company, String address1, String address2, String city, String postCode, String otherInfo,String homePhone,String mobilePhone, String addressAlias){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(visibilityOf(registerButton));
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        companyInput.sendKeys(company);
        addressInput1.sendKeys(address1);
        addressInput2.sendKeys(address2);
        cityInput.sendKeys(city);
        zipPostCodeInput.sendKeys(postCode);
        otherInfoInput.sendKeys(otherInfo);
        homePhoneInput.sendKeys(homePhone);
        mobilePhoneInput.sendKeys(mobilePhone);
        addressAliasInput.sendKeys(addressAlias);

    }

    public void setGender(String gender){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(visibilityOf(registerButton));
        if(gender.equalsIgnoreCase("mr."))
            selectGender.get(0).click();
        else if (gender.equalsIgnoreCase("mrs."))
            selectGender.get(1).click();
    }

    public void selectDayOfBirth(String value){
        Select drop = new Select(dayOfBirth);
        drop.selectByValue(value);
    }

    public void selectMonthOfBirth(String value){
        Select drop = new Select(monthOfBirth);
        drop.selectByValue(value);
    }
    public void selectYearOfBirth(String year){
        Select drop = new Select(yearOfBirth);
        if (Integer.parseInt(year) <= 2003) {
            drop.selectByValue(year);
        }
        else {
            System.out.println("Year should be 2003 or less");
        }
    }

    public void selectNewsletterCheckBox(){
        if (!newsletterCheckBox.isSelected())
            newsletterCheckBox.click();
    }
    public void selectOfferCheckBox(){
        if (!offersCheckBox.isSelected())
            offersCheckBox.click();
    }
    public void selectState(String value){
        Select drop = new Select(stateDropDown);
        drop.selectByVisibleText(value);
    }
    public void setSelectCountry(String value){
        Select drop = new Select(selectCountry);
        drop.selectByVisibleText(value);
    }
    public String getResultError() {
        return errorMessages.getText();

    }
    public String getPhoneError(){
        return phoneError.getText();
    }


}
