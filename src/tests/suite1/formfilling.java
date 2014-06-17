package tests.suite1;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import tests.testbase;

public class formfilling extends testbase{

	@Before
	public void beforetest() throws IOException {
		
		initialize();
		}
	
	@Test
	public void changepwd(){
		getObject("mysettings").click();
		getObject("pwsettings").click();
		getObject("pwfield").sendKeys("qwerty");
		getObject("newpwd").sendKeys("qwerty");
		getObject("cfmnewpwd").sendKeys("qwerty");
		getObject("save").click();
		String userdisplay = getObject("confirmation").getText();
		String cmp = "Your settings have been saved successfully.";
		if(userdisplay.equals(cmp)){
			System.out.println("Settings Saved Succesfully");
		}else{
			System.out.println("Failed To Save Data");
		}
		
		getObject("signout").click();
		
	}
	
}
