package com.cydeo.tests.week19;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Task1 {

    @Test
    public void test1() {
        //TC001:  Iframe-Window Handles
        //     1- Go to the url : http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        //     2- Get the current window’s handle and write to the console window. It must be the first window handle.
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Current window's handle: " + mainWindowHandle);

        //     3- Click on “Visit W3Schools.com!” link
        driver.switchTo().frame("iframeResult");
        WebElement w3link = driver.findElement(By.linkText("Visit W3Schools.com!"));
        w3link.click();
        BrowserUtils.sleep(3);

        //     4- Verify total window handle number is 2.
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Window handle number: " + allWindowHandles.size());
        if (allWindowHandles.size() == 2) {
            System.out.println("WINDOW COUNT VERIFICATION PASSED");
        } else {
            System.out.println("WINDOW COUNT VERIFICATION FAILED");
        }

        //     5- Switch to the second window.
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        //     6- Verify upper left side logo is displayed in second window.
        WebElement logo = driver.findElement(By.id("w3-logo"));
        if (logo.isDisplayed()) {
            System.out.println("LOGO VERIFICATION PASSED");
        } else {
            System.out.println("LOGO VERIFICATION FAILED");
        }

        //     7- Go back (Switch) to the first window.
        driver.switchTo().window(mainWindowHandle);

        //     8- Verify Run Button contains “Run ❯” text
        WebElement runButton = driver.findElement(By.id("runbtn"));
        String expectedText = "Run ❯";
        String actualText = runButton.getText();
        if (actualText.contains(expectedText)) {
            System.out.println("TEXT VERIFICATION PASSED");
        } else {
            System.out.println("TEXT VERIFICATION FAILED");
        }

        driver.quit();
    }
}
