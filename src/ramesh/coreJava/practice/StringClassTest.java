package ramesh.coreJava.practice;

public class StringClassTest {
	public static void main(String args[]) {

		String s = "Sachin"; // String s = new String("Sachin");
		System.out.println(s.toUpperCase());// SACHIN
		System.out.println(s.toLowerCase());// sachin
		System.out.println(s);// Sachin(no change in original)

		
		s="  Sachin  ";  
		System.out.println(s);//  Sachin    
		System.out.println("Trimmed: " + s.trim());//Sachin  
		
		
		
		 s="Kachin";  
		 System.out.println(s.startsWith("Sa"));//true  
		 System.out.println(s.endsWith("n"));//true  
		 
		 System.out.println(s.charAt(0));//S  
		 System.out.println(s.charAt(3));//h  
		   
		 System.out.println(s.length());//6  
		 
		 
		 int a=10;  
		 s=String.valueOf(a);  
		 System.out.println(s+10);  
		 
		 
		 String s1="Java is a programming language. Java is a platform. Java is an Island.";    
		 String replaceString=s1.replace("Java","Kava");//replaces all occurrences of "Java" to "Kava"    
		 System.out.println(replaceString);    
		 
		 
		 String SubString1 = s1.substring(10);
		 System.out.println("Sub String1: "+ SubString1);  
		 
		 String SubString2 = s1.substring(10, 22);
		 System.out.println("Sub String2: "+ SubString2);  
		 
	}
}