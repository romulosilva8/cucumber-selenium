package br.com.azulseguros.pageobjects.configuracao;

import java.util.concurrent.TimeUnit;

import br.com.azulseguros.pageobjects.BasePage;
import br.com.azulseguros.utils.Highlighter;
import br.com.azulseguros.utils.SleepLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PerfisPage extends BasePage {

    @FindBy(xpath = "//input[@name='users']")
    private WebElement btnExibirUsuarios;

    public PerfisPage(WebDriver driver) {
        super(driver, SleepLevel.TARTARUGA.getValue(TimeUnit.SECONDS), SleepLevel.TARTARUGA.getValue(TimeUnit.SECONDS));
    }

    public void acionarPerfil(String perfil) {
        String xpath = String.format(
                "//span[text()='%s']/parent::a/parent::div",
                perfil);
        getActions().pause(SleepLevel.LENTO.getValue(TimeUnit.SECONDS)).perform();
        WebElement iframe = getWebWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='Perfis ~ Salesforce - Enterprise Edition']")));
        getDriver().switchTo().frame(iframe);
        
        WebElement perfilEscolhido = getWebWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        
        Highlighter.highlightElement(getDriver(), perfilEscolhido);
        //ele clica mas não abre a página, clicar 2 vezes?
        getActions().click(perfilEscolhido).perform();
        Highlighter.removeHighlightElement(getDriver(), perfilEscolhido);
    }

    public void acionarExibirUsuarios() {
        
        //provavelmente tem um iframe também que p´recisa ser navegado
        getWebWait().until(ExpectedConditions.elementToBeClickable(btnExibirUsuarios));
        Highlighter.highlightElement(getDriver(), btnExibirUsuarios);
        btnExibirUsuarios.click();
        Highlighter.removeHighlightElement(getDriver(), btnExibirUsuarios);
    }
}
