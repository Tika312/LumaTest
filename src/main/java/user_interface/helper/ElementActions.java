package user_interface.helper;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user_interface.driver_factory.Driver;

import java.time.Duration;

public class ElementActions {

    public ElementActions waitButtonToBeClickable(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public ElementActions waitElementTobeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public ElementActions clickTheButton(WebElement element){
        waitButtonToBeClickable(element);
        element.click();
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper();
        javaScriptHelper.highLightElement(element);
        return this;
    }

    public ElementActions fillUpTheInput(WebElement element, String text){
        waitElementTobeDisplayed(element);
        element.sendKeys(text);
        return this;
    }

    public ElementActions scrollDownClick(WebElement element){
        WebElementActions.scrollToElement(Driver.getDriver(), element);
        waitButtonToBeClickable(element);
        element.click();
        return this;
    }
    public ElementActions fillUpAndEnter(WebElement element, String text){
        element.sendKeys(text + Keys.ENTER);
        return this;
    }
    public ElementActions moveToTheElementAndClick(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).click().perform();
        return this;
    }

    public ElementActions scrollDowntoTheElement(WebElement element){
        WebElementActions.scrollToElement(Driver.getDriver(), element);
        return this;
    }
    public ElementActions moveToTheElement(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element);
        return this;
    }

    public ElementActions uploadTheFile(WebElement element, String path){
        String filePath = path;
        element.sendKeys(filePath);
        return this;
    }

    public ElementActions downAndEnter(WebElement element){
        waitElementTobeDisplayed(element);
        element.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }

    public ElementActions pressEnter(WebElement element) throws InterruptedException {
        Thread.sleep(2000);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public ElementActions clearText(WebElement element){
        element.sendKeys(Keys.CLEAR);
        return this;
    }

    public ElementActions writeTextWithEnter(WebElement element, String txt){
        waitElementTobeDisplayed(element);
        element.sendKeys(txt, Keys.ARROW_DOWN);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public ElementActions clearAllText(WebElement element){
        waitElementTobeDisplayed(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        return this;
    }

    public ElementActions selectAllText(WebElement element){
        waitElementTobeDisplayed(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        return this;
    }



}
