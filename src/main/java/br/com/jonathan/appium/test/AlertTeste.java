package br.com.jonathan.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.AlertaPage;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class AlertTeste extends BaseTest{

	private MenuPage menu = new MenuPage();
	
	private AlertaPage page = new AlertaPage();
	
	@Before
	public void setup() {
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		page.clicarAlertaConfirm();
		
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		page.confirmar();
		
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		page.sair();	
	}
	
	@Test
	public void deveClicarForaAlerta() {
		page.clicarAlertaSimples();
		
		esperar(1000);
		page.clicarForaCaixa();
		
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
