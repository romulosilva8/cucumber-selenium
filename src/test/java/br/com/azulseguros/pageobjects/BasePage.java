package br.com.azulseguros.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.azulseguros.utils.SleepLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriverWait wait;
    private Wait<WebDriver> webWait;
    private Actions actions;
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.setDriver(driver);
        actions = new Actions(getDriver());
        setWait(new WebDriverWait(getDriver(), SleepLevel.SUPERLENTO.getValue(TimeUnit.SECONDS)));
        setWebWait(new FluentWait<>(getDriver())
                .withTimeout(SleepLevel.SUPERLENTO.getValue(TimeUnit.SECONDS))
                .pollingEvery(SleepLevel.SUPERSONICO.getValue(TimeUnit.MILLISECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class));
    }

    public BasePage(WebDriver driver, Duration waitDurationInSeconds) {
        PageFactory.initElements(driver, this);
        this.setDriver(driver);
        actions = new Actions(getDriver());
        setWait(new WebDriverWait(getDriver(), waitDurationInSeconds));
        setWebWait(new FluentWait<>(getDriver())
                .withTimeout(waitDurationInSeconds)
                .pollingEvery(SleepLevel.SUPERSONICO.getValue(TimeUnit.MILLISECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class));
    }

    public BasePage(WebDriver driver, Duration waitDurationInSeconds, Duration waitImplicitInSeconds) {
        PageFactory.initElements(driver, this);
        this.setDriver(driver);
        actions = new Actions(getDriver());
        setWait(new WebDriverWait(getDriver(), waitImplicitInSeconds));
        setWebWait(new FluentWait<>(getDriver())
                .withTimeout(waitDurationInSeconds)
                .pollingEvery(SleepLevel.SUPERSONICO.getValue(TimeUnit.MILLISECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class));
    }

    public void navegarPara(String url) {
        driver.navigate().to(url);
    }

    

    public WebElement aguardarElementoAte(String locator, int numeroTentativas) {
        int tentativas = 0;
        while (tentativas < numeroTentativas) {
            try {
                WebElement elemento = webWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
                if (elemento.isDisplayed()) {
                    return elemento;
                }

            } catch (NoSuchElementException e) {
                tentativas++;
            }
        }
        return null;
    }

    public List<WebElement> aguardarListaElementoAte(String locator, int numeroTentativas) {
        int tentativas = 0;
        while (tentativas < numeroTentativas) {
            try {
                List<WebElement> elemento = webWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath(locator))));
                if (!elemento.isEmpty()) {
                    return elemento;
                }

            } catch (NoSuchElementException e) {
                tentativas++;
            }
        }
        return null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Wait<WebDriver> getWebWait() {
        return webWait;
    }

    public void setWebWait(Wait<WebDriver> webWait) {
        this.webWait = webWait;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public Actions getActions() {
        return actions;
    }
}
