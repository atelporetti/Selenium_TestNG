package casosReales;

import clasesUtiles.Util;

import static org.testng.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class Omayo {
	Util util = new Util();
	WebDriver driver;
	String expectedResult = "";
	String actualResult = "";

	/*
	 * INICIO TEST CASE
	 * 
	 * 0. Navegar hacia http://omayo.blogspot.com/ 0.1 Comprobar que el titulo de la
	 * pagina sea "omayo (QAFox.com)" 1 Validar que el texto (en cssSelector:
	 * div#delayedText) aparezca pasados 10 segundos 2 Validar que el texto (en
	 * cssSelector: div#deletesuccess) desaparezca a los 15 segundos 3. Validar que
	 * todos los links internos esten funcionando 4. Validar que todos los links
	 * externos esten funcionando 5. Validar que en la barra de menus, al pasar el
	 * mouse cambien de color 6. Elegir las opciones "Volvo" y "Hyundai" 7. Elegir
	 * del menu desplegabla de abajo, la opcion "doc 4" 8. En la caja de ingreso de
	 * datos, donde dice "Selenium WebDriver", corroborar que este escrito ese texto
	 * inicialmente. Luego cambiarlo por otro y comprobar que quedo escrito 9.
	 * Comprobar que el boton "Enabled button" este activo 10. Comprobar que el
	 * boton "Disabled  button" este inactivo 11. Comprobar que la Text Box este
	 * inactiva 12.Comprobar que los 3 botones tengan respectivamente como texto
	 * legible "Submit", "Login" y "Register" 13.Comprobar que la lista ordenada
	 * tenga 6* elementos 14.Comprobar que la lista desordenada contenga un elemento
	 * "Pomegranate" 15.Hacer click en el boton "ClickAfterTextDissapears",
	 * comprobar que el texto de la alerta diga "Hello" y darle aceptar 16.Hacer
	 * click en el link "Open a popup window", navegar hacia la nueva ventana,
	 * copiar el segundo parrafo y cerrar la ventana 17.Hacer click en Upload File y
	 * cerrar la ventana 18.Comprobar que el boton "My Button" se desactive pasados
	 * 3 segundos al clickear el boton "Try it" ubicado mas abajo 19.Hcaer doble
	 * click en el boton "Double click here", copiar el mensaje de la alerta y darle
	 * aceptar 20.Comprobar que la casilla "Mr Option" se active pasados 10 segundos
	 * al clickear el boton "Check this" ubicado mas abajo. Hacer click en el cuando
	 * se active 21.Escribir tu nombre en la Text Area Field 22.Comprobar que el
	 * texto "The cat was playing in the garden." por defecto este escrito en la
	 * Text Area Field Two 23.Sumar las edades de las 4 personas y mostrarlo por
	 * consola 24.En el Iframe2, hacer click en el link Chapter4 y luego abaja a la
	 * izquierda pasar e mouse sobre el elemento "Mouse over this", copiar el
	 * mensaje de la alerta y cerrarlo 25.En la LoginSection, ingresar el usuario y
	 * contrase�a, darle al boton "Cancel", comprobar que borre los datos ingresados
	 * anteriormente, volver a cargarlos y darle al boton "Login". Copiar el mensaje
	 * de la alerta y cerrarla 26.En el cuadro de busqueda (cssSelector:
	 * input[name=q][title=search]) colocar la palabra "Feliz A�o Nuevo" y comprobar
	 * si se encuentran resultados (cssSelector: div.status-msg-body) 27.Verificar
	 * que la url de la pagina haya cambiado a
	 * "http://omayo.blogspot.com/search?q=Feliz+A%C3%B1o+Nuevo" 28.Comprobar que el
	 * la opcion por defecto del Check Box sea "Orange" 29.Hacer click en el boton
	 * "GetPrompt", ingresar una palabra y darle aceptar 30.Hacer click en el boton
	 * "GetConfirmation" y darle cancelar 31.Comprobar que el boton Hidden Button
	 * este oculto 32.Seleccionar el vehiculo "Car" 31.Invertir la seleccion por
	 * defecto de las opciones multiples (quedarian seleccionadas Pen, Laptop y Bag)
	 * 33.Comprobar que luego de 3 segundos de apretar el boton "Dropdown", este
	 * disponible el link hacia Facebook, hacer click en el 4 FIN TEST CASE
	 * 
	 */

	@BeforeTest
	public void accederPagina() {
		util.setUrlBase("http://omayo.blogspot.com/");
		driver = Util.setUpEdgeChromium();
		driver.get(util.getUrlBase());
		// driver.manage().window().maximize();
	}

	@AfterTest
	public void cerrarPagina() {
		driver.quit();
	}

	@AfterMethod
	public void mensaje() {
		System.out.println("--------------Fin metodo--------------");
	}
	
	// la prioridad del Test sera igual al numero de consigna anterior
	@Test(priority = 0, enabled = false)
	public void tituloPagina() {
		String tituloEsperado = "omayo (QAFox.com)";
		Assert.assertEquals(driver.getTitle(), tituloEsperado);
	}

	@Test(priority = 1, enabled = false)
	public void textoAparece() {
		WebDriverWait espera = new WebDriverWait(driver, 15);
		try {
			WebElement texto = espera
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#delayedText)")));
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

	// Chequear que este bien
	@Test(priority = 2, enabled = false)
	public void textoDesaparece() {
		WebDriverWait espera = new WebDriverWait(driver, 20);
		try {
			WebElement texto = driver.findElement(By.cssSelector("div#deletesuccess)"));
			Assert.assertNull(texto.isDisplayed(), "Elemento aun visible");
			Assert.assertTrue(espera
					.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#deletesuccess)"))));
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

	@Test(priority = 3, enabled = true)
	public void linksExternos() {
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		for (WebElement link : links) {
			url = link.getAttribute("href");
			// Assert.assertTrue(url == null, "URL vacia");

			if (url == null) {
				System.out.println("URL vacia");
				continue;
			}

			// Link externo encontrado
			if (!url.contains("http://omayo.blogspot.com/")) {
				System.out.println(url);
				try {
					huc = (HttpURLConnection) (new URL(url).openConnection());

					huc.setRequestMethod("GET");

					huc.connect();

					respCode = huc.getResponseCode();

					Assert.assertFalse(respCode >= 400, "Link caido");
					Assert.assertTrue(respCode <= 400, "Link NO valido");

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	@Test(priority = 4, enabled = true)
	public void linksInternos() {
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		for (WebElement link : links) {
			url = link.getAttribute("href");
			System.out.println(url);
			// Assert.assertTrue(url == null, "URL vacia");

			if (url == null) {
				System.out.println("URL vacia");
				continue;
			}

			// Link interno encontrado
			if (url.contains("http://omayo.blogspot.com/")) {
				System.out.println(url);
				try {
					huc = (HttpURLConnection) (new URL(url).openConnection());

					huc.setRequestMethod("GET");

					huc.connect();

					respCode = huc.getResponseCode();

					Assert.assertFalse(respCode >= 400, "Link caido");
					Assert.assertTrue(respCode <= 400, "Link NO valido");

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test(priority = 2, enabled = false)
	public void envioMail() {
		Util.enviaAdjuntoEmailSSL("aaxelporetti@gmail.com", "*****", "aaxelporetti@gmail.com", "Prueba Asunto",
				"Prueba cuerpo mail", "\\src\\test\\java\\casosReales\\Compendiumdev.java");
	}
	
	//Darle prioridades  
    @Test()
    public void multiSelectBox1(){
        String css = "select[id='multiselect1']";
        String opcion = "Volvo";
        util.multiSelectedBox(opcion,css);
    }

    @Test()
    public void multiSelectBox2(){
        String css = "select[id='multiselect1']";
        String opcion = "Hyundai";
        util.multiSelectedBox(opcion,css);
    }

    @Test()
    public void multiSelectBox3() throws InterruptedException {
        String css = "select[name='SiteMap']";
        String opcion = "doc 4";
        util.multiSelectedBox(opcion,css);
    }
    
    /*En la caja de ingreso de datos, donde dice "Selenium WebDriver", corroborar que este escrito ese texto inicialmente. 
    Luego cambiarlo por otro y comprobar que quedo escrito
    */
    @Test()
    public void TextBox(){
        WebElement caja = driver.findElement(By.cssSelector("input[id='textbox1']"));
        actualResult = caja.getAttribute("value");
        expectedResult = "Selenium WebDriver";
        Assert.assertEquals(actualResult,expectedResult, "No es igual al resultado esperado");
        caja.clear();
        caja.sendKeys("JAVA");
        actualResult = caja.getAttribute("value");
        expectedResult = "JAVA";
        Assert.assertEquals(actualResult,expectedResult, "No es igual al resultado esperado");
    }
    
    //7.Comprobar que el boton "Enabled button" este activo
    @Test()
    public void buttonEnabled(){
    String css = "button[id='but2']";
    boolean expected = true;
    util.enabledDisabled(css, expected);
    }
   //8. Comprobar que el boton "Disabled  button" este inactivo
    @Test()
    public void buttonDisabled(){
        String css = "button[id='but1']";
        boolean expected = false;
        util.enabledDisabled(css, expected);
    }
    //9. Comprobar que la Text Box este inactiva
    @Test()
    public void textBox(){
        boolean result = driver.findElement(By.cssSelector("input[id='tb2']")).isEnabled();
        Assert.assertEquals(result,false,"No es igual al resultado esperado");
    }
    //10.Comprobar que los 3 botones tengan respectivamente como texto legible "Submit", "Login" y "Register"
    @Test()
    public void buttonSubmit(){
        String xpath = "//*[@id=\"HTML10\"]/div[1]/button[1]";
        expectedResult = "Submit";
        util.buttonName(actualResult,expectedResult,xpath);
    }

    @Test()
    public void buttonLogin(){
        String xpath = "//*[@id=\"HTML10\"]/div[1]/button[2]";
        expectedResult = "Login";
        util.buttonName(actualResult,expectedResult,xpath);
    }

    @Test()
    public void buttonRegister(){
        String xpath = "//*[@id=\"HTML10\"]/div[1]/button[3]";
        expectedResult = "Register";
        util.buttonName(actualResult,expectedResult,xpath);
    }
    
    //11.Comprobar que la lista ordenada tenga 6 elementos
    @Test()
    public void orderedList(){
     String xpath ="//*[@id=\"HTML25\"]/div[1]/ol";
     String identificador = "ordered";
     util.listOrdered(xpath,identificador);
    }

    //12.Comprobar que la lista desordenada contenga un elemento "Pomegranate"
    @Test()
    public void unOrderedList(){
        String xpath ="//*[@id=\"HTML26\"]/div[1]/ul";
        String identificador = "unordered";
        util.listOrdered(xpath,identificador);
    }
    
    

	
}
