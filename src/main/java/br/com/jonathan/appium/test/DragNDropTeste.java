package br.com.jonathan.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.page.DragNDropPage;
import br.com.jonathan.appium.page.MenuPage;

public class DragNDropTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private DragNDropPage page = new DragNDropPage();
	
	private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

	
	@Test
	public void deveEfetuarDragNDrop() {
		menu.acessarDragNDrop();
		
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		page.arrastar("Esta", "e arraste para");
		
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		page.arrastar("Faça um clique longo,", "é uma lista");
		
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
	}
}
