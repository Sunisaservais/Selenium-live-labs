package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
This class will be storing only the utility methods that can be used across the project
 */
public class BrowserUtils {

    public static void sleep(int second) {

        /*
        This method will accept int (int seconds) and execute
        Thread.sleep method for given duration
        Arg: int second
         */

        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param mainTabElement
     * @return List<String> for each WebElement Texts
     */

    public static List<String> getTextOfWebElement(List<WebElement> mainTabElement) {
        List<String> result = new ArrayList<>();

        for (WebElement eachTab : mainTabElement) {
            result.add(eachTab.getText());
        }
        return result;
    }
}
