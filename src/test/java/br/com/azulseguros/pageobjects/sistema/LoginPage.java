package br.com.azulseguros.pageobjects.sistema;

import br.com.azulseguros.pageobjects.BasePage;
import br.com.azulseguros.utils.Highlighter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "Login")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void informarUsername(String nomeUsuario) {
        Highlighter.highlightElement(getDriver(), username);
        this.username.sendKeys(nomeUsuario);
        Highlighter.removeHighlightElement(getDriver(), username);
    }

    public void informarSenha(String senha) {
        Highlighter.highlightElement(getDriver(), password);
        this.password.sendKeys(senha);
        Highlighter.removeHighlightElement(getDriver(), password);
    }

    public void acionarBotaoLogin() {
        Highlighter.highlightElement(getDriver(), btnLogin);
        this.btnLogin.click();
        Highlighter.removeHighlightElement(getDriver(), btnLogin);
    }
}
