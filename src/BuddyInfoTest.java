import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
	BuddyInfo buddy;
	BuddyInfo buddy2;
	BuddyInfo buddy3;

	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo("Jim", "3510 Cawthra", 18);
		buddy2 = new BuddyInfo(buddy);
		buddy3 = new BuddyInfo(buddy);
		buddy3.setAge(20);
	}

	@Test
	public void testBuddyInfoBuddyInfo() {
		assertTrue(buddy.getName() == buddy2.getName());
	}

	@Test
	public void testGreeting() {
		
		assertEquals("Hello Jim", buddy.greeting());
	}

	@Test
	public void testIsOver18() {
		assertTrue(buddy3.isOver18());
	}

}
