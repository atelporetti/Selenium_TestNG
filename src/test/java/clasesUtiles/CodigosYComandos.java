package clasesUtiles;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.edge.EdgeDriver;					// Edge
import org.openqa.selenium.firefox.FirefoxDriver;			// Firefox
import org.openqa.selenium.chrome.ChromeDriver;				// Chrome

import java.util.*;
import java.util.concurrent.*; 								// Para Hacer Esperas Implicitas
import org.openqa.selenium.support.ui.ExpectedConditions;	// Esperas Explicitas
import org.openqa.selenium.support.ui.WebDriverWait;		// Esperas Explicitas
import org.testng.annotations.Listeners;

public class CodigosYComandos {

	public static void main(String[] args) throws InterruptedException {
        
	    // GET ELEMENT BY ...
	    
	    /*
	By.className		finds elements based on the value of the "class" attribute	findElement(By.className("someClassName"))
	By.cssSelector		finds elements based on the driver's underlying CSS Selector engine	findElement(By.cssSelector("input#email"))
	By.id				ocates elements by the value of their "id" attribute		findElement(By.id("someId"))  
	By.linkText			finds a link element by the exact text it displays			findElement(By.linkText("REGISTRATION"))  
	By.name				locates elements by the value of the "name" attribute		findElement(By.name("someName"))  
	By.partialLinkText	locates elements that contain the given link text			findElement(By.partialLinkText("REG"))  
	By.tagName			locates elements by their tag name							findElement(By.tagName("div"))  
	By.xpath			locates elements via XPath									findElement(By.xpath("//html/body/div/table/tbody/tr/td[2]/table/ tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/ form/table/tbody/tr[5]"))

		// Para ni tener que escribir siempre el findElement se creo un objeto de este elemento
		//WebElement miElemento = driver.findElement(By.id("username"));
		//miElemento.sendKeys("tutorial");
	    */      

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
	 // GET COMMANDS ...
	    
	 /* 
	get()			abre una nueva ventana(la url como argumento
	getTitle()		S/A sin argumentos
	getPageSource()	S/A, devuelve el codigo HTML de la pagina
	getCurrentUrl()	S/A
	getText()		retorna el inner text del elemento especificado
	*/

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			    
	// NAVEGAR COMMANDS. Mantienen el historial de navegacion. El get() no
	    
	/*
	navigate().to()			igual al get() con URL como argumento
	navigate().refresh()	S/A
	navigate().back()		S/A
	navigate().forward()	S/A
	switchTo().frame()		para enfocarse en el marco o la ventana antes de acceder a sus elementos
	switchTo().alert()		acceder a elementos dentro de la alerta
	close()					cierra la ventana actual que el navegador esta controlando
	quit()					cierra todas las ventanas
	*/
	    
	    /*
	    driver.get("https://web.archive.org/web/20160119054809/http://selenium.googlecode.com/svn/trunk/docs/api/java/overview-summary.html");
	    driver.navigate().refresh();
	    //driver.findElement(By.linkText("Deprecated")).click();
	    driver.close(); 
	    
	    
	    driver.get("http://jsbin.com/usidix/1");
	    driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
	    String alertMessage = driver.switchTo().alert().getText();
	    driver.switchTo().alert().accept();
	   
	    System.out.println(alertMessage);
	    driver.quit();
	    */

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
		// ESPERAS COMMANDS
	    
	/*
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		//Implicita. Dentro del programa

	WebDriverWait espera = new WebDriverWait(driver, 10);					//Explicita bajo determinadas condiciones
	WebElement elemento = espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));	

	try{
			espera
	    }
		catch(TimeoutException toe){
		            System.out.println(toe.toString());
		}

	 */
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// CONDICIONES ESPERADAS
		
		/*
		alertIsPresent()					espera hasta que una alerta aparezca
		elementToBeClickable()				espera hasta que un elemento sea visible y este activado
		elementToBeSelected()				espera hasta verificar si un elemento este seleccionado
		invisivilityOfElementLocatedBy()	espera hasta que un elemento sea invisible o no presente en el DOM
		jsReturnValue()						espera por una cadena de caracteres de JavaScript
		frameToBeAvailableAndSwitchToIt()	espera hasta que el Frame este disponible y cambia hacia alli	
		*/

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// INTERACTIONS COMMANDS
	//	Select nombreVariable = new Select(WebElement);
	//	nombreVariable.  --->

	/*
		INPUT					sendKeys()	
								clear()
		CHECK BOX, RADIO BOTTOM	click()
		LINKS					click()
		DROP DOWN BOX			selectsByVisibleText()
								selectsByValue()
								selectsByIndex()
								isMultiple()
								deselectsAll()
		SUBMIT					submit()

	 */
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// MOUSE COMMANDS
	
	/*
	clickAndHold()						click sin soltar
	clickAndHold(onElement)				click sin soltar sobre un WebElement
	contextClick()						click derecho (contextual) en la ubicacion actual del mouse
	contextClick(onElement)				click derecho (contextual) en la ubicacion actual del mouse sobre un WebElement
	doubleClick()						doble click
	contextClick(onElement)				doble click sobre un WebElement
	release()							libera el boton izquierdo en la posicion actual del mouse	release()					libera el boton izquierdo en la posicion actual del mouse
	release(onElement)					libera el boton izquierdo en la posicion actual del mouse sobre un WebElement
	dragAndDrop(source, target)			click, retiene y suelta en otra ubicacion. WebElement son source y target
	moveToElement(toElement)			moueve el raton hacia el centro del elemento
	moveByOffset(x-offset, y-offset)	parametros en int. Valor negativo va hacia la izquierda y arriba	
	
	
	*/
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// TECLADO COMMANDS
	
	/*
	keyDown(modifier_key)					presionar una tecla. Las posteriores suponen que continua presionada. Keys.ALT, Keys.CNTRL, Keys.SHIFT
	keyDown(onElement, modifier_key)		presionar tecla. Parametro WebElement y Keys.ALT, Keys.CNTRL, Keys.SHIFT
	keyUp(modifier_key)						libera una tecla. Las posteriores suponen que continua presionada
	keyUp(onElement, modifier_key)			libera una tecla. Las posteriores suponen que continua presionada
	sendKeys(charsequence)					Envia una serie de pulsaciones. El valor de la cadena son las pulsaciones
	sendKeys(charsequence, modifier_key)	Envia una serie de pulsaciones. El valor de la cadena son las pulsaciones
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
		// CONDICIONES COMMANDS
	    
	/*
	isEnabled()				saber si un elemento esta Activado antes de ejecutar un comando
	isDisplayed()			saber si un elemento esta Visible antes de ejecutar un comando
	isSelected()			saber si un "check box, radio button, or option in a drop-down box" esta seleccionado

	 Asume que los elementos ya estan disponibles. Hay que hacer un Try-Catch
		try{
			if(txtbox_username.isEnabled()){
	            txtbox_username.sendKeys("tutorial");
	        }
	    }
		catch(NoSuchElementException nsee){
		            System.out.println(nsee.toString());
		}
		


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//	 		LOCATOR COMMANDS
//			WebElement elementName = driver.findElement(By.LocatorStrategy("LocatorValue"));
		
//			Xpath=//tagname[@attribute='value']
//				Xpath=//label[starts-with(@attribute,'value')]		and | or
//				Xpath=//label[contains(@attribute,'value')]			and | or		Ej: label[contains(text(),'value')]	
//				Xpath=//label[text()='value']										si en el texto esta el contenido. Se puede usar text() dentro del contains
//				Xpath=//*[@attribute='value']//following::tagname[indice]			para seleccionar todos los elementos del tipo dentro del nodo
//				Xpath=//*[@attribute='value']//ancestor::tagname[indice]			para seleccionar todos los elementos del tipo, dentro de los ancestros del nodo del elemento seleccionado
//				Xpath=//*[@attribute='value']//child::tagname[indice]				para seleccionar todos los elementos del tipo, dentro de los hijos del nodo del elemento seleccionado
//				Xpath=//*[@attribute='value']//preceding::tagname[indice]			para seleccionar todos los elementos del tipo, antes del nodo del elemento seleccionado
//				Xpath=//*[@attribute='value']//following-sibling::tagname[indice]	para seleccionar todos los elementos del tipo, hermanos del nodo del elemento seleccionado
//				Xpath=//*[@attribute='value']//parent::tagname[indice]				para seleccionar todos los elementos del tipo, del padre del nodo del elemento seleccionado
//				Xpath=//*[@attribute='value']//self::tagname						para seleccionar todos los elementos del tipo, dentro del nodo del elemento seleccionado
//				Xpath=//*[@attribute='value']//descendant::tagname[indice]			para seleccionar todos los elementos del tipo, descendientes del nodo del elemento seleccionado
		
//			CSS Selector = tag#
			//	CSS Selector ID = tagname#nombreDelId
			//	CSS Selector Class = tagname.nombreDelId
			//	CSS Selector Atributo = tagname[atributo='valor']										
			//	CSS Selector ID & Atributo = tagname#nombreDelId[atributo='valor']					
			//	CSS Selector Class & Atributo = tagname.nombreDelId[atributo='valor']					
			//	CSS Selector SubString = tagname[atributo^'valor']	// tagname[atributo$'valor']	
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
//	 		ALERT COMMANDS

//			driver.switchTo().alert().dismiss();		para  'Cancel'
//			driver.switchTo().alert().accept();			para  'Ok'
//			driver.switchTo().alert().getText();		para  capturar texto del mensaje
//			driver.switchTo().alert().sendKeys("Text");	para  escribir en la Prompt Alert

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////					
//	 		WINDOWS COMMANDS

//			driver.getWindowHandles();		para muchas paginas
//			driver.getWindowHandle();		para identificar una pagina
		
		
		/*
	Method						Target Syntax										Example				

	By ID						id= id_of_the_element								id=email
	By Name						name=name_of_the_element							name=userName
	By Name Using Filters		name=name_of_the_element filter=value_of_filter		name=tripType value=oneway
	By Link Text				link=link_text										link=REGISTER
	Tag and ID					css=tag#id											css=input#email
	Tag and Class				css=tag.class										css=input.inputtext
	Tag and Attribute			css=tag[attribute=value]							css=input[name=lastName]
	Tag, Class, and Attribute	css=tag.class[attribute=value]						css=input.inputtext[tabindex=1]

	*/


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//			TEST-NG COMMANDS

//		@Test(priority = X)								"0" es el mas importante. Primero: Test sin prioridad + orden Alfabetico. Segundo: Test con prioridad + orden alfabetico. Para  ejecutar  las pruebas en un orden especifico y no en el alfabetico del nombre de cada una
//		@Test(priority = X, alwaysRun = true/false, enabled = true/false, groups = "nombre" o {"n1", "n2", ...}, dataProvider = "nombre", dataProviderClass = "nombreDelDataProvider", dependsOnMethods = "nombreDelMetodo")		
//		@BeforeTest										para ejecutarse antes del primer caso de prueba
//		@AfterTest										para ejecutarse despues del ultimo caso de prueba
//		@BeforeMethod									para ejecutarse antes de cada Test
//		@AfterMethod									para ejecutarse despues de cada Test
//		@BeforeSuite									para ejecutarse antes de todas os Test de cada conjunto de pruebas
//		@AfterSuite										para ejecutarse despues de todas os Test de cada conjunto de pruebas
//		@BeforeClass									anota los metodos que se ejecutaran antes del primer metodo de la prueba actual
//		@AfterClass										anota los metodos que se ejecutaran despues del ultimo metodo de la prueba actual
//		@BeforeGroups									anota los metodos que se ejecutaran antes de ejecutar el primer metodo de los grupos especificados
//		@AfterGroups									anota los metodos que se ejecutaran despues de ejecutar el ultimo metodo de los grupos especificados
//		@Test (groups = { "bonding", "strong_ties" })	para ejecutarse despues de cada Test
//		@DataProvider (name = "")						marca un metodo como proveedor de datos para un metodo de prueba. Utilizar Method para que provea distintos tipos de datos segun el metodo (test) que se ejecute. ITestContext para que 
//		@Factory										metodo que se utiliza como fabrica de objetos que seran utilizados por TestNG como claes de prueba
//		@Listeners										Define Listeners para usarlos en reporteo
//		@Parameters										pasar parametros a metodos @Test, esto para crossBrowserTesting
		
		/*
DESCRIPCION		PRE-CONDICIONES		PASOS											RESULTADO ESPERADO		POST-CONDICIONES
@Test			@BeforeTest			@BeforeMethod (p/c paso que sea comun)									@AfterMethod
		*/

		

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//			INTERFACES LISTENERS. Paa modificar el comportamiento de TestNG
//			@Listeners(NombreDeLaClase.class)
		
//		ISuite	
//		IMethodInterceptor										
//		IConfiguration										
//		IHookable			
//		IEx	ecutionListener			
//		IAnnotationTransformer			
//		IinvokedMethod			
//		IReporter			
//		ITest			
		

		
		
		
		
		
    }	
		
	
	//driver.findElement(By.name("login")).click(); // el elemento a clickear debe ser visible (no debe tener altura y ancho == 0) 
		
