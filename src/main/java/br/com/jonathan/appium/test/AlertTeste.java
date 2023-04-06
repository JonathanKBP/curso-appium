package br.com.jonathan.appium.test;

import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class AlertTeste extends BaseTest{

	private MenuPage menu = new MenuPage();
	
	private AlertaPage page = new AlertaPage();
	
	@Test
	public void deveConfirmarAlerta() {
		menu.acessarAlertas();
		
		page.clicarAlertaConfirm();
		
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		page.confirmar();
		
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		page.sair();
		
		
	}
}
