package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohammadmuntakim
 */
public class BasePage extends DateUtil {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {

		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {

		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}



	//43:00
	public void setValue(String value, By locator) {

		webAction(locator).sendKeys(value);
	}





	public void switchToWindow(int index) {
		List<String> listOfWindows = new ArrayList<String>(SharedSD.getDriver().getWindowHandles());
		SharedSD.getDriver().switchTo().window(listOfWindows.get(index));
	}

	public static void switchToRootWindowAndCloseAllOtherWindows(){
		List<String> listOfWindows = new ArrayList<String>(SharedSD.getDriver().getWindowHandles());

		for(int i = 1; i < listOfWindows.size(); i++){
			SharedSD.getDriver().switchTo().window(listOfWindows.get(i));
			SharedSD.getDriver().close(); // only closes current browser
		}
		SharedSD.getDriver().switchTo().window(listOfWindows.get(0));
	}
	public void selectDropDown(By locator,String dropDownText) throws InterruptedException{
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText(dropDownText);

	}

	public void autocomplete(By locator,String expectedcity) {
//        System.out.println("Inside autocomplete method");
//        List<WebElement> city = DriverWrapper.getDrive().findElements(locator);
//        for(WebElement element : city){
//            System.out.println(element.getText() + " element.gettext");
//            if(element.getText().contains(expectedcity)){
//                System.out.println("City Name"+element.getText());
//
//                element.click();
//                break;
//            }
		boolean expectedCity = false;
		webAction(locator);
		if(expectedCity){
			System.out.println(expectedcity);
		}

	}

	public static void mouseOver(By locator) throws InterruptedException {

//        By locator = By.id("");

		SharedSD.getDriver().manage().window().maximize();
		WebElement element = SharedSD.getDriver().findElement(locator);


		Actions actions = new Actions(SharedSD.getDriver());
		actions.moveToElement(element).build().perform();

	}

	public void selectTodayFromCal( By locator) {



		SimpleDateFormat sdf = new SimpleDateFormat("d");
		Date date = new Date();
		String todayDate = sdf.format(date);

		SharedSD.getDriver().findElement(locator).click();
		List<WebElement> days = SharedSD.getDriver().findElements(locator);
		for (WebElement day : days) {
			if (day.getText().equals(todayDate)) {
				day.click();
				break;
			}
		}


	}

	public static void selectTodayFromCal(String dateInput) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, MMMM d yyyy");// day of week,Month day year
		Date readDate = sdf1.parse(dateInput);
		System.out.println("The date is " + readDate);


	}
//	public static void alertHandles() throws InterruptedException{
//		By locator = By.id("");
//
//		//SharedSD.getDriver().switchTo().frame("iframeResult");
//		//SharedSD.getDriver().switchTo().alert().accept();
//		//SharedSD.getDriver().switchTo().alert().accept();
////		webAction(locator).click();
////		SharedSD.getDriver().switchTo().alert().dismiss();
////		webAction(locator).click();
////		SharedSD.getDriver().switchTo().alert().sendKeys("nnam");
////		SharedSD.getDriver().switchTo().alert().dismiss();
////		webAction(locator).click();
////		SharedSD.getDriver().switchTo().alert().sendKeys("Test");
////		SharedSD.getDriver().switchTo().alert().dismiss();
////		webAction(locator).click();


	//}
	public static void alertAccept(By locator){
		SharedSD.getDriver().switchTo().alert().accept();

	//	webAction(locator).click();

	}
	public static void alertDismiss(By locator){
		SharedSD.getDriver().switchTo().alert().dismiss();
		//webAction(locator).click();

	}

	public static void alertSendKeys(String sendKey){
		SharedSD.getDriver().switchTo().alert().sendKeys(sendKey);
	}

	public static void switchToFrame(String frameResult)
	{
		SharedSD.getDriver().switchTo().frame(frameResult);
	}

	public static List<WebElement> webActions(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage("Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(locator);
			}
		});
		return elements;
	}
	public String getTimeInHours(int num){

		return currentDate(num);
	}

}
