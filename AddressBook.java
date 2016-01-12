import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;

public class AddressBook{

	private int numOfContacts;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	String path = "";

	public AddressBook(){}

	public AddressBook(String path)
	{
		this.path = path;
	}

	public boolean isEmpty()
	{
		return (contacts.size() == 0);
	}

	public void viewContacts()
	{
		for(int i = 0; i < contacts.size() ; i++)
		{
			System.out.println("Contact " + (i+1) + ":");
			System.out.println(contacts.get(i));
			System.out.println();
		}
	}

	public void eraseBook()
	{
		for(int i = 0; i < contacts.size(); i++)
			contacts.remove(i);
	}

	public void addContact(Contact contact)
	{
		contacts.add(contact);
		numOfContacts++;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	//index of contact to be edited/replaced.
	public void editContact(int index, Contact contact)
	{
		contacts.set(index, contact);
	}

	public void save()
	{
		try{
			PrintWriter f = new PrintWriter(new FileWriter(path));
			for(int i = 0; i < contacts.size(); i++)
			{
				f.println(contacts.get(i).getFirstName());
				f.println(contacts.get(i).getLastName());
				f.println(contacts.get(i).getCellPhone());
				f.println(contacts.get(i).getHousePhone());
			}
			f.close();
		}catch(Exception ex)
		{
			System.err.println("An error occured while writing");
		}
	}

	public boolean loadData()
	{
		Scanner in;
		boolean dataLoaded = false;
		System.out.println("Loading data...");

		try{
			File file = new File(path);

			if(file.exists() )
			{
				in = new Scanner(new FileReader(file));

				while(in.hasNext() )
				{	
					String fName = in.next();
					String lName = in.next();
					long cellPhone = in.nextLong();
					long housePhone = in.nextLong();
					Contact contact = new Contact(fName, lName, cellPhone, housePhone);
					addContact(contact);
				}

				in.close();
				dataLoaded = true;
			}
		}
		catch(FileNotFoundException ex)
		{
			System.err.println("File does not exist");
			dataLoaded = false;
			//save(); //saveing an empty file. 
		}
		catch(Exception ex)
		{
			dataLoaded = false;
			System.err.println("An error occured while reading");
		}

		return dataLoaded;
	}

	//returns true if contact was removed false otherwise.
	public boolean removeContact(Contact contact)
	{
		for(int i = 0; i < contacts.size(); i++)
		{		
			if(contacts.get(i).equals(contact) )
			{
				contacts.remove(i);
				return true;
			}
		}
		return false;	
	}

	public String toString()
	{
		String info = "";
		for(int i = 0; i < contacts.size() ; i++)
		{
			info += "Contact " + (i+1) + ":";
			info += contacts.get(i);
			info += "\n";
		}
		return info;
	}
}