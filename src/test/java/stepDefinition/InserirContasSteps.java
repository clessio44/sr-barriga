package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InserirContasSteps {
	
	private WebDriver driver;
	
	@Given("que estou acessando a aplicacao")
	public void que_estou_acessando_a_aplicacao() {
		System.setProperty("webdriver.chrome.driver",  "src\\test\\resources\\chromeDriver\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@When("informo o usuario {string}")
	public void informo_o_usuario(String string) throws Throwable{
		driver.findElement(By.id("email")).sendKeys(string);
	    
	}

	@When("a senha {string}")
	public void a_senha(String string) throws Throwable{
	   driver.findElement(By.id("senha")).sendKeys(string);
	}

	@When("seleciono entrar")
	public void seleciono_entrar() throws Throwable{
	   driver.findElement(By.tagName("button")).click();
	}

	@Then("visualizo a pagina inicial")
	public void visualizo_a_pagina_inicial() throws Throwable{
		String text = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Bem vindo, user!", text);
	}

	@When("seleciono contas")
	public void seleciono_contas() throws Throwable{
	    driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	}

	@When("seleciono Adicionar")
	public void seleciono_Adicionar() throws Throwable{
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@When("informo a conta {string}")
	public void informo_a_conta(String string) throws Throwable{
	   driver.findElement(By.id("nome")).sendKeys(string);
	}

	@When("seleciono salvar")
	public void seleciono_salvar() throws Throwable{
	   driver.findElement(By.tagName("button")).click();
	}

	@Then("a conta e inserida com sucesso")
	public void a_conta_e_inserida_com_sucesso() throws Throwable{
	    String text2 = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	    Assert.assertEquals("Conta adicionada com sucesso!",text2);
	}
	@AfterAll
	public void close() {
		driver.quit();
	}
}
