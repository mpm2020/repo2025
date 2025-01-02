package edit.EducacionIT_74162;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticaM2 {
	// Variables que necesitaremos para nuestra prueba
	String url="http://www.automationpractice.pl/";

	@Test
	public void registrarUsuario() {
		//(1) Definir qué navegador vamos a utilizar
		WebDriver navegador = new EdgeDriver();
		navegador.manage().deleteAllCookies(); // Borra las cookies
		navegador.manage().window().maximize(); // Maximiza la ventana

		//(2) Abrir la página que se va a probar
		navegador.get(url);
		
		//(3) Hacer clic en 'Sign in'	
		WebElement lnkSign=navegador.findElement(By.partialLinkText("Sign"));
		lnkSign.click();	
		
		//(4) Escribir el correo electronico
		WebElement txtEmail=navegador.findElement(By.id("email_create"));
		txtEmail.sendKeys("correo05dic"+Math.random()+"@gmail.com");
		
		//(5) Hacer clic en 'Create an account'
		WebElement btnCreate=navegador.findElement(By.name("SubmitCreate"));
		btnCreate.click();
		
		//Necesitamos agregar una espera de X tiempo o hasta que el radio button se cargue
		WebDriverWait espera=new WebDriverWait(navegador,Duration.ofSeconds(30));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		//(6)Seleccionar Sr. o Sra
		WebElement radTitulo=navegador.findElement(By.id("id_gender1"));
		radTitulo.click();
		
		
		//(7) Escribir el nombre
		WebElement txtNombre=navegador.findElement(By.id("customer_firstname"));
		txtNombre.sendKeys("Arturo");
		
		//(8) Escribir el apellido
		WebElement txtApellido=navegador.findElement(By.cssSelector("#customer_lastname"));
		txtApellido.sendKeys("Lopez");
		
		//(9) Limpiar el valor del correo electronico
		WebElement txtEmailForm=navegador.findElement(By.id("email"));
		txtEmailForm.clear();
		
		//(10) Escribir un nuevo valor de correo electronico
		txtEmailForm.sendKeys("correoModificado05dic"+Math.random()+"@gmail.com");
		
		//(11) Escribir la contraseña
		WebElement txtPasswordForm=navegador.findElement(By.name("passwd"));
		txtPasswordForm.clear();
		txtPasswordForm.sendKeys("123456");
		
		//(12) Seleccionar la fecha de nacimiento(día-mes-año)
		
		Select drpDaysForm=new Select(navegador.findElement(By.id("days")));
		
		drpDaysForm.selectByValue("11");
		
        Select drpMonthsForm=new Select(navegador.findElement(By.id("months")));
		
		drpMonthsForm.selectByValue("4");
		 
		Select drpYearForm=new Select(navegador.findElement(By.id("years")));
			
		drpYearForm.selectByValue("1998"); 
		
		//(13) Hacer clic en checkbox
		
		WebElement chkNewsletter=navegador.findElement(By.name("newsletter"));
		chkNewsletter.click();
		
		//(14) Hacer clic en boton 'Register'
		WebElement btnRegister=navegador.findElement(By.id("submitAccount"));
		btnRegister.click();
		
		//(15) Cerrar el navegador
		navegador.quit();
		
	}

}
