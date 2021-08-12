package Java_feb_005;

import org.testng.annotations.Test;

import Day_002_Java.TC05_Login_NonStatic_Paarameters;

public class Java_login_005 {
	
	
	
  @Test
  public void Login_Test() throws Exception
  {
	  {
		  Java_login_005 K11=new Java_login_005();
			
		  K11.OpenChromeBrowser();
		  K11.OpenOrangeHRM();
		  K11.Login(UserName,Password);
		  K11.AddNationalities(Nationality);
			
	
		
		}
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
