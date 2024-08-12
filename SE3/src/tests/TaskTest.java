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
		Task t1 = new Task();
		t1.setTitle("");
		String title = t1.getTitle();
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
		Task t1 = new Task();
		t1.setTitle("AaA");
		String title = t1.getTitle();
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
		Task t1 = new Task();
		t1.setTitle("AaAa");
		String title = t1.getTitle();
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
		Task t1 = new Task();
		t1.setTitle("AaAaBbBb");
		String title = t1.getTitle();
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
		Task t1 = new Task();
		t1.setTitle("AaAaBbBbCcCcDdDdEeEe");
		String title = t1.getTitle();
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
		Task t1 = new Task();
		t1.setTitle("AaAaBbBbCcCcDdDdEeEeF");
		String title = t1.getTitle();
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
		Task t1 = new Task();
		t1.setDescription("");
		String description = t1.getDescription();
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
		Task t1 = new Task();
		t1.setDescription("AaA");
		String description = t1.getDescription();
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
		Task t1 = new Task();
		t1.setDescription("AaAa");
		String description = t1.getDescription();
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
		Task t1 = new Task();
		t1.setDescription("AaAaBbBb");
		String description = t1.getDescription();
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
		Task t1 = new Task();
		t1.setDescription("AaAaBbBbCcCcDdDdEeEeFfFfGgGgHhHhIiIiJjJj");
		String description = t1.getDescription();
    	assertEquals(true, Task.isValidDescription(description));
    }
    
    /**
	 * Test #12
	 * Objective: Verify DESCRIPTION value being 41 characters is not accepted and returns an error message.
	 * Input: String description = "AaAaBbBbCcCcDdDdEeEeFfFfGgGgHhHhIiIiJjJjK"
	 * Output: False
	 */
	
	public void testInvalidDescription3() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setDescription("AaAaBbBbCcCcDdDdEeEeFfFfGgGgHhHhIiIiJjJjK");
		String description = t1.getDescription();
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
		Task t1 = new Task();
		t1.setDuedate(LocalDate.now().minusDays(1));
		LocalDate dueD = t1.getDuedate();
    	assertEquals(false, Task.isValidDate(dueD));
    }
     
     
     
     /**
  	 * Test #14
  	 * Objective: Verify the due date being the current date is accepted.
  	 * Input: LocalDate duedate = LocalDate.now();
  	 * Output: True
  	 */
      
	public void testValidDueDate1() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setDuedate(LocalDate.now());
		LocalDate dueD = t1.getDuedate();
    	assertEquals(true, Task.isValidDate(dueD));
    }
      
    /**
 	 * Test #15
 	 * Objective: Verify the due date being the current date + 1 day is accepted.
 	 * Input: LocalDate duedate = LocalDate.now().plusDays(1);
 	 * Output: True
 	 */
        
	public void testValidDueDate2() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setDuedate(LocalDate.now().plusDays(1));
		LocalDate dueD = t1.getDuedate();
    	assertEquals(true, Task.isValidDate(dueD));
    }
        
    /**
 	 * Test #16
 	 * Objective: Verify the due date being the current date + 150 years (max date) is accepted.
 	 * Input: LocalDate duedate = LocalDate.now().plusYears(150);
 	 * Output: True
 	 */
          
	public void testValidDueDate3() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setDuedate(LocalDate.now().plusYears(150));
		LocalDate dueD = t1.getDuedate();
    	assertEquals(true, Task.isValidDate(dueD));
    }
	
    /**
 	 * Test #17
 	 * Objective: Verify the due date being a day past the max date is not accepted.
 	 * Input: LocalDate duedate = LocalDate.now().plusYears(150).plusDays(1);
 	 * Output: True
 	 */
	
	public void testInvalidDueDate2() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setDuedate(LocalDate.now().plusYears(150).plusDays(1));
		LocalDate dueD = t1.getDuedate();
    	assertEquals(false, Task.isValidDate(dueD));
    }
	
	
    /**
 	 * Test #18
 	 * Objective: Verify priority level being below the minimum priority level is not accepted.
 	 * Input: int num = 0;
 	 * Output: False
 	 */
	
	public void testInvalidPriorityLevel1() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setPrioritylevel(0);
		int pl = t1.getPrioritylevel();
    	assertEquals(false, Task.isValidPriorityLevel(pl));
    }
	
    /**
 	 * Test #19
 	 * Objective: Verify Priority Level being 1 is accepted.
 	 * Input: int num = 1;
 	 * Output: True
 	 */
	
	public void testValidPriorityLevel1() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setPrioritylevel(1);
		int pl = t1.getPrioritylevel();
    	assertEquals(true, Task.isValidPriorityLevel(pl));
    }
	
    /**
 	 * Test #20
 	 * Objective: Verify Priority Level being 2 is accepted.
 	 * Input: int num = 2;
 	 * Output: True
 	 */
	
	public void testValidPriorityLevel2() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setPrioritylevel(2);
		int pl = t1.getPrioritylevel();
    	assertEquals(true, Task.isValidPriorityLevel(pl));
    }
	
    /**
 	 * Test #21
 	 * Objective: Verify Priority Level being 3 is accepted.
 	 * Input: int num = 3;
 	 * Output: True
 	 */
	
	public void testValidPriorityLevel3() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setPrioritylevel(3);
		int pl = t1.getPrioritylevel();
    	assertEquals(true, Task.isValidPriorityLevel(pl));
    }
	
    /**
 	 * Test #22
 	 * Objective: Verify Priority Level is between 1 and 3 inclusive.
 	 * Input: int num = 4;
 	 * Output: False
 	 */
	
	public void testInvalidPriorityLevel2() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setPrioritylevel(4);
		int pl = t1.getPrioritylevel();
    	assertEquals(false, Task.isValidPriorityLevel(pl));
    }
	
    /**
 	 * Test #23
 	 * Objective: Verify Task object can be created with all valid parameters.
 	 * Input: Task t1 = new Task("Title","Description",2,2029-01-01);
 	 * Output: False
 	 */
	
	public void testValidObject1() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setTitle("AaAa");
		t1.setDescription("AaAa");
		t1.setPrioritylevel(2);
		t1.setDuedate(LocalDate.now());
		int pl = t1.getPrioritylevel();
    	assertEquals(true, Task.isValidObject(t1));
    }
	
    /**
 	 * Test #24
 	 * Objective: Verify Title containing an integer returns false.
 	 * Input: title = "aAaA1"
 	 * Output: False
 	 */
	
	public void testInvalidTitle3() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setTitle("aAaA1");
		String pl = t1.getTitle();
    	assertEquals(false, Task.isValidTitle(pl));
    }
	
    /**
 	 * Test #25
 	 * Objective: Verify Title containing a symbol returns false.
 	 * Input: title = "aAaA*"
 	 * Output: False
 	 */
	
	public void testInvalidTitle4() throws TaskExceptionHandler 
	{
		Task t1 = new Task();
		t1.setTitle("aAaA*");
		String pl = t1.getTitle();
    	assertEquals(false, Task.isValidTitle(pl));
    }
	
    /**
 	 * Test #26
 	 * Objective: Verify Priority Level containing a symbol returns false.
 	 * Input: char symbol = "*"
 	 * Output: False
 	 * CAN'T USE OBJECT AS IT DOESN'T TAKE A CHAR.
 	 */
	
	public void testInvalidPriorityLevel3() throws TaskExceptionHandler 
	{
		char symbol = '*';
		assertEquals(false, Task.isValidPriorityLevel(symbol));
    }
	
    /**
 	 * Test #27
 	 * Objective: Verify Task cannot be created with an invalid Title value.
 	 * Input: title = "" description = "AaAa" priority = 2 duedate = 20/01/2029
 	 * Output: False
 	 */
	
	public void testInvalidPriorityLevel4() {
		char symbol = 'A';
		assertEquals(false, Task.isValidPriorityLevel(symbol));
    }
	
    /**
 	 * Test #28
 	 * Objective: Verify Task cannot be created with an invalid Title value.
 	 * Input: title = "" description = "AaAa" priority = 2 duedate = 20/01/2029
 	 * Output: False
 	 */
	
	public void testInvalidObject1() {
        boolean result = true;
        
        try 
        {
            Task t1 = new Task("", "AaAa", 2, LocalDate.of(2029, 1, 20));
        } 
        catch (TaskExceptionHandler e) 
        {
            result = false;
        }
        assertEquals(false, result);
    }
	
    /**
 	 * Test #29
 	 * Objective: Verify Task cannot be created with an invalid Description value.
 	 * Input: title = "AaAa" description = "" priority = 2 duedate = 20/01/2029
 	 * Output: False
 	 */
	
	public void testInvalidObject2() {
        boolean result = true;
        
        try 
        {
            Task t1 = new Task("AaAa", "", 2, LocalDate.of(2029, 1, 20));
        } 
        catch (TaskExceptionHandler e) 
        {
            result = false;
        }
        assertEquals(false, result);
    }
	
    /**
 	 * Test #30
 	 * Objective: Verify Task cannot be created with an invalid priority level value.
 	 * Input: title = "AaAa" description = "AaAa" priority = 4 duedate = 20/01/2029
 	 * Output: False
 	 */
	
	public void testInvalidObject3() {
        boolean result = true;
        
        try 
        {
            Task t1 = new Task("AaAa", "AaAa", 4, LocalDate.of(2029, 1, 20));
        } 
        catch (TaskExceptionHandler e) 
        {
            result = false;
        }
        assertEquals(false, result);
    }
	
    /**
 	 * Test #31
 	 * Objective: Verify Task cannot be created with an invalid due date value.
 	 * Input: title = "AaAa" description = "AaAa" priority = 2 duedate = 20/01/2019
 	 * Output: False
 	 */
	
	public void testInvalidObject4() {
        boolean result = true;
        
        try 
        {
            Task t1 = new Task("AaAa", "AaAa", 2, LocalDate.of(2019, 1, 20));
        } 
        catch (TaskExceptionHandler e) 
        {
            result = false;
        }
        assertEquals(false, result);
    }

	   
}