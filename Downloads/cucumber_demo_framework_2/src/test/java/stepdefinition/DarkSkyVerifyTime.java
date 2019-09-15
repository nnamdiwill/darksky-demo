package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DarkSkyVerifyTime {
    private By clickTimeMachine = By.xpath("//a[@class='button']");
    private HomePage homePage = new HomePage();


    @Given( "^I create a date object$")
    public void verifyingCurrentDate() throws InterruptedException {
        Date todaysDate = new Date();
        System.out.println("Todays date is " + todaysDate);
        SimpleDateFormat df = new SimpleDateFormat("d");
        String today = df.format(todaysDate);


    }
    //Scroll action

    @And("^I scale down to time machine button$") @When("^I click on time machine button$")
    public void scrollFunction() throws InterruptedException {
        //By clickTimeMachine = By.xpath("//a[@class='button']");

        WebElement timeMachineButton = SharedSD.getDriver().findElement(clickTimeMachine);

        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", timeMachineButton);

        Thread.sleep(2000);
        timeMachineButton.click();
        Date todaysDate = new Date();
        System.out.println("Todays date is " + todaysDate);
        SimpleDateFormat df = new SimpleDateFormat("d");
        String today = df.format(todaysDate);

        boolean result = false;

        for (int i = 1; i <= 28; i++) {

            String daysXPath = SharedSD.getDriver().findElement(By.xpath("//td[@data-day='" + i + "']")).toString();
            String convertI = Integer.toString(i);
            if (convertI.equals(today)) {
                System.out.println("The dates are a match.");
                System.out.println("The date is " + daysXPath);
                result = true;
                break;
            }
        }

    }
    @Then("^I verify current date is selected$")
    public void verifyTrueAssert() {
        boolean result = false;
        if(result) {
            Assert.assertTrue(result, "Date didn't match");

        }
    }

}
