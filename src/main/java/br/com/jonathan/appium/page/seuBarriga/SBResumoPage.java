package br.com.jonathan.appium.page.seuBarriga;

import static br.com.jonathan.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.jonathan.appium.core.BasePage;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {
	public void excluirMovimentacao(String desc) {
		MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}
}
