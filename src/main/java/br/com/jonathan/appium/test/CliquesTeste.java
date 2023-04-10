package br.com.jonathan.appium.test;

import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.CliquesPage;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();

	@Test
	public void deveRealizarCliqueLongo() {
		menu.acessarCliques();
		
		page.cliqueLongo();
		
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
}