	/*
		String url = "https://eficiencia.netlify.app/";
		String xpaths = "//img";
		String xpath = "//a[@href='registro.html']";
		
		driver.get(url);
        
		List<WebElement> elements = driver.findElements(By.xpath(xpaths));
		System.out.println("Number of elements:" +elements.size());
        for (WebElement element : elements){
        	System.out.println(element.getAttribute("alt"));
        }

        WebElement navegacion = driver.findElement(By.xpath(xpath));
        if (navegacion != null) {
        	System.out.println("Elemento encontrado");
        }
        navegacion.click();
        xpath = "//input[@id='Nombre']";
        WebElement input = driver.findElement(By.xpath(xpath));
        input.sendKeys("Atel");
        xpath = "//input[@id='Apellido']";
        input = driver.findElement(By.xpath(xpath));
        input.sendKeys("Poretti");
        xpath = "//select/optgroup[2]/option[2]";
        input = driver.findElement(By.xpath(xpath));
        input.click();
        input.clear();
	 */
	
	/*
        String url = "http://demo.guru99.com/test/newtours/register.php";
        driver.get(url);
        String xpath = "//option";

        List<WebElement> elements = driver.findElements(By.xpath(xpath));
		System.out.println("Number of elements:" +elements.size());
        for (WebElement element : elements){
        	System.out.println(element.getAttribute("value"));
        }
        for (WebElement element : elements){
        	if (element.getAttribute("value").equalsIgnoreCase("ARGENTINA")) {
        	element.click();
        	}
        }
        System.out.println(elements.size());
        
        Select paises = new Select(driver.findElement(By.name("country")));
        paises.selectByVisibleText("ARGENTINA");
	 */
	
