import java.util.Scanner;

public class BuddyInfo {
	
	private String name;
	private String address;
	private int age;
	
	public BuddyInfo(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	public BuddyInfo(BuddyInfo buddyInfo) {
		this.name = buddyInfo.getName();
		this.address = buddyInfo.getAddress();
		this.age = buddyInfo.getAge();
	}
	
	public String greeting() {
		return "Hello " + this.getName();
	}
	
	public boolean isOver18() {
		boolean result = age > 18 ? true : false;
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return (name + "$" + address + "$" + age);
	}
	
	public static BuddyInfo importBuddyInfo(String newName) {
		String name = newName;
		Scanner scanner = new Scanner(System.in);
		String address = scanner.nextLine();
		int age = scanner.nextInt();
		
		BuddyInfo buddy = new BuddyInfo(name, address, age);
		return buddy;
	}
	
}
