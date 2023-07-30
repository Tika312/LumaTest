package luma;

import base_test.BaseTestbyTilek;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user_interface.model.LoginCredentials;



@Epic("Registration page Test")
public class RegistrationTest extends BaseTestbyTilek {






    @Description("Register with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo1(){
        driver.get("https://luma.enablementadobe.com/content/luma/us/en/community/signup.html#");
        String password = fakeDataProvider.generateFakePassword();
        registrationPage.enterFirstName(fakeDataProvider.generateFakeFirstName())
                .enterLastName(fakeDataProvider.generateFakeLastName())
                .enterEmail(fakeDataProvider.generateFakeEmail())
                .enterPassword(password)
                .confirmEnteredPassword(password)
                .clickSignUpButton();
        WebElement element = driver.findElement(By.xpath("//h1[text()='THANK YOU!']"));
        elementActions.waitElementTobeDisplayed(element);
        Assert.assertTrue(element.isDisplayed());
    }
    @Description("Register with invalid first name")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo2()  {
        driver.get("https://luma.enablementadobe.com/content/luma/us/en/community/signup.html#");
        String email = fakeDataProvider.generateFakeEmail();
        String firstName = fakeDataProvider.generateFakeMobileNumber();
        registrationPage.enterFirstName(firstName)
                .enterLastName(LoginCredentials.lastName.getCredentials())
                .enterEmail(email)
                .enterPassword(LoginCredentials.password.getCredentials())
                .confirmEnteredPassword(LoginCredentials.password.getCredentials())
                .clickSignUpButton();
        System.out.println(email);
        System.out.println(firstName);
        String resultText = driver.findElement(By.xpath("//h1[text()='THANK YOU!']")).getText();
        String expectedResult = "Unsuccessful";
        Assert.assertEquals(resultText, expectedResult);
    }

    @Description("Register with invalid first name and invalid last Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo3()  {
        driver.get("https://luma.enablementadobe.com/content/luma/us/en/community/signup.html#");
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
        String resultText = driver.findElement(By.xpath("//h1[text()='THANK YOU!']")).getText();
        String expectedResult = "Unsuccessful";
        Assert.assertEquals(resultText, expectedResult);
    }

    @Description("Register with invalid first name and invalid last Name and email")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo4(){
        driver.get("https://luma.enablementadobe.com/content/luma/us/en/community/signup.html#");
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
        String resultText = driver.findElement(By.xpath("//h1[text()='THANK YOU!']")).getText();
        String expectedResult = "Unsuccessful";
        Assert.assertEquals(resultText, expectedResult);
    }

    @Description("Register with invalid first name and invalid last Name and email, user name")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo5(){
        driver.get("https://luma.enablementadobe.com/content/luma/us/en/community/signup.html#");
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
        String expectedResult = "Unsuccessful";
        String resultText = driver.findElement(By.xpath("//h1[text()='THANK YOU!']")).getText();
        Assert.assertEquals(resultText, expectedResult);
    }

    @Description("Register with invalid first name and invalid last Name and email, user name and 2 different passwords")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void demo6(){
        driver.get("https://luma.enablementadobe.com/content/luma/us/en/community/signup.html#");
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
        WebElement element = driver.findElement(By.xpath("//div[text()='Password fields do not match']"));
       elementActions.waitElementTobeDisplayed(element);
        Assert.assertTrue(element.isDisplayed());
    }
}
