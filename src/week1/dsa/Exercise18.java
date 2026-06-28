class EmployeeRecord {
    int employeeId;
    String name;
    String position;
    double salary;

    public EmployeeRecord(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + employeeId + ", name=" + name +
                ", position=" + position + ", salary=" + salary + "}";
    }
}

class EmployeeArrayManager {
    private EmployeeRecord[] employees;
    private int count = 0;

    public EmployeeArrayManager(int capacity) {
        employees = new EmployeeRecord[capacity];
    }

    public void add(EmployeeRecord emp) { // O(1) - next free slot
        if (count < employees.length) {
            employees[count++] = emp;
        } else {
            System.out.println("Array full, cannot add more employees");
        }
    }

    public EmployeeRecord search(int employeeId) { // O(n) worst case
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() { // O(n) - visits every element
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void delete(int employeeId) { // O(n) - find + shift remaining elements
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--count] = null;
        }
    }
}

class Exercise18 {
    public static void main(String[] args) {
        EmployeeArrayManager manager = new EmployeeArrayManager(10);

        manager.add(new EmployeeRecord(1, "Shivangi", "Engineer", 60000));
        manager.add(new EmployeeRecord(2, "Rahul", "Manager", 90000));
        manager.add(new EmployeeRecord(3, "Priya", "Analyst", 55000));

        System.out.println("All employees:");
        manager.traverse();

        EmployeeRecord found = manager.search(2);
        System.out.println();
        System.out.println("Search for id 2: " + found);

        manager.delete(1);
        System.out.println();
        System.out.println("After deleting id 1:");
        manager.traverse();

        // Arrays give fast index-based access but resizing is expensive, and
        // deleting/inserting in the middle means shifting every later element - O(n).
        // A linked list (see Exercise19) avoids that shifting cost.
    }
}
