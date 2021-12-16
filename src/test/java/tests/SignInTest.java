package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AutomationPracticeSignIn;
import pages.CompletePersonalInfos;
import pages.CreateAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.is;

public class SignInTest {
    WebDriver driver;


    @Test
    public void pressSignInButton(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        AutomationPracticeSignIn homePage = new AutomationPracticeSignIn(driver);
        CreateAccount createAccount = homePage.clickButton();

        createAccount.setEmailAdress("jknknk@mailinator.com");
    }

    @Test
    public void verifyMailError(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        AutomationPracticeSignIn homePage = new AutomationPracticeSignIn(driver);
        CreateAccount createAccount = homePage.clickButton();

        createAccount.setEmailAdress("blablabla");
        assertThat(createAccount.EmailError(), is ("Invalid email address.") );

    }

    @Test
    public void invalidAge(){

        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        AutomationPracticeSignIn homePage = new AutomationPracticeSignIn(driver);
        CreateAccount createAccount = homePage.clickButton();

        createAccount.setEmailAdress("blablallllfdsal@mailinator.com");

        CompletePersonalInfos completeAccountFields = new CompletePersonalInfos(driver);
        completeAccountFields.setGender("mr.");
        completeAccountFields.fillInContactForm("Vlad", "Olaru","0987654", "Endava","Aleea Studentilor, 17","Aleea Studentilor, 17", "Timisoara", "55555","none"," ","0725528943","Complex");
        completeAccountFields.selectDayOfBirth("20");
        completeAccountFields.selectMonthOfBirth("9");
        completeAccountFields.selectYearOfBirth("2010");

        completeAccountFields.selectNewsletterCheckBox();
        completeAccountFields.selectOfferCheckBox();
        completeAccountFields.selectState("Arizona");
        completeAccountFields.registerButton.click();
        assertThat(completeAccountFields.getResultError(), is ("There is 1 error\n" + "Invalid date of birth"));

    }

    @Test
     public void signInFormValid(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");

        AutomationPracticeSignIn homePage = new AutomationPracticeSignIn(driver);
        CreateAccount createAccount = homePage.clickButton();

        createAccount.setEmailAdress("blaalne1l2llfdsal@mailinator.com");

        CompletePersonalInfos completeAccountFields = new CompletePersonalInfos(driver);
        completeAccountFields.setGender("mr.");
        completeAccountFields.fillInContactForm("Vlad", "Olaru","0987654", "Endava","Aleea Studentilor, 17","Aleea Studentilor, 17", "Timisoara", "55555","none"," ","0725528943","Complex");
        completeAccountFields.selectDayOfBirth("20");
        completeAccountFields.selectMonthOfBirth("9");
        completeAccountFields.selectYearOfBirth("2002");

        completeAccountFields.selectNewsletterCheckBox();
        completeAccountFields.selectOfferCheckBox();
        completeAccountFields.selectState("Arizona");
        completeAccountFields.setSelectCountry("United States");
        completeAccountFields.registerButton.click();

    }

    @Test
    public void noTelephoneNumbers(){

        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");

        AutomationPracticeSignIn homePage = new AutomationPracticeSignIn(driver);
        CreateAccount createAccount = homePage.clickButton();

        createAccount.setEmailAdress("blaa5l55nelll7gfdsal@mailinator.com");

        CompletePersonalInfos completeAccountFields = new CompletePersonalInfos(driver);
        completeAccountFields.setGender("mr.");
        completeAccountFields.fillInContactForm("Olaru", "Vlad","0987654", "Endava","Aleea Studentilor, 17","Aleea Studentilor, 17", "Timisoara", "55555","none"," ","","Complex");
        completeAccountFields.selectDayOfBirth("20");
        completeAccountFields.selectMonthOfBirth("9");
        completeAccountFields.selectYearOfBirth("2002");

        completeAccountFields.selectNewsletterCheckBox();
        completeAccountFields.selectOfferCheckBox();
        completeAccountFields.selectState("Arizona");
        completeAccountFields.setSelectCountry("United States");
        completeAccountFields.registerButton.click();
        assertThat(completeAccountFields.getPhoneError(), is ("You must register at least one phone number."));
    }

    @Test
    public void noFields(){

        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");

        AutomationPracticeSignIn homePage = new AutomationPracticeSignIn(driver);
        CreateAccount createAccount = homePage.clickButton();

        createAccount.setEmailAdress("blaalne1lll910fdsal@mailinator.com");

        CompletePersonalInfos completeAccountFields = new CompletePersonalInfos(driver);

        completeAccountFields.setSelectCountry("-");
        completeAccountFields.registerButton.click();
        assertThat(completeAccountFields.getResultError(), is ("There are 9 errors\n" +
                "You must register at least one phone number.\n" +
                "lastname is required.\n" +
                "firstname is required.\n" +
                "passwd is required.\n" +
                "id_country is required.\n" +
                "address1 is required.\n" +
                "city is required.\n" +
                "Country cannot be loaded with address->id_country\n" +
                "Country is invalid"));

    }

}
