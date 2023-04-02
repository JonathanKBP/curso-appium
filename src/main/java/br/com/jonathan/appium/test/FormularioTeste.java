package br.com.jonathan.appium.test;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.jonathan.appium.core.BaseTest;
import br.com.jonathan.appium.core.DriverFactory;
import br.com.jonathan.appium.page.FormularioPage;
import br.com.jonathan.appium.page.MenuPage;
import junit.framework.Assert;

public class FormularioTeste extends BaseTest {
	private MenuPage menu = new MenuPage();

	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Jonathan");

		assertEquals("Jonathan", page.obterNome());
	}

	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");

		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwithMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwithMarcado());
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Jonathan");
		page.selecionarCombo("PS4");
		page.clicarCheck();
		page.clicarSwitch();

		page.salvar();

		Assert.assertEquals("Nome: Jonathan", page.obterNomeCadastrado());
		Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));
	}

	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Jonathan");
		
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		page.salvarDemorado();
		//esperar(3000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Jonathan']")));
		
		
		Assert.assertEquals("Nome: Jonathan", page.obterNomeCadastrado());
	}
}
