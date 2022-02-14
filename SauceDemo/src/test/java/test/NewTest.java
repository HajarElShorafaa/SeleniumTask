package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;  
import org.testng.annotations.Test;  
import org.testng.annotations.AfterClass; 


//test.NewTest
public class NewTest {

	WebDriver driver;

	@BeforeClass
	public void beforeclass() {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	  }

	  @AfterClass
	  public void afterclass() {  
			driver.quit();
	  }	
	  
  @Test
  public void f() throws InterruptedException {
	  
	  	//login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		//select the product
		driver.findElement(By.id("item_0_img_link")).click();
		//add product to cart
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		Thread.sleep(1000);
		
		//check the cart
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(1000);
		
		//checkout information
		driver.findElement(By.id("first-name")).sendKeys("HH");
		driver.findElement(By.id("last-name")).sendKeys("EE");
		driver.findElement(By.id("postal-code")).sendKeys("00");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("finish")).click();
		Thread.sleep(1000);

  }

}
