package br.com.asilva.appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastoPageObject {

    AppiumDriver driver;
    private MobileElement campoNome;
    private MobileElement campoSeha;
    private MobileElement campoConfirmaSenha;
    private MobileElement botaoCadastro;
    private MobileElement mensagemErro;

    public CadastoPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

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

    public void cadastrar(String nome, String senha, String confirmaSenha){
        preencheFormulario(nome, senha, confirmaSenha);
        botaoCadastro.click();
    }

    public String mensagemDeErro() {
        mensagemErro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        return mensagemErro.getText();
    }
}
