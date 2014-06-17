package tests.suite1;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import tests.testbase;

public class Regtest extends testbase {

	@Before
	public void beforetest() throws IOException {
		initialize();
	}

	@Test
	public void editformtest() throws InterruptedException {
		// driver.get(CONFIG.getProperty("testSiteName"));
		// Loggin in
		
		getObject("profileedit").click();
		new Select(driver.findElement(By.xpath("//*[@id='wantChildren']")))
				.selectByValue("2");// password
		new Select(driver.findElement(By.xpath("//*[@id='relationship']")))
				.selectByValue("8");
		new Select(driver.findElement(By.xpath("//*[@id='income']")))
				.selectByValue("5");
		new Select(driver.findElement(By.xpath("//*[@id='smoking']")))
				.selectByValue("3");
		getObject("submit");

	}
}
