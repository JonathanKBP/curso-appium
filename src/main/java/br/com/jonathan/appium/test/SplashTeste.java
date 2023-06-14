package br.com.jonathan.appium.test;

import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import br.com.jonathan.appium.page.SplashPage;
import junit.framework.Assert;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		menu.acessarSplash();
		
		page.isTelaSplashVisivel();
		
		page.aguardarSplashSumir();
		
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}
}
