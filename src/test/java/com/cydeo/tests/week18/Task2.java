package com.cydeo.tests.week18;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {
    @Test
    public void test2() {

        //TC002 As a user I should be able to select Alabama
        //  1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //  2- Go to https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

        //  3- Click Dropdown
        WebElement dropdown = driver.findElement(By.partialLinkText("Dropdown"));
        dropdown.click();

        //  4- Select Alabama from State Selection dropdown menu
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByValue("AL");

        //  5- Verify Alabama is selected
        String expected = "Alabama";
        String actualText = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualText, expected);

        driver.quit();
    }
}
