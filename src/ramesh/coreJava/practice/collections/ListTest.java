package ramesh.coreJava.practice.collections;

import java.util.*;

public class ListTest {
	public static void main(String args[]) {

		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("Ravi");
		arrList.add("Vijay");
		arrList.add("Ravi");
		arrList.add("Ajay");
		arrList.add("Rehan");

		Iterator<String> itr = arrList.iterator();

		while (itr.hasNext()) {
			System.out.println("Iterating Result of List1: " + itr.next());
		}
		System.out.println("..........................................");
		for (String ArrayListObj : arrList) {
			System.out.println("For Each Result of List1: " + ArrayListObj);
		}

		ArrayList<String> arrList2 = new ArrayList<String>();
		arrList2.add("Ravi");
		arrList2.add("Vijay");
		arrList2.add("Ravi");
		arrList2.add("Arjun");
		arrList2.add("Tejas");

		arrList.retainAll(arrList2);

		itr = arrList.iterator();
		System.out.println("..........................................");
		while (itr.hasNext()) {
			System.out
					.println("Iterating Result After Using retainAll on List1: "
							+ itr.next());
		}

		arrList.addAll(arrList2);

		itr = arrList.iterator();
		System.out.println("..........................................");
		while (itr.hasNext()) {
			System.out
					.println("Iterating Result After Using addAll on List1 : "
							+ itr.next());
		}

		itr = arrList.iterator();
		System.out.println("..........................................");
		while (itr.hasNext()) {
			System.out.println("Iterating Result After Using removeAll : "
					+ itr.next());
		}
		ArrayList<String> arrList3 = new ArrayList<String>();
		arrList3.add("Test1");
		arrList3.add("Test2");
		arrList3.add("Test3");
		arrList3.add("Test3");
		arrList3.add("Test4");

		ArrayList<String> arrList4 = new ArrayList<String>();
		arrList4.add("Test3");
		arrList4.add("Test4");
		arrList4.add("Test5");

		arrList3.removeAll(arrList4);
		itr = arrList3.iterator();
		System.out.println("..........................................");
		while (itr.hasNext()) {
			System.out.println("Iterating Result After Using removeAll : "
					+ itr.next());

		}

		/**
		 * 1) ArrayList internally uses dynamic array to store the elements.
		 * LinkedList internally uses doubly linked list to store the elements.
		 * 2) Manipulation with ArrayList is slow because it internally uses
		 * array. If any element is removed from the array, all the bits are
		 * shifted in memory. Manipulation with LinkedList is faster than
		 * ArrayList because it uses doubly linked list so no bit shifting is
		 * required in memory. 3) ArrayList class can act as a list only because
		 * it implements List only. LinkedList class can act as a list and queue
		 * both because it implements List and Deque interfaces. 4) ArrayList is
		 * better for storing and accessing data. LinkedList is better for
		 * manipulating data.
		 */
		System.out.println("..........................................");
		List<String> linkedList = new LinkedList<String>();
		linkedList.add("James");
		linkedList.add("Serena");
		linkedList.add("Swati");
		linkedList.add("Swati");
		linkedList.add("Junaid");
		System.out.println("Linkedlist: " + linkedList);

		System.out.println("..........................................");
		ListIterator <String> listItr = linkedList.listIterator();
		System.out.println("Ttraversing List elements in forward direction...");
		while (listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		System.out.println("Traversing elements in backward direction...");
		while (listItr.hasPrevious()) {
			System.out.println(listItr.previous());
		}
	}
}
