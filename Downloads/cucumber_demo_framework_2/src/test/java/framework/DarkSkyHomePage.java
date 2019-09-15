package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.*;

public class DarkSkyHomePage extends BasePage {

    //  private By nowAsStartingPoint = By.xpath("//span[@class='Now']//*[text()='Now']");


    private By nowAsStartingPoint = By.xpath("//span[@class='Now']");

    private By everyHourafterStart = By.xpath("//span[contains(@class,'hour')]");

    private By expandTodaysWeatherButton = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]/span[2]");

    private By weatherSummary = By.xpath("//span[@class='summary swap']");

    private By weatherUpdates = By.xpath("//div[@class='temps']//span//span");

    int num = 2;

    private By minTemperature = By.xpath("//span[@class='minTemp']");
    private By maxTemperature = By.xpath("//span[@class='maxTemp']");

   // private By displayMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']following-sibling::span[@class='temp']");
   // private By displayMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swip']following-sibling::span[@class='temp']");

    private By displayMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//child::span");
    private By displayMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//child::span");
    private By darkSkyAPILink = By.linkText("Dark Sky API");
    private By usernameInputDarkSkySignup = By.xpath("//input[@placeholder='hacker@example.com']");
    private By inputPW = By.xpath("//input[@name='password']");
    private By confirmPWDarSkyAPI = By.xpath("//input[@name='confirmation']");
    private By registerButtonforDarksky = By.linkText("Register");

    public void createStartPoint() {
        WebElement nowAsStart = SharedSD.getDriver().findElement(nowAsStartingPoint);

    }

    public void incrementEveryHour() {


        // List<WebElement> allHours = SharedSD.getDriver().findElements(everyHourafterStart);
//    boolean hourIncrementsByTwo = false;
//    for (int i = 1; i <= 12; i = i + 2) {
//        if (i == 12) {
//            for ( i = 2; i <= 12; i = i + 2) {
//
//                hourIncrementsByTwo = true;
//                String hours = SharedSD.getDriver().findElement(By.xpath("//span[@class=' " + i + "']")).toString();
//
//            }

//        }
//   }
        try {
            List<WebElement> allHours = SharedSD.getDriver().findElements(everyHourafterStart);

            List<String> expectedTime = new ArrayList<>();
            List<String> actualTime = new ArrayList<>();

            String hour = getTimeInHours(num);

            for (WebElement timeExpectation : allHours) {

                expectedTime.add(timeExpectation.getText()); //converts web element into string array

            }

            String currentHour = "Now";
            actualTime.add(0, currentHour); // adds curent hour into the arraylist at position zero
            for (int i = 1; i < allHours.size(); i++) {
                hour.toLowerCase();

                num = num + 2;

            }
            Assert.assertEquals(expectedTime, actualTime, "The times are equal.");
        } catch (IllegalArgumentException iae) {
            System.out.println("Problem found");
            iae.printStackTrace();
        }
    }


    public void scrolldown() throws InterruptedException {
        WebElement Button = SharedSD.getDriver().findElement(expandTodaysWeatherButton);

        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", Button);


        Thread.sleep(2000);
    }

    public void clickTodaysWeatherButton() {
        clickOn(expandTodaysWeatherButton);
    }

    public void compareMaxAndMinTemp() {

       // boolean isWeatherDisplayedEqually = false;

//Assert.assertEquals(minTemperature,displayMinTemp );

        WebElement maxTempdisplayed = SharedSD.getDriver().findElement(maxTemperature);
        String maxTempValue = maxTempdisplayed.getText();
        maxTempValue= maxTempValue.replaceAll("\\D","");

        WebElement maxTempFromButton = SharedSD.getDriver().findElement(displayMaxTemp);
        String maxTempDisplay = maxTempFromButton.getText();
        maxTempDisplay = maxTempDisplay.replaceAll("\\D","");

        WebElement minTempDisplayed = SharedSD.getDriver().findElement(minTemperature);
        String minTempValue = minTempDisplayed.getText();
        minTempValue = minTempValue.replaceAll("\\D","");

        WebElement minTempfromButton = SharedSD.getDriver().findElement(displayMinTemp);
        String minTempDisplay = minTempfromButton.getText();
        minTempDisplay = minTempDisplay.replaceAll("\\D","");

        Assert.assertEquals(minTempDisplay,minTempValue);
        Assert.assertEquals(maxTempValue, maxTempDisplay);
    }


    public void getCurrentWeather() {

//        try {
//            boolean forecastIshigherThanLowestValueAndLowerThanHighestValue = false;
//            WebElement forecast = SharedSD.getDriver().findElement(weatherSummary);
//            List<WebElement> weatherList = SharedSD.getDriver().findElements(weatherUpdates);
//
//
//            int weatherListLength = weatherList.size();
//            int minValue;
//            int maxValue;
//
//            for (int i = 0; i <= weatherListLength - 1; i++) {
//                String findWeather = SharedSD.getDriver().findElements(By.xpath("//div[@class='temps']//span//span[" + i + "]")).toString();
//                int convertI = Integer.parseInt(findWeather.trim());
//
//                if (i <= convertI & i >= convertI) {
//                    forecastIshigherThanLowestValueAndLowerThanHighestValue = true;
//
//                }
//
//            }
//        }catch (NumberFormatException nfe){
//            System.out.println("Problem found");
//        }
//
//}
//}
        String currentTemp = getTextFromElement(weatherSummary); //Pulls out the text from the element
        currentTemp = currentTemp.replaceAll("\\D", ""); //Replaces all NON-Numbers with blank
        int intTemp = Integer.parseInt(currentTemp);
    }

    List<WebElement> weatherList = SharedSD.getDriver().findElements(weatherUpdates);
    List<Integer> tempList = new ArrayList<>();

    public void createWeatherLists() {

/*
I created 2 lists. 1 is for the web elements that we will eventually iterate through.
The other is an array list which stores our number values as integers.
 */
//        List<WebElement> weatherList = SharedSD.getDriver().findElements(weatherUpdates);
//        List<Integer> tempList = new ArrayList<>();

        for (WebElement tempRange : weatherList) {
            String rangeOfTemps = tempRange.getText();
            rangeOfTemps = rangeOfTemps.replaceAll("\\D", "");
            int tempInt = Integer.parseInt(rangeOfTemps);
            tempList.add(tempInt);


        }
            Collections.sort(tempList);


    }

     public  int getMinValue(){
           createWeatherLists();
        int minValue = tempList.get(0);
        return  minValue;
    }

   public int getMaxVlue(){
        createWeatherLists();
        int maxValue = tempList.get(tempList.size()-1);
        return maxValue;
    }
    public void clickOnDarkSkyAPIBanner(){
        clickOn(darkSkyAPILink);
    }

    public void putInuserPWandclickRegister(){
        setValue("Kkodes245@gmail.com",usernameInputDarkSkySignup);
        setValue("ASDWDW211!",inputPW);
        setValue("ASDWDW211!",confirmPWDarSkyAPI);

        clickOn(registerButtonforDarksky);

    }



}

