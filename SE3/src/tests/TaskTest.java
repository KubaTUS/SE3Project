package tests;
import junit.framework.TestCase;
import proj.Task;

public class TaskTest extends TestCase 
{

	
    /**
	 * Test #1
	 * Objective: Verify Valid Title returns true.
	 * Input: String title = "Read" (4 CHARS = MIN CHARS)
	 * Output: True
	 */
	
    public void testValidTitle() {
    	try {
    	Task task  = new Task ();
    	String title = "Read";
    	assertTrue(Task.isValidTitle(title));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    /**
	 * Test #2
	 * Objective: Verify Valid Title returns true.
	 * Input: String title = "Go Swimming" (11 CHARS = IN-RANGE)
	 * Output: True
	 */
	
    public void testValidTitle2() {
    	try {
    	Task task  = new Task ();
    	String title = "Read";
    	assertTrue(Task.isValidTitle(title));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    /**
	 * Test #3
	 * Objective: Verify Valid Title returns true.
	 * Input: String title = "Finish Harry Potter." (20 CHARS = MAX CHARS)
	 * Output: True
	 */
	
    public void testValidTitle3() {
    	try {
    	Task task  = new Task ();
    	String title = "Finish Harry Potter.";
    	assertTrue(Task.isValidTitle(title));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    /**
	 * Test #4
	 * Objective: Verify Invalid title returns false.
	 * Input: String title = "" (0 Chars < MIN CHARS)
	 * Output: False
	 */
	
    public void testInvalidTitle() {
    	try {
    	Task task  = new Task ();
    	String title = "";
    	assertFalse(Task.isValidTitle(title));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    /**
	 * Test #5
	 * Objective: Verify Invalid title returns false.
	 * Input: String title = "Go play football with friends."  (30 Chars > MAX CHARS)
	 * Output: False
	 */
	
    public void testInvalidTitle2() {
    	try {
    	Task task  = new Task ();
    	String title = "Go play football with friends.";
    	assertFalse(Task.isValidTitle(title));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
	

	
	
}
