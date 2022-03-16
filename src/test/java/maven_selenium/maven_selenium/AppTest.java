package maven_selenium.maven_selenium;


import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class AppTest extends App {

@Test(priority = 1)
public void loginPageTest() {
	driver.manage().window().maximize();
	driver.get("http://localhost:81");
	driver.findElement(By.id("formBasicEmail")).sendKeys("admin"); 
	driver.findElement(By.id("formBasicPassword")).sendKeys("admin");
	driver.findElement(By.id("submitBtn")).click();
	String title = driver.findElement(By.id("homeHeading")).getText();
	String expectedString = "CNAP sample react CICD dashboard";
	System.out.println(title);
	//assertEquals(title, expectedString);
	assertSame(title, expectedString);
}

@Test(priority = 2)
public void addBuildServerTest() {
	driver.manage().window().maximize();
	driver.get("http://localhost:81/home");
	driver.findElement(By.id("buildServerIcon")).click();
	String buildServertitle = driver.findElement(By.id("buildServerHeading")).getText();
	System.out.println(buildServertitle);
	String expectedBuildServertitle = "CNAP Build Server";
	assertEquals(buildServertitle, expectedBuildServertitle);
}

@Test(priority = 3)
public void checkPipelinePage() {
	driver.manage().window().maximize();
	driver.get("http://localhost:81/home");
	driver.findElement(By.id("pipelineConfIcon")).click();
	String pipelineConf = driver.findElement(By.id("pipelineConfiguration")).getText();
	System.out.println(pipelineConf);
	String expectedPipelineConf = "CNAP Pipeline Configuration";
	assertEquals(pipelineConf, expectedPipelineConf);
}

@Test(priority = 4)
public void addPipelineTest() {
	driver.manage().window().maximize();
	driver.get("http://localhost:81/home");
	driver.findElement(By.id("pipelineConfIcon")).click();
	Select bServer = new Select(driver.findElement(By.id("buildServer")));
	bServer.selectByVisibleText("surendhar_server");
	//List<WebElement> scmURL = (List<WebElement>) driver.findElement(By.cssSelector("div[id='pipelineInput'] [style='display: none']"));
}

@Test(priority=5)
public void addDeployServerTest() {
	driver.manage().window().maximize();
	driver.get("http://localhost:81/home");
	driver.findElement(By.id("deployServerIcon")).click();
	Select pName = new Select(driver.findElement(By.id("pipelineName")));
	pName.selectByVisibleText("surendhar_pipeline");
	Select dType = new Select(driver.findElement(By.id("deploymentType")));
	dType.selectByVisibleText("Server Deployment");
	driver.quit();
}

@AfterMethod
public void testResult(ITestResult result) throws IOException {
	if(ITestResult.FAILURE == result.getStatus()) {
		System.out.println(result.getName() +" has got failed");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(".\\Screenshots\\"+result.getName()+".png"));
		System.out.println("Screenhost taken for "+result.getName());
		driver.quit();
	}
}

}