package tests;
import java.time.LocalDate;

import Exceptions.TaskExceptionHandler;
import junit.framework.TestCase;
import proj.Task;

public class TaskTest extends TestCase 
{

	
    /**
	 * Test #1
	 * Objective: Verify TITLE value being NULL is not accepted and returns an error message.
	 * Input: String title = ""
	 * Output: False
	 */
	
	public void testInvalidTitle1() throws TaskExceptionHandler 
	{
    	String title = "";
    	assertEquals(false, Task.isValidTitle(title));
    }
    
    
    
    /**
	 * Test #2
	 * Objective: Verify TITLE value being 3 characters is not accepted and returns an error message.
	 * Input: String title = "AaA"
	 * Output: False
	 */
	
	public void testInvalidTitle2() throws TaskExceptionHandler 
	{
    	String title = "AaA";
    	assertEquals(false, Task.isValidTitle(title));
    }
    
    
    
    /**
	 * Test #3
	 * Objective: Verify TITLE value being 4 characters is accepted.
	 * Input: String title = "AaAa"
	 * Output: True
	 */
	
	public void testValidTitle1() throws TaskExceptionHandler 
	{
    	String title = "AaAa";
    	assertEquals(true, Task.isValidTitle(title));
    }
    
    
    
    /**
	 * Test #4
	 * Objective: Verify TITLE value being 8 characters is accepted.
	 * Input: String title = "AaAaBbBb"
	 * Output: True
	 */
	
	public void testValidTitle2() throws TaskExceptionHandler 
	{
    	String title = "AaAaBbBb";
    	assertEquals(true, Task.isValidTitle(title));
    }
    
    
    
    /**
	 * Test #5
	 * Objective: Verify TITLE value being 20 characters is accepted.
	 * Input: String title = "AaAaBbBbCcCcDdDdEeEe"
	 * Output: True
	 */
	
	public void testValidTitle3() throws TaskExceptionHandler 
	{
    	String title = "AaAaBbBbCcCcDdDdEeEe";
    	assertEquals(true, Task.isValidTitle(title));
    }
    
    /**
	 * Test #6
	 * Objective: Verify TITLE value being 21 characters is not accepted and returns an error message.	
	 * Input: String title = "AaAaBbBbCcCcDdDdEeEeF"
	 * Output: False
	 */
	
	public void testValidTitle4() throws TaskExceptionHandler 
	{
    	String title = "AaAaBbBbCcCcDdDdEeEeF";
    	assertEquals(false, Task.isValidTitle(title));
    }
    
	

	
    /**
	 * Test #7
	 * Objective: Verify DESCRIPTION value being NULL is not accepted and returns an error message.
	 * Input: String description = ""
	 * Output: False
	 */
    
	public void testInvalidDescription1() throws TaskExceptionHandler 
	{
    	String description = "";
    	assertEquals(false, Task.isValidDescription(description));
    }
    
    
    
    
    /**
	 * Test #8
	 * Objective: Verify DESCRIPTION value being 3 characters is not accepted and returns an error message.
	 * Input: String description = "AaA"
	 * Output: False
	 */
    
	public void testInvalidDescription2() throws TaskExceptionHandler 
	{
    	String description = "AaA";
    	assertEquals(false, Task.isValidDescription(description));
    }
    
    
    
    /**
	 * Test #9
	 * Objective: Verify DESCRIPTION value being 4 characters is accepted.
	 * Input: String description = "AaAa"
	 * Output: True
	 */
    
	public void testValidDescription1() throws TaskExceptionHandler 
	{
    	String description = "AaAa";
    	assertEquals(true, Task.isValidDescription(description));
    }
    
    
    
    /**
	 * Test #10
	 * Objective: Verify DESCRIPTION value being 8 characters is accepted.
	 * Input: String description = "AaAaBbBb"
	 * Output: True
	 */
    
	public void testValidDescription2() throws TaskExceptionHandler 
	{
    	String description = "AaAaBbBb";
    	assertEquals(true, Task.isValidDescription(description));
    }
    
    
    
    /**
	 * Test #11
	 * Objective: Verify DESCRIPTION value being 40 characters is accepted.
	 * Input: String description = "AaAaBbBbCcCcDdDdEeEeFfFfGgGgHhHhIiIiJjJj"
	 * Output: True
	 */
    
	public void testValidDescription3() throws TaskExceptionHandler 
	{
    	String description = "AaAaBbBbCcCcDdDdEeEeFfFfGgGgHhHhIiIiJjJj";
    	assertEquals(true, Task.isValidDescription(description));
    }
    
    /**
	 * Test #12
	 * Objective: Verify DESCRIPTION value being 41 characters is not accepted and returns an error message.
	 * Input: String description = ""  (NULL CHARS)
	 * Output: False
	 */
	
	public void testInvalidDescription3() throws TaskExceptionHandler 
	{
    	String description = "AaAaBbBbCcCcDdDdEeEeFfFfGgGgHhHhIiIiJjJjK";
    	assertEquals(false, Task.isValidDescription(description));
    }
    
    /**
 	 * Test #13
 	 * Objective: Verify the due date being a day before the minimum due date is not accepted.
 	 * Input: LocalDate duedate = LocalDate.now().minusDays(1);
 	 * Output: True
 	 */
     
	public void testInvalidDueDate1() throws TaskExceptionHandler 
	{
		LocalDate duedate = LocalDate.now().minusDays(1);
    	assertEquals(false, Task.isValidDate(duedate));
    }
     
     
     
