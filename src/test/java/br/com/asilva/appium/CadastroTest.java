package br.com.asilva.appium;

import br.com.asilva.appium.pageobjects.CadastoPageObject;
import br.com.asilva.appium.pageobjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;

public class CadastroTest
{

    private AppiumDriver driver;

    @Before
    public void setUp(){
        driver = AppiumDriverConfig.Instance().driver;
    }

    @Test
    public void naoDeve_CadastrarUsuarioComSenhaDiferente() {
        LoginPageObject telaDeLogin = new LoginPageObject(driver);
        CadastoPageObject telaCadastro = telaDeLogin.irParaTeladeCadastro();
        telaCadastro.cadastrar("Anderson", "123", "456");
        Assert.assertEquals("Senhas não conferem", telaCadastro.mensagemDeErro());
    }

    @Test
    public void deve_CadastrarUsuarioComSenhaQueConferem() throws MalformedURLException {
        LoginPageObject telaDeLogin = new LoginPageObject(driver);
        CadastoPageObject telaCadastro = telaDeLogin.irParaTeladeCadastro();
        telaDeLogin = telaCadastro.cadastrar("Anderson", "123", "123");
        Assert.assertNotNull(telaDeLogin);
    }

}
