package br.com.jonathan.appium.page;

import br.com.jonathan.appium.core.BasePage;

public class AbasPage extends BasePage {

	public boolean isAba1() {
		return ExisteElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return ExisteElementoPorTexto("Este é o conteúdo da Aba 2");
	}
	
	public void selecionarAba2() {
		clicarPorTexto("Aba 2");
	}
}
