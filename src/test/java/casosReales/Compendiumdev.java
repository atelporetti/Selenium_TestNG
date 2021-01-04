package casosReales;

import clasesUtiles.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * 1. Navegar a la pagina
 * 2. Hacer click en boton Show Alert box
 * 3. Mostrar mensaje de alerta
 * 4. Apretar aceptar y salir de alerta
 * 
 * 5. Hacer click en boton Show confirm box
 * 6. Mostrar mensaje de alerta
 * 7. Apretar cancelar y salir de la alerta
 * 8. Verificar si al dar cancelar da false el texto de la pagina
 * 
 * 9. Hacer click en el boton Show prompt box
 * 10. Escribir tu nombre
 * 11. Apretar aceptar y cerrar alerta
 * 12. Verificar si el texto en la pagina es el mismo que el introducido en la alerta
 */


@Test
public class Compendiumdev {
	public WebDriver driver;

	@Test(priority = 0, groups = "alertas")
	public void verificarBoton1() {
		WebElement boton1 = driver.findElement(By.cssSelector("input[id='alertexamples']"));
		boton1.click();
		Alert alerta1 = driver.switchTo().alert();
		System.out.println(alerta1.getText());
		alerta1.accept();
	}

	@Test(priority = 1, groups = "alertas")
	public void verificarBoton2() {
		WebElement boton2 = driver.findElement(By.cssSelector("input[id='confirmexample']"));
		boton2.click();
		WebDriverWait espera = new WebDriverWait(driver, 10); // Explicita bajo determinadas condiciones
		espera.until(ExpectedConditions.alertIsPresent());
		try {
			Alert alerta2 = driver.switchTo().alert();
			System.out.println(alerta2.getText());
			alerta2.dismiss();
			Assert.assertEquals(driver.findElement(By.cssSelector("p[id='confirmreturn']")).getText(), "false");
		} catch (TimeoutException toe) {
			System.out.println(toe.toString());
		}
	}

	@Test(priority = 2, groups = "alertas")
	public void verificarBoton3() {
		WebElement boton3 = driver.findElement(By.cssSelector("input[id='promptexample']"));
		boton3.click();
		WebDriverWait espera = new WebDriverWait(driver, 10); // Explicita bajo determinadas condiciones
		espera.until(ExpectedConditions.alertIsPresent());
		try {
			Alert alerta3 = driver.switchTo().alert();
			String nombre = "Atel";
			alerta3.sendKeys(nombre);
			alerta3.accept();
			Assert.assertEquals(driver.findElement(By.cssSelector("p[id='promptreturn']")).getText(), nombre);
		} catch (TimeoutException toe) {
			System.out.println(toe.toString());
		}
	}

	@BeforeMethod
	public void f() {
		System.out.println("----------Inicio Prueba----------");

	}

	@AfterMethod
	public void volverLandingPage() {
		System.out.println("----------Fin Prueba----------");
	}

	@BeforeTest
	public void inicio() {
		Util datos = new Util();
		datos.setUrlBase("http://compendiumdev.co.uk/selenium/testpages/alerts.html");
		driver = Util.setUpManual();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(datos.getUrlBase());
	}

	@AfterTest
	public void finalizar() {
		driver.quit();

	}

}
