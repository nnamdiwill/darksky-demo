package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepdefinition.SharedSD;

public class AmazonHomePage extends BasePage {

    private By amazonSignInHover = By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]");
   // private  By signInButton = By.xpath("//div[@class='nav-flyout-content']//span[@class='nav-action-inner'][contains(text(),'Sign in')]");
    private By signInButton = By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]");
    private By searchBox = By.id("twotabsearchtextbox");
    private By cReeveCollection = By.xpath("//span[contains(text(),'The Christopher Reeve Superman Collection: (Superm')]");
    private By searchButton = By.xpath("//input[@value='Go']");
   // private By searchButton = By.className("nav-input");


    public void mouseOverSignIn(){
        SharedSD.getDriver().manage().window().maximize();// maximizes the window
        WebElement element = SharedSD.getDriver().findElement(amazonSignInHover);

        Actions act = new Actions(SharedSD.getDriver());
        act.moveToElement(element).build().perform();
        webAction(amazonSignInHover);

    }
    public void clickOnSignIn() throws InterruptedException {
        //Thread.sleep(2000);
        clickOn(signInButton);

    }

    public void moveToSignIn(){
        WebElement element = SharedSD.getDriver().findElement(signInButton);

        Actions act = new Actions(SharedSD.getDriver());
        act.moveToElement(element).build().perform();
        webAction(signInButton);

    }
    public void typeInSupermanDVDIntoText() throws InterruptedException{
        setValue(searchBox,"Superman DVD");
        Thread.sleep(2000);
    }
    public void clickSearchBox() throws InterruptedException{
        clickOn(searchButton);
        Thread.sleep(2000);
    }

}
