package luma;

import base_test.BaseTestbyTilek;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user_interface.model.LoginCredentials;
import user_interface.pages.RegistrationPage;
import user_interface.pages.RegistrationSuccessfulPage;

import static user_interface.model.LoginCredentials.firstName;
import static user_interface.model.LoginCredentials.lastName;


@Epic("Registration page Test")
public class RegistrationTest extends BaseTestbyTilek {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessfulPage registrationSuccessfulPage = new RegistrationSuccessfulPage();


    @Description("Opening the Registration page")
    @BeforeClass
    void openingBrowser(){
        driver.get("https://luma.enablementadobe.com/content/luma/us/en/community/signup.html#");
    }

    @Description("Register with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo1(){
        registrationPage.enterFirstName(firstName.getCredentials())
                .enterLastName(lastName.getCredentials())
                .enterEmail(LoginCredentials.email.getCredentials())
                .enterPassword(LoginCredentials.password.getCredentials())
                .confirmEnteredPassword(LoginCredentials.password.getCredentials())
                .clickSignUpButton();
        String resultText = registrationSuccessfulPage.thankYouMessage.getText();
        String expectedResult = "THANK YOU!";
        Assert.assertEquals(resultText, expectedResult);
    }
    @Description("Register with invalid first name")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo2() throws InterruptedException {
        String email = fakeDataProvider.generateFakeEmail();
        String firstName = fakeDataProvider.generateFakeMobileNumber();
        registrationPage.enterFirstName(firstName)
                .enterLastName(lastName.getCredentials())
                .enterEmail(email)
                .enterPassword(LoginCredentials.password.getCredentials())
                .confirmEnteredPassword(LoginCredentials.password.getCredentials())
                .clickSignUpButton();
        Thread.sleep(3000);
        System.out.println(email);
        System.out.println(firstName);
        String resultText = registrationSuccessfulPage.thankYouMessage.getText();
        String expectedResult = "Unsuccessful";
        Assert.assertEquals(resultText, expectedResult);
    }

    @Description("Register with invalid first name and invalid last Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo3() throws InterruptedException {
        String email = fakeDataProvider.generateFakeEmail();
        String firstName = fakeDataProvider.generateFakeMobileNumber();
        String lastName = fakeDataProvider.generateFakeMobileNumber();
        registrationPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(LoginCredentials.password.getCredentials())
                .confirmEnteredPassword(LoginCredentials.password.getCredentials())
                .clickSignUpButton();
        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastName);
        String resultText = registrationSuccessfulPage.thankYouMessage.getText();
        String expectedResult = "Unsuccessful";
        Assert.assertEquals(resultText, expectedResult);
    }

    @Description("Register with invalid first name and invalid last Name and email")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo4(){
        String email = "12456780@mail.ri";
        String firstName = fakeDataProvider.generateFakeMobileNumber();
        String lastName = fakeDataProvider.generateFakeMobileNumber();
        registrationPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(LoginCredentials.password.getCredentials())
                .confirmEnteredPassword(LoginCredentials.password.getCredentials())
                .clickSignUpButton();
        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastName);
        String resultText = registrationSuccessfulPage.thankYouMessage.getText();
        String expectedResult = "Unsuccessful";
        Assert.assertEquals(resultText, expectedResult);
    }

    @Description("Register with invalid first name and invalid last Name and email, user name")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo5(){
        String email = "12456780@mail.ri";
        String firstName = fakeDataProvider.generateFakeMobileNumber();
        String lastName = fakeDataProvider.generateFakeMobileNumber();
        String userName = fakeDataProvider.generateFakeMobileNumber();
        registrationPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .thick()
                .enterUserName(userName)
                .enterPassword(LoginCredentials.password.getCredentials())
                .confirmEnteredPassword(LoginCredentials.password.getCredentials())
                .clickSignUpButton();
        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastName);
        String resultText = registrationSuccessfulPage.thankYouMessage.getText();
        String expectedResult = "Unsuccessful";
        Assert.assertEquals(resultText, expectedResult);
    }

    @Description("Register with invalid first name and invalid last Name and email, user name and 2 different passwords")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo6(){
        String email = "12456780@mail.ri";
        String firstName = fakeDataProvider.generateFakeMobileNumber();
        String lastName = fakeDataProvider.generateFakeMobileNumber();
        String userName = fakeDataProvider.generateFakeMobileNumber();
        registrationPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .thick()
                .enterUserName(userName)
                .enterPassword(LoginCredentials.password.getCredentials())
                .confirmEnteredPassword(email)
                .clickSignUpButton();
        System.out.println(email);
        System.out.println(firstName);
        System.out.println(lastName);
        String resultText = registrationPage.passwordDidNotMatchMessage.getText();
        String expectedResult = "Password fields do not match";
        Assert.assertEquals(resultText, expectedResult);
    }
}
