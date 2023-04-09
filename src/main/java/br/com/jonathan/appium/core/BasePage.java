package br.com.jonathan.appium.core;

import static br.com.jonathan.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
		
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean ExisteElementoPorTexto(String texto) {
		 List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		 
		 return elementos.size() > 0;
	}
	
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
	}
}
