import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

public class AddressBook {

	private DefaultListModel<BuddyInfo> buddyInfoList;
	
	public AddressBook() {
		this.buddyInfoList = new DefaultListModel<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo b) {		
		if(b != null) {
			this.buddyInfoList.addElement(b);			
		}
	}
	
	public BuddyInfo removeBuddy(int i) {
		if(i >= 0 && i < buddyInfoList.size()) {
			return this.buddyInfoList.remove(i);			
		}
		return null;
	}
	
	public DefaultListModel<BuddyInfo> getAddressBook() {
		return buddyInfoList;
	}
	
	public void setBuddyName(int i, String name) {
		buddyInfoList.getElementAt(i).setName(name);
	}
	public String getBuddyName(int i) {
		return buddyInfoList.getElementAt(i).getName();
	}
	
	public void setBuddyAddress(int i, String address) {
		buddyInfoList.getElementAt(i).setAddress(address);
	}
	
	public void setBuddyNumber(int i, int number) {
		buddyInfoList.getElementAt(i).setAge(number);
	}
	
	public String getAddressBookList() {	 // Prints the list of buddies that was saved into the addressbook
		int count = 0; 						 // Display the order of list
		String addressBookPrint = "";					 // To Display nothing when there's no saved information
		for (int i=0; i<buddyInfoList.getSize(); i++) {
			count++;
			addressBookPrint += count + ":	Unique ID: " + buddyInfoList.get(i).toString() + " \n	Name: " + buddyInfoList.get(i).getName() + "\n    Address: " + buddyInfoList.get(i).getAddress() + "\n    age: " + buddyInfoList.get(i).getAge() + "\r\n\n";
		}
		return addressBookPrint;
	}
	
	public int size() {
		return buddyInfoList.size();
	}
	public void clear() {
		buddyInfoList.removeAllElements();
	}
	
	public void export() {
		try {
			/* Save Location: F:\Users\Andrew Nguyen\eclipse-workspace\SYSC 3110 Week5 - PhoneBook GUI */
			PrintWriter writer = new PrintWriter("addressBook.txt", "UTF-8");
			
			writer.println(this.getAddressBookList());
			writer.close();
		} catch(FileNotFoundException e1) {
			System.out.println("Unable to Create File");
		} catch(UnsupportedEncodingException e1) {
			System.out.println("Illegal Charset");
		}
	}
	
	public static void main(String[] args) {
		BuddyInfo b = new BuddyInfo("Homer", "Cawthra Road", 14);
		BuddyInfo b2 = new BuddyInfo("Marge", "Cawthra Road", 51);
		BuddyInfo b3 = new BuddyInfo("Lisa", "Cawthra Road", 20);
		BuddyInfo b4 = new BuddyInfo("Bart", "Cawthra Road", 65);
		BuddyInfo b5 = new BuddyInfo("Maggie", "Cawthra Road", 30);
		AddressBook a = new AddressBook();
		a.addBuddy(b);
		a.addBuddy(b2);
		a.addBuddy(b3);
		a.addBuddy(b4);
		a.addBuddy(b5);
		// a.removeBuddy(0);
		
		System.out.println("Hello " + b.getName()); //Testing
		PhoneBookGUI gui = new PhoneBookGUI(a);
	}
}
