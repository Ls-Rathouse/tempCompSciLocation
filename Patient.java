class Patient extends Person
{
  private String PCPName;
  private String lastVisitedDoctor;

  public Patient(String fN, String lN, String add, String PCP, String lVD)
  {
    super(fN, lN, add);
    PCPName = PCP;
    lastVisitedDoctor = lVD;
  }

  public void visit(String doctorName)
  {
    lastVisitedDoctor = "doctorName";
    if(doctorName == "PCP")
    {
      lastVisitedDoctor = PCPName;
    }
  }

  public String getPCP()
  {
    return PCPName;
  }
}