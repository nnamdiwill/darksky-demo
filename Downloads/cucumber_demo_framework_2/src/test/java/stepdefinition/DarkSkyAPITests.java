package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;
import framework.GoogleHomePage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DarkSkyAPITests {

    DarkSkyHomePage dshp = new DarkSkyHomePage();
    private By darkSkyAPILink = By.linkText("Dark Sky API");
    GoogleHomePage ghp = new GoogleHomePage();

    String currentUrl ="https://darksky.net/forecast/40.7127,-74.0059/us12/en";

    @Given("^I am on Darksky HomePage.$")
    public void startingPoint(){
        dshp.createStartPoint();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(),currentUrl);
        // ghp.clickGoogleSignIn();
    }

    @When("^I click on DarkSkyAPI.$")
    public void clickForDarkSkyAPI(){
        dshp.clickOnDarkSkyAPIBanner();
        Assert.assertEquals(SharedSD.getDriver().findElement(darkSkyAPILink).getText(),"Dark Sky API");
    }

    @And("^I sign up in Darksky api.$")
    public void signingUpDarksky(){

    }


}
