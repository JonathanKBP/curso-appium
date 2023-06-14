package br.com.jonathan.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.MenuPage;
import br.com.jonathan.appium.page.seuBarriga.SBContasPage;
import br.com.jonathan.appium.page.seuBarriga.SBHomePage;
import br.com.jonathan.appium.page.seuBarriga.SBLoginPage;
import br.com.jonathan.appium.page.seuBarriga.SBMenuPage;
import br.com.jonathan.appium.page.seuBarriga.SBMovimentacaoPage;
import br.com.jonathan.appium.page.seuBarriga.SBResumoPage;
import junit.framework.Assert;

public class SBTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage(); 
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
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
	
	@Test
	public void deveAtualizarSaldoAoEcluirMovimentacao(){
		//verificar saldo "Conta para saldo" = 534.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		
		//ir para resumo
		menuSB.acessarResumo();
		
		//excluir Movimentacao 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		
		//validar a mensagem "Movimentação removida com sucesso"
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));
		
		//voltar home
		menuSB.acessarHome();
		
		//atualizar saldos
		esperar(1000);
		home.scroll(0.2, 0.9);
		
		//verificar saldo = -1000.00
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}
}