     /**
  	 * Test #14
  	 * Objective: Verify the due date being the current date is accepted.
  	 * Input: LocalDate duedate = LocalDate.now();
  	 * Output: True
  	 */
      
	public void testValidDueDate1() throws TaskExceptionHandler 
	{
		LocalDate duedate = LocalDate.now();
    	assertEquals(true, Task.isValidDate(duedate));
    }
      
    /**
 	 * Test #15
 	 * Objective: Verify the due date being the current date + 1 day is accepted.
 	 * Input: LocalDate duedate = LocalDate.now().plusDays(1);
 	 * Output: True
 	 */
        
	public void testValidDueDate2() throws TaskExceptionHandler 
	{
		LocalDate duedate = LocalDate.now().plusDays(1);
    	assertEquals(true, Task.isValidDate(duedate));
    }
        
    /**
 	 * Test #16
 	 * Objective: Verify the due date being the current date + 150 years (max date) is accepted.
 	 * Input: LocalDate duedate = LocalDate.now().plusYears(150);
 	 * Output: True
 	 */
          
	public void testValidDueDate3() throws TaskExceptionHandler 
	{
		LocalDate duedate = LocalDate.now().plusYears(150);
    	assertEquals(true, Task.isValidDate(duedate));
    }
	
    /**
 	 * Test #17
 	 * Objective: Verify the due date being a day past the max date is not accepted.
 	 * Input: LocalDate duedate = LocalDate.now().plusYears(150).plusDays(1);
 	 * Output: True
 	 */
	
	public void testInvalidDueDate2() throws TaskExceptionHandler 
	{
		LocalDate duedate = LocalDate.now().plusYears(150).plusDays(1);
    	assertEquals(false, Task.isValidDate(duedate));
    }
	
	
    /**
 	 * Test #18
 	 * Objective: Verify priority level being below the minimum priority level is not accepted.
 	 * Input: int num = 0;
 	 * Output: False
 	 */
	
	public void testInvalidPriorityLevel1() throws TaskExceptionHandler 
	{
		int num = 0;
		assertEquals(false, Task.isValidPriorityLevel(num));
    }
	
    /**
 	 * Test #19
 	 * Objective: Verify Priority Level being 1 is accepted.
 	 * Input: int num = 1;
 	 * Output: True
 	 */
	
	public void testValidPriorityLevel1() throws TaskExceptionHandler 
	{
		int num = 1;
		assertEquals(true, Task.isValidPriorityLevel(num));
    }
	
    /**
 	 * Test #20
 	 * Objective: Verify Priority Level being 2 is accepted.
 	 * Input: int num = 2;
 	 * Output: True
 	 */
	
	public void testValidPriorityLevel2() throws TaskExceptionHandler 
	{
		int num = 2;
		assertEquals(true, Task.isValidPriorityLevel(num));
    }
	
    /**
 	 * Test #21
 	 * Objective: Verify Priority Level being 3 is accepted.
 	 * Input: int num = 3;
 	 * Output: True
 	 */
	
	public void testValidPriorityLevel3() throws TaskExceptionHandler 
	{
		int num = 3;
		assertEquals(true, Task.isValidPriorityLevel(num));
    }
	
    /**
 	 * Test #22
 	 * Objective: Verify Priority Level is between 1 and 3 inclusive.
 	 * Input: int num = 4;
 	 * Output: False
 	 */
	
	public void testInvalidPriorityLevel2() throws TaskExceptionHandler 
	{
		int num = 4;
		assertEquals(false, Task.isValidPriorityLevel(num));
    }
	
    /**
 	 * Test #23
 	 * Objective: Verify Task object can be created with all valid parameters.
 	 * Input: Task t1 = new Task("Title","Description",2,2029-01-01);
 	 * Output: False
 	 */
	
	public void testValidObject1() throws TaskExceptionHandler 
	{
		LocalDate dueDate = LocalDate.of(2029, 1, 1);
		Task task = new Task("title", "description", 2, dueDate);
		assertNotNull(task);
    }
	
    /**
 	 * Test #24
 	 * Objective: Verify Title containing an integer returns false.
 	 * Input: title = "aAaA1"
 	 * Output: False
 	 */
	
	public void testInvalidTitle3() throws TaskExceptionHandler 
	{
		String title = "AaAa1";
		assertEquals(false, Task.isValidTitle(title));
    }
	
    /**
 	 * Test #25
 	 * Objective: Verify Title containing a symbol returns false.
 	 * Input: title = "aAaA*"
 	 * Output: False
 	 */
	
	public void testInvalidTitle4() throws TaskExceptionHandler 
	{
		String title = "AaAa*";
		assertEquals(false, Task.isValidTitle(title));
    }
	
    /**
 	 * Test #26
 	 * Objective: Verify Priority Level containing a symbol returns false.
 	 * Input: char symbol = "*"
 	 * Output: False
 	 */
	
	public void testInvalidPriorityLevel3() throws TaskExceptionHandler 
	{
		char symbol = '*';
		assertEquals(false, Task.isValidPriorityLevel(symbol));
    }
	
    /**
 	 * Test #27
 	 * Objective: Verify Priority Level containing a character returns false.
 	 * Input: char chara = "A"
 	 * Output: False
 	 */
	
	public void testInvalidTitle5() throws TaskExceptionHandler 
	{
		char chara = 'A';
		assertEquals(false, Task.isValidPriorityLevel(chara));
    }
	
}