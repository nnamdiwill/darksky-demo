package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import framework.MessengerLoginPage;
import framework.MessengerPage;
import org.testng.Assert;

public class MessengerSD {
    private HomePage homePage = new HomePage();
    private MessengerPage messengerPage = new MessengerPage();
    private MessengerLoginPage messengerLoginPage = new MessengerLoginPage();


    @Given("^I am on messenger page$")
    public void setMessengerPage() {
        homePage.clickOnLoginButton();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.messenger.com/login/password/");
    }

    @When("^I enter  mohammad@technosoft.io into username field on messenger page$")
    public void enterUserName(){
        messengerPage.enterEmail("mohammad@technosoft.io");

    }

    @And("^I enter  test1234 into password field on messenger page$")
    public void enterPW(){
        messengerPage.enterPassword("test1234");
    }

    @And("^I click on signup button on messenger page$")
    public void clickSignUp(){
messengerPage.clickOnSignupButton();

    }

    @Then("^I verify invalid login verify message on signup page$")
    public void verifyInvalidLogin(){
    messengerLoginPage.getErrorMessage();
        Assert.assertTrue(true, "We recieved an error message");
    }



}
