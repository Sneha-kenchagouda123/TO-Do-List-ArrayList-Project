package weeklypractice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class To_Do_List_Using_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- To-Do List Menu ---");
                System.out.println("1. Add Task");
                System.out.println("2. View Tasks");
                System.out.println("3. Update Task");
                System.out.println("4. Delete Task");
                System.out.println("5. Mark Task as Completed");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character

                switch (choice) {
                    case 1: // Add Task
                        System.out.print("Enter the task: ");
                        String newTask = scanner.nextLine();
                        tasks.add(newTask);
                        System.out.println("Task added successfully.");
                        break;

                    case 2: // View Tasks
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks found.");
                        } else {
                            System.out.println("\n--- Task List ---");
                            for (int i = 0; i < tasks.size(); i++) {
                                System.out.println((i + 1) + ". " + tasks.get(i));
                            }
                        }
                        break;

                    case 3: // Update Task
                        System.out.print("Enter the task number to update: ");
                        int updateIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Clear the newline character
                        if (updateIndex >= 0 && updateIndex < tasks.size()) {
                            System.out.print("Enter the updated task: ");
                            String updatedTask = scanner.nextLine();
                            tasks.set(updateIndex, updatedTask);
                            System.out.println("Task updated successfully.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                        break;

                    case 4: // Delete Task
                        System.out.print("Enter the task number to delete: ");
                        int deleteIndex = scanner.nextInt() - 1;
                        if (deleteIndex >= 0 && deleteIndex < tasks.size()) {
                            tasks.remove(deleteIndex);
                            System.out.println("Task deleted successfully.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                        break;

                    case 5: // Mark Task as Completed
                        System.out.print("Enter the task number to mark as completed: ");
                        int completeIndex = scanner.nextInt() - 1;
                        if (completeIndex >= 0 && completeIndex < tasks.size()) {
                            String completedTask = tasks.get(completeIndex);
                            tasks.set(completeIndex, completedTask + " [COMPLETED]");
                            System.out.println("Task marked as completed.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                        break;

                    case 6: // Exit
                        System.out.println("Exiting the application. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
