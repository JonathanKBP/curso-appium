package br.com.jonathan.appium.test;

import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import br.com.jonathan.appium.page.SwipeListPage;
import junit.framework.Assert;

public class SwipeElementTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();

	@Test
	public void deveResolverDesafio() {
		menu.acessarSwipeList();
		
		page.swipeElementRight("Opção 1");
		
		page.clicarBotaoMais();
		
		Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));
		
		page.swipeElementRight("Opção 4");
		
		page.clicarPorTexto("(-)");
		
		Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));
		
		page.swipeElementLeft("Opção 5 (-)");
		
		Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));
	}
}
