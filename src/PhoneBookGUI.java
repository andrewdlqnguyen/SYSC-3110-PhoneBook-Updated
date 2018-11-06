import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PhoneBookGUI extends JFrame {

	JMenuBar menuBar;
	JMenu menu1, menu2;
	
	JMenuItem createAddressBook, saveAddressBook, displayAddressBook, addBuddyInfo, editBuddyInfo, removeBuddyInfo;
	JList<BuddyInfo> buddyInfoList;
	// JTextArea textArea;
	JScrollPane scrollPane;
	JOptionPane optionPane;
	Container contentPane;
	FlowLayout layout;
	AddressBook addressBook;
	
	public PhoneBookGUI(AddressBook addressBook) {
		super("Address Book Interface");
		
		this.addressBook = addressBook;
		
		/* Setting up start up layout of GUI */
		setLocationRelativeTo(null);
		setSize(300, 400);
		layout = new FlowLayout();
		contentPane = getContentPane();
		contentPane.setLayout(layout);

		/* Setting up List */
		buddyInfoList = new JList<>(this.addressBook.getAddressBook());
		scrollPane = new JScrollPane(buddyInfoList);
		buddyInfoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Dimension d = buddyInfoList.getPreferredSize();
		d.width = 200;
		d.height = 300;
		scrollPane.setPreferredSize(d);
		
		contentPane.add(scrollPane);
		
		/* The removed code from textArea to JList
		textArea = new JTextArea(30,30);
		textArea.setEditable(false);		
		contentPane.add(textArea); */
		
		/* Menu navigation: AddressBook and BuddyInfo */
		menuBar = new JMenuBar();
		menu1 = new JMenu("AddressBook");
		menu2 = new JMenu("BuddyInfo");
		menuBar.add(menu1);
		menuBar.add(menu2);
		setJMenuBar(menuBar);
		
		/* Sub menu for navigation tabs: AddressBook - Create, Save, Display */
		createAddressBook = new JMenuItem("Create AddressBook");
		saveAddressBook = new JMenuItem("Save AddressBook");
		displayAddressBook = new JMenuItem("Display BuddyList");
		menu1.add(createAddressBook);
		menu1.add(saveAddressBook);
		menu1.addSeparator();
		menu1.add(displayAddressBook);
		
		/* Sub menu for navigation tab: BuddyInfo - Add New Buddy */
		addBuddyInfo = new JMenuItem("Add New Buddy");
		editBuddyInfo = new JMenuItem("Edit Selected Buddy");
		removeBuddyInfo = new JMenuItem("Remove Selected Buddy");
		menu2.add(addBuddyInfo);
		menu2.add(editBuddyInfo);
		menu2.add(removeBuddyInfo);
		
		/* Create action handler for each sub menu option */
		actionHandler handler = new actionHandler();
		createAddressBook.addActionListener(handler);
		saveAddressBook.addActionListener(handler);
		displayAddressBook.addActionListener(handler);
		
		addBuddyInfo.addActionListener(handler);
		editBuddyInfo.addActionListener(handler);
		removeBuddyInfo.addActionListener(handler);
		
		/* Disable some sub menu option: forces user to create an AddressBook first */
//		saveAddressBook.setEnabled(false);
//		displayAddressBook.setEnabled(false);
//		addBuddyInfo.setEnabled(false);
//		editBuddyInfo.setEnabled(false);
//		removeBuddyInfo.setEnabled(false);
		
		/* Keep this on for now. Will make future upgrades */
		saveAddressBook.setEnabled(true);
		displayAddressBook.setEnabled(true);
		addBuddyInfo.setEnabled(true);
		editBuddyInfo.setEnabled(true);
		removeBuddyInfo.setEnabled(true);
		
		/* Display the interface */
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private class actionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == createAddressBook) {
				//textArea.setText("Creating AddressBook...... AddressBook Created!\n" + "Example Contact: Homer \n\n" + addressBook.getAddressBookList());
				createAddressBook.setEnabled(false);
				saveAddressBook.setEnabled(true);
				displayAddressBook.setEnabled(true);
				addBuddyInfo.setEnabled(true);
				editBuddyInfo.setEnabled(true);
				removeBuddyInfo.setEnabled(true);
				
				System.out.println(e.getActionCommand());
			}
			if(e.getSource() == saveAddressBook) {
				// textArea.setText("AddressBook Saving...... AddressBook Saved!\n");
				
				addressBook.export();
			}
			if(e.getSource() == displayAddressBook) {
				// textArea.setText(addressBook.getAddressBookList());
				
				System.out.println(e.getActionCommand());
			}
			if(e.getSource() == addBuddyInfo) {
				String name = "";
				String address = "";
				int age;
				name = JOptionPane.showInputDialog("Enter Name:");
				address = JOptionPane.showInputDialog("Enter Address:");
				age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age: "));
				addressBook.addBuddy(new BuddyInfo(name,address,age));
	
				System.out.println(e.getActionCommand());
			}
			if(e.getSource()==removeBuddyInfo) {
				addressBook.removeBuddy(buddyInfoList.getSelectedIndex());
			}
			
			if(e.getSource()==editBuddyInfo) {
				System.out.println(e.getActionCommand());
				try {
					String newName = JOptionPane.showInputDialog("Enter Name:", buddyInfoList.getSelectedValue().getName());
					String newAddress = JOptionPane.showInputDialog("Enter Address:", buddyInfoList.getSelectedValue().getAddress());
					int newAge = Integer.parseInt(JOptionPane.showInputDialog("Enter Age: ", buddyInfoList.getSelectedValue().getAge()));
					
					addressBook.setBuddyName(buddyInfoList.getSelectedIndex(), newName);
					addressBook.setBuddyAddress(buddyInfoList.getSelectedIndex(), newAddress);
					addressBook.setBuddyNumber(buddyInfoList.getSelectedIndex(), newAge);
			
				} catch(NullPointerException e1) {
					System.out.println("Nothing has been selected");
				}
			}
		}
	}
}
