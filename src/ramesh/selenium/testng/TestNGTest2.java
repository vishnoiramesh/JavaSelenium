package ramesh.selenium.testng;

import org.testng.annotations.Test;

public class TestNGTest2 {

	@Test(groups={"sanity", "HighPriority"}, alwaysRun = true, priority = 1)
	public void test5(){
		System.out.println("5");
	}

	@Test(groups={"regression"}, dependsOnGroups={"sanity"})
	public void test6(){
		System.out.println("6");
	}

	@Test(groups={"sanity"})
	public void test7(){
		System.out.println("7");
	}
	
	@Test(groups={"regression"}, dependsOnGroups={"sanity"})
	public void test8(){
		System.out.println("8");
	}
}
