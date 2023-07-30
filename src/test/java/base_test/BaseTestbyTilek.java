package base_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import user_interface.config.FakeDataProvider;
import user_interface.driver_factory.Driver;
import user_interface.helper.ElementActions;


@Listeners({AllureReportListener.class})
public abstract class BaseTestbyTilek {

   public WebDriver driver;
   public ElementActions elementActions;

   public FakeDataProvider fakeDataProvider;


    @BeforeClass
    public void setUpBrowser(){
      driver = Driver.getDriver();
      elementActions = new ElementActions();

      fakeDataProvider = new FakeDataProvider();
    }

    @AfterClass
    public void tearDown(){
//       Driver.closeDriver();
    }

}
