package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	WebDriver driver=null;
	String url="http://www.automationpractice.pl/index.php";
	By searchqueryLocator=By.cssSelector("input[placeholder='Search']");


	@BeforeMethod
	@Parameters("navegador")
	public void setUP(String navegador) {

		if(navegador.equalsIgnoreCase("edge")) {

			driver= new EdgeDriver();
		}

		else {

			driver= new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);

	}

	@Test
	public void buscarPalabra() {
		WebElement txtBuscador=driver.findElement(searchqueryLocator);

		txtBuscador.clear();

		txtBuscador.sendKeys("Blouse");

		txtBuscador.sendKeys(Keys.ENTER);

	}

	@AfterMethod
	public void cierreNavegador() {

		driver.quit();
	}

}
