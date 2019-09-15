package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AmazonHomePage;
import framework.AmazonSearchPage;
import framework.AmazonSignInPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AmazonSD {

    AmazonHomePage ahp = new AmazonHomePage();
    AmazonSignInPage asip = new AmazonSignInPage();
    AmazonSearchPage asp = new AmazonSearchPage();
    private By errorMessage = By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]");
    private By pwError = By.xpath("//span[@class='a-list-item']");
    private By passwordError = By.xpath("//div[contains(text(),'Enter your password')]");
    private By emailError = By.xpath("//div[@id='auth-email-missing-alert']//div[@class='a-alert-content'][contains(text(),'Enter your email')]");

    //  @Given("^I am on Amazon home page$")
//    @When("^I hover over sign in account$")
//    public void hoverOverSignIn(){
//       // ahp.mouseOverSignIn();
//    }
//
//    @Then("^I click on sign in button$")
//    public void click() throws InterruptedException {
//        ahp.moveToSignIn();
//        ahp.clickOnSignIn();
//
//        Assert.assertTrue(true,"I can click sign in");
//
//    }


    //Test case 1
    @Given("^I go to Signin Page$")
    public void goingToSignIn() throws InterruptedException {
        ahp.mouseOverSignIn();
        ahp.clickOnSignIn();
    }

    @When("^I enter username nnamdiwill@gmail.com$")
    public void enteringUN() {
        asip.setSignInEmail();
    }


    @And("^I enter pwrd in password box$")
    public void enterPW() {
        asip.sentPassword("pwrd");
        asip.submitSignIn();
    }

    @When("^I click on signin button$")
    @Then("^I should get an error message$")
    public void getError() {
        asip.readError(pwError);

        Assert.assertEquals(asip.readError(pwError),"Your password is incorrect");
    }


    //Test case 2
    @Given("^I am on Signin Page$")
    public void toSignOn() throws InterruptedException {
        ahp.mouseOverSignIn();
        ahp.clickOnSignIn();
    }

    @When("^I don't enter username$")
    public void emptyUserName() {
        asip.noUserName();
    }

    @And("^I enter charliepw as my password$")
    public void fakePW() {
        asip.sentPassword("charliepw");
        asip.submitSignIn();

    }

    @Then("^I should receive enter email error message$")
    public void enterEmailError() {
        asip.readError(errorMessage);

        Assert.assertEquals(SharedSD.getDriver().findElement(errorMessage).getText(), "Enter your email or mobile phone number");
    }

    @Given("^I am on Amazon home page$")
    public void enterName() throws InterruptedException {
        asip.setSignInEmail();
    }

    //Test case 3
    @Given("^I click on create Amazon account$")
    public void clickOnCreateAmazonAccount() throws InterruptedException {
        ahp.mouseOverSignIn();
        ahp.clickOnSignIn();
        asip.clickcreateAcct();

    }

    @When("^I put username as Kevin Code$")
    public void enterKevinCodeUN() {

        asip.enternameForKCode();
    }

    @And("^I enter email as kcode@gmail.com$")
    public void enterKcodeEmail() {

        asip.enterEmailforKcode();
    }


    @And("^I click on next box$")
    public void kCodeCreateACCTBox() {

        asip.clickCreateacctActivate();

    }

    @Then("^I should get enter password error$")
    public void kCodePWErrors() {

        asip.readError(passwordError);
        Assert.assertTrue(true, "We received a enter password error message");
    }

    //test case 4
    @Given("^I am going on Create account page$")
    public void gotoCreateAccount() throws InterruptedException {
        ahp.mouseOverSignIn();
        ahp.clickOnSignIn();
        asip.clickcreateAcct();
    }

    @When("^I type in Kevin code for name$")
    public void unKevinCode() {
        asip.enternameForKCode();
    }

    @And("^I leave email and password blank and I click on next box$")
    public void clickonCreate() {
        asip.clickCreateacctActivate();
    }

    @Then("^I should get error messages$")
    public void errorMessages() {
        asip.readError(passwordError);
        asip.readError(emailError);

        Assert.assertTrue(true, "We received  enter password  and enter email error messages");

    }

    //test case 5
    @Given("^I head to Create account Page$")
    public void startFromCreateAcct() throws InterruptedException {
        ahp.mouseOverSignIn();
        ahp.clickOnSignIn();
        asip.clickcreateAcct();
    }

    @When("^I put username for Kevin Code$")
    public void enterKcode() {
        asip.enternameForKCode();
    }

    @And("^I enter  the email as kcode@gmail.com$")
    public void emailforKCode() {
        asip.enterEmailforKcode();
    }

    @And("^I enter password a abcef$")
    public void enterShortPW() {
        asip.fiveLetterPW();

    }

    @And("^I click on create box$")
    public void clickCreateBox() {
        asip.clickCreateacctActivate();
    }

    @Then("^I should get an error message.$")
    public void multipleErrors() {
        asip.shortPW();
        asip.pwReEnter();
        Assert.assertTrue(true, "We received short password  and re-enter pw error messages");
       // Assert.assertTrue();

    }

    //test 6
    @Given("^I'm still going to the create account page$")
    public void clickingCreate() throws InterruptedException {
        ahp.mouseOverSignIn();
        ahp.clickOnSignIn();
        asip.clickcreateAcct();
    }

    @When("^I  still put username as Kevin Code$")
    public void KcodeforName() {
        asip.enternameForKCode();

    }

    @And("^I enter email as kcode$")
    public void invalidUNKCode() {
        asip.shortEmail();
    }

    @And("^I enter password a abcEfg@$")
    public void pwForKcode() {

        asip.testProperPW();
    }

    @And("^I re-enter pw as abcEfg@$")
    public void reEnterPWforKcode() {

        asip.reEnterProperPW();
    }

    @And("^I do a click for create Amazon account$")
    public void clickingcreationofAcct() {
        asip.clickCreateacctActivate();
    }

    @Then("^I should receive error message for invalid email$")
    public void invalidEmailMessage() {

        asip.invalidEmailMessage();
        Assert.assertEquals("Enter a valid email address", "Enter a valid email address");
    }

    //Test case 7

    @Given("^I'm staying on Create account page$")
    public void acctPageClick() throws InterruptedException {
        ahp.mouseOverSignIn();
        ahp.clickOnSignIn();
        asip.clickcreateAcct();
    }

    @When("^I set username as Kevin Code$")
    public void unTOKcode() {
        asip.enternameForKCode();
    }

    @And("^I do email as kcode@gmail.com$")
    public void enteringKcodeemail() {
        asip.enterEmailforKcode();
    }

    @And("^I enter password a abcEfg@ again$")
    public void enteringLegitPW() {
        asip.testProperPW();
    }

    @And("^I re-enter pw as abcEfg@ again$")
    public void reEnteringLegitPW() {
        asip.reEnterProperPW();
    }

    @And("^I click on create Amazon account for verification$")
    public void clickclickCreateAcct() {
        asip.clickCreateacctActivate();
    }

    @Then("^I should get verify email page$")
    public void verifyGetEmail() {
        asip.verifyEmail();
        Assert.assertTrue(true, "Verify email is displayed");
    }

    //Test 8
    @Given("^I'm at the Sign in page after mouseover.$")
    public void keepClicking() throws InterruptedException{
        ahp.mouseOverSignIn();
        ahp.clickOnSignIn();


    }
    @When("^I send my email to kcode@gmail.com.$")
    public void enteringTheKcodeEmail(){
        asip.enterEmailforKcode();
    }



    @And("^I click on Forgot your password.$")
    public void clickOnForgotPassword(){
        asip.clickingForgotPassword();

    }

    @Then("^The password assistance page should come up.$")
    public void passwordAssistancePageMessage(){
        Assert.assertEquals("Password assistance","Password assistance");
    }

    //Test9

    @Given("^I'm on the offical Homepage.$")
    public void typeInSearchBoxAndClick() throws InterruptedException{
        ahp.typeInSupermanDVDIntoText();

    }
    @When("^I type in Superman dvd.$")
    public void clickOnBoxWithSupermanText() throws InterruptedException{
        ahp.clickSearchBox();
    }

    @And("^Scroll down to Christopher Reeve Collection.$")
    public void scrollingDownToCollection() throws InterruptedException{
        asp.scrollDownAction();
    }

    @And("^I click and at to cart.$")
    public void clickAndAddToCart() throws InterruptedException{
        asp.clickOnCReeveColection();
        asp.clickOnAddToCart();
        asp.clickOnProceedToCheckoutButton();
    }

    @Then("^I should end up on sign in page.$")
    public void verifyImOnSignInPage(){
        Assert.assertTrue(true,"Sign In");
    }

}
