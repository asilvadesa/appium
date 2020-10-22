package br.com.asilva.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class CadastroTest
{

    @Test
    public void naoDeve_CadastrarUsuarioComSenhaDiferente() throws MalformedURLException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario")).click();
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome")).sendKeys("asilvadesa");
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha")).sendKeys("123");
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha")).sendKeys("456");
        driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")).click();
        String text = driver.findElement(By.id("br.com.alura.aluraesporte:id/erro_cadastro")).getText();
        Assert.assertNotNull(text);
    }

    @Test
    public void deve_CadastrarUsuariosComSenhaQueConferem() throws MalformedURLException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MobileElement botaoCadastro = (MobileElement) driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        botaoCadastro.click();
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome")).sendKeys("asilvadesa");
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha")).sendKeys("123");
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha")).sendKeys("123");
        driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")).click();

        MobileElement botaoLogar = (MobileElement) driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_logar"));
        Assert.assertNotNull(botaoLogar);
    }

}
