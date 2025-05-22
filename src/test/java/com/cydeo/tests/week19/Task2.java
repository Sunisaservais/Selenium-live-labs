package com.cydeo.tests.week19;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task2 {

    @Test
    public void test2() {
        //TC002:  Web Table
        //     1- Go to the url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        //     2- Click on Date input area
        WebElement dateInput = driver.findElement(By.id("datepicker"));
        dateInput.click();

        //     3- Get all elements(td) of calendar table using findElements method
        List<WebElement> calendarDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        //     4- Get the text of all elements(td) of calendar table
        for (WebElement day : calendarDays) {
            System.out.print(day.getText() + " ");
        }

        System.out.println();

        //     5- Click 12. day of month
        for (WebElement day : calendarDays) {
            if (day.getText().equals("12")) {
                day.click();
                break;
            }
        }

        //     6- Verify date of "05/12/2025" has been entered in input area.
        //     ExpectedDate need to change from 2024 to 2025
        String expectedDate = "05/12/2025";
        String actualDate = dateInput.getAttribute("value");
        System.out.println("Expected = " + actualDate);

        if (actualDate.equals(expectedDate)) {
            System.out.println("Date verification passed");
        } else {
            System.out.println("Date verification failed");
        }

        driver.quit();

    }
}
