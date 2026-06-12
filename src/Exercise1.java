// Original bad class - ONE class doing THREE things
class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

// Responsibility 1 - ONLY calculates salary
class SalaryCalculator {
    public double calculate(Employee emp) {
        return emp.salary * 0.9; // example deduction
    }
}

// Responsibility 2 - ONLY handles database
class EmployeeRepository {
    public void save(Employee emp) {
        System.out.println("Saving " + emp.name + " to database");
    }
}

// Responsibility 3 - ONLY generates payslip
class PayslipGenerator {
    public void generate(Employee emp) {
        System.out.println("Generating payslip for " + emp.name);
    }
}

// Main to test it
class Exercise1 {
    public static void main(String[] args) {
        Employee emp = new Employee("Shivangi", 50000);

        SalaryCalculator calc = new SalaryCalculator();
        System.out.println("Salary: " + calc.calculate(emp));

        EmployeeRepository repo = new EmployeeRepository();
        repo.save(emp);

        PayslipGenerator gen = new PayslipGenerator();
        gen.generate(emp);
    }
}