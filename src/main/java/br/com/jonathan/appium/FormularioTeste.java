package br.com.jonathan.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.jonathan.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class FormularioTeste {
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
	    
		//Seleciona formuario
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
	    //Escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Jonathan");
	    
	    //checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Jonathan", text);
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {	    
	    //Clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //Selecionar opcao desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //Verificar opcao selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    
	    Assert.assertEquals("Nintendo Switch", text);
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {	    
	   //Verificar status dos elementos
	    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    
	    //Clicar nos elementos
	    check.click();
	    switc.click();
	    
	    //Verificar estados alterados
	    Assert.assertFalse(check.getAttribute("checked").equals("false"));
	    Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	}
	
	@Test
	public void devePreencherFormulario() throws MalformedURLException {
		//Preencher formulario
	    driver.findElement(By.xpath("//android.widget.EditText[@text='Nome']")).sendKeys("Jonathan");
	    driver.findElement(By.xpath("//android.widget.Spinner")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
	    driver.findElement(By.xpath("//android.widget.CheckBox")).click();
	    driver.findElement(By.xpath("//android.widget.Switch")).click();
	    driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
	    
	    //Verificar resultado
	    String nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Jonathan']")).getText();
	    Assert.assertEquals("Nome: Jonathan", nome);
	    
	    MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	    Assert.assertEquals("Console: ps4", combo.getText());
	    
	    MobileElement switc = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	    Assert.assertTrue(switc.getText().endsWith("Off"));
	    
	    MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	    Assert.assertTrue(check.getText().endsWith("Marcado"));
	}
}
