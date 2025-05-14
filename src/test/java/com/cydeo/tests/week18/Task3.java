package com.cydeo.tests.week18;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        try {
            //TC003 As a user I should be able to select my favorite color and sport
            //  1- Open a chrome browser
            driver.manage().window().maximize();

            //    2- Goto https://practice.cydeo.com/
            driver.get("https://practice.cydeo.com/");

            //    3- Click Radio Buttons
            driver.findElement(By.partialLinkText("Radio")).click();

            //    4- Verify title contains Radio buttons
            Assert.assertTrue(driver.getTitle().contains("Radio buttons"));

            //    5- Select the favorite color as Red
            WebElement redRadioButton = driver.findElement(By.id("red"));
            redRadioButton.click();

            //    6- Verify the Red is selected
            Assert.assertTrue(redRadioButton.isSelected());

            //    7- Select the favorite sport as Football
            WebElement footballRadioButton = driver.findElement(By.id("football"));
            footballRadioButton.click();

            //    8- Verify the Football is selected
            Assert.assertTrue(footballRadioButton.isSelected());

        } finally {
            BrowserUtils.sleep(5);
            System.out.println("We are able to close whenever exception happened");
            driver.quit();
        }
    }
}
