package br.com.asilva.appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ListaDeProdutosObject extends PageObjectBase{


    private MobileElement botaoDeslogar;

    public ListaDeProdutosObject(AppiumDriver driver) {
        super(driver);
        buscaElementos();
    }

    @Override
    public void buscaElementos() {
        botaoDeslogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/menu_principal_deslogar");
    }
}
