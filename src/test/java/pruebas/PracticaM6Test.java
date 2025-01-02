package pruebas;

import org.openqa.selenium.Alert;
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
public class PracticaM6Test {
	String url="https://demoqa.com/alerts";
	WebDriver driver;
	paginaLogin login;
	
	@BeforeMethod
	public void setUP() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		double zoom = 0.8;
        options.addArguments("--force-device-scale-factor="+zoom);
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}
	
	@Test()
	public void alertaNotificacion() {
		
		WebElement btnButton=driver.findElement(By.id("alertButton"));
	    btnButton.click();
			
	    Alert Alerta=driver.switchTo().alert();
	    
	    Alerta.accept();
	}


	
	@AfterMethod
	public void tearDown() {	
		driver.quit();
		
	}
	

}
