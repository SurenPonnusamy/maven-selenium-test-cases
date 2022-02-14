package maven_selenium.maven_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

/**
 * Hello world!
 *
 */
public class App 
{
	public static WebDriver driver;
	

	@BeforeClass
	public static void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\surendhar.ponnusamy\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
}
