import java.util.ArrayList;

public class AddressBook{

	private int numOfContacts;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();


	public AddressBook()
	{

	}

	public AddressBook(String path)
	{

	}

	public boolean isEmpty()
	{
		return (numOfContacts == 0);
	}

	public void viewContacts()
	{
		for(int i = 0; i < contacts.size() ; i++)
		{
			System.out.println("Contact " + i + ":");
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

	public void removeContact(Contact contact)
	{
		contacts.remove(contact);
	}
}