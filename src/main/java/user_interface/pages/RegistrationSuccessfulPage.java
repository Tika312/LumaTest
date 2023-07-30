package user_interface.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationSuccessfulPage extends BasePage {


    @FindBy(xpath = "//h1[text()='THANK YOU!']")
    public WebElement thankYouMessage;


}
