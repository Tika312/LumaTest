package user_interface.driver_factory;

import org.openqa.selenium.WebDriver;
import user_interface.config.ConfigReader;


public class Driver {


    private Driver(){
        //singleton pattern (Этот класс будет единственным в своем роде,
        // не получится создать экземляр или обьект
        // этоого класса)
    }

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
                switch (ConfigReader.getPropertyOf("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxWebDriver();
                    break;
                case "edge":
                    driver = MicrosoftEdgeWebDriver.loadMicrosoftEdgeWebDriver();
                    break;
                default:
                    throw new IllegalArgumentException("You provided wrong driver name");
            }
        }
        return driver;
    }


    public static void closeDriver(){
        try {
            if (driver!=null){
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            System.out.println("Error while closing");
        }
    }
}
