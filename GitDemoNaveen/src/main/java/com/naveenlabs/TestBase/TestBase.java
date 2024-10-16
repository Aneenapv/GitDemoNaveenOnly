package com.naveenlabs.TestBase;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.naveenlabs.Listeners.WebDriverEvents;
import com.naveenlabs.RandomPackage.RandomGenerator;
import com.naveenlabs.browsersEnum.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends RandomGenerator{
	
   public static WebDriver driver;
   
  // public final String browser = "Chrome";
   public final Browsers Default_Browser = Browsers.CHROME;
   public final String URL ="https://naveenautomationlabs.com/opencart/index.php?route=account/login";
   public static Logger logger;
   private WebDriverEvents events;
   private EventFiringWebDriver eDriver;
   
   
   @BeforeClass
   public void setUpLogger()
	{
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}
   
   
   
   public void initialise()
   {
	   initialiseWebDriver();
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.get(URL);
      }
   
   

private void initialiseWebDriver() {
	//switch (browser) 
	switch(Default_Browser)
	   {
	   case CHROME: 
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   break;
		   
	   case FIREFOX: 
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
		   break;  
		   
	   case EDGE: 
		   WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
		   break;
		   
	default:
		throw new IllegalArgumentException("Unexpected browser name ");
	           }
	
	eDriver = new EventFiringWebDriver(driver);
	events = new WebDriverEvents();
	eDriver.register(events);
	driver=eDriver;
	
}



   public void selectDropDownCommonMethod(WebElement element, String text, String value)
   {
	   Select select = new Select(element);
	   try
	   {
	   select.selectByVisibleText(text);
	   }
	   catch(Exception e)
	   {
		  select.selectByValue(value); 
	   }
   }

   



   
   public void tearDown()
   {
	   driver.quit();
   }

}
