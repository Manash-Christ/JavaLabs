import java.util.HashMap;
import java.util.Map;

class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    public Employee(){System.out.println("This is the base Employee class");}

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }

    public double calculateBonus() {
        // Base implementation, can be overridden by derived classes
        return 0.0;
    }

    public double calculateAnnualEarnings() {
        // Base implementation, can be overridden by derived classes
        return 0.0;
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(){System.out.println("This is the child hourly employee class");}

    public HourlyEmployee(int employeeId, String employeeName, String designation,
                          double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.05; // Bonus for hourly employees is 5% of weekly salary
    }

    @Override
    public double calculateAnnualEarnings() {
        return calculateWeeklySalary() * 52; // Assuming 52 weeks in a year
    }

    private double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation,
                            double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Monthly Salary: $" + monthlySalary);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
    }

    @Override
    public double calculateBonus() {
        return monthlySalary / 12 * 0.1; // Bonus for salaried employees is 10% of monthly salary
    }

    @Override
    public double calculateAnnualEarnings() {
        return monthlySalary * 12;
    }

    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation,
                             double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Weekly Salary: $" + super.calculateWeeklySalary());
    }

    @Override
    public double calculateBonus() {
        return super.calculateBonus() + getMonthlySalary() * (bonusPercentage / 100);
    }

    @Override
    public double calculateAnnualEarnings() {
        return super.calculateAnnualEarnings() + getMonthlySalary() * (bonusPercentage / 100) * 12;
    }
}

public class lab3prog1 {
    public static void main(String[] args) {
        // Sample usage
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "John Doe", "Assistant", 15.0, 40);
        hourlyEmployee.displayEmployeeInfo();
        System.out.println("Annual Earnings: $" + hourlyEmployee.calculateAnnualEarnings());
        System.out.println("Bonus: $" + hourlyEmployee.calculateBonus());
        System.out.println();

        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Jane Doe", "Professor", 5000.0);
        salariedEmployee.displayEmployeeInfo();
        System.out.println("Annual Earnings: $" + salariedEmployee.calculateAnnualEarnings());
        System.out.println("Bonus: $" + salariedEmployee.calculateBonus());
        System.out.println();

        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Bob Smith", "Dean", 8000.0, 15.0);
        executiveEmployee.displayEmployeeInfo();
        System.out.println("Annual Earnings: $" + executiveEmployee.calculateAnnualEarnings());
        System.out.println("Bonus: $" + executiveEmployee.calculateBonus());
        System.out.println();

        // Additional features: Total Payroll
        Employee[] employees = {hourlyEmployee, salariedEmployee, executiveEmployee};
        displayTotalPayroll(employees);
    }

    private static void displayTotalPayroll(Employee[] employees) {
        double totalPayroll = 0;
        for (Employee employee : employees) {
            totalPayroll += employee.calculateAnnualEarnings();
        }
        System.out.println("Total Payroll: $" + totalPayroll);
    }
}

public class PayrollTest {
    public static void main(String[] args) {
        // Test HourlyEmployee
        HourlyEmployee hourlyEmployee = new HourlyEmployee(101, "John Hourly", "Assistant", 20.0, 30);
        displayEmployeeDetails(hourlyEmployee);
        System.out.println();

        // Test SalariedEmployee
        SalariedEmployee salariedEmployee = new SalariedEmployee(102, "Jane Salaried", "Professor", 6000.0);
        displayEmployeeDetails(salariedEmployee);
        System.out.println();

        // Test ExecutiveEmployee
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(103, "Bob Executive", "Dean", 10000.0, 15.0);
        displayEmployeeDetails(executiveEmployee);
        System.out.println();

        // Display total payroll
        Employee[] employees = {hourlyEmployee, salariedEmployee, executiveEmployee};
        displayTotalPayroll(employees);
    }

    private static void displayEmployeeDetails(Employee employee) {
        System.out.println("Employee Details:");
        System.out.println("-----------------");
        employee.displayEmployeeInfo();
        System.out.println("Weekly Salary: $" + employee.calculateWeeklySalary());
        System.out.println("Bonus: $" + employee.calculateBonus());
        System.out.println("Annual Earnings: $" + employee.calculateAnnualEarnings());
        System.out.println();
    }

    private static void displayTotalPayroll(Employee[] employees) {
        System.out.println("Total Payroll Details:");
        System.out.println("----------------------");
        double totalPayroll = 0;
        for (Employee employee : employees) {
            displayEmployeeDetails(employee);
            totalPayroll += employee.calculateAnnualEarnings();
        }
        System.out.println("Total Payroll: $" + totalPayroll);
    }
}
