package br.com.jonathan.appium.test;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jonathan.appium.core.DriverFactory;
import br.com.jonathan.appium.page.FormularioPage;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class FormularioTeste {
	private MenuPage menu = new MenuPage();
	
	private FormularioPage page = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Jonathan");
	    
	    assertEquals("Jonathan", page.obterNome());
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {	    
		page.selecionarCombo("Nintendo Switch");
	    
	    Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {	    
	    Assert.assertFalse(page.isCheckMarcado());
	    Assert.assertTrue(page.isSwithMarcado());
	    
	    page.clicarCheck();
	    page.clicarSwitch();
	    
	    Assert.assertTrue(page.isCheckMarcado());
	    Assert.assertFalse(page.isSwithMarcado());
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Jonathan");
		page.selecionarCombo("PS4");
	    page.clicarCheck();
	    page.clicarSwitch();
	    
	    page.salvar();
	    
	    Assert.assertEquals("Nome: Jonathan", page.obterNomeCadastrado());
	    Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());
	    Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
	    Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));
	}
}
