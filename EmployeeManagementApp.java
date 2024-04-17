import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagementApp {

    private static Map<Integer, Employee> employees = new HashMap<>();
    private static int nextId = 1;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Employee Management Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewEmployee(scanner);
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();
        
        Employee employee = new Employee(nextId, name, position);
        employees.put(nextId, employee);
        
        System.out.println("Employee added with ID: " + nextId);
        nextId++;
    }

    private static void viewEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to view: ");
        int id = scanner.nextInt();
        
        Employee employee = employees.get(id);
        
        if (employee != null) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Position: " + employee.getPosition());
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void updateEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        Employee employee = employees.get(id);
        
        if (employee != null) {
            System.out.print("Enter new employee name (press Enter to keep current): ");
            String name = scanner.nextLine();
            
            System.out.print("Enter new employee position (press Enter to keep current): ");
            String position = scanner.nextLine();
            
            if (!name.isEmpty()) {
                employee.setName(name);
            }
            
            if (!position.isEmpty()) {
                employee.setPosition(position);
            }
            
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        
        Employee employee = employees.remove(id);
        
        if (employee != null) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}

class Employee {
    private int id;
    private String name;
    private String position;

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
