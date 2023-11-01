package ramesh.selenium.testng.otherTestng.my.test;

import org.testng.annotations.Test;

public class OtherTest {
	@Test(groups={"Previous"}, priority= 1)
	public void previousMethod(){
		System.out.println("Inside another package, First method (Test case)");
	}


	@Test(groups={"Mid"}, dependsOnGroups={"Previous"}, priority= 2)
	public void otherMethod(){
		System.out.println("Inside another package, Second method (Test case)");
	}
	
	@Test(groups={"Last"}, dependsOnMethods={"previousMethod","otherMethod"})
	public void LastMethod(){
		System.out.println("Inside another package, Last method (Test case)");
	}


}
