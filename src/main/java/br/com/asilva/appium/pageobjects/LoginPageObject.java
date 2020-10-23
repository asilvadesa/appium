package br.com.asilva.appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;

public class LoginPageObject extends PageObjectBase{

    private MobileElement botaoCadastroDeNovosUsuarios;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
        buscaElementos();
    }

    @Override
    public void buscaElementos() throws NoSuchElementException {
        try{
            botaoCadastroDeNovosUsuarios = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        }catch (NoSuchElementException e){
        }
    }

    public CadastoPageObject irParaTeladeCadastro(){
        botaoCadastroDeNovosUsuarios.click();
        return new CadastoPageObject(this.driver);
    }


}
