package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ForumTest {
    @Test
            public void forumTest(){

        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        By name = By.name("my-text");
        By password = By.name("my-password");
        By textarea = By.name("my-textarea");
        By disabled = By.name("my-disabled");
        By dropdown = By.name("my-select");
        By firstDropDown = By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select/option[2]");
        By submit = By.xpath("/html/body/main/div/form/div/div[2]/button");
        By finalPage = By.xpath("/html/body/main/div/div[1]/div/h1");


        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.findElement(name).click();
        driver.findElement(name).sendKeys("Test");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Test");
        driver.findElement(textarea).click();
        driver.findElement(textarea).sendKeys("Test");
        driver.findElement(disabled).click();
        Assert.assertFalse( driver.findElement(disabled).isEnabled());
        driver.findElement(dropdown).click();
        driver.findElement(firstDropDown).click();
        driver.findElement(submit).click();

        //driver.close();

    }

    @Test
    public void waits(){
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();

        By box = By.id("adder");
        By isAppeard = By.xpath("//*[@id=\"box0\"]");
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(box).click();
        Assert.assertTrue(driver.findElement(isAppeard).isDisplayed());

    }

    @Test
    public void waits2(){
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        By input = By.id("reveal");
        By field = By.id("revealed");
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(input).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
         wait.until(
                ExpectedConditions.elementToBeClickable(By.id("revealed")));
        driver.findElement(field).sendKeys("Test");

    }

}
