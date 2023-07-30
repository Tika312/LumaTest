package base_test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import user_interface.virtual_drivers.VirtualDriver;

import java.net.MalformedURLException;

public abstract class VirtualBaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setUpVirtualBrowser() throws MalformedURLException {
        driver = VirtualDriver.getVirtualDriver();
    }

    @AfterClass
    public void tearDownVirtual(){
        VirtualDriver.closeVirtualDriver();
    }
}
