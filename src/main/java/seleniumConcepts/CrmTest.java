package seleniumConcepts;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CrmTest { 
WebDriver driver;
	
	@Before
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=login/"); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void loginTest() {
		
		//STORING WEB ELEMENT
		//ELEMENT LIBERARY
		
		//STORING WEB ELEMENT USING WEBELEMENT CLASS OR INTERFACE
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement USERPASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SINGIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		
		
		//Type name = value
		//int a = 5; 
		//driver.findElement(By.xpath("//input[@id='username']"));
		//Type name = value 
		
		
		//STRORING WEB ELEMENT USING BY CLASS
		By.xpath("//input[@id='username']");
		//Type name = value 
		By USERNAME_FIELD_LOCATOR = By.xpath("//input[@id='username']");
		By USERPASSWORD_FIELD_LOCATOR = By.xpath("//*[@id=\"password\"]");
		By SINGIN_BUTTON_LOCATOR = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_FIELD_LOCATOR =By.xpath("//h2[contains(text()),'Dashboard')]");
		
	//===============================================================	
	//	driver.findElement(USERPASSWORD_FIELD_LOCATOR).sendKeys("abc123");
	//	driver.findElement(SINGIN_BUTTON_LOCATOR).click();
	//===============================================================	
		
	
	
		
		//driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys("demo@techfios.com");
		USERPASSWORD_FIELD_ELEMENT.clear();
		USERPASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		USERNAME_FIELD_ELEMENT.clear();//for clear the box.if any data is there
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		SINGIN_BUTTON_ELEMENT.click();
		
		boolean pageTitleDisplayStatus;
		
		try {
			WebElement DASHBOARD_FIELD_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));	
		    pageTitleDisplayStatus = true;
		
		}catch(NoSuchElementException e) {
			
			 pageTitleDisplayStatus= false;
			// e.printStackTrace();
			
		}
		
		
		//using Explicit wait
		//WebDriverWait wait = new WebDriverWait(driver,3);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(DASHBOARD_FIELD_LOCATOR));
	
		//validation	
	  Assert.assertTrue("Dashboard page not found", pageTitleDisplayStatus);
	}
	
	@Test
	public void loginTest1() {
		
		
		
		//STORING WEB ELEMENT
		//ELEMENT LIBERARY
		
		//STORING WEB ELEMENT USING WEBELEMENT CLASS OR INTERFACE
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement USERPASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SINGIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		
		
		//Type name = value
		//int a = 5; 
		//driver.findElement(By.xpath("//input[@id='username']"));
		//Type name = value 
		
		
		//STRORING WEB ELEMENT USING BY CLASS
		By.xpath("//input[@id='username']");
		//Type name = value 
		By USERNAME_FIELD_LOCATOR = By.xpath("//input[@id='username']");
		By USERPASSWORD_FIELD_LOCATOR = By.xpath("//*[@id=\"password\"]");
		By SINGIN_BUTTON_LOCATOR = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_FIELD_LOCATOR =By.xpath("//h2[contains(text()),'Dashboard')]");
		
	//===============================================================	
	//	driver.findElement(USERPASSWORD_FIELD_LOCATOR).sendKeys("abc123");
	//	driver.findElement(SINGIN_BUTTON_LOCATOR).click();
	//===============================================================	
		
	
	
		
		//driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys("demo@techfios.com");
		
		USERNAME_FIELD_ELEMENT.clear();//for clear the box.if any data is there
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		USERPASSWORD_FIELD_ELEMENT.clear();
		USERPASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SINGIN_BUTTON_ELEMENT.click();
		
		boolean pageTitleDisplayStatus;
		try {
			WebElement DASHBOARD_FIELD_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]"));	
		    pageTitleDisplayStatus = true;
		
		}catch(NoSuchElementException e) {
			
			 pageTitleDisplayStatus= false;
			
		}
		
		
		//using Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(DASHBOARD_FIELD_LOCATOR));
	
		//validation	
	   Assert.assertTrue("Dashboard page not found", pageTitleDisplayStatus);
	}
	
	@After
	public void tearDown() {
		driver.close();//what ever we are iniciting over here.what ever object we are creating its closes over here.closes the process.
		//closes the object we are creating those close this.kills the process of the webdriver that one we created.its the kill the process.
		driver.quit();//closes the windows.closes the browser
		
	}
}
