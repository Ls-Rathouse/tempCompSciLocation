class Person
{
  protected String firstName;
  protected String lastName;
  protected String address;

  public Person(String fN, String lN, String add)
  {
    firstName = fN;
    lastName = lN;
    address = add;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }
}