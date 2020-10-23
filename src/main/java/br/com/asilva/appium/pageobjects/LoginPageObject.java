package br.com.asilva.appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject {

    AppiumDriver driver;
    private MobileElement botaoCadastroDeNovosUsuarios;

    public LoginPageObject(AppiumDriver driver) {
        this.driver = driver;
        buscaElementos();
    }

    private void buscaElementos(){
        botaoCadastroDeNovosUsuarios = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    public CadastoPageObject irParaTeladeCadastro(){
        botaoCadastroDeNovosUsuarios.click();
        return new CadastoPageObject(this.driver);
    }


}
