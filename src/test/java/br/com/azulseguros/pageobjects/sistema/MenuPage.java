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

public class MenuPage extends BasePage {

    @FindBy(xpath = "//button[@title='Mostrar Menu de navegação']")
    private WebElement btnMenuNavegacao;

    @FindBy(xpath = "//a[@data-label='Consulta FIPE']")
    private WebElement btnConsultaFipe;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void acionarBotaoMenuNavegacao() {
        // aguardarSistema();
        // wait.until(ExpectedConditions.elementToBeClickable(btnMenuNavegacao));
        getActions().pause(SleepLevel.NORMAL.getValue(TimeUnit.SECONDS)).perform();
        getWebWait().until(ExpectedConditions.elementToBeClickable(btnMenuNavegacao));
        Highlighter.highlightElement(getDriver(), btnMenuNavegacao);
        this.btnMenuNavegacao.click();
        Highlighter.removeHighlightElement(getDriver(), btnMenuNavegacao);
    }

    public void acionarBotaoConsultaFipe() {
        // wait.until(ExpectedConditions.elementToBeClickable(btnConsultaFipe));
        getWebWait().until(ExpectedConditions.elementToBeClickable(btnConsultaFipe));
        Highlighter.highlightElement(getDriver(), btnConsultaFipe);
        ScreenshotUtils.captureScreenshot(getDriver(), "o usuário clicar na Guia Consulta FIPE");
        this.btnConsultaFipe.click();
        Highlighter.removeHighlightElement(getDriver(), btnConsultaFipe);
    }

    public void acionarVeiculoFipe(String fipe) {
        // wait.until(ExpectedConditions.elementToBeClickable(veiculoFipe));
        String xpath = String.format(
                "//a[@title='%s | Consulta FIPE']",
                fipe);
        getWebWait().until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath)),
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));
        
        WebElement veiculoFipe = getDriver().findElement(By.xpath(xpath));

        Highlighter.highlightElement(getDriver(), veiculoFipe);
        veiculoFipe.click();
        Highlighter.removeHighlightElement(getDriver(), veiculoFipe);
    }

    public void acionarFecharVeiculoFipe(String fipe) {
        // wait.until(ExpectedConditions.elementToBeClickable(veiculoFipe));
        String xpath = String.format(
                "//button[contains(@title,'%s') and contains(@title, 'Fechar')]",
                fipe);
        WebElement veiculoFipe = getWebWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath(xpath))));
        Highlighter.highlightElement(getDriver(), veiculoFipe);
        veiculoFipe.click();
        Highlighter.removeHighlightElement(getDriver(), veiculoFipe);
    }

}
