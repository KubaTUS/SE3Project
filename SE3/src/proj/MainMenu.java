package proj;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;

import Exceptions.TaskExceptionHandler;

public class MainMenu 
{
    private TaskManager taskManager;
    private static Scanner sc = new Scanner(System.in);

    public MainMenu() 
    {
        this.taskManager = new TaskManager();
    }

    public void displayMenu() 
    {
        int choice = 0;
        while (choice != 6) { // Menu will keep looping until choice 6 is selected (Exit)
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Update a Task");
            System.out.println("4. Delete a Task");
            System.out.println("5. Mark Task as Complete"); // New option
            System.out.println("6. Exit"); // Updated exit option

            System.out.print("Enter your choice: ");
            try 
            {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) 
                {
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
                        markTaskAsComplete(); // Handle task completion
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear the buffer
            }
        }
        sc.close();
    }

    private void createTask() throws TaskExceptionHandler
    {
        System.out.println("");
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
                    throw new IllegalArgumentException("Title must be between 4 and 20 characters and contain at least 4 letters with no numbers.");
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
                System.out.print("Enter description: ");
                description = sc.nextLine();
                if (!Task.isValidDescription(description)) 
                {
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
                System.out.println("Invalid input: Priority level must be between 1 and 3.");
                sc.nextLine();
            }
        }

        while (true) 
        {
            try 
            {
                System.out.print("Enter due date (YYYY-MM-DD): ");
                LocalDate currentDate = LocalDate.now();
                LocalDate maxDate = currentDate.plusYears(150);
                dueDate = LocalDate.parse(sc.next());
                if (!Task.isValidDate(dueDate)) 
                {
                    throw new IllegalArgumentException("Due date must be between " + currentDate + " and " + maxDate + ".");
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
        if (taskManager.tasks.isEmpty()) 
        {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("");
        System.out.println("Sort by:");
        System.out.println("1. Highest Priority Level");
        System.out.println("2. Soonest Due Date");
        System.out.println("3. No Filter");

        int sortChoice = 0;
        while (true) 
        {
            try 
            {
            	System.out.println("");
                System.out.print("Enter your choice: ");
                sortChoice = sc.nextInt();
                sc.nextLine();

                switch (sortChoice) 
                {
                    case 1:
                    	System.out.println("");
                        taskManager.tasks.sort(Comparator.comparingInt(Task::getPrioritylevel).reversed());
                        break;
                    case 2:
                    	System.out.println("");
                        taskManager.tasks.sort(Comparator.comparing(Task::getDuedate));
                        break;
                    case 3:
                        // Returning results without filter.
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 3.");
                        continue;
                }
                break;

            } 
            catch (Exception e) 
            {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
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

    private void updateTask() throws TaskExceptionHandler
    {
        System.out.println("\nUpdating a task:");
        listTasks();
        System.out.print("Enter the index of the task to update: ");
        int index = sc.nextInt() - 1; // Adjust index to start from 0
        sc.nextLine();
        if (index >= 0 && index < taskManager.tasks.size()) 
        {
            Task taskToUpdate = taskManager.tasks.get(index);
            String title = taskToUpdate.getTitle();
            String description = taskToUpdate.getDescription();
            int priorityLevel = taskToUpdate.getPrioritylevel();
            LocalDate dueDate = taskToUpdate.getDuedate();

            while (true) 
            {
                try 
                {
                    System.out.print("Enter new title: ");
                    title = sc.nextLine();
                    if (!Task.isValidTitle(title)) 
                    {
                        throw new IllegalArgumentException("Title must be between 4 and 20 characters and must contain no numbers or symbols.");
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
                    System.out.print("Enter new description: ");
                    description = sc.nextLine();
                    if (!Task.isValidDescription(description)) 
                    {
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
                    System.out.print("Enter new priority level (1-3): ");
                    priorityLevel = sc.nextInt();
                    if (!Task.isValidPriorityLevel(priorityLevel)) 
                    {
                        throw new IllegalArgumentException("Priority level must be between 1 and 3.");
                    }
                    break;
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("Invalid input: Priority level must be a number between 1 and 3.");
                    sc.nextLine();
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
                    System.out.print("Enter new due date (YYYY-MM-DD): ");
                    dueDate = LocalDate.parse(sc.next());
                    if (!Task.isValidDate(dueDate)) 
                    {
                        throw new IllegalArgumentException("Due date must be between today and 150 years.");
                    }
                    break;
                } 
                catch (DateTimeParseException e) 
                {
                	if (e.getMessage().contains("could not be parsed:")) 
                	{
                        System.out.println("Invalid input: " + e.getMessage());
                    } 
                	else 
                    {
                        System.out.println("Invalid input: Please enter date in valid format YYYY-MM-DD");
                    }
                    sc.nextLine();
                }
                
                catch (Exception e) 
                {
                    System.out.println("Invalid input: " + e.getMessage());
                    sc.nextLine();
                }
            }

            Task updatedTask = new Task(title, description, priorityLevel, dueDate);
            taskManager.updateTask(index, updatedTask);
        } 
        else 
        {
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
    
    private void markTaskAsComplete() 
    {
        System.out.println("\nMarking a task as complete:");
        listTasks();
        System.out.print("Enter the index of the task to mark as complete: ");
        try {
            int index = sc.nextInt() - 1;
            sc.nextLine();
            if (index >= 0 && index < taskManager.tasks.size()) 
            {
                Task taskToComplete = taskManager.tasks.get(index);
                taskToComplete.setTitle(taskToComplete.getTitle() + " - COMPLETED");
                System.out.println("Task marked as complete.");
            } 
            else 
            {
                System.out.println("Invalid task index.");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Invalid input. Please enter a valid task index.");
            sc.nextLine();
        }
    }


    public static void main(String[] args)
    {
    	
        MainMenu mainMenu = new MainMenu();
        mainMenu.displayMenu();
    }
}
