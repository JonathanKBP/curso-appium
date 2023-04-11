package br.com.jonathan.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.CliquesPage;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Before
	public void setup() {
		menu.acessarCliques();
	}

	@Test
	public void deveRealizarCliqueLongo() {
		page.cliqueLongo();
		
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}
}
