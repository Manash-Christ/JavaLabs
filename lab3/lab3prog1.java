import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

class Employee {
    // declare private variables for employee
    static int eID;
    private String eNAME;
    private String DESG;

    public Employee(){System.out.println("This is the base Employee class");}

    public Employee(int eID, String eNAME, String DESG) {
        this.eID = eID;
        this.eNAME = eNAME;
        this.DESG = DESG;
    }

    // METHOD TO RETURN EMP ID
    public int geteID() {
        return eID;
    }

    // METHOD TO RETURN EMP NAME
    public String geteNAME() {
        return eNAME;
    }

    // METHOD TO RETURN EMP DESIGNATION
    public String getDESG() {
        return DESG;
    }

    // METHOD TO DISPLAY EMP INFO
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + eID);
        System.out.println("Employee Name: " + eNAME);
        System.out.println("DESG: " + DESG);
    }

    // METHOD TO CALCULATE BONUS
    public double calculateBonus() {
        // overridden by derived classes
        return 0.0;
    }

    // MEHTOD TO CALCULATE ANNUAL EARNING
    public double calculateAnnualEarnings() {
        // overridden by derived classes
        return 0.0;
    }
}

class HourlyEmployee extends Employee {
    private double hrRATE;
    private int hrWORKED;

    public HourlyEmployee(){System.out.println("This is the child class for hourly employees");}

    // PARAMETRIC CONSTRUCTOR
    public HourlyEmployee(int eID, String eNAME, String DESG,
                          double hrRATE, int hrWORKED) {
        super(eID, eNAME, DESG);
        this.hrRATE = hrRATE;
        this.hrWORKED = hrWORKED;
    }

    // GET HOURLY RATE
    public double gethrRATE() {
        return hrRATE;
    }

    // GET HOURS WORKED
    public int gethrWORKED() {
        return hrWORKED;
    }

    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Hourly Rate: $" + hrRATE);
        System.out.println("Hours Worked: " + hrWORKED);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
        System.out.println("Monthly Salary: $" + calculateWeeklySalary()*4);
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.05; // Bonus for hourly employees is 5% of weekly salary
    }

    @Override
    public double calculateAnnualEarnings() {
        return calculateWeeklySalary() * 52; // Assuming 52 weeks in a year
    }

    // GET WEEKLY SALARY AS HR_WORKED*HR_RATE
    private double calculateWeeklySalary() {
        return hrRATE * hrWORKED;
    }
}

class SalariedEmployee extends Employee {
    private double mnthSAL;

    public SalariedEmployee(int eID, String eNAME, String DESG,
                            double mnthSAL) {
        super(eID, eNAME, DESG);
        this.mnthSAL = mnthSAL;
    }
    
    // GET MONTHLY SALARY
    public double getmnthSAL() {
        return mnthSAL;
    }

    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Monthly Salary: $" + mnthSAL);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
    }

    @Override
    public double calculateBonus() {
        return mnthSAL / 12 * 0.1; // Bonus for salaried employees is 10% of monthly salary
    }

    @Override
    public double calculateAnnualEarnings() {
        return mnthSAL * 12;
    }

    public double calculateWeeklySalary() {
        return mnthSAL / 4;
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    private double bnPR;

    public ExecutiveEmployee(int eID, String eNAME, String DESG,
                             double mnthSAL, double bnPR) {
        super(eID, eNAME, DESG, mnthSAL);
        this.bnPR = bnPR;
    }

    // GET BONUS
    public double getbnPR() {
        return bnPR;
    }

    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Bonus Percentage: " + bnPR + "%");
        System.out.println("Weekly Salary: $" + super.calculateWeeklySalary());
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + getmnthSAL() * (bnPR / 100);
    }

    @Override
    public double calculateAnnualEarnings() {
        return super.calculateAnnualEarnings() + getmnthSAL() * (bnPR / 100) * 12;
    }
}

