package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

public class GoogleHomePage extends BasePage {

    private By googleSignInButton = By.linkText("Sign in");

    public void clickGoogleSignIn(){
        WebElement gmailPage = SharedSD.getDriver().findElement(googleSignInButton);
        clickOn(googleSignInButton);
    }
}
