package br.com.azulseguros.pageobjects.configuracao;

import br.com.azulseguros.pageobjects.BasePage;
import br.com.azulseguros.utils.Highlighter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuLateralPage extends BasePage {

    @FindBy(xpath = "//input[@class='filter-box input']")
    private WebElement buscaRapida;

    @FindBy(xpath = "//mark[text()='Perfis']")
    private WebElement btnMenuPerfis;

    public MenuLateralPage(WebDriver driver) {
        super(driver);
    }

    public void informarBuscaRapida(String busca) {
        getWebWait().until(ExpectedConditions.elementToBeClickable(buscaRapida));
        Highlighter.highlightElement(getDriver(), buscaRapida);
        this.buscaRapida.sendKeys(busca);
        Highlighter.removeHighlightElement(getDriver(), buscaRapida);
    }

    public void acionarBotaoMenuPerfis() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(btnMenuPerfis));
        Highlighter.highlightElement(getDriver(), btnMenuPerfis);
        this.btnMenuPerfis.click();
        Highlighter.removeHighlightElement(getDriver(), btnMenuPerfis);
    }
}
