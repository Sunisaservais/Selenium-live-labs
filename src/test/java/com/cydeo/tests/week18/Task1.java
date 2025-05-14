package com.cydeo.tests.week18;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //TC001 As a user I should be able to see Home, About us, Our Approach,
        // Product and Services, Contact and LOGIN labels are displayed
        //  1- Open a chrome browser
        //  2- Go to https://qa1.vytrack.com/user/login
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa1.vytrack.com/user/login");
    }

    @Test
    public void test1() {
        //  3- Login with User1 as username and UserUser123 as password
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("User1");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        WebElement login = driver.findElement(By.id("_submit"));
        login.click();
        BrowserUtils.sleep(6);

        //  4- Verify Fleet, Customers, Activities, System labels are displayed
        List<WebElement> mainTabElement = driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> expectedTexts = List.of("Fleet", "Customers", "Activities", "System");
        List<String> actualTexts = BrowserUtils.getTextOfWebElement(mainTabElement);
        System.out.println(actualTexts);
        Assert.assertEquals(actualTexts, expectedTexts);

        //  --(Optional)
        //    3- Login with salesmanager120 as username and UserUser123 as password
        //    4- Verify Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System labels are displayed
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

