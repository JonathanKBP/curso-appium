package br.com.jonathan.appium;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.jonathan.appium.core.DSL;
import br.com.jonathan.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import junit.framework.Assert;

public class FormularioTeste {
	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		//Seleciona formuario
		dsl.clicarPorTexto("Formulário");
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
	    //Escrever nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Jonathan");
	    
	    //checar nome escrito
	    assertEquals("Jonathan", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {	    
	    //Clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
	    
	    //Verificar opcao selecionada
	    String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	    
	    Assert.assertEquals("Nintendo Switch", text);
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {	    
	   //Verificar status dos elementos
	    Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	    
	    //Clicar nos elementos
	    dsl.clicar(By.className("android.widget.CheckBox"));
	    dsl.clicar(MobileBy.AccessibilityId("switch"));
	    
	    //Verificar estados alterados
	    Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}
	
	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		//Preencher formulario
	    dsl.escrever(By.xpath("//android.widget.EditText[@text='Nome']"), "Jonathan");
	    dsl.selecionarCombo(By.xpath("//android.widget.Spinner"), "PS4");
	    dsl.clicar(By.xpath("//android.widget.CheckBox"));
	    dsl.clicar(By.xpath("//android.widget.Switch"));
	    
	    //Salvar
	    dsl.clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));
	    
	    //Verificar resultado
	    Assert.assertEquals("Nome: Jonathan", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Jonathan']")));
	    Assert.assertEquals("Console: ps4", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
	    Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));
	    Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
	}
}
