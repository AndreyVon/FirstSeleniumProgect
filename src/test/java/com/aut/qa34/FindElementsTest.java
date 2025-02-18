package com.aut.qa34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.avito.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Test
    public void findElementByTagName(){
        // поиск по тегу
        WebElement element = driver.findElement(By.tagName("h2"));
        System.out.println(element.getText()); // поиск одно элемента


        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println(a.size()); // поиск всех элементов
    }

    @Test
    public void findElementLocators(){
        //tag name = tag name
        //id
        //driver.findElement(By.id("Купить"));

        //class name
        driver.findElement(By.className("styles-module-footer-brg1O"));

        //name By.name("user");

        //link text
        driver.findElements(By.linkText("Карьера в Авито"));

    }

    //css selector

    @Test
    public void findElementByCssSelector(){
        //id -> #id
        //driver.findElements(By.cssSelector("#id"));
        // class name -> .className
        driver.findElements(By.cssSelector(".styles-module-input-rA1dB"));
        //[name = 'user']
        driver.findElements(By.cssSelector("[data-marker='service-autoteka/title']"));
    }
    //xPath //tag[@attr = 'value']

    @Test
    public void findElementBtXpath(){
        //tag name = //tag
        driver.findElements(By.xpath("//h1"));
        //id -> //tag[@id='city']
        //driver.findElement(By.id("city"));
        driver.findElements(By.xpath("//*[id = 'city']"));
        //class name -> //tag[@class= 'className'];
        driver.findElement(By.xpath("//*[@class= 'input-container']"));

        //text
        driver.findElements(By.xpath("//li[text()='© ООО «КЕХ еКоммерц» 2007–2025. ']"));
        driver.findElements(By.xpath("//li[.='© ООО «КЕХ еКоммерц» 2007–2025. ']"));
        driver.findElements(By.xpath("//span[contains(.,'2007-2025')]"));
    }






    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
