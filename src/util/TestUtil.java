package util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import tests.testbase;

public class TestUtil extends testbase {

	// static Xls_Reader dataloader = new
	// Xls_Reader("C:\\Users\\Thilaknath\\workspace1\\JunitDataDriven\\src\\config\\Suite1.xlsx");

	public static void dologin(String username, String password)
			throws InterruptedException {
		if (isloggedin) {
			return;
		}
		// driver.get("http://www.mate1.com/ajax/login?iframe");
		getObject("usernamefield").sendKeys(username);
		getObject("passwordfield").sendKeys(password);
		getObject("login").click();

		// Whether login successfully
		Thread.sleep(5000L);
		try {
			// Getobject is not used since it will also report an error; to
			// avoid that we are searching by xpath
			String Title1 = driver.getTitle();
			assertEquals(Title1, "Mate1.com - Find Someone Today");
			String userdisplay = driver.findElement(
					By.xpath(OR.getProperty("username"))).getText();
			String user1 = "vampslayer";
			if (userdisplay.equals(user1)) {
				isloggedin = true;
			} else {
				isloggedin = false;
			}
		} catch (Throwable T) {
			isloggedin = false;
		}
	}

	public void takescreenshot(String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("F:\\sample1.jpg"));
	}

	public static void logout() {
		if (isloggedin) {
			getObject("signout").click();
		}
	}

	// Read from excel and say whether to perform test or not
	// True - Y
	// False - N
	/*
	 * public static Object[][] getdata(String testName) {
	 * 
	 * // return test data
	 * 
	 * //Read Data Table if(dataloader == null){ dataloader = new Xls_Reader(
	 * "C:\\Users\\Thilaknath\\workspace1\\JunitDataDriven\\src\\config\\Suite1.xlsx"
	 * ); }
	 * 
	 * 
	 * // Subtracting one row becasuse first row is column name int rows =
	 * dataloader.getRowCount(testName) - 1;
	 * 
	 * // To check whether there is test data inside the sheet if (rows <= 0) {
	 * Object[][] testData = new Object[1][0]; return testData; } rows =
	 * dataloader.getRowCount(testName); int cols =
	 * dataloader.getColumnCount(testName); System.out.println("Test Name --" +
	 * testName); System.out.println("Total Rows--" + rows);
	 * System.out.println("Total Cols--" + cols); Object data[][] = new
	 * Object[rows - 1][cols];
	 * 
	 * for (int rownum = 2; rownum <= rows; rownum++) { for (int colnum = 0;
	 * colnum < cols; colnum++) { data[rownum - 2][colnum] =
	 * dataloader.getCellData(testName, colnum, rownum); } }
	 * 
	 * return data; }
	 */

}