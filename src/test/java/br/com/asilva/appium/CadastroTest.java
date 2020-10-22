package br.com.asilva.appium;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

@RunWith(JUnit4.class)
public class CadastroTest
{

    @Test
    public void naoDeve_CadastrarUsuarioComSenhaDiferente() throws MalformedURLException {
        AppiumDriverConfig driver = new AppiumDriverConfig();
        driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario")).click();
        driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome")).sendKeys("asilvadesa");
        driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha")).sendKeys("123");
        driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha")).sendKeys("456");
        driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")).click();
        String text = driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/erro_cadastro")).getText();
        Assert.assertNotNull(text);

    }

}
