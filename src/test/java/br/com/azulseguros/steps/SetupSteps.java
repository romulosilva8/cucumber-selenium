package br.com.azulseguros.steps;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;

import br.com.azulseguros.utils.CustomScreenRecorder;
import br.com.azulseguros.utils.GerarPdf;
import br.com.azulseguros.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Examples;
import io.cucumber.plugin.event.Node.Example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupSteps {

    protected String url = "https://azulseguros--azulqa.sandbox.my.salesforce.com/";
    // protected WebDriver driver;
    private CustomScreenRecorder screenRecorder;
    
    @Before
    public void setUp(Scenario scenario) throws IOException, AWTException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        // options.addArguments("--disk-cache-size=0");
        options.addArguments("--start-maximized");

        // setDriver(wdm.capabilities(options).create());
        StepData.driver = new ChromeDriver(options);
        StepData.url = this.url;
        
        ScreenshotUtils.clearScreenshots();
        
        
        /*
        screenRecorder = new CustomScreenRecorder(new File(System.getProperty("user.dir")
                + File.separator
                + "target"
                + File.separator
                + "screen-records"
                + File.separator
                + scenario.getName()));
        screenRecorder.startRecording(
                LocalDateTime.now().toString().replace(":", ""), false);
    */
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        //new Actions(StepData.driver).pause(Duration.ofSeconds(2)).perform(); // pausando por 2 segundo apenas para melhorar a gravação
        //screenRecorder.stopRecording(true);
        byte[] screenshot = ((TakesScreenshot) StepData.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot");
        
        if(scenario.isFailed()) {
            ScreenshotUtils.captureScreenshot(getDriver(), "Evidência da falha");
        }
        
        if(!ScreenshotUtils.getScreenshots().isEmpty()) {
            new GerarPdf().criarPdf(scenario, getDriver(), ScreenshotUtils.getScreenshots(), ScreenshotUtils.getPrintDescriptions());
        }
        StepData.driver.quit();
    }
    
    /*
     * @After
     * public void embedScreenshot() {
     * }
     */

    public WebDriver getDriver() {
        return StepData.driver;
    }
}
