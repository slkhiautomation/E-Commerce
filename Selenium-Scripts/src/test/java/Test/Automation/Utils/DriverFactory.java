package Test.Automation.Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import javax.swing.text.html.StyleSheet;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static Test.Automation.Utils.DataPool.readExcelData;

public class DriverFactory {

	private static final String remoteHub = new PropertyReader().readProperty("remoteHub");
	protected static WebDriver driver;
	protected static String webIndicator;
//	protected static Connection conn;
//	public static String JDBC_URL = "jdbc:sqlserver://192.168.222.70:1433;databaseName=H_F_Water;integratedSecurity=false";


	public DriverFactory(){
		initialize();
		//initializeSQL();
		initializeLogging();
	}

	public void initialize()  {
		if (driver == null)
			if(new PropertyReader().readProperty("runAt").equals("local"))
			{
				createNewLocalDriverInstance();
				
			}
			else if(new PropertyReader().readProperty("runAt").equals("remote"))
			{
				createNewRemoteDriverInstance();
				
			}
	}

//	private  void initializeSQL(){
//		try{
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn = DriverManager.getConnection(JDBC_URL,"amad","amad@123");
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//	}

	private void createNewLocalDriverInstance()   {
		String browser = new PropertyReader().readProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
 
			//System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver\\chromedriver.exe");
			
			
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--incognito");

			String browserExePath = new PropertyReader().readProperty("browserExePath");
			String driverExePath = new PropertyReader().readProperty("driverExePath");
			
			options.setBinary(browserExePath); 
			System.setProperty("webdriver.chrome.driver", driverExePath); 
			driver = new ChromeDriver(options);
		}  else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
            driver =  new FirefoxDriver();
            /*DesiredCapabilities dc = DesiredCapabilities.firefox();
            dc.setCapability("marionette", true);
            driver =  new FirefoxDriver(dc);*/

		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("requireWindowFocus", true);*/
			driver = new InternetExplorerDriver();
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}


	private void createNewRemoteDriverInstance()  {
		String browser = new PropertyReader().readProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();

			try {
				driver = new RemoteWebDriver(
						new URL(remoteHub), capabilities);
				((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} /*else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("requireWindowFocus", true);
            driver = new InternetExplorerDriver();
        } */else {
        	throw new IllegalArgumentException("The Browser Type is Undefined");
        }
	}

	public String getReportConfigPath(){
		String report = new PropertyReader().readProperty("reportConfigPath");
		if(report != null) return report;
		else throw new RuntimeException("Extent Report Path is not specified in the Config.properties file");
	}

	private void initializeLogging() {
		driver = new EventFiringWebDriver(driver).register(new WebDriverListeners());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		driver.quit();
		driver = null;
	}
}
