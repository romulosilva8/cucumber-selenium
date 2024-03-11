package br.com.azulseguros.pageobjects.sistema;

import java.util.concurrent.TimeUnit;

import br.com.azulseguros.pageobjects.BasePage;
import br.com.azulseguros.utils.Highlighter;
import br.com.azulseguros.utils.ScreenshotUtils;
import br.com.azulseguros.utils.SleepLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {
    
    //url: https://azulseguros--azulqa.sandbox.lightning.force.com/lightning/setup/SetupOneHome/home?setupApp=all
    
    @FindBy(xpath = "//lightning-icon[@icon-name=\"utility:setup\"]")
    private WebElement btnEngrenagem;
    
    @FindBy(xpath = "//button[contains(@class,'salesforceIdentityAppLauncherHeader')]")
    private WebElement btnIniciadorDeAplicativos;
    
    @FindBy(xpath = "//one-app-launcher-search-bar/descendant::input")
    private WebElement inputPesquisar;
    

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void acionarBotaoEngrenadem() {
        Highlighter.highlightElement(getDriver(), btnEngrenagem);
        this.btnEngrenagem.click();
        Highlighter.removeHighlightElement(getDriver(), btnEngrenagem);
    }
    
    public void acionarBotaoIniciadorDeAplicativos() {
        getActions().pause(SleepLevel.NORMAL.getValue(TimeUnit.SECONDS)).perform();
        getWebWait().until(ExpectedConditions.elementToBeClickable(btnIniciadorDeAplicativos));
        Highlighter.highlightElement(getDriver(), btnIniciadorDeAplicativos);
        this.btnIniciadorDeAplicativos.click();
        Highlighter.removeHighlightElement(getDriver(), btnIniciadorDeAplicativos);
    }
    
    public void informarPesquisaAplicativosItens(String pesquisa) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(inputPesquisar));
        Highlighter.highlightElement(getDriver(), inputPesquisar);
        this.inputPesquisar.sendKeys(pesquisa);
        Highlighter.removeHighlightElement(getDriver(), inputPesquisar);
    }
    
    public void acionarAplicativoNoMenu(String nomeAplicativo) {
        String xpath = String.format(
                "//a[@data-label='%s']//p",
                nomeAplicativo);
        getWebWait().until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath)),
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));
        
        WebElement menuAplicativo = getDriver().findElement(By.xpath(xpath));

        Highlighter.highlightElement(getDriver(), menuAplicativo);
        ScreenshotUtils.captureScreenshot(getDriver(), "acessar app " + nomeAplicativo);
        menuAplicativo.click();
        Highlighter.removeHighlightElement(getDriver(), menuAplicativo);
        
       
    }
}
