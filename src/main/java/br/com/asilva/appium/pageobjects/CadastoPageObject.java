package br.com.asilva.appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastoPageObject extends PageObjectBase{

    private MobileElement campoNome;
    private MobileElement campoSeha;
    private MobileElement campoConfirmaSenha;
    private MobileElement botaoCadastro;
    private MobileElement mensagemErro;

    public CadastoPageObject(AppiumDriver driver) {
        super(driver);
        buscaElementos();
    }

    @Override
    public void buscaElementos(){

        campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoSeha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmaSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

    }


    private void preencheFormulario(String nome, String senha, String confirmaSenha) {
        campoNome.sendKeys(nome);
        campoSeha.sendKeys(senha);
        campoConfirmaSenha.sendKeys(confirmaSenha);
    }

    public LoginPageObject cadastrar(String nome, String senha, String confirmaSenha){
        preencheFormulario(nome, senha, confirmaSenha);
        botaoCadastro.click();
        return new LoginPageObject(driver);
    }

    public String mensagemDeErro() {
        String erroID = "br.com.alura.aluraesporte:id/erro_cadastro";
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.id(erroID)));
        mensagemErro = (MobileElement) driver.findElementById(erroID);
        return mensagemErro.getText();
    }
}
