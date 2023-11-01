package ramesh.coreJava.practice.collections;

import java.util.*;

public class SetTest {
	public static void main(String args[]) {

		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("Ravi");
		hashSet.add("Vijay");
		hashSet.add("Ravi");
		hashSet.add("Ajay");
		hashSet.add("Rehan");

		Iterator<String> itr = hashSet.iterator();

		while (itr.hasNext()) {
			System.out.println("Iterating Result of Hashset: " + itr.next());
		}

		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("Ravi");
		linkedHashSet.add("Vijay");
		linkedHashSet.add("Ravi");
		linkedHashSet.add("Ajay");

		itr = linkedHashSet.iterator();
		while (itr.hasNext()) {
			System.out.println("Iterating Result of LinkedHashset: "
					+ itr.next());
		}
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("Ravi");
		treeSet.add("Vijay");
		treeSet.add("Ravi");
		treeSet.add("Ajay");

		itr = treeSet.iterator();
		while (itr.hasNext()) {
			System.out.println("Iterating Result of Treeset: " + itr.next());
		}

	}
}
