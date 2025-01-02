package edit.EducacionIT_74162;
// Librerias que se necesitaran para ejecutar este archivo
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1 {
	// Variables que necesitaremos para nuestra prueba
	String url = "http://www.automationpractice.pl/";

	@Test
	public void buscarProductoEdge() {
		// Paso 1: Definir qué navegador vamos a utilizar
		WebDriver navegador = new EdgeDriver();
		navegador.manage().deleteAllCookies(); // Borra las cookies
		navegador.manage().window().maximize(); // Maximiza la ventana

		// Paso 2: Abrir la página que se va a probar
		navegador.get(url);

		// Paso 3: Escribir la palabra que queremos buscar
		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");

		// Paso 4: Hacer clic en el botón de búsqueda 
		txtBusqueda.sendKeys(Keys.ENTER); // Simular que presionamos ENTER
		// WebElement btnBuscar = navegador.findElement(By.name("submit_search"));
		// btnBuscar.click();

		// Paso 5: Cerrar el navegador
		navegador.close(); // Cierra la última pestaña que se trabajó
		//navegador.quit(); // Cierra todas las pestañas que se trabajaron
	}

	@Test
	public void buscarProductoFirefox() {
		// Paso 1: Definir qué navegador vamos a utilizar
		WebDriver navegador = new FirefoxDriver();

		// Paso 2: Abrir la página que se va a probar
		navegador.get(url);

		// Paso 3: Escribir la palabra que queremos buscar
		WebElement txtBusqueda = navegador.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");

		// Paso 4: Hacer clic en el botón de búsqueda 
		WebElement btnBuscar = navegador.findElement(By.name("submit_search"));
		btnBuscar.click();
	}
}


