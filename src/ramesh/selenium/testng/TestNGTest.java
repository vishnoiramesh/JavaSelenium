package ramesh.selenium.testng;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGTest {

	@Test(groups={"sanity"})
	public void test1(){
		System.out.println("1");
	}

	@Test(groups={"regression"}, dependsOnGroups={"sanity"}, alwaysRun=true)
	public void test2(){
		System.out.println("2");
	}

	@Test(groups={"sanity"})
	public void test3(){
//		int a = 1/0;
		boolean result = 1 > -1;
		Assert.assertTrue(result, "Test failed due to unmatched condition......");
		System.out.println("3");
	}
	
	@Test(groups={"regression"}, dependsOnGroups={"sanity"}, alwaysRun=true)
	public void test4(){
		System.out.println("4");
	}
	
	@BeforeSuite
	public void setUp(){
		System.out.println("Inside setup");
	}
	
	@AfterSuite
	public void tearDown(){
		System.out.println("Inside teardown");
	}

}
