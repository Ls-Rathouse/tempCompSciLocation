//Rename to Clinic in the actual java file
import java.util.Scanner;
import java.util.ArrayList;

class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    boolean noMorePatients = false;
    String anotherPatient = "";
    String tempNewPatient = "";
    String tempFirstName = "";
    String tempLastName = "";
    String tempAddress = "";
    String tempPCP = "";
    String tempDoctor = "";
    String PCPPreference = "";
    String chosenDoctor = "";
    //Because if(object == "yes") wasn't working
    String yes = "yes";
    String no = "no";
    int currentPatientIndex = 0;
    int doctorIndex = 0;
    boolean doctorExists = false;
    
    ArrayList<Doctor> mainStaff = new ArrayList<Doctor>();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Patient> patients = new ArrayList<Patient>();
    
    mainStaff.add(new Doctor("Micheal", "Willis", "Address", "PCP", 100.0, 2));
    mainStaff.add(new Doctor("John", "Blake", "Address", "Dermatologist", 150.0, 1));
    mainStaff.add(new Doctor("Sara", "Frost", "Address", "Pediatric", 150.0, 1));
    employees.add(new Employee("John", "Jones", "Address", 170, 2000.0));
    employees.add(new Employee("James", "Harrison", "Address", 160, 3200.0));

    //Enter in patients
    while(noMorePatients == false)
    {
      System.out.println("Is this a new Patient?");
      tempNewPatient = scan.next();
      while(!tempNewPatient.equals(yes) && !tempNewPatient.equals(no))
      {
        System.out.println("Please enter a yes or no");
        tempNewPatient = scan.next();
      }

      if(tempNewPatient.equals(yes))
      {
        System.out.println("Patient's first name:");
        tempFirstName = scan.next();
        System.out.println("Patient's last name:");
        tempLastName = scan.next();
        System.out.println("Patient's address:");
        tempAddress = scan.next();
        System.out.println("Patient's primary doctor:");
        tempPCP = scan.next();
        while(doctorExists == false)
        {
          for(int i = 0; i < mainStaff.size(); i++)
          {
            if(tempPCP.equals(mainStaff.get(i).getLastName()))
            {
              doctorIndex = i;
              doctorExists = true;
            }
          }
          if(doctorExists == false)
          {
            System.out.println("There is no doctor by that name.");
            tempPCP = scan.next();
          }
        }
        doctorExists = false;
        System.out.println("Doctor's name:");
        tempDoctor = scan.next();
        while(doctorExists == false)
        {
          for(int i = 0; i < mainStaff.size(); i++)
            {
            if(tempDoctor.equals(mainStaff.get(i).getLastName()))
            {
              doctorIndex = i;
              doctorExists = true;
              mainStaff.get(i).patientVisits();
            }
          }
          if(doctorExists == false)
          {
            System.out.println("There is no doctor by that name.");
            tempDoctor = scan.next();
          }
        }
        doctorExists = false;
        patients.add(new Patient(tempFirstName, tempLastName, tempAddress, tempPCP, tempDoctor));
        currentPatientIndex = patients.size() - 1;
        patients.get(currentPatientIndex).visit(tempDoctor);
      }
      if(tempNewPatient.equals(no))
      {
        System.out.println("Patient's first name:");
        tempFirstName = scan.next();
        System.out.println("Patient's last name:");
        tempLastName = scan.next();
        currentPatientIndex = -1;
        for(int i = 0; i < patients.size(); i++)
        {
          if(tempFirstName.equals(patients.get(i).getFirstName()) && tempLastName.equals(patients.get(i).getLastName()))
          {
            currentPatientIndex = i;
          }
          while(currentPatientIndex == -1)
          {
            if(currentPatientIndex == -1)
            {
              System.out.println("We do not have any patients by that name");
              System.out.println("Patient's first name:");
              tempFirstName = scan.next();
              System.out.println("Patient's last name:");
              tempLastName = scan.next();
            }
          }
        }
        System.out.println("Would the patient like their primary care doctor");
        PCPPreference = scan.next();
        while(!PCPPreference.equals(yes) && !PCPPreference.equals(no))
        {
          System.out.println("Please enter a yes or no");
          PCPPreference = scan.next();
        }
        patients.get(currentPatientIndex).visit("PCP");
        if(PCPPreference.equals(no))
        {
          System.out.println("Which doctor would they like?");
          chosenDoctor = scan.next();
          while(doctorExists == false)
          {
            for(int i = 0; i < mainStaff.size(); i++)
            {
              if(chosenDoctor.equals(mainStaff.get(i).getLastName()))
              {
                doctorIndex = i;
                doctorExists = true;
              }
            }
            if(doctorExists == false)
            {
              System.out.println("There is no doctor by that name.");
              chosenDoctor = scan.next();
            }
          }
          mainStaff.get(doctorIndex).patientVisits();
          doctorExists = false;
        }
        for(int i = 0; i < mainStaff.size(); i++)
        {
          if(patients.get(currentPatientIndex).getPCP().equals(mainStaff.get(i).getLastName()))
          {
            doctorIndex = i;
          }
        }
        mainStaff.get(doctorIndex).patientVisits();
      }
      System.out.println("Are there any more patients?");
      anotherPatient = scan.next();
      while(!anotherPatient.equals(yes) && !anotherPatient.equals(no))
      {
        System.out.println("Please enter a yes or no");
        anotherPatient = scan.next();
      }
      if(anotherPatient.equals(no))
      {
        noMorePatients = true;
      }
    }

    //Information report
    System.out.println("===============================================");
    for(int i = 0; i < mainStaff.size(); i++)
    {
      mainStaff.get(i).informationReport();
    }
    for(int i = 0; i < employees.size(); i++)
    {
      employees.get(i).informationReport();
    }
  }
}