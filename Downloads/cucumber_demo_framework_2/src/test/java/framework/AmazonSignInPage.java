package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepdefinition.SharedSD;

public class AmazonSignInPage  extends BasePage{

    private By signInEmail = By.xpath("//input[@name='email']");
    private By signInPW = By.xpath("//input[@id='ap_password']");
    private By clickONSignIn = By.xpath("//input[@type='submit']");
    private By wrongPWwErrorMessage = By.xpath("//span[@class='a-list-item']");
    private By amazonSignInHover = By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]");
    // private  By signInButton = By.xpath("//div[@class='nav-flyout-content']//span[@class='nav-action-inner'][contains(text(),'Sign in')]");
    private By signInButton = By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]");
    private By secondSignIn = By.xpath("//input[@id='signInSubmit']");
    private By emailError = By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]");
    private By createAmazonAcctButton = By.xpath("//a[@class='a-button-text']");
    private By customerName = By.xpath("//input[@name='customerName']");
    private By customerEmail = By.xpath("//input[@id='ap_email']");
    private By customerPW = By.xpath("//input[@id='ap_password']");
    private By amazonAcctCreate = By.xpath("//input[@id='continue']");
    private By pwTooShortMessage = By.xpath("//div[@id='auth-password-invalid-password-alert']//div[@class='a-alert-content'][contains(text(),'Passwords must be at least 6 characters.')]");
    private By reEnterPWMessage = By.xpath("//div[contains(text(),'Type your password again')]");
    private By reEnterPW = By.xpath("//input[@name='passwordCheck']");
    private By invalidEmailMessage = By.xpath("//div[contains(text(),'Enter a valid email address')]");
    private By verifyEmailMessage = By.xpath("//h1[contains(text(),'Verify email address')]");
    private By forgotPWclick = By.xpath("//a[contains(text(),'Forgot your password?')]");


    public void setSignInEmail(){
    setValue(signInEmail,"nnamdiwill@gmail.com");
}

public void sentPassword(String password) {
    setValue(signInPW, password);
}

public void setClickONSignIn(){
    clickOn(clickONSignIn);
}

public String readError(By Locator){
    return getTextFromElement(Locator);
}

//    public void mouseOverSignIn(){
//        SharedSD.getDriver().manage().window().maximize();// maximizes the window
//        WebElement element = SharedSD.getDriver().findElement(amazonSignInHover);
//
//        Actions act = new Actions(SharedSD.getDriver());
//        act.moveToElement(element).build().perform();
//        webAction(amazonSignInHover);
//
//    }
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

    public void submitSignIn(){
clickOn(secondSignIn);
    }
    public void noUserName(){
        setValue(signInEmail,"" );
    }

    public void clickcreateAcct(){
        clickOn(createAmazonAcctButton);
    }

    public void enternameForKCode(){
        setValue(customerName,"Kevin Code");
    }

    public void enterEmailforKcode(){

        setValue(customerEmail,"KCode@gmail.com");
    }

    public void blankPWKCode(){
        setValue(customerPW,"");

    }

    public void fiveLetterPW(){
        setValue(customerPW,"abcef");
    }

    public void clickCreateacctActivate(){
        clickOn(amazonAcctCreate);
    }

    public void shortPW(){
        readError(pwTooShortMessage);
    }
    public void pwReEnter(){

        readError(reEnterPWMessage);
    }

    public void shortEmail(){
        setValue(customerEmail,"KCode");
    }

    public void testProperPW(){
        setValue(customerPW,"abcEfg@");
    }

    public void reEnterProperPW(){
        setValue(reEnterPW,"abcEfg@");
    }

    public void invalidEmailMessage(){
        readError(invalidEmailMessage);
    }

    public void verifyEmail(){
        readError(verifyEmailMessage);
    }

    public void enteringUnforNNam(){
        setValue(signInEmail,"nnamdiwill@gmail.com");
    }

    public void clickingForgotPassword(){
        clickOn(forgotPWclick);
    }


}
