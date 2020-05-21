package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.gherkin.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InserirContaSemNomeSteps {
	
	private WebDriver driver;
	
	@Given("que estou acessando a aplicacao")
	public void que_estou_acessando_a_aplicacao(){
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromeDrive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("informo o usuario {string}")
	public void informo_o_usuario(String string) {
		driver.findElement(By.id("email")).sendKeys(string);
	}

	@When("a senha {string}")
	public void a_senha(String string) {
		driver.findElement(By.id("senha")).sendKeys(string);
	}

	@When("seleciono entrar")
	public void seleciono_entrar() {
		driver.findElement(By.tagName("button")).click();
	}

	@Then("visualizo a pagina inicial")
	public void visualizo_a_pagina_inicial() {
		String text = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Assert.assertEquals("Bem vindo, user!", text);
	}

	@When("seleciono contas") 
	public void seleciono_contas() {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	}

	@When("seleciono Adicionar")
	public void seleciono_Adicionar() {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@When("seleciono salvar")
	public void seleciono_salvar() {
		driver.findElement(By.tagName("button")).click();
	}

	@Then("sou notificado que o nome da conta e obrigatorio")
	public void sou_notificado_que_o_nome_da_conta_e_obrigatorio() {
	    String text = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
	    Assert.assertEquals("Informe o nome da conta", text);
	}
	@After
	public void screenshot(Scenario scenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target//screenshots//"+ scenario.getName() +".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@AfterAll
	public void close() {
		driver.quit();
	}
}














