package user_interface.virtual_drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SafariVirtual {

    public static WebDriver loadVirtualSafari() throws MalformedURLException {
        SafariOptions browserOptions = new SafariOptions();
        browserOptions.setPlatformName("macOS 13");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-tikanmuratov-4c4c7");
        sauceOptions.put("accessKey", "8bb990dd-3f3e-4a85-9221-394e274f8451");
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
        return driver;
    }
}
