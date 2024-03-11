package br.com.azulseguros.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import br.com.azulseguros.pageobjects.configuracao.MenuLateralPage;
import br.com.azulseguros.pageobjects.configuracao.PerfisPage;
import br.com.azulseguros.pageobjects.sistema.ConsultaFipePage;
import br.com.azulseguros.pageobjects.sistema.LoginPage;
import br.com.azulseguros.pageobjects.sistema.MenuPage;
import br.com.azulseguros.steps.SetupSteps;
import br.com.azulseguros.utils.SleepLevel;
import br.com.azulseguros.utils.TestConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.interactions.Actions;
/*
class PocTest extends SetupSteps {
    private LoginPage login;
    private MenuPage menu;
    private ConsultaFipePage consultaFipe;
    private MenuLateralPage menuLateral;
    private PerfisPage perfis;
    
    @Test
    void testPoc() throws InterruptedException {
        
        login = new LoginPage(getDriver());
        menu = new MenuPage(getDriver());
        consultaFipe = new ConsultaFipePage(getDriver());
        menuLateral = new MenuLateralPage(getDriver());
        perfis = new PerfisPage(getDriver());
        
        login.navegarPara(url);
        login.informarUsername("romulosilva.ilab@azulseguros.com.br.qa");
        login.informarSenha(TestConstants.PASSWORD);
        login.acionarBotaoLogin();
        /*
        menu.navegarPara("https://azulseguros--azulqa.sandbox.lightning.force.com/lightning/setup/SetupOneHome/home?setupApp=all");
        
        menuLateral.informarBuscaRapida("Perfis");
        menuLateral.acionarBotaoMenuPerfis();
        perfis.acionarPerfil("Atendimento - Chat");
        perfis.acionarExibirUsuarios();
        
        /*
        menu.acionarBotaoMenuNavegacao();
        menu.acionarBotaoConsultaFipe();

        consultaFipe.acionarBotaoModoExibicao();
        consultaFipe.acionarMenuAceitaNovosVeiculos();
        action.pause(SleepLevel.NORMAL.getValue(TimeUnit.SECONDS)).perform();
        consultaFipe.acionarCodigoFipeDoVeiculo("111821", "5427", "01/2024", "2021");
        
        menu.acionarVeiculoFipe("111821");
        menu.acionarFecharVeiculoFipe("111821");
        */
    //}
    
//}
