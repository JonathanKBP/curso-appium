package br.com.jonathan.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import br.com.jonathan.appium.page.seuBarriga.SBContasPage;
import br.com.jonathan.appium.page.seuBarriga.SBLoginPage;
import br.com.jonathan.appium.page.seuBarriga.SBMenuPage;
import br.com.jonathan.appium.page.seuBarriga.SBMovimentacaoPage;
import junit.framework.Assert;

public class SBTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage(); 
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	
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
		
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta(){
		// entrar em contas
		menuSB.acessarContas();
		
		//clique longo na conta
		contas.selecionarConta("Conta de Teste");
		
		//ecluir
		contas.excluir();
		
		//verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMov(){
		menuSB.acessarMovimentacoes();
		
		//validar desc
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		//validar inte
		mov.setDescricao("Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		//validar valor
		mov.setInteressado("interess");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		//validar conta
		mov.setValor("123");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		//inserir com sucesso
		mov.setConta("Conta para alterar");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}
}
