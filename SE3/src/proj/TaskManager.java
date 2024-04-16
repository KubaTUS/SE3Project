package proj;

import java.util.ArrayList;
import java.util.List;

public class TaskManager 
{
    List<Task> tasks;

    public TaskManager() 
    {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) 
    {
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void listTasks() 
    {
        if (tasks.isEmpty()) 
        {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("List of Tasks:");
        for (int i = 0; i < tasks.size(); i++) 
        {
            System.out.println((i + 1) + ". " + tasks.get(i).getTitle());
        }
    }

    public void updateTask(int index, Task updatedTask) 
    {
        if (index >= 0 && index < tasks.size()) 
        {
            tasks.set(index, updatedTask);
            System.out.println("Task updated successfully.");
        } 
        
        else 
        {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int index) 
    {
        if (index >= 0 && index < tasks.size()) 
        {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } 
        
        else 
        {
            System.out.println("Invalid task index.");
        }
    }
}