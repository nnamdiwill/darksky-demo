package CapGem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Listeners(CapGem.TestNGListeners.class)
public class MainClass {

    @Test
    public void firstTest() {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.capgemini.com");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//p[contains(text(),'Close')]")).click();

        System.out.println("The window handle is " + driver.getWindowHandle());
        System.out.println("The URL is " +driver.getCurrentUrl());


        //This shows the list of subclasses in industry sights
//        List<WebElement> industrySights =  driver.findElements(By.xpath("//li[@class='menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children cmw-level-2 cmw-has-submenu cmw-menu-item-had-children menu-item-4553']//a"));
//
//        List<String> isList = new ArrayList<String>();
//        for(WebElement e : industrySights){
//            isList.add(e.getText());
//            System.out.println(e.getText());

       ;

        //This will make us hover over expertise again
//        WebElement expertiseLinkSecondtime = driver.findElement(By.linkText("Expertise"));
//
//        Actions actUp = new Actions(driver);
//        // act.moveToElement(productLink).build().perform();
//        act.moveToElement(expertiseLinkSecondtime).build().perform();
WebElement serLink = driver.findElement(By.linkText("Services"));

        List<WebElement> services = driver.findElements(By.xpath("//ul[@class='sub-menu']//li"));
        Actions hoverServices = new Actions(driver);
        hoverServices.moveToElement(serLink).build().perform();
      List<String> servicesList = new ArrayList<String>();

        for (WebElement we: services) {
           servicesList.add(we.getText());
            System.out.println(   we.getText());
        }

//        WebElement we =    driver.findElement(By.linkText("Here are Africa’s top 6 most expensive footballers"));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", we);
//        //we.getText();

        WebElement doe = driver.findElement(By.linkText("The Department for Education uses robotics to enhance responsiveness to customer emails"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()",doe);
        System.out.print(doe.getText());
        doe.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.quit();

    }
}