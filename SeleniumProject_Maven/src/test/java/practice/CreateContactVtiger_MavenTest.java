package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactVtiger_MavenTest {
	

	@Test
	public void contactTest() {
		WebDriver driver;
		String URL=System.getProperty("url");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		String BROWSER=System.getProperty("browserToOpen");
		String FIRST_NAME=System.getProperty("first_name");
		String LAST_NAME=System.getProperty("last_name");
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
			driver.get(URL);
		}else {
			driver=new FirefoxDriver();
			driver.get(URL);
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FIRST_NAME,Keys.TAB,Keys.TAB,LAST_NAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		
		driver.close();
		
}
	

}
