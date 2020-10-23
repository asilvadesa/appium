package br.com.asilva.appium;

import br.com.asilva.appium.pageobjects.CadastoPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class CadastroTest
{

    @Test
    public void naoDeve_CadastrarUsuarioComSenhaDiferente() throws MalformedURLException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario").click();

        CadastoPageObject telaCadastro = new CadastoPageObject(driver);
        telaCadastro.buscaElementos();
        telaCadastro.cadastrar("Anderson", "123", "456");
        Assert.assertEquals("Senhas não conferem", telaCadastro.mensagemDeErro());

    }

    @Test
    public void deve_CadastrarUsuarioComSenhaQueConferem() throws MalformedURLException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario").click();

        CadastoPageObject telaCadastro = new CadastoPageObject(driver);
        telaCadastro.buscaElementos();
        telaCadastro.cadastrar("Anderson", "123", "123");


        MobileElement botaoLogin = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
        Assert.assertNotNull(botaoLogin);
    }

}
