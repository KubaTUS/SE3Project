package tests;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Comparator;

import Exceptions.TaskExceptionHandler;
import junit.framework.TestCase;
import proj.Task;
import proj.TaskManager;

public class TaskManagerTest extends TestCase 
{

    private TaskManager taskManager;

    protected void setUp() throws Exception 
    {
        super.setUp();
        taskManager = new TaskManager();

    }
    
    /**
 	 * Test #31
 	 * Objective: Verify Tasks sorted by Priority are returned by highest priority.
 	 * Input:
 	 * new Task("Low Priority", "Not Important", 1, LocalDate.of(2025, 1, 15))
 	 * new Task("High Priority", "Important", 3, LocalDate.of(2025, 12, 31))
 	 * new Task("Medium Priority", "Less Important", 2, LocalDate.of(2025, 1, 30))
 	 * Output: High Priority, Medium Priority and Low Priority (in order of the tasks list.)
 	 */

    public void testSortByPriority() throws TaskExceptionHandler 
    {
        taskManager.addTask(new Task("Low Priority", "Not Important", 1, LocalDate.of(2025, 1, 15)));
        taskManager.addTask(new Task("High Priority", "Important", 3, LocalDate.of(2025, 12, 31)));
        taskManager.addTask(new Task("Medium Priority", "Less Important", 2, LocalDate.of(2025, 1, 30)));
        taskManager.tasks.sort(Comparator.comparingInt(Task::getPrioritylevel).reversed());
        assertEquals("High Priority", taskManager.tasks.get(0).getTitle());
        assertEquals("Medium Priority", taskManager.tasks.get(1).getTitle());
        assertEquals("Low Priority", taskManager.tasks.get(2).getTitle());
    }
    
    /**
 	 * Test #32
 	 * Objective: Verify Tasks sorted by Due Date are returned by nearest due date.
 	 * Input:
 	 * new Task("Low Priority", "Not Important", 1, LocalDate.of(2025, 1, 15))
 	 * new Task("High Priority", "Important", 3, LocalDate.of(2025, 12, 31))
 	 * new Task("Medium Priority", "Less Important", 2, LocalDate.of(2025, 1, 30))
 	 * Output: Low Priority, Medium Priority andHigh Priority (in order of the tasks list.)
 	 */

    public void testSortByDueDate() throws TaskExceptionHandler 
    {
        taskManager.addTask(new Task("Low Priority", "Not Important", 1, LocalDate.of(2025, 1, 15)));
        taskManager.addTask(new Task("High Priority", "Important", 3, LocalDate.of(2025, 12, 31)));
        taskManager.addTask(new Task("Medium Priority", "Less Important", 2, LocalDate.of(2025, 1, 30)));
        taskManager.tasks.sort(Comparator.comparing(Task::getDuedate));
        assertEquals("Low Priority", taskManager.tasks.get(0).getTitle());
        assertEquals("Medium Priority", taskManager.tasks.get(1).getTitle());
        assertEquals("High Priority", taskManager.tasks.get(2).getTitle());
    }
    
    /**
 	 * Test #33
 	 * Objective: Verify if a task has been created that it has been added to the list.
 	 * Input: new Task("Test Task", "Test Description", 1, LocalDate.now()
 	 * Output: List contains two tasks.
 	 */

    public void testListTasksWithTasks() throws TaskExceptionHandler 
    {
        taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
        taskManager.addTask(new Task("Test Task Two", "Test Description", 1, LocalDate.now()));
        taskManager.listTasks();
        assertEquals(2, taskManager.tasks.size());
    }
    
    /**
 	 * Test #34
 	 * Objective: Verify that if the list has no tasks, nothing is listed.
 	 * Input: N/A
 	 * Output: Task list size is 0.
 	 */

    public void testListTasksEmpty() 
    {
        taskManager.listTasks();
        assertEquals(0, taskManager.tasks.size());
    }
    
    /**
 	 * Test #35
 	 * Objective: Verify that if updating a task that is valid then that it is infact saved.
 	 * Input: 
 	 * taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
 	 * Task taskUpdated = new Task("Updated Task", "Test Description", 1, LocalDate.now());
 	 * Output: Task with old details now becomes the task with new details.
 	 */
    
    public void testUpdateTask() throws TaskExceptionHandler 
    {
    	taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
    	Task taskUpdated = new Task("Updated Task", "Test Description", 1, LocalDate.now());
    	taskManager.updateTask(0, taskUpdated);
    	assertEquals("Updated Task", taskManager.tasks.get(0).getTitle());
    }
    
    /**
 	 * Test #36
 	 * Objective: Verify that task cannot be updated if a field is invalid.
 	 * Input: 
 	 * taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
 	 * Task invalidTask = new Task("Updated 55", "Test Description", 1, LocalDate.now());
 	 * Output: Task with "Test Task" title isn't overridden by "Updated 55" title task.
 	 */

    public void testUpdateTaskWithInvalidData() 
    {
        try 
        {
            taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
            Task invalidTask = new Task("Updated 55", "Test Description", 1, LocalDate.now());
            taskManager.updateTask(0, invalidTask);
            fail("Expected TaskExceptionHandler not thrown");
        }
        
        catch (TaskExceptionHandler e) 
        {
            assertTrue(e.getMessage().contains("Invalid title"));
            assertEquals("Test Task", taskManager.tasks.get(0).getTitle());
        }
    }
    
    /**
 	 * Test #37
 	 * Objective: Verify that a task is deleted from the list if it has been chosen to.
 	 * Input: 
 	 * taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
 	 * taskManager.deleteTask(0);
 	 * Output: Task list size is 0.
 	 */

    public void testDeleteTask() throws TaskExceptionHandler 
    {
            taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
            taskManager.deleteTask(0);
            assertEquals(0, taskManager.tasks.size());
    }
    
    /**
 	 * Test #38
 	 * Objective: Verify that error message "Invalid task index" is returned if an attempt to delete a non existant task is made.
 	 * Input: 
 	 * taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
 	 * taskManager.deleteTask(0);
 	 * Output: Task size is 1.
 	 */
    
    public void testDeleteNonExistantTask() 
    {
        try 
        {
            taskManager.addTask(new Task("Test Task", "Test Description", 1, LocalDate.now()));
            

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));
            

            taskManager.deleteTask(1);
            

            String output = outputStream.toString().trim();
            assertTrue(output.contains("Invalid task index."));
            

            System.setOut(originalOut);
        } 
        catch (TaskExceptionHandler e) 
        {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}