package br.com.jonathan.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class FormularioTeste {
	private AndroidDriver<MobileElement> driver;
	
	@Before
	private void inicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
	    //desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
	    //desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "\\Users\\Jonathan\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");
	    
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		//Seleciona formuario
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	    
	    elementosEncontrados.get(1).click();
	    
	    //Escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Jonathan");
	    
	    //checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Jonathan", text);
	    
	    driver.quit();
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
	    //Seleciona formuario
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
	    //Clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //Selecionar opcao desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //Verificar opcao selecionada
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    
	    Assert.assertEquals("Nintendo Switch", text);
	    
	    driver.quit();
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		//Seleciona formuario
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	    
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
	    
	    driver.quit();
	}
	
	@Test
	public void devePreencherFormulario() throws MalformedURLException {
	    //Seleciona formuario
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
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
	    
	    driver.quit();
	}
}
