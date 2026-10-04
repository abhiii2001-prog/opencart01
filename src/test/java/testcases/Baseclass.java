package testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	public static WebDriver driver ;
	public Logger logger;//log4j
	public Properties p;
	
	@BeforeClass(groups= {"sanity","regression"})
	@Parameters({"OS","Browser"})
	public void setup(String os,String Br) throws IOException {
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		
		
	
		logger=LogManager.getLogger(this.getClass()); 
		if(p.getProperty("execution_env").equals("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if(os.equals("Windows")) {
				cap.setPlatform(Platform.WIN10);
			}
			else if (os.equals("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else if (os.equals("Linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No Matching Os");
				return;
			}
			
			switch(Br) { 
			case "Chrome" : cap.setBrowserName("chrome");break;
			case "firefox" : cap.setBrowserName("firefox");break;

			case "edge" : cap.setBrowserName("MicrosoftEdge");break;
			default: System.out.println("no matching browser");return;
			
			}
			System.out.println("1. Creating Remote Driver...");
	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	System.out.println("2. Remote Driver Created Successfully");
		
	}
		if(p.getProperty("execution_env").equals("local")) {
		 switch(Br.toLowerCase()){
		    case "chrome": driver = new ChromeDriver(); break;
		    case "firefox": driver = new FirefoxDriver(); break;
		    case "edge": driver = new EdgeDriver(); break;
		    	
		    default: System.out.println("Invalid browser"); return;
		    
		    }
		
	
	
		}
	
		
	
		    driver.get(p.getProperty("Url"));
		   
		
		

		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
		

	

	
	
	@AfterClass(groups= {"sanity","regression"})
	public void tearDown() {
		driver.close();
	}
	
	public String randomString() {
		String GeneratedString = RandomStringUtils.secure().nextAlphabetic(3);
		return GeneratedString;
		
		}
	public String randomAlphaNumber() {
		String Alpha = RandomStringUtils.secure().nextAlphanumeric(8);
		return Alpha;
		
	}
	
	public String captureScreen(String tname) throws IOException {

	    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir")
	            + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}

}
