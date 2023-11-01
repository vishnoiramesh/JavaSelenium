package ramesh.coreJava.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Collections;


public class CollectionTest {
   public static void main(String[] args) {
	   String name = "ramesh", country ;
	   if (name == "ramesh")
		{
			country = "India";
		} 
		
	   else if (name == "Swati")
			{
				country = "USA";
			}
			
			else
			{
				country ="Other Nation";
			}
	   int age = 20;
	   if (age ==18)
	   {
		   boolean adult = true;
	   }
      List lnkLst = new LinkedList();
      lnkLst.add("element1");
      lnkLst.add("Alement2");
      lnkLst.add("element9");
      lnkLst.add("element4");
      displayAll(lnkLst);
      List aryLst = new ArrayList();
      aryLst.add("x");
      aryLst.add("y");
      aryLst.add("z");
      aryLst.add("w");
      displayAll(aryLst);
      Set hashSet = new HashSet();
      hashSet.add("set1");
      hashSet.add("set2");
      hashSet.add("set3");
      hashSet.add("set4");
      hashSet.add("set4");
      displayAll(hashSet);
      SortedSet treeSet = new TreeSet();
      treeSet.add("1");
      treeSet.add("2");
      treeSet.add("3");
      treeSet.add("4");
      displayAll(treeSet);
      LinkedHashSet lnkHashset = new LinkedHashSet();
      lnkHashset.add("one");
      lnkHashset.add("two");
      lnkHashset.add("three");
      lnkHashset.add("four");
      displayAll(lnkHashset);
      Map map1 = new HashMap();
      map1.put("keyK", "J");
      map1.put("keyL", "K");
      map1.put("keyB", "L");
      map1.put("keyO", "M");
      displayAll(map1.keySet());
      displayAll(map1.values());
      SortedMap map2 = new TreeMap();
      map2.put("keyV", "JJ");
      map2.put("keyA", "KK");
      map2.put("keyD", "LL");
      map2.put("keyK", "MM");
      displayAll(map2.keySet());
      displayAll(map2.values());
      LinkedHashMap map3 = new LinkedHashMap();
      map3.put("key1", "JJJ");
      map3.put("key2", "KKK");
      map3.put("key3", "LLL");
      map3.put("key4", "MMM");
      displayAll(map3.keySet());
      displayAll(map3.values());
      
     Object str =  map3.get("key3");
      
      int [] a = {1,5,3};
     List  list = Collections.unmodifiableList(lnkLst);
      
      Arrays.sort(a);
      System.out.println("Test: " + a[1]);
   }
   static void displayAll(Collection col) {
      Iterator itr = col.iterator();
      while (itr.hasNext()) {
         String str = (String) itr.next();
         System.out.print(str + " ");
      }
      System.out.println();
   }
}