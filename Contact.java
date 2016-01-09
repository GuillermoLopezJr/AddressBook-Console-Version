
public class Contact{

	private String fName, lName;
	private int cellPhone, housePhone;

	private final String NAME_NOT_PROVIDED = "";
	private final int NUMBER_NOT_PROVIDED = -1;

	public Contact()
	{
		fName = NAME_NOT_PROVIDED;
		lName = NAME_NOT_PROVIDED;
		cellPhone = NUMBER_NOT_PROVIDED;
		housePhone = NUMBER_NOT_PROVIDED;
	}

	public Contact(String fname, String lname)
	{
		this.fName = fName;
		this.lName = lName;
	}

	public void setFirstName(String fName)
	{
		this.fName = fName;
	}

	public void setLastName(String lName)
	{
		this.lName = lName;
	}

	public void setCellPhone(int num)
	{
		cellPhone = num;
	}

	public void setHousePhone(int num)
	{
		housePhone = num;
	}

	public String getFirstName()
	{
		return fName;
	}

	public String getLastName()
	{
		return lName;
	}

	public int getCellPhone()
	{
		return cellPhone;
	}

	public int getHousePhone()
	{
		return housePhone;
	}

	public boolean equals(Contact contact)
	{
		return(this.getFirstName().equals(contact.getFirstName()) &&
			this.getLastName().equals(contact.getLastName()) &&
			this.getCellPhone() == contact.getCellPhone() );
	}

	public String toString()
	{
		String contactInfo = "";

		if(!fName.equals(NAME_NOT_PROVIDED))
			contactInfo += "First Name: " + fName;
		if(!lName.equals(NAME_NOT_PROVIDED))
			contactInfo += "\nLast Name:  " + lName;
		if(cellPhone != NUMBER_NOT_PROVIDED)
			contactInfo += "\nCell Phone: " + cellPhone;
		if(housePhone != NUMBER_NOT_PROVIDED)
			contactInfo += "House Phone: " + housePhone;

		return contactInfo;
	}
}