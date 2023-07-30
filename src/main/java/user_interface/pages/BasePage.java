package user_interface.pages;

import org.openqa.selenium.support.PageFactory;
import user_interface.driver_factory.Driver;
import user_interface.helper.ElementActions;


public abstract class BasePage {


    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public ElementActions elementActions = new ElementActions();
}