	/*
		String url = "http://demo.guru99.com/test/newtours/";
        driver.get(url);
        String xpath = "//option";
		Actions desplazarMouse = new Actions(driver);
		WebElement link_Home = driver.findElement(By.linkText("Home"));
		Action mouseHover = desplazarMouse
				.moveToElement(link_Home)
                .build();
		mouseHover.perform();
		
		link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver
                .findElement(By
                .xpath("//html/body/div"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr"));    
         
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(link_Home)
                .build();
         
        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);        
        mouseOverHome.perform();        
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);
	 */
	/*
		String url = "http://demo.guru99.com/test/yahoo.html";
        driver.get(url);
        WebElement descarga = driver.findElement(By.id("messenger-download"));
		String linkDescarga = descarga.getAttribute("href");
		String wget_command = "cmd /c wget -P c: " + linkDescarga;
		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exit = exec.waitFor();
			System.out.println("Valor de salida: " + exit);
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	 */
	/*
		String url = "http://demo.guru99.com/popup.php";
        driver.get(url);
        String xpath = "//a[text()='Click Here']";
        driver.findElement(By.xpath(xpath)).click();
        
        String ventanaInicio = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();		
        Iterator<String> i1 = s1.iterator();
                
        while(i1.hasNext()){
        	String ventanaHija = i1.next();
        	if (!ventanaInicio.equalsIgnoreCase(ventanaHija)){
        		driver.switchTo().window(ventanaHija);
        		xpath = "//input[@name='emailid']";
        		driver.findElement(By.xpath(xpath)).sendKeys("axelturis@gmail.com");
        		
        		xpath = "//input[@name='btnLogin']";
        		driver.findElement(By.xpath(xpath)).click();
        		//
        		xpath = "//*[text()='User ID :']//following-sibling::td";
        		String userID = driver.findElement(By.xpath(xpath)).getText();
        		System.out.println(userID);
        		xpath = "//*[text()='Password :']//following-sibling::td";
        		String pass = driver.findElement(By.xpath(xpath)).getText();
        		System.out.println(pass);
        		//
        		//driver.close();	
        	}
        	driver.switchTo().window(ventanaInicio);
        }
	 */
	/*
		String url = "http://demo.guru99.com/test/web-table-element.php";
        driver.get(url);
        //No.of Columns
        List col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size()); 
        //No.of rows 
        List rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
        
        String numMaxS;
        double numMax = 0;
        double num = 0;
        for (int i=1; i<rows.size(); i++) {
        	numMaxS = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[3]")).getText();
        	numMax = Double.parseDouble(numMaxS);
        	if (numMax> num){
        		num = numMax;
        	}
        }
        System.out.println("El numero mas grande es :" + numMax);
        driver.close();
	 */
	/*
		Util datos = new Util();
		datos.setUrlBase("http://demo.guru99.com/test/tooltip.html");
		WebDriver driver = Util.setUpManual();
		
		driver.get(datos.getUrlBase());
		WebElement descarga = driver.findElement(By.xpath("//a[@id='download_now']"));
		
		Actions acciones = new Actions(driver);
		acciones.moveToElement(descarga).build().perform();
		
		WebElement linkDescarga = driver.findElement(By.xpath("//a[@href='/release-notes']"));
		String linkText = linkDescarga.getText();
		if (linkText.equalsIgnoreCase("What's new in 3.2")) {
			System.out.println("Test passed");
		}
		else System.out.println("Test NOT passed");
	 */
	
