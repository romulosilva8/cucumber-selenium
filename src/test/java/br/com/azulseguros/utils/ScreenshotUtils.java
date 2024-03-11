package br.com.azulseguros.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    
    private static List<File> screenshots = new ArrayList<>();
    private static List<String> printDescriptions = new ArrayList<>();
    
    public static void captureScreenshot(WebDriver driver, String description) {
        screenshots.add(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
        printDescriptions.add(description);
    }

    public static List<File> getScreenshots() {
        return screenshots;
    }

    public static List<String> getPrintDescriptions() {
        return printDescriptions;
    }
    
    public static void clearScreenshots() {
        screenshots.clear();
        printDescriptions.clear();
    }

}
