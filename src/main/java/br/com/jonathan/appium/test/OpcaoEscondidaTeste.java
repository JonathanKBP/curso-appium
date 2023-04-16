package br.com.jonathan.appium.test;

import static br.com.jonathan.appium.core.DriverFactory.getDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class OpcaoEscondidaTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();

	@Test
	public void deveEncontrarOpcaoEscondida() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		
		menu.scrollDown();
		
		menu.clicarPorTexto("Opção bem escondida");
		
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		
		menu.clicarPorTexto("OK");
	}
}
