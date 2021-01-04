package clasesUtiles;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//import com.itextpdf.text.log.SysoCounter;

import java.io.*;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//*************************************************************
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;	
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
	// DATOS
	private String urlBase = "";
	private String userName = "";
	private String password = "";
	
	// ENTORNO
	private String nombreNavegador = "EDGE";
	private String locationEdge = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
	private String versionEdge = "87.0.664.60";
	private String driverNavegador = "webdriver.edge.driver";
	private String ubicacionDriver = "C:\\msedgedriver.exe";
	private DesiredCapabilities entorno;
	private WebDriver driver;

	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public String getNombreNavegador() {
		return nombreNavegador;
	}
	public void setNombreNavegador(String navegador) {
		this.nombreNavegador = navegador;
	}
	
	public String getDriverNavegador() {
		return driverNavegador;
	}
	public void setDriverNavegador(String driverNavegador) {
		this.driverNavegador = driverNavegador;
	}
	
	public String getUbicacionDriver() {
		return ubicacionDriver;
	}
	public void setUbicacionDriver(String ubicacionDriver) {
		this.ubicacionDriver = ubicacionDriver;
	}
	
	public DesiredCapabilities getEntorno() {
		return entorno;
	}
	public void setEntorno(DesiredCapabilities entorno) {
		this.entorno = entorno;
	}
	
	public String getVersionEdge() {
		return versionEdge;
	}
	public void setVersionEdge(String versionEdge) {
		this.versionEdge = versionEdge;
	}

	private int tiempoEspera = 30;
	
	
	public int getTiempoEspera() {
		return tiempoEspera;
	}
	public void setTiempoEspera(int tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLocationEdge() {
		return locationEdge;
	}
	public void setLocationEdge(String locationEdge) {
		this.locationEdge = locationEdge;
	}
	
	public String getUrlBase() {
		return urlBase;
	}
	public void setUrlBase(String url) {
		this.urlBase = url;
	}
	
	public Util() {}
	
	public static WebDriver setUpEdgeChromium(){
			Util datos = new Util();
			DesiredCapabilities entorno = DesiredCapabilities.edge();
			entorno.setCapability(CapabilityType.BROWSER_NAME, datos.getNombreNavegador());
			System.setProperty(datos.getDriverNavegador(),datos.getUbicacionDriver());
			EdgeDriverService service = new EdgeDriverService.Builder().usingDriverExecutable(new File(datos.getUbicacionDriver())).usingAnyFreePort().build();
			EdgeOptions opciones = new EdgeOptions();
			//opciones.merge(entorno); MEJORAR LA UNION DE DESIRED CAPABILITIES CON EDGEOPTIONS
			EdgeDriver driver = new EdgeDriver(service, opciones);
			driver.manage().window().maximize();
		return driver;
	}
	
	public static void takeScreenShot(WebDriver driver, String archivoConUbic) throws IOException{
		TakesScreenshot capturaPant = (TakesScreenshot) driver;
		File archivo = capturaPant.getScreenshotAs(OutputType.FILE);
		File destino = new File(archivoConUbic);
		FileUtils.copyFile(archivo, destino);
		
	}
	

	public static void enviaEmail(String from, String password, String to, String subject, String cuerpoMail){
		Properties propiedades = System.getProperties();
		String host = "smtp.gmail.com";
		propiedades.put("mail.smtp.starttls.enable", "true");
		propiedades.put("mail.smtp.host", host);
		propiedades.put("mail.smtp.user", from);
		propiedades.put("mail.smtp.password", password);
		propiedades.put("mail.smtp.port", "587"); //25 | 465 | 587
		propiedades.put("mail.smtp.auth", "true");
		Session sesion = Session.getDefaultInstance(propiedades);
		MimeMessage mensaje = new MimeMessage(sesion);
		
		try {
			mensaje.setFrom(new InternetAddress(from));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mensaje.setSubject(subject);
			mensaje.setText(cuerpoMail);
			BodyPart objetoMensajeBP = new MimeBodyPart();
			objetoMensajeBP.setText(cuerpoMail);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(objetoMensajeBP);
			objetoMensajeBP = new MimeBodyPart();
			
			String nombreArchivo = System.getProperty("user.dir") + "\\SeleniumTestNG.pdf";
			DataSource origen = new FileDataSource(nombreArchivo);
			objetoMensajeBP.setDataHandler(new DataHandler(origen));
			objetoMensajeBP.setFileName(nombreArchivo);
			multipart.addBodyPart(objetoMensajeBP);
			
			mensaje.setContent(multipart);
			Transport transporte = sesion.getTransport("smtp");
			transporte.connect(host, from, to);
			transporte.sendMessage(mensaje, mensaje.getAllRecipients());
			transporte.close();
		}catch (AddressException e) {
			System.out.println("Problemas con la direccion de correo: " + e.getMessage());
		}catch (MessagingException e) {
			System.out.println("No se pudo conectar al host SMTP: " + e.getMessage());
		}
		
	}
	/*
	public static String[][] getInfoExcel(){
		String nombreArchivo = "testData.xlsx";
		String rutaArchivo = "D:\\Documentos\\MEGA\\PROGRAMACIÓN\\Cursos\\Selenium + Java\\Day03" + nombreArchivo;
		String hoja = "Data";
		String matrizDatos [][] = new String [4][2];
		
		int colInicio = 2, colFin = 3, filaInicio = 2, filaFin = 5;
		
		for (int i=colInicio; i<colFin; i++) {
			for (int j=filaInicio; j<filaFin; j++) {
				
			}
		}
		OPCPackage pkg = OPCPackage.open(new File(nombreArchivo));
		XSSFWorkbook excel = new XSSFWorkbook(pkg);
		XSSFSheet hojaExcel = excel.getSheet(hoja);
		XSSFRow row = hojaExcel.getRow(1);

		
		pkg.close();
		
		return matrizDatos[][];
		
	}
	*/
}