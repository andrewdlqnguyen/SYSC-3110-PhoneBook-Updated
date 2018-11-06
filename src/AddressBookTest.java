import static org.junit.Assert.*;

import javax.swing.DefaultListModel;

import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	DefaultListModel<BuddyInfo> buddyInfoList;
	BuddyInfo b;
	BuddyInfo b2;
	BuddyInfo b3;
	BuddyInfo b4;
	BuddyInfo b5;
	AddressBook a;
	

	@Before
	public void setUp() throws Exception {
		buddyInfoList = new DefaultListModel<BuddyInfo>();
		b = new BuddyInfo("Homer", "Cawthra Road", 14);
		b2 = new BuddyInfo("Marge", "Cawthra Road", 51);
		b3 = new BuddyInfo("Lisa", "Cawthra Road", 20);
		b4 = new BuddyInfo("Bart", "Cawthra Road", 65);
		b5 = new BuddyInfo("Maggie", "Cawthra Road", 30);
		a = new AddressBook();
		a.addBuddy(b);
		a.addBuddy(b2);
		a.addBuddy(b3);
		a.addBuddy(b4);
		a.addBuddy(b5);
	}

	@Test
	public void testSetBuddyName() {
		a.setBuddyName(1, "Henry");
		assertTrue(a.getBuddyName(1) == "Henry");
	}

	@Test
	public void testSize() {
		assertTrue(a.size() == 5);
	}

	@Test
	public void testClear() {
		a.clear();
		assertTrue(a.size() == 0);
	}

}
