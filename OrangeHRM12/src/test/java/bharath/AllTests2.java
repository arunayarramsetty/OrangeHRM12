package bharath;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AllTests2 {

	@BeforeSuite
	public void Test1() throws Exception {
		
		System.out.println("10");
	}
	

	@BeforeTest
	public void Test3() throws Exception {
		System.out.println("11");
	}
	
	@BeforeClass
	public void Test2() throws Exception {
		
		System.out.println("12");
	}
	
  @Test
  public void Test4() throws Exception {
		System.out.println("13");
	}
 

 
  @AfterClass
  public void Test6() throws Exception {
		System.out.println("14");
  }
  @AfterTest
	public void Test5() throws Exception {
		System.out.println("15");
	}
	
	
	@AfterSuite
	public void Test7() throws Exception {
		
		System.out.println("16");
	}
		
	
	@BeforeMethod
	public void Test8() throws Exception {
		System.out.println("66");
	}
	
	@AfterMethod
	public void Test9() throws Exception {
		
		System.out.println("100");
	}
	
	
}                                                  

