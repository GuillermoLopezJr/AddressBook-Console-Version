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

	public void removeContact(Contact contact)
	{
		for(int i = 0; i < contacts.size(); i++)
		{		
			if(contacts.get(i).equals(contact) )
			{
				contacts.remove(i);
				return;
			}
		}	
	}
}