package br.com.jonathan.appium.page;

import br.com.jonathan.appium.core.DSL;

public class MenuPage {
	
	DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}

}
