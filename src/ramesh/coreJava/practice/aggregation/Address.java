package ramesh.coreJava.practice.aggregation;

public class Address {
	String city, state, country;

	public Address(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;

		System.out
				.println("Address constructor has set the values to instance variables from prameters passed by you.");
	}

}
