import java.util.Scanner;

public class Main{
	public static void main(String[] args)
	{
		AddressBook book = new AddressBook();
		int choice = -1;
		
		do{
			printMenu();
			choice = getChoice();

			switch(choice)
			{
				case 1:
					book.viewContacts();
					break;
				case 2:
					Contact contact1 = getContactInfo();
					book.addContact(contact1);
					break;
				case 3:
					Contact contact2 = getContactInfo();
					book.removeContact(contact2);
					break;
				case 4:
					editContact();
					break;
				case 5:
					book.eraseBook();
				case 6:
					break;
				default:
					System.out.println("Not a valid option");
					break;
			}
		}
		while(choice != 6);
	}

	public static void editContact()
	{

	}

	public static Contact getContactInfo()
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.print("First Name:");
		String fName = keyboard.nextLine();
		
		System.out.print("Last Name: ");
		String lName = keyboard.nextLine();

		System.out.print("Cell Phone: ");
		int cellPhone = keyboard.nextInt();
		System.out.println();

		Contact contact = new Contact();
		contact.setFirstName(fName);
		contact.setLastName(lName);
		contact.setCellPhone(cellPhone);

		return contact;
	}
	public static int getChoice()
	{
		Scanner keyboard = new Scanner(System.in);

		int choice = keyboard.nextInt();
		return choice;
	}

	public static void printMenu()
	{
		System.out.println("1. view AddressBook");
		System.out.println("2. Add Contact");
		System.out.println("3. Remove Contact");
		System.out.println("4. Edit Contact");
		System.out.println("5. Delete Address Book");
		System.out.println("6. Exit");
		System.out.print("\n> ");
	}
}