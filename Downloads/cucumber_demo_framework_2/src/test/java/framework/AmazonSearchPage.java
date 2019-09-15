package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

public class AmazonSearchPage extends BasePage {
    private By cReeveCollection = By.xpath("//span[contains(text(),'Superman 5 Film Collection (DVD)')]");
    private By addToCart = By.xpath("//input[@title='Add to Shopping Cart']");
    private By checkOutButton = By.xpath("//div[contains(@class,'a-row huc-v2-table-col')]//a[@class='a-button-text a-text-center'][contains(text(),'Proceed to checkout (1 item)')]");


    public void scrollDownAction() throws InterruptedException {

      //  JavascriptExecutor jse =(JavascriptExecutor)SharedSD.getDriver();
       // jse.executeScript("arguments[0].scrollIntoView();",cReeveCollection );
       // WebElement timeMachineButton = DriverWrapper.getDrive().findElement(clickTimeMachine);


        WebElement findCReeve = SharedSD.getDriver().findElement(cReeveCollection);
        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);",findCReeve);
        Thread.sleep(3000);
    }
    public void clickOnCReeveColection() throws InterruptedException{
        clickOn(cReeveCollection);
       Thread.sleep(2000);
    }
    public void clickOnAddToCart() throws InterruptedException{
        clickOn(addToCart);
        Thread.sleep(3000);

    }
    public void clickOnProceedToCheckoutButton(){
        clickOn(checkOutButton);
    }
}