class EmployeeList<T>{
    int id;
    String name;
    String desg;
    ArrayList<Object> List = new ArrayList<Object>();
    EmployeeList(int id, String name, String desg){
        this.id = id;
        this.name = name;
        this.desg = desg;
        
    }
    List.add(id);

    //List<String[]> EMP_List = new ArrayList<>();
    Collections.addAll(EMP_List, List);
    public static void show(){
        List<String[]> EMP_List = new ArrayList<>();


    }
}

public class lab3prog1 {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        System.out.println("WELCOME TO EMPLOYEE INFORMATION SERVICE!");
        System.out.println("________________________________________");
        System.out.println("Enter choice: ");
        String choice = scan.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Add Employee: ");
                System.out.println("Enter type of employees to add: \n1. Regular\n2. Hourly\n3.Salaried\n4. Executive\n");
                int emp = scan.nextInt();
                switch (emp) {
                    case 1:
                        System.out.println("enter emplyee name: ");
                        String name = scan.next();
                        System.out.println("enter emplyee designation: ");
                        String desg = scan.next();
                        Employee emp1 = new Employee(Employee.eID++, name, desg);
                        emp1.displayEmployeeInfo();

                        break;
                
                    default:
                        break;
                }
                break;
        
            default:
            System.out.println("iohg");
                break;
        }

        




















        /*
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Test1", "Assistant", 15.0, 40);
        hourlyEmployee.displayEmployeeInfo();
        System.out.println("Annual Earnings: $" + hourlyEmployee.calculateAnnualEarnings());
        System.out.println("Bonus: $" + hourlyEmployee.calculateBonus());
        System.out.println();

        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Test2", "Professor", 5000.0);
        salariedEmployee.displayEmployeeInfo();
        System.out.println("Annual Earnings: $" + salariedEmployee.calculateAnnualEarnings());
        System.out.println("Bonus: $" + salariedEmployee.calculateBonus());
        System.out.println();

        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Test3", "Dean", 8000.0, 15.0);
        executiveEmployee.displayEmployeeInfo();
        System.out.println("Annual Earnings: $" + executiveEmployee.calculateAnnualEarnings());
        System.out.println("Bonus: $" + executiveEmployee.calculateBonus());
        System.out.println();
        */

        //HourlyEmployee hourlyEmployee = new HourlyEmployee(101, "Nishikant Kamat", "Assistant", 20.0, 30);
       // PayrollTest.displayEmployeeDetails(hourlyEmployee);
       // System.out.println();

        // salariedEmployee = new SalariedEmployee(102, "J. Chandrashekar", "Professor", 6000.0);
       // PayrollTest.displayEmployeeDetails(salariedEmployee);
        //System.out.println();

        //ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(103, "Bobby Deol", "Dean", 10000.0, 15.0);
        //PayrollTest.displayEmployeeDetails(executiveEmployee);
       // System.out.println();

        //Employee[] employees = {hourlyEmployee, salariedEmployee, executiveEmployee};
        //PayrollTest.displayTotalPayroll(employees);
    }

    private static void totalPayroll(Employee[] employees) {
        double totalPayroll = 0;
        for (Employee employee : employees) {
            totalPayroll += employee.calculateAnnualEarnings();
        }
        System.out.println("Total Payroll: $" + totalPayroll);
    }
}
/*
class PayrollTest {
    
   public static void displayEmployeeDetails(Employee employee) {
        System.out.println("Employee Details:");
        System.out.println("-----------------");
        employee.displayEmployeeInfo();
        System.out.println("Weekly Salary: $" + employee.calculateWeeklySalary());
        System.out.println("Bonus: $" + employee.calculateBonus());
        System.out.println("Annual Earnings: $" + employee.calculateAnnualEarnings());
        System.out.println();
    }

   
public static void displayTotalPayroll(Employee[] employees) {
        System.out.println("Total Payroll Details:");
        System.out.println("----------------------");
        double totalPayrolll = 0;
        for (Employee employee : employees) {
            totalPayroll(employee);
            totalPayrolll += employee.calculateAnnualEarnings();
        }
        System.out.println("Total Payroll: $" + totalPayroll);
    }
}
*/