package com.aut.qa34;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        //driver.get("https://www.google.ru/"); // всегда без истории
        driver.navigate().to("https://www.google.ru/"); // работает с историей
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


    }
    @Test
    public void openGoogleTest(){
        System.out.println("Google is opened");
    }
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit(); // закрывает все вкладки
        //driver.close(); // закрывает 1 вкладку
    }
}
