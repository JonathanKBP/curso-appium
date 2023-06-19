package br.com.jonathan.appium.page.seuBarriga;

import br.com.jonathan.appium.core.BasePage;

public class SBMenuPage extends BasePage {

	public void acessarContas() {
		clicarPorTexto("Contas");
	}
	
	public void acessarMovimentacoes(){
		clicarPorTexto("Mov...");
	}
	
	public void acessarResumo(){
		clicarPorTexto("Resumo");
	}
	
	public void acessarHome(){
		clicarPorTexto("Home");
	}
}
