package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.paginaLogin;
public class PracticaM6 {
	String url="https://practice.automationtesting.in/";
	WebDriver driver;
	paginaLogin login;
	
	@BeforeMethod
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--incognito");
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}
	
	@Test()
	public void testLogo() {
		
		WebElement linkTitulo=driver.findElement(By.linkText("Automation Practice Site"));
		linkTitulo.click();
			
	}


	
	@AfterMethod
	public void tearDown() {	
		driver.quit();
		
	}
	

}
