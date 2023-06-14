package br.com.jonathan.appium.page.seuBarriga;

import br.com.jonathan.appium.core.BasePage;

public class SBMenuPage extends BasePage {

	public void acessarContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimentacoes(){
		clicarPorTexto("MOV...");
	}
}
