package tests.suite1;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import tests.testbase;

public class mate1tests extends testbase  {
	
	@Before
	public void beforetest() throws IOException {
		
		initialize();
		}
	
	
	@Test
	public void mate1test() throws InterruptedException{
		
		getObject("profileedit").click();
		getObject("title").clear();
		getObject("title").sendKeys("This is my Second Test");
		new Select(driver.findElement(By.xpath("//*[@id='profileLooking_gender']"))).selectByValue("3");
		new Select(driver.findElement(By.xpath("//*[@id='profileLooking_minAge']"))).selectByValue("21");
		new Select(driver.findElement(By.xpath("//*[@id='profileLooking_maxAge']"))).selectByValue("28");
		new Select(driver.findElement(By.xpath("//*[@id='month']"))).selectByValue("4");
		new Select(driver.findElement(By.xpath("//*[@id='daysOfMonth']"))).selectByValue("7");
		new Select(driver.findElement(By.xpath("//*[@id='year']"))).selectByValue("80");
		
		new Select(driver.findElement(By.xpath("//*[@id='country']"))).selectByValue("39");
		getObject("postalcode").clear();
		getObject("postalcode").sendKeys("H3H 2P1");
		new Select(driver.findElement(By.xpath("//*[@id='ethnicity']"))).selectByValue("4");
		new Select(driver.findElement(By.xpath("//*[@id='hairColor']"))).selectByValue("6");
		new Select(driver.findElement(By.xpath("//*[@id='year']"))).selectByValue("80");
		new Select(driver.findElement(By.xpath("//*[@id='bodyType']"))).selectByValue("5");
		
		new Select(driver.findElement(By.xpath("//*[@id='eyeColor']"))).selectByValue("4");
		
		new Select(driver.findElement(By.xpath("//*[@id='children']"))).selectByValue("5");
		new Select(driver.findElement(By.xpath("//*[@id='religion']"))).selectByValue("5");
		
		
		new Select(driver.findElement(By.xpath("//*[@id='educationField']"))).selectByValue("4");
		new Select(driver.findElement(By.xpath("//*[@id='occupation']"))).selectByValue("6");
		new Select(driver.findElement(By.xpath("//*[@id='education']"))).selectByValue("6");
		new Select(driver.findElement(By.xpath("//*[@id='smoking']"))).selectByValue("5");
		new Select(driver.findElement(By.xpath("//*[@id='alcohol']"))).selectByValue("4");
		
				
		
		new Select(driver.findElement(By.xpath("//*[@id='wantChildren']")))
			.selectByValue("2");// password
		new Select(driver.findElement(By.xpath("//*[@id='relationship']")))
			.selectByValue("8");
		new Select(driver.findElement(By.xpath("//*[@id='income']")))
			.selectByValue("5");
		new Select(driver.findElement(By.xpath("//*[@id='smoking']")))
			.selectByValue("3");
		
		getObject("aboutme").clear();
		getObject("aboutme").sendKeys("@");
		getObject("whatami").clear();
		getObject("whatami").sendKeys("www.google.com");
		
		getObject("submit").click();
		
		Thread.sleep(1000);
		
		String Title1 = driver.findElement(By.xpath("//*[@id='basic_information']/div[2]/div[1]")).getText();
		System.out.println(Title1);
		
		try {
			assertEquals(Title1, "This is my Second Test");
			System.out.println("Title Entered Correctly");
		}catch (Exception e){
			System.out.println("ERROR"+e.getMessage());
		}
		
			
		String Title3 = driver.findElement(By.xpath("//*[@id='basic_information']/ul/li[10]")).getText();
		System.out.println(Title3);
		try {
			assertEquals(Title3, "Brown");
			System.out.println("eye color Entered Correctly");
		}catch (Exception e){
			System.out.println("ERROR"+e.getMessage());
		}
				
		String Title4 = driver.findElement(By.xpath("//*[@id='about_myself']/p")).getText();
		System.out.println(Title4);
		
		getObject("signout").click();
				
			
	}
		
	}


	
		


