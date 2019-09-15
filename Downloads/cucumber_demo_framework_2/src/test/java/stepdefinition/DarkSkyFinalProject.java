package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DarkSkyHomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DarkSkyFinalProject {

    DarkSkyHomePage dshp = new DarkSkyHomePage();
    String currentUrl ="https://darksky.net/forecast/40.7127,-74.0059/us12/en";
    private By weatherUpdates = By.xpath("//div[@class='temps']//span//span");
    List<WebElement> weatherList = SharedSD.getDriver().findElements(weatherUpdates);
    List<Integer> tempList = new ArrayList<>();
    boolean minValueisDisplayed = true;
    boolean maxValueisDisplyed = true;

    @Given("^I am on darksky home page and create object for starting point.$")
    public void startingPoint(){

        dshp.createStartPoint();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(),currentUrl);
    }

    @Then("^I verify the timelin is diplayed in 2 hour increments.$")
    public void verifyTimeLine(){
        dshp.incrementEveryHour();


    }

    @Given("^I am on darksky home page and will create an object.$")
    public void startOnDarkSky(){

        dshp.createStartPoint();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(),currentUrl);

    }

    @When("^I expand todays timeline.$")
    public void showTimeLine() throws InterruptedException {

        dshp.scrolldown();
        dshp.clickTodaysWeatherButton();
    }

    @Then("^I verify lowest and highest temp is displayed correctly.$")
    public void verifyLowAndHighTemp(){

       dshp.compareMaxAndMinTemp();
    }

    @Given("^I am on Darksky Home Page.$")
    public void darkSkyHomePage(){
        dshp.createStartPoint();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(),currentUrl);

    }


    @Then("^I verify current temp is not greater or less then temps from daily timeline.$")
    public void verifyTempRange(){

        dshp.getCurrentWeather();
        dshp.createWeatherLists();
        dshp.getMinValue();
        dshp.getMaxVlue();
        Assert.assertTrue("The min value is displayed", minValueisDisplayed);
        Assert.assertTrue("The max value is displayed",maxValueisDisplyed);

    }
}
