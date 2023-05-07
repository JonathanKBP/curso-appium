package br.com.jonathan.appium.test;

import org.junit.After;
import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import br.com.jonathan.appium.page.WebViewPage;
import junit.framework.Assert;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();

	@Test
	public void deveFazerLogin(){
		//acessar o menu
		menu.acessarSBHibrido();
		esperar(3000);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("jonathan@android.com");
		
		//senha
		page.setSenha("teste@123");
		
		//entrar
		page.entrar();
		
		//verificar
		Assert.assertEquals("Bem vindo, Jonathan!", page.getMensagem());
	}
	
	@After
	public void tearDown(){
		page.sairContextoWeb();
	}
}