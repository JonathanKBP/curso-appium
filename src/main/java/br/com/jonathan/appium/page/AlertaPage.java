package br.com.jonathan.appium.page;

import br.com.jonathan.appium.core.BasePage;

public class AlertaPage extends BasePage {

	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void confirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void sair() {
		clicarPorTexto("SAIR");
	}
	
	public void clicarForaCaixa() {
		tap(200, 200);
	}
}
