package user_interface.virtual_drivers;

import org.openqa.selenium.WebDriver;
import user_interface.config.ConfigReader;


import java.net.MalformedURLException;

public class VirtualDriver {


    private VirtualDriver(){
        //singleton pattern (Этот класс будет единственным в своем роде,
        // не получится создать экземляр или обьект
        // этоого класса)
    }

    private static WebDriver driver;

    public static WebDriver getVirtualDriver() throws MalformedURLException {
        if (driver == null){
            switch (ConfigReader.getPropertyOf("virtual").toLowerCase()){
                case "chrome":
                    driver = ChromeVirtual.loadVirtualChrome();
                    break;
                case "safari":
                    driver = SafariVirtual.loadVirtualSafari();
                    break;
                case "edge":
                    driver = EdgeVirtual.loadVirtualEdge();
                    break;
                default:
                    throw new IllegalArgumentException("You provided wrong driver name");
            }
        }
        return driver;
    }


    public static void closeVirtualDriver(){
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

