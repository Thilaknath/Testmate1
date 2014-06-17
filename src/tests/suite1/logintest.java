package tests.suite1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tests.testbase;
import util.TestUtil;



@RunWith(Parameterized.class)
public class logintest extends testbase {

	//For Parameterization
	//step 1: Global variable declaration
	public String email;
	public String password;
	public String posdata;
	
	
	
	public logintest(String email, String password, String posdata){
		this.email = email;
		this.password = password;
		this.posdata = posdata;
	}

	@Before
	public void beforetest() throws IOException {
		initialize();
	}

	@Test
	public void logintest1() throws InterruptedException {
		// Calling Website
		driver.get(CONFIG.getProperty("testSiteName"));
		// Loggin in
		TestUtil.dologin(email, password);
		if (isloggedin & posdata.equals("Y")) {
			// report error
			System.out.println(" login with good credentials");
			
		}else if (isloggedin & posdata.equals("N")){
			//report error login with wrong user name
			System.out.println("Loggin in with wrong user name and password");
		}
		
		TestUtil.logout();
	}

	
	@Parameters
	public static Collection<Object[]> datagenerator(){
		
		//
		
		
		Object[][] data = new Object[1][3];
			
		//1st set of data
		data[0][0]="thilaknath@rocketmail.com";
		data[0][1]="qwerty";
		data[0][2]="Y";
		
		return Arrays.asList(data);
	}
}
