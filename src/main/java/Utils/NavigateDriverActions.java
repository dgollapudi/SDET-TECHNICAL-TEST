package Utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by dgollapudi on 07/03/2018.
 */
public class NavigateDriverActions extends NavigateDriver {
    private Logger logger = Logger.getLogger(NavigateDriverActions.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Override
    public void setDriver() {
        System.setProperty(PropertyReader.getSystemProps().getProperty("chromeDriver"), PropertyReader.getSystemProps().getProperty("chromeDriverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Override
    public void navigateToPage(String url) {
        driver.get(url);
        Logging.info(this.getClass(), "Navigated to sportsbook" + url);
    }

    @Override
    public void navigateToElementById(String id) throws InterruptedException {
        try {
            this.currentElement = driver.findElement(By.id(id));
        } catch (NoSuchElementException exp1) {
            Logging.info(this.getClass(), "navigateToElementById: Element not found with id " + id);
        }
    }

    @Override
    public void navigateToElementByClassName(String className) {
        try {
            this.currentElement = driver.findElement(By.className(className));
        } catch (NoSuchElementException exp2) {
            Logging.error(this.getClass(), "Element is not found with className  " + className, exp2);
        }
    }

    @Override
    public void navigateToElementByPartialLinkText(String linkText) {
        try {
            this.currentElement = driver.findElement(By.partialLinkText(linkText));
        } catch (NoSuchElementException exp2) {
            Logging.error(this.getClass(), "Element is not found with className  " + linkText, exp2);
        }
    }

    @Override
    public void navigateToElementByXpath(String xpath) {
        try {
            this.currentElement = driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException exp2) {
            Logging.error(this.getClass(), "Element is not found with className  " + xpath, exp2);
        }

    }

    @Override
    public void navigateToElementBycssSelector(String cssSelector) {
        try {
            this.currentElement = driver.findElement(By.cssSelector(cssSelector));
        } catch (NoSuchElementException exp2) {
            Logging.error(this.getClass(), "Element is not found with className  " + cssSelector, exp2);
        }
    }

    public void typeIn(String text) throws InterruptedException {
        try {
            this.currentElement.sendKeys(text);
        } catch (NoSuchFieldError exp3) {
            Logging.error(this.getClass(), "no username found  " + text + exp3);
        }
    }

    public void scrollDown() {
        js.executeScript("scroll(0,250)");
    }

    public void click() {
        this.currentElement.click();
    }

    public void close() {
        driver.close();
    }

    public String getText() {
        String text = this.currentElement.getText();
        return text;
    }

}





