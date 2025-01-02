package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import paginas.paginaLogin;
public class PracticaM4 {
	String url="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	WebDriver driver;
	paginaLogin login;
	
	@BeforeSuite
	public void setUP() {
		driver=new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}
	
	@Test
	public void loginUser() {
		login=new paginaLogin(driver);
		login.ingresarDatos("test1@gmail.com","123456");
		Assert.assertEquals(login.getTitleForm(),"AUTHENTICATION");
		
		
	}
	
	@AfterSuite
	public void tearDown() {	
		driver.quit();
		
	}
	

}
