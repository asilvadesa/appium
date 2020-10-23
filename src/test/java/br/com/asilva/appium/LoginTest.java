package br.com.asilva.appium;

import br.com.asilva.appium.pageobjects.CadastoPageObject;
import br.com.asilva.appium.pageobjects.ListaDeProdutosObject;
import br.com.asilva.appium.pageobjects.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {

    AppiumDriver driver;

    @Before
    public void setUp(){
        driver = AppiumDriverConfig.Instance().driver;
    }

    @Test
    public void deve_FazerLoginQuandoSenhaForCorreta(){
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.logar("Anderson", "123");
        new ListaDeProdutosObject(driver);
    }

    @Test
    public void naoDeve_FazerLoginComSenhaIncorreta(){
        cadastroDeUsuarioCenarioDeTeste();
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.logar("Anderson", "124");
        String erro = telaLogin.mensagemErro();
        Assert.assertEquals("Usuário ou senha inválidos", erro);
    }

    private void cadastroDeUsuarioCenarioDeTeste() {
        LoginPageObject telaDeLogin = new LoginPageObject(driver);
        CadastoPageObject telaCadastro = telaDeLogin.irParaTeladeCadastro();
        telaDeLogin = telaCadastro.cadastrar("Anderson", "123", "123");
        Assert.assertNotNull(telaDeLogin);
    }

}
