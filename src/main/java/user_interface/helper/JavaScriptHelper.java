package user_interface.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import user_interface.driver_factory.Driver;

public class JavaScriptHelper {

    public JavaScriptHelper clickwithJs(WebElement element){
        ElementActions elementActions = new ElementActions();
        elementActions.waitElementTobeDisplayed(element);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();",element);
        highLightElement(element);
        return this;
    }

    public JavaScriptHelper highLightElement(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].style.border='4px solid red'", element);
        return this;
    }

    public JavaScriptHelper sendKeysWithJs(WebElement element, String txt){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value = arguments[1];", element, txt);
        highLightElement(element);
        return this;
    }

    public JavaScriptHelper popUpAlert(String alertmessage){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("alert('"+ alertmessage + "');");
        return this;
    }


}
