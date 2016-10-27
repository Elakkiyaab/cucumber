package nl.home.testing.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;

   // By placeTextBoxLocator = By.xpath("//*[@id='autocomplete-input']");
    By placeTextBoxLocator = By.id("autocomplete-input");
    By distanceOptionsLocator = By.id("Afstand");
    By minPriceLocator = By.id("range-filter-selector-select-filter_fundakoopprijsvan");
    By maxPriceLocator = By.id("range-filter-selector-select-filter_fundakoopprijstot");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://www.funda.nl/");
        waitUntilPageLoad();
    }

    private void waitUntilPageLoad() {
        // TO wait untill the page is loaded.
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }
    public void enterPlace(String place){
        driver.findElement(placeTextBoxLocator).isEnabled();
        driver.findElement(placeTextBoxLocator).clear();
        driver.findElement(placeTextBoxLocator).click();
        driver.findElement(placeTextBoxLocator).sendKeys(place);
    }

    public void selectDistance(String distance){
        driver.findElement(distanceOptionsLocator).click();
        Select droplist = new Select(driver.findElement(distanceOptionsLocator));
        droplist.selectByValue(distance);
    }

    public void selectMinPrice(String min){
        Select droplist = new Select(driver.findElement(minPriceLocator));
        droplist.selectByValue(min);
    }

    public void selectMaxPrice(String max){
        Select droplist = new Select(driver.findElement(maxPriceLocator));
        droplist.selectByValue(max);
    }
}
