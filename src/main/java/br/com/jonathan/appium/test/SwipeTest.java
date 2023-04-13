package br.com.jonathan.appium.test;

import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class SwipeTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveRealizarSwipe() {
		menu.acessarSwipe();
		
		Assert.assertTrue(menu.ExisteElementoPorTexto("a esquerda"));
		
		menu.swipe(0.9, 0.1);
		
		Assert.assertTrue(menu.ExisteElementoPorTexto("E veja se"));
		
		menu.clicarPorTexto("›");
		
		Assert.assertTrue(menu.ExisteElementoPorTexto("Chegar até o fim!"));
			
		menu.swipe(0.1, 0.9);
		
		menu.clicarPorTexto("‹");
		
		Assert.assertTrue(menu.ExisteElementoPorTexto("a esquerda"));
		
	}
}
