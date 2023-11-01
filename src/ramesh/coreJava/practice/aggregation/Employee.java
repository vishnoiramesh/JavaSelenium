package ramesh.coreJava.practice.aggregation;

public class Employee {
	int id;
	String name;
	Address address;

	public Employee(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	void display() {
		System.out.println(id + " " + name);
		System.out.println(address.city + " " + address.state + " "
				+ address.country);
	}

	public static void main(String[] args) {
		Address address1 = new Address("Ghaziabaad", "UP", "india");
		Address address2 = new Address("Gwaliar", "UP", "india");

		Employee e1 = new Employee(111, "Varun", address1);
		Employee e2 = new Employee(112, "Arun", address2);

		e1.display();
		e2.display();

	}
}