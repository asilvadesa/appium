package br.com.asilva.appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;

public class LoginPageObject extends PageObjectBase{

    private MobileElement botaoCadastroDeNovosUsuarios;
    private MobileElement campoIdUsuario;
    private MobileElement campoSenha;
    private MobileElement botaoLogar;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
        buscaElementos();
    }

    @Override
    public void buscaElementos() throws NoSuchElementException {
        campoIdUsuario = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
        campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");
        try{
            botaoCadastroDeNovosUsuarios = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        }catch (NoSuchElementException e){
        }
    }

    public CadastoPageObject irParaTeladeCadastro(){
        botaoCadastroDeNovosUsuarios.click();
        return new CadastoPageObject(this.driver);
    }


    public void logar(String usuario, String senha) {
        preencheFormulario(usuario, senha);
        botaoLogar.click();
    }

    private void preencheFormulario(String usuario, String senha) {
        campoIdUsuario.sendKeys(usuario);
        campoSenha.sendKeys(senha);
    }

    public String mensagemErro() {
        return driver.findElementById("br.com.alura.aluraesporte:id/mensagem_erro_login").getText();
    }
}
