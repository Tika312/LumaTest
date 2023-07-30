package base_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import user_interface.config.FakeDataProvider;
import user_interface.driver_factory.Driver;
import user_interface.helper.ElementActions;
import user_interface.pages.RegistrationPage;


@Listeners({AllureReportListener.class})
public abstract class BaseTestbyTilek {

   public WebDriver driver;
   public ElementActions elementActions;

   public FakeDataProvider fakeDataProvider;
   public RegistrationPage registrationPage;


    @BeforeMethod
    public void setUpBrowser(){
      driver = Driver.getDriver();
      elementActions = new ElementActions();

      fakeDataProvider = new FakeDataProvider();
      registrationPage = new RegistrationPage();
    }

    @AfterMethod
    public void tearDown(){
       Driver.closeDriver();
    }

}
