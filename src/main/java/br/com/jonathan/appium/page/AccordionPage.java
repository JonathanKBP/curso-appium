package br.com.jonathan.appium.page;

import org.openqa.selenium.By;

import br.com.jonathan.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionarOp1() {
		clicarPorTexto("Opção 1");
	}
	
	public String obterValorOp1() {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
