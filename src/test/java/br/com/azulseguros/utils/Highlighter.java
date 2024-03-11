package br.com.azulseguros.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {

    private static String originalStyle;

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);

    }

    public static void removeHighlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (isElementVisible(element)) {
            if (originalStyle != null) {
                js.executeScript(
                        "if(arguments[0]) { arguments[0].setAttribute('style', arguments[1]); };",
                        element, originalStyle);
            } else {
                js.executeScript("if(arguments[0]) { arguments[0].removeAttibute('style'); };",
                        element);
            }
        }
    }
    
    private static boolean isElementVisible(WebElement element) {
        try {
           return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e ) {
            return false;
        }
    }

}
