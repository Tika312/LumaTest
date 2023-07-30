package user_interface.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import user_interface.helper.ElementActions;
import user_interface.helper.JavaScriptHelper;

public class RegistrationPage extends BasePage{

    JavaScriptHelper js = new JavaScriptHelper();
    ElementActions element = new ElementActions();


    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement LumaLogo;


    @FindBy(xpath = "(//a[@class='we-Cart-button'])[2]")
    public WebElement cartButton;

    @FindBy(xpath = "//div[text()='Password fields do not match']")
    public WebElement passwordDidNotMatchMessage;

    @FindBy(xpath = "//h3[text()='Sign Up']")
    public WebElement signUpMessage;

    @FindBy(xpath = "//label[text()='First Name']")
    public WebElement firsNameText;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//label[text()='Last Name']")
    public WebElement lastNameText;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//label[text()='Email']")
    public WebElement emailText;
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBoxToUseEmailToLogin;

    @FindBy(xpath = "//label[text()='User Name']")
    public WebElement userNameText;
    @FindBy(xpath = "//input[@placeholder='User Name']")
    public WebElement userNameInput;

    @FindBy(xpath = "//label[text()='Password']")
    public WebElement passwordText;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']")
    public WebElement confirmPasswordText;
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signUpButton;

    @FindBy(xpath = "//button[@type='cancel']")
    public WebElement cancelButton;



    @Step("Enter First Name")
    public RegistrationPage enterFirstName(String text){
        element.fillUpTheInput(firstNameInput,text);
        js.highLightElement(firstNameInput);
        return this;
    }

    @Step("Enter Last Name")
    public RegistrationPage enterLastName(String text){
        lastNameInput.sendKeys(text);
        js.highLightElement(lastNameInput);
        return this;
    }

    @Step("Enter email")
    public RegistrationPage enterEmail(String txt){
        emailInput.sendKeys(txt);
        js.highLightElement(emailInput);
        return this;
    }

    @Step("Enter user name")
    public RegistrationPage enterUserName(String txt){
        userNameInput.sendKeys(txt);
        js.highLightElement(userNameInput);
        return this;
    }

    @Step("Enter password")
    public RegistrationPage enterPassword(String txt){
        passwordInput.sendKeys(txt);
        js.highLightElement(passwordInput);
        return this;
    }

    @Step("Confirm entered password")
    public RegistrationPage confirmEnteredPassword(String txt){
        confirmPasswordInput.sendKeys(txt);
        js.highLightElement(confirmPasswordInput);
        return this;
    }

    @Step("Click Sign up button")
    public RegistrationPage clickSignUpButton(){
        signUpButton.click();
        js.highLightElement(signUpButton);
        return this;
    }

    @Step("Click Cancel button")
    public RegistrationPage clickCancelButton(){
        cancelButton.click();
        js.highLightElement(cancelButton);
        return this;
    }

    @Step("Thick to not  use my email address to login")
    public RegistrationPage thick(){
        checkBoxToUseEmailToLogin.click();
        js.highLightElement(checkBoxToUseEmailToLogin);
        return this;
    }


}
