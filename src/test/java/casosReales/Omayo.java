package casosReales;

import clasesUtiles.Util;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class Omayo {

	WebDriver driver;

	/*
 * INICIO TEST CASE

* 0. Navegar hacia http://omayo.blogspot.com/ 0.1 Comprobar que el titulo de la pagina sea "omayo (QAFox.com)"
* 1 Validar que el texto (en cssSelector: div#delayedText) aparezca pasados 10 segundos
* 2 Validar que el texto (en cssSelector: div#deletesuccess) desaparezca a los 15 segundos 
* 3. Validar que todos los links internos esten funcionando 2. Validar que todos los links externos esten funcionando
* 4. Validar que en la barra de menus, al pasar el mouse cambien de color 4. Elegir las opciones "Volvo" y "Hyundai"
* 5. Elegir del menu desplegabla de abajo, la opcion "doc 4"
* 6. En la caja de ingreso de datos, donde dice "Selenium WebDriver", corroborar que este escrito ese texto inicialmente. Luego cambiarlo por otro y comprobar que quedo escrito
* 7. Comprobar que el boton "Enabled button" este activo
* 8. Comprobar que el boton "Disabled  button" este inactivo
* 9. Comprobar que la Text Box este inactiva
* 10.Comprobar que los 3 botones tengan respectivamente como texto legible "Submit", "Login" y "Register" 
* 11.Comprobar que la lista ordenada tenga 6* elementos 
* 12.Comprobar que la lista desordenada contenga un elemento "Pomegranate"
* 13.Hacer click en el boton "ClickAfterTextDissapears", comprobar que el texto de la alerta diga "Hello" y darle aceptar
* 14.Hacer click en el link "Open a popup window", navegar hacia la nueva ventana, copiar el segundo parrafo y cerrar la ventana
* 15.Hacer click en Upload File y cerrar la ventana 
* 16.Comprobar que el boton "My Button" se desactive pasados 3 segundos al clickear el boton "Try it" ubicado mas abajo
* 17.Hcaer doble click en el boton "Double click here", copiar el mensaje de la alerta y darle aceptar 
* 18.Comprobar que la casilla "Mr Option" se active pasados 10 segundos al clickear el boton "Check this" ubicado mas abajo. Hacer click en el cuando se active
* 19.Escribir tu nombre en la Text Area Field 
* 20.Comprobar que el texto "The cat was playing in the garden." por defecto este escrito en la Text Area Field Two
* 21.Sumar las edades de las 4 personas y mostrarlo por consola 
* 22.En el Iframe2, hacer click en el link Chapter4 y luego abaja a la izquierda pasar e mouse sobre el elemento "Mouse over this", copiar el mensaje de la alerta y cerrarlo
* 23.En la LoginSection, ingresar el usuario y contraseña, darle al boton "Cancel", comprobar que borre los datos ingresados anteriormente, volver a cargarlos y darle al boton "Login". Copiar el mensaje de la alerta y cerrarla 
* 24.En el cuadro de busqueda (cssSelector: input[name=q][title=search]) colocar la palabra "Feliz Año Nuevo" y comprobar si se encuentran resultados (cssSelector: div.status-msg-body)
* 25.Verificar que la url de la pagina haya cambiado a "http://omayo.blogspot.com/search?q=Feliz+A%C3%B1o+Nuevo"
* 26.Comprobar que el la opcion por defecto del Check Box sea "Orange"
* 27.Hacer click en el boton "GetPrompt", ingresar una palabra y darle aceptar
* 28.Hacer click en el boton "GetConfirmation" y darle cancelar
* 29.Comprobar que el boton Hidden Button este oculto
* 30.Seleccionar el vehiculo "Car" 31.Invertir la seleccion por defecto de las opciones multiples (quedarian seleccionadas Pen, Laptop y Bag)
* 32.Comprobar que luego de 3 segundos de apretar el boton "Dropdown", este disponible el link hacia Facebook, hacer click en el 

 * FIN TEST CASE
	 * 
	 * 
	 * 
	 */

	@BeforeTest
	public void accederPagina() {
		driver = Util.setUpManual();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void cerrarPagina() {
		driver.quit();
	}

	
	// la prioridad del Test esta dada por el numero de consigna anterior
	
	@Test(priority = 0)
	public void tituloPagina() {
		String tituloEsperado = "omayo (QAFox.com)";
		Assert.assertEquals(driver.getTitle(), tituloEsperado);
	}

	@Test(priority = 1, enabled = false)
	public void textoAparece() {
		WebDriverWait espera = new WebDriverWait(driver, 15);
		try {
			WebElement texto = espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#delayedText)")));
			Assert.assertTrue(texto.isDisplayed());
		} catch (TimeoutException toe) {
			System.err.println("El tiempo se excedio " + toe.getMessage());
		} catch (NoSuchElementException error) {
			System.err.println("No se encontro el elemento " + error.getMessage());
		} catch (NoSuchFrameException error) {
			System.err.println("No se encontro el frame " + error.getMessage());
		} catch (NoAlertPresentException error) {
			System.err.println("Alerta no presente " + error.getMessage());
		} catch (WebDriverException errorGeneral) {
			System.err.println("Falla General " + errorGeneral.getMessage());
		}
	}

	//Chequear que este bien
	@Test(priority = 2, enabled = true)
	public void textoDesaparece() {
		WebDriverWait espera = new WebDriverWait(driver, 20);
		try {
			WebElement texto = driver.findElement(By.cssSelector("div#deletesuccess)"));
			Assert.assertNull(texto.isDisplayed(), "Elemento aun visible");
			Assert.assertTrue(espera.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#deletesuccess)"))));
		} catch (TimeoutException toe) {
			System.err.println("El tiempo se excedio " + toe.getMessage());
		} catch (NoSuchElementException error) {
			System.err.println("No se encontro el elemento " + error.getMessage());
		} catch (NoSuchFrameException error) {
			System.err.println("No se encontro el frame " + error.getMessage());
		} catch (NoAlertPresentException error) {
			System.err.println("Alerta no presente " + error.getMessage());
		} catch (WebDriverException errorGeneral) {
			System.err.println("Falla General " + errorGeneral.getMessage());
		}
	}
	
	
	
	
	
	
	
	
}
