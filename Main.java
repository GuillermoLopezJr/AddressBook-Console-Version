import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;


public class Main{

	public static void main(String[] args)
	{
		String path = "test.txt";
		AddressBook book = new AddressBook(path);

		boolean dataLoaded = book.loadData();
		if(!dataLoaded)
			createFile(path);
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
					contact = getContactInfo();
					book.addContact(contact);
					System.out.println("Adding...\n");
					break;
				case 3:
					contact = getContactInfo();
					book.removeContact(contact);
					System.out.println("Removing...\n");
					break;
				case 4:
					editContact();
					break;
				case 5:
					book.eraseBook();
					break;
				case 6:
					//book.save(path);
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

	public static void save(String path) //make  this addressbook method.
	{

	}

	public static boolean loadData(AddressBook book) //make this a method.
	{
		Scanner in;
		String path = "test.txt";
		boolean dataLoaded = false;

		try{
			
			File file = new File(path);

			if(file.exists() )
			{
				in = new Scanner(new FileReader(file));

				while(in.hasNext() )
				{	
					String fName = in.next();
					String lName = in.next();
					int cellPhone = in.nextInt();
					//int housePhone = in.nextInt();
					Contact contact = new Contact(fName, lName, cellPhone);
					System.out.println(contact + "\n");
					book.addContact(contact);
					
				}
				in.close();
				dataLoaded = true;
			}
		}

		catch(FileNotFoundException ex)
		{
			System.err.println("File does not exist");
			createFile(path);
		}
		catch(Exception ex)
		{
			System.err.println("An error occured while reading");
			dataLoaded = false;
		}

		return dataLoaded;
	

	}

	public static void createFile(String path)
	{

		try{
			PrintWriter f = new PrintWriter(new FileWriter(path));
			f.println("i am cool");
			f.close();
		}catch(Exception ex)
		{
			System.err.println("An error occured while writing");
		}
	}
	public static void editContact()
	{

	}

	public static Contact getContactInfo()
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.print("\nFirst Name: ");
		String fName = keyboard.nextLine();
		
		System.out.print("Last Name: ");
		String lName = keyboard.nextLine();

		System.out.print("Cell Phone: ");
		int cellPhone = keyboard.nextInt();

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