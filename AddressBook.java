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

	public void viewAddressBook()
	{
		for(int i = 0; i < contacts.size() ; i++)
		{
			System.out.println(contacts.get(i));
			System.out.println();
		}
	}

	public void addContact(Contact contact)
	{
		contacts.add(contact)
		numOfContacts++;
	}

	public void deleteContact(Contact contact)
	{

		remove(contact);
		/*
		int index = -1;

		for(int i = 0; i < contacts.size(); i++)
		{
			if(contacts.get(i) == contact)
			{
				index = i;
			}
		}

		remove(index);
	*/

	}
}