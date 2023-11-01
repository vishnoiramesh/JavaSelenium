package ramesh.coreJava.practice;

public class PrivateConstructor {
int a = 5;

private PrivateConstructor(int b){
	a = b;
}


static public  PrivateConstructor returnObject(){
	PrivateConstructor myObject = new PrivateConstructor(100);
	
	return myObject;
}

}
