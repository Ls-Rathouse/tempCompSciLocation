class Doctor extends Person
{
  private String speciality;
  private double visitFee;
  private int patientsVisited;

  public Doctor(String fN, String lN, String add, String special, double vF, int pV)
  {
    super(fN, lN, add);
    speciality = special;
    visitFee = vF;
    patientsVisited = pV;
  }

  public double calcPaycheck()
  {
    return visitFee * patientsVisited;
  }

  public void patientVisits()
  {
    patientsVisited += 1;
  }

  public void informationReport()
  {
    System.out.println("Doctor's information:");
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Speciality: " + speciality);
    System.out.println("Office visit fee: " + visitFee);
    System.out.println("Number of visits: " + patientsVisited);
    System.out.println("Paid: " + calcPaycheck());
    System.out.println("===============================================");
  }
}