class Employee extends Person
{
  public int workHours;
  public double salary;

  public Employee(String fN, String lN, String add, int wH, double payment)
  {
    super(fN, lN, add);
    workHours = wH;
    salary = payment;
  }

  public double calcSalary()
  {
    if(workHours <= 165)
    {
      return salary;
    }
    return salary + (workHours - 165) * salary / 165 * 1.5;
  }

  public void informationReport()
  {
    System.out.println("Employee's information:");
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Salary Rate: " + salary);
    System.out.println("Hours: " + workHours);
    System.out.println("Paid: " + calcSalary());
    System.out.println("===============================================");
  }
}