	/*
		String homePage = "https://eficiencia.netlify.app/";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
        WebDriver driver = Util.setUpManual();
        
        driver.get(homePage);
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        for (WebElement link : links){
            
            
        	url = link.getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
            	System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("GET");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } ///// FIN 
        
        driver.quit();
	 */
	
	/*
		WebDriver driver = Util.setUpManual();
		driver.get("http://live.guru99.com/index.php/checkout/cart");
		
		try {
			WebElement TV = driver.findElement(By.xpath("//a[contains(@href,'tv')]"));
			TV.click();
			WebElement addToCart = driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > button > span > span"));
			addToCart.click();
		}
		catch (NoSuchElementException error) {
			System.err.println("No se encontro el elemento " + error.getMessage());
		}
		catch (WebDriverException errorGeneral) {
			System.err.println("Falla General " + errorGeneral.getMessage());
		}
		finally {
			driver.close();
		}
	 */
	
	/*
	WebDriver driver = Util.setUpManual();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
	WebDriverWait espera = new WebDriverWait(driver, 15);
	
	try {
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#iframeResult")));
		//espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button")));
		WebElement btnTry =  driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		espera.until(ExpectedConditions.elementToBeClickable(btnTry));
		btnTry.click();
		espera.until(ExpectedConditions.alertIsPresent());
		Alert alerta = driver.switchTo().alert();
		System.out.println(alerta.getText());
		alerta.sendKeys("Atel");
		alerta.accept();
		//WebElement tryButton = driver.findElement(By.cssSelector("button"));
		//tryButton.click();
		//espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Hello Atel! How are you today?']")));
		String texto = driver.findElement(By.xpath("//p[text()='Hello Atel! How are you today?']")).getText();
		if (texto.contains("Hello Atel!")) {
			System.out.println("Prueba superada");
		}
	}
	catch (NoSuchElementException error) {
		System.err.println("No se encontro el elemento " + error.getMessage());
	}
	catch (NoSuchFrameException error) {
		System.err.println("No se encontro el frame " + error.getMessage());
	}
	catch (NoAlertPresentException error) {
		System.err.println("Alerta no presente " + error.getMessage());
	}
	
		catch (TimeoutException error) {
			System.err.println("El tiempo se excedio " + error.getMessage());
		}
	
	catch (WebDriverException errorGeneral) {
		System.err.println("Falla General " + errorGeneral.getMessage());
	}
	finally {
		driver.close();
	}
	*/
	
}
