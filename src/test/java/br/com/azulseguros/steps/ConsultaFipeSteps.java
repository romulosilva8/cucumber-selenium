package br.com.azulseguros.steps;

import java.util.concurrent.TimeUnit;

import br.com.azulseguros.pageobjects.sistema.ConsultaFipePage;
import br.com.azulseguros.pageobjects.sistema.HeaderPage;
import br.com.azulseguros.pageobjects.sistema.LoginPage;
import br.com.azulseguros.pageobjects.sistema.MenuPage;
import br.com.azulseguros.utils.ScreenshotUtils;
import br.com.azulseguros.utils.SleepLevel;
import br.com.azulseguros.utils.TestConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Scenario;

public class ConsultaFipeSteps {

    private LoginPage login;
    private HeaderPage header;
    private MenuPage menu;
    private ConsultaFipePage consultaFipe;
    private Scenario scenario;

    public ConsultaFipeSteps() {
        login = new LoginPage(StepData.driver);
        header = new HeaderPage(StepData.driver);
        menu = new MenuPage(StepData.driver);
        consultaFipe = new ConsultaFipePage(StepData.driver);
    }

    @Given("o usuário está logado com um dos perfis Analista")
    public void o_usuário_está_logado_com_um_dos_perfis_analista() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Analista");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Auditor")
    public void o_usuário_está_logado_com_um_dos_perfis_auditor() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Auditor");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Atendimento")
    public void o_usuário_está_logado_com_um_dos_perfis_atendimento() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Atendimento");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Atendimento chat")
    public void o_usuário_está_logado_com_um_dos_perfis_atendimento_chat() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Atendimento chat");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Backoffice")
    public void o_usuário_está_logado_com_um_dos_perfis_backoffice() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Backoffice");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Monitor Qualidade")
    public void o_usuário_está_logado_com_um_dos_perfis_monitor_qualidade() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Monitor Qualidade");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Promotor")
    public void o_usuário_está_logado_com_um_dos_perfis_promotor() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Promotor");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Sinistro Regulação")
    public void o_usuário_está_logado_com_um_dos_perfis_sinistro_regulação() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Sinistro Regulação");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Supervisor")
    public void o_usuário_está_logado_com_um_dos_perfis_supervisor() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Supervisor");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Supervisor Live chat")
    public void o_usuário_está_logado_com_um_dos_perfis_supervisor_live_chat() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Supervisor Live chat");
        login.acionarBotaoLogin();
    }

    @Given("o usuário está logado com um dos perfis Integração SF")
    public void o_usuário_está_logado_com_um_dos_perfis_integração_sf() {
        login.navegarPara(StepData.url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        ScreenshotUtils.captureScreenshot(StepData.driver, "o usuário está logado com um dos perfis Integração SF");
        login.acionarBotaoLogin();
    }

    @Given("acessar um dos apps Azul - Console atendimento")
    public void acessar_um_dos_apps_console_atendimento() {
        header.acionarBotaoIniciadorDeAplicativos();
        header.acionarAplicativoNoMenu("Azul - Console atendimento");   
    }

    @Given("acessar um dos apps Supervisor")
    public void acessar_um_dos_apps_supervisor() {
        header.acionarBotaoIniciadorDeAplicativos();
        header.acionarAplicativoNoMenu("Supervisor");
    }

    @When("o usuário clicar na Guia Consulta FIPE")
    public void o_usuário_clicar_na_guia_consulta_fipe() {
        menu.acionarBotaoMenuNavegacao();
        menu.acionarBotaoConsultaFipe();
        
    }

    @Then("o sistema deverá validar se os campos {string} e {string} estão retornando {string} ou {string} na listagem e na página de Detalhes da Guia Consulta FIPE")
    public void o_sistema_deverá_validar_se_os_campos_e_estão_retornando_ou_na_listagem_e_na_página_de_detalhes_da_guia_consulta_fipe(String string,
            String string2, String string3, String string4) {
        // string1 = Aceita veículos novos
        // string 2 = Vidros
        // string 3 = SIM
        // string 4 = NÃO
        consultaFipe.acionarBotaoModoExibicao();
        consultaFipe.acionarMenuAceitaNovosVeiculos();
        consultaFipe.getActions().pause(SleepLevel.NORMAL.getValue(TimeUnit.SECONDS)).perform();
    }

}
