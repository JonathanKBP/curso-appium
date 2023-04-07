package br.com.jonathan.appium.test;

import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.AbasPage;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class AbasTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		menu.acessarAbas();
		
		Assert.assertTrue(page.isAba1());
		
		page.selecionarAba2();
		
		Assert.assertTrue(page.isAba2());
	}
}
