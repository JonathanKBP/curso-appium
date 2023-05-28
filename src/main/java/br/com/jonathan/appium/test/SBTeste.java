package br.com.jonathan.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import br.com.jonathan.appium.page.seuBarriga.SBContasPage;
import br.com.jonathan.appium.page.seuBarriga.SBLoginPage;
import br.com.jonathan.appium.page.seuBarriga.SBMenuPage;
import junit.framework.Assert;

public class SBTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage(); 
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	@Before
	public void setup(){
		menu.acessarSBNativo();
		login.setEmail("jonathan@android.com");
		login.setSenha("teste@123");
		login.entrar();
	}

	@Test
	public void deveInserirContaComSucesso() {
		menuSB.acessarContas();
		
		contas.setConta("Conta de Teste");
		
		contas.salvar();
		
		Assert.assertTrue(contas.ExisteElementoPorTexto("Conta adicionada com sucesso"));
	}
}
