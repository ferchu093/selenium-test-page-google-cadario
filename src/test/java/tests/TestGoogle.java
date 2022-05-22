package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TestGoogle {
	//VARIABLES
	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "./src/test/resources/webDriver/chromedriver.exe";
	private String URL = "https://www.google.com";
	
	@BeforeClass
	public static void setUpBeforeClass()
	{
		System.out.println("INICIO DE TESTS");
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	}
	@Before
	public void setUp()
	{
		//Abre el navegador
		driver = new ChromeDriver();
		driver.get(URL);
	}
	@Test
	public void testSourch()
	{
		String textSend = "TEST01";
		WebElement txtSourch = driver.findElement(By.name("q"));
		txtSourch.sendKeys(textSend);
		txtSourch.submit();
		//ESPERE UN MOMENTO HASTA QUE GOOGLE RESPONDA
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//VALIDAR TITULO ENVIADO
		String titulo = driver.getTitle();
		Assert.assertTrue("VALIDA EL TITULO", titulo.contains(textSend));
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterClass
	public static void tearDownAfterClass()
	{
		System.out.println("FINALIZARON LOS TESTS");
	}
	
	

}
