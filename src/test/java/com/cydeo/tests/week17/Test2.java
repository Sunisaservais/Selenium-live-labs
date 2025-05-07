package com.cydeo.tests.week17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test2 {

    public static void main(String[] args) {

        //TC002 As a user I should be able to see the password hidden as default

        //1- Open a chrome browser
        //2- Go to "https://vytrack.com/"
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vytrack.com/");

        //3- Click LOGIN button
        WebElement logInButton = driver.findElement((By.xpath("//a[@href='http://app.vytrack.com\']")));
        logInButton.click();

        //4- Verify the password is hidden
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        String expectedText = "password";
        String actualText = password.getDomAttribute("type");
        if (actualText.equals(expectedText)) {
            System.out.println("Text verification passed");
        } else {
            System.out.println("Text verification failed");
        }
    }
}
