package ramesh.coreJava.practice.collections;

import java.util.*;

class QueueTest {
	public static void main(String args[]) {

		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.add("Amit");
		queue.add("Vijay");
		queue.add("Karan");
		queue.add("Jai");
		queue.add("Rahul");

		System.out.println("Head: " + queue.element());
		System.out.println("Head: " + queue.peek());

		System.out.println("iterating the queue Items:");
		Iterator<String> itr = queue.iterator();
		while (itr.hasNext()) {
			System.out.println("Queue Items: " + itr.next());
		}

		queue.remove();
		queue.poll();

		System.out.println("After removing two Items: ");
		itr = queue.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}