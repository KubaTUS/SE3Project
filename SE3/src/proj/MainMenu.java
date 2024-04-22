package proj;

import java.time.LocalDate;
import java.util.Scanner;

import Exceptions.K_Exception;

public class MainMenu {
    private TaskManager taskManager;
    private static Scanner sc = new Scanner(System.in);
    
        public MainMenu() 
        {
            this.taskManager = new TaskManager();
        }

        public void displayMenu() 
        {
            int choice = 0;
            while (choice != 5) 
            {
                System.out.println("\nMain Menu:");
                System.out.println("1. Create Task");
                System.out.println("2. List Tasks");
                System.out.println("3. Update a Task");
                System.out.println("4. Delete a Task");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                try 
                {
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            createTask();
                            break;
                        case 2:
                            listTasks();
                            break;
                        case 3:
                            updateTask();
                            break;
                        case 4:
                            deleteTask();
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } 
                
                catch (Exception e) 
                {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine();
                }
            }
            sc.close();
        }

        private void createTask() throws K_Exception 
        {
            System.out.println("Creating a new task:");
            String title = "";
            String description = "";
            int priorityLevel = 0;
            LocalDate dueDate = null;

            while (true) 
            {
                try 
                {
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    
                    if (!Task.isValidTitle(title)) 
                    {
                        throw new IllegalArgumentException("Title must be between 4 and 20 characters.");
                    }
                    
                    break;
                    
                } 
                
                catch (Exception e) 
                {
                    System.out.println("Invalid input: " + e.getMessage());
                }
            }

            while (true) 
            {
                try {
                    System.out.print("Enter description: ");
                    description = sc.nextLine();
                    if (!Task.isValidDescription(description)) {
                        throw new IllegalArgumentException("Description must be between 4 and 40 characters.");
                    }
                    break;
                } 
                
                catch (Exception e) 
                {
                    System.out.println("Invalid input: " + e.getMessage());
                }
            }

            while (true) 
            {
                try 
                {
                    System.out.print("Enter priority level (1-3): ");
                    priorityLevel = sc.nextInt();
                    if (!Task.isValidPriorityLevel(priorityLevel)) 
                    {
                        throw new IllegalArgumentException("Priority level must be between 1 and 3.");
                    }
                    
                    break;
                } 
                
                catch (Exception e) 
                {
                    System.out.println("Invalid input: " + e.getMessage());
                    sc.nextLine();
                }
            }

            while (true) 
            {
                try 
                {
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    dueDate = LocalDate.parse(sc.next());
                    if (!Task.isValidDate(dueDate)) 
                    {
                        throw new IllegalArgumentException("Due date must be after today and within 150 years.");
                    }
                    break;
                } 
                
                catch (Exception e) 
                {
                    System.out.println("Invalid input: " + e.getMessage());
                    sc.nextLine();
                }
            }

            Task newTask = new Task(title, description, priorityLevel, dueDate);
            taskManager.addTask(newTask);
        }

        private void listTasks() 
        {
            System.out.println("\nListing all tasks:");
            if (taskManager.tasks.isEmpty()) 
            {
                System.out.println("No tasks found.");
                return;
            }

            for (int i = 0; i < taskManager.tasks.size(); i++) 
            {
                Task task = taskManager.tasks.get(i);
                System.out.println("Task " + (i + 1) + ":");
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Priority Level: " + task.getPrioritylevel());
                System.out.println("Due Date: " + task.getDuedate());
                System.out.println();
            }
        }

        private void updateTask() throws K_Exception 
        {
            System.out.println("\nUpdating a task:");
            listTasks();
            System.out.print("Enter the index of the task to update: ");
            int index = sc.nextInt() - 1; // Adjust index to start from 0
            sc.nextLine();
            if (index >= 0 && index < taskManager.tasks.size()) {
                Task taskToUpdate = taskManager.tasks.get(index);
                String title = taskToUpdate.getTitle();
                String description = taskToUpdate.getDescription();
                int priorityLevel = taskToUpdate.getPrioritylevel();
                LocalDate dueDate = taskToUpdate.getDuedate();

                while (true) {
                    try {
                        System.out.print("Enter new title: ");
                        title = sc.nextLine();
                        if (!Task.isValidTitle(title)) {
                            throw new IllegalArgumentException("Title must be between 4 and 20 characters.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter new description: ");
                        description = sc.nextLine();
                        if (!Task.isValidDescription(description)) 
                        {
                            throw new IllegalArgumentException("Description must be between 4 and 40 characters.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter new priority level (1-3): ");
                        priorityLevel = sc.nextInt();
                        if (!Task.isValidPriorityLevel(priorityLevel)) 
                        {
                            throw new IllegalArgumentException("Priority level must be between 1 and 3.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input: " + e.getMessage());
                        sc.nextLine();
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter new due date (YYYY-MM-DD): ");
                        dueDate = LocalDate.parse(sc.next());
                        if (!Task.isValidDate(dueDate)) {
                            throw new IllegalArgumentException("Due date must be after today and within 150 years.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input: " + e.getMessage());
                        sc.nextLine();
                    }
                }

                Task updatedTask = new Task(title, description, priorityLevel, dueDate);
                taskManager.updateTask(index, updatedTask);
            } else {
                System.out.println("Invalid task index.");
            }
        }

        private void deleteTask() 
        {
            System.out.println("\nDeleting a task:");
            listTasks();
            System.out.print("Enter the index of the task to delete: ");
            int index = sc.nextInt() - 1;
            sc.nextLine();
            taskManager.deleteTask(index);
        }


    public static void main(String[] args) 
    {
        MainMenu mainMenu = new MainMenu();
        mainMenu.displayMenu();
    }
}