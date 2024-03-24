import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> taskList = new ArrayList<>();

        while (true) {
            System.out.println("Task List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    taskList.add(taskToAdd);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    if (taskList.isEmpty()) {
                        System.out.println("Task list is empty!");
                    } else {
                        System.out.println("Current Tasks:");
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.println((i + 1) + ". " + taskList.get(i));
                        }
                        System.out.print("Enter task number to remove: ");
                        int taskNumberToRemove = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (taskNumberToRemove > 0 && taskNumberToRemove <= taskList.size()) {
                            taskList.remove(taskNumberToRemove - 1);
                            System.out.println("Task removed successfully!");
                        } else {
                            System.out.println("Invalid task number!");
                        }
                    }
                    break;
                case 3:
                    if (taskList.isEmpty()) {
                        System.out.println("Task list is empty!");
                    } else {
                        System.out.println("Current Tasks:");
                        for (int i = 0; i < taskList.size(); i++) {
                            System.out.println((i + 1) + ". " + taskList.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting Task List Application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }
}
