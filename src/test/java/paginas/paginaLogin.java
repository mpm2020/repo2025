package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class paginaLogin {
	
	WebDriver driver;
	
	//Locators
	By emailField=By.id("email");
	By passwordField=By.id("passwd");
	By loginButton=By.id("SubmitLogin");
	By titleForm=By.xpath("//h1[contains(text(),'Authentication')]");
	
	//Constructor
	public paginaLogin(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	//Metodo para Ingresar Datos
	public void ingresarDatos(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	//Metodo para obtener Titulo
	
	public String getTitleForm() {	
		return driver.findElement(titleForm).getText();
	}

}
