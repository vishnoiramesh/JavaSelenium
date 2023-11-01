package ramesh.coreJava.practice;

public class IndirectObjectCreation {

//	PrivateConstructor myObject = new PrivateConstructor(100); Not allowed as construtor in that class was private.
	
	public static void main(String args[])
	{PrivateConstructor myObject = PrivateConstructor.returnObject();
}
}
