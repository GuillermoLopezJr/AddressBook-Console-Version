import java.util.Scanner;

public class Main{

	public static void main(String[] args)
	{
		String path = "test.txt";
		AddressBook book = new AddressBook(path);

		boolean dataLoaded = book.loadData();
		int choice = -1;
		
		do{
			printMenu();
			choice = getChoice();
			Contact contact;

			switch(choice)
			{
				case 1:
					book.viewContacts();
					break;
				case 2:
					System.out.println("leave empty name field not applicable.");
					System.out.println("Type -1 if number field not applicable.\n");
					contact = getContactInfo();
					book.addContact(contact);
					System.out.println("Adding...\n");
					break;
				case 3:
					removeContact(book);	
					break;
				case 4:
					editContact(book);
					break;
				case 5:
					System.out.println("Erasing Address Book...\n");
					book.eraseBook();
					break;
				case 6:
					System.out.println("Saving...\n");
					book.save();
					break;
				case 7:
					break;
				default:
					System.out.println("Not a valid option");
					break;
			}
		}
		while(choice != 7);
	}

	public static void removeContact(AddressBook book)
	{
		Contact contact = getContactInfo();
		boolean removed = book.removeContact(contact);
		if(removed)
			System.out.println("\nRemoving...\n");
		else 
			System.out.println("\nContact not found...\n");
	}

	public static void editContact(AddressBook book)
	{
		System.out.print("Enter index of contact you wish to edit: ");
		int index = getChoice();

		Contact contact = getContactInfo();
		book.editContact(index-1, contact);
		System.out.println();
	}

	public static Contact getContactInfo()
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.print("\nFirst Name: ");
		String fName = keyboard.nextLine();
		
		System.out.print("Last Name: ");
		String lName = keyboard.nextLine();

		System.out.print("Cell Phone: ");
		long cellPhone = keyboard.nextLong();

		System.out.print("House Phone: ");
		long housePhone = keyboard.nextLong();

		Contact contact = new Contact();

		contact.setFirstName(fName);
		contact.setLastName(lName);
		contact.setCellPhone(cellPhone);
		contact.setHousePhone(housePhone);

		return contact;
	}
	public static int getChoice()
	{
		Scanner keyboard = new Scanner(System.in);

		int choice = keyboard.nextInt();
		System.out.println();
		return choice;
	}

	public static void printMenu()
	{
		System.out.println("1. view AddressBook");
		System.out.println("2. Add Contact");
		System.out.println("3. Remove Contact");
		System.out.println("4. Edit Contact");
		System.out.println("5. Delete Address Book");
		System.out.println("6. Save Address Book");
		System.out.println("7. Exit");
		System.out.print("\n> ");
	}
}