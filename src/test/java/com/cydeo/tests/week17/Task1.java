package com.cydeo.tests.week17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {

        //TC001 As a user I should be able to login with valid credentials

        //1- Open a chrome browser
        //2- Go to "https://vytrack.com/"
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vytrack.com/");

        //3- Click LOGIN button
        WebElement logInButton = driver.findElement((By.xpath("//a[@href='http://app.vytrack.com\']")));
        logInButton.click();

        //4- Login to application with username as "User1" and password as "UserUser123"
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys("User1");
        username.sendKeys(Keys.ENTER);

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        password.sendKeys(Keys.ENTER);

        WebElement logInButtonClick = driver.findElement(By.id("_submit"));
        logInButtonClick.click();
        Thread.sleep(5000);

        //5- Verify the title contains "Dashboard"
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }
        driver.quit();
    }
}

/*

Homework create a login method
login (username password)

 */
