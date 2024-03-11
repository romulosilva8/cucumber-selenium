package br.com.azulseguros.pageobjects.sistema;

import java.util.List;
import java.util.concurrent.TimeUnit;

import br.com.azulseguros.pageobjects.BasePage;
import br.com.azulseguros.utils.Highlighter;
import br.com.azulseguros.utils.SleepLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConsultaFipePage extends BasePage {

    @FindBy(xpath = "//button[@title='Selecionar um modo de exibição de lista: Consulta FIPE']")
    private WebElement btnModoExibicao;

    @FindBy(xpath = "//input[@name='Azul_VeiculosFipe__c-search-input']")
    private WebElement inputPesquisar;

    @FindBy(xpath = "//ul[@aria-label='Consulta FIPE | Modos de exibição de lista']/li/a/span[text()='Todas as Consultas FIPE']")
    private WebElement menuTodasConsultasFipe;

    @FindBy(xpath = "//ul[@aria-label='Consulta FIPE | Modos de exibição de lista']/li/a/span[text()='Aceita Novos Veículos']")
    private WebElement menuAceitaNovosVeiculos;

    public ConsultaFipePage(WebDriver driver) {
        super(driver);
    }

    public void acionarBotaoModoExibicao() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(btnModoExibicao));
        Highlighter.highlightElement(getDriver(), btnModoExibicao);
        this.btnModoExibicao.click();
        Highlighter.removeHighlightElement(getDriver(), btnModoExibicao);
    }

    public void acionarMenuTodasAsConsultasFipe() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(menuTodasConsultasFipe));
        Highlighter.highlightElement(getDriver(), menuTodasConsultasFipe);
        this.menuTodasConsultasFipe.click();
        Highlighter.removeHighlightElement(getDriver(), menuTodasConsultasFipe);
    }

    public void acionarMenuAceitaNovosVeiculos() {
        getWebWait().until(ExpectedConditions.elementToBeClickable(menuAceitaNovosVeiculos));
        Highlighter.highlightElement(getDriver(), menuAceitaNovosVeiculos);
        this.menuAceitaNovosVeiculos.click();
        Highlighter.removeHighlightElement(getDriver(), menuAceitaNovosVeiculos);
    }

    public void informarTextoPesquisaFipe(String textoPesquisa) {
        getWebWait().until(ExpectedConditions.visibilityOf(inputPesquisar));
        Highlighter.highlightElement(getDriver(), inputPesquisar);
        this.inputPesquisar.sendKeys(textoPesquisa);
        Highlighter.removeHighlightElement(getDriver(), inputPesquisar);
    }

    public void acionarPesquisaFipe() {
        Highlighter.highlightElement(getDriver(), inputPesquisar);
        this.inputPesquisar.sendKeys(Keys.ENTER);
        Highlighter.removeHighlightElement(getDriver(), inputPesquisar);
    }

    public void acionarCodigoFipeDoVeiculo(String fipe, String codigoPorto, String tarifa, String anoModelo) throws InterruptedException {

        // int posCodigoFipe = findElementPositionByTitle(driver.findElements(By.xpath("//thead/tr/th")), "Código FIPE");
        // a posicao do codigo fipe é sempre fixa

        // aguardarElementoAte("//thead/tr/th", 10);
        getActions().pause(SleepLevel.NORMAL.getValue(TimeUnit.SECONDS)).perform();
        
        String xpathCodigo = "//thead/tr/th";
        
        int posCodigoPorto = findElementPositionByTitle(getDriver().findElements(By.xpath(xpathCodigo)), "Código Porto");
        int posTarifa = findElementPositionByTitle(getDriver().findElements(By.xpath(xpathCodigo)), "Tarifa");
        int posAnoModelo = findElementPositionByTitle(getDriver().findElements(By.xpath(xpathCodigo)), "Ano Modelo");

        String xpath = String.format(
                "//tbody/tr[th[1]/span/a[@title='%s'] and td["
                        + posCodigoPorto
                        + "]/span/span[@title='%s'] and td["
                        + posTarifa
                        + "]/span/span[@title='%s'] and td["
                        + posAnoModelo
                        + "]/span/span[@title='%s']]/th/span/a",
                fipe, codigoPorto, tarifa, anoModelo);
        WebElement veiculo = getWebWait().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath(xpath))));
        Highlighter.highlightElement(getDriver(), veiculo);
        veiculo.click();
        Highlighter.removeHighlightElement(getDriver(), veiculo);
    }

    private int findElementPositionByTitle(List<WebElement> elements, String title) {
        for (WebElement element : elements) {
             if (title.equals(element.getAttribute("title"))) {
                return elements.indexOf(element);
            }
        }
        return -1;
    }
}
