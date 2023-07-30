package user_interface.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DropDownHelper {

    public static void selectUsingVisibleText(WebElement element, String txt){
        Select select = new Select(element);
        select.selectByVisibleText(txt);
    }

    public static void selectUsingValue(WebElement element, String txt){
        Select select = new Select(element);
        select.selectByValue(txt);
    }

    public static void selectUsingIndex(WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectRandom(WebElement element){
        Select select = new Select(element);
        Random random = new Random();
        int index = random.nextInt(select.getOptions().size());
        select.selectByIndex(index);
    }

    public static void selectRandomValue(WebElement element){
        Random random = new Random();
        List<String> values = getAllDroDownValues(element);
        int index = random.nextInt(values.size());
        String value = values.get(index);
        selectUsingVisibleText(element, value);
    }


    public static List<String> getAllDroDownValues(WebElement locator){
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList =   new LinkedList<>();

        for (WebElement element: elementList){
            valueList.add(element.getText());
        }
        return valueList;
    }


}
