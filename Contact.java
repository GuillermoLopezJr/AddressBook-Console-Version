
public class Contact{

	private String fName, lName;
	private int cellPhone, housePhone;

	public Contact()
	{

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

	public String toString()
	{
		String contactInfo = "First Name: " + fName +
							 "Last Name: " + lName +
							 "cellPhone: " + cellPhone +
							 "housePhone: " + housePhone;


		return contactInfo;
	}
}