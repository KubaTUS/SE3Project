package tests;
import java.time.LocalDate;

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
	 * Input: String title = "A" (1 Chars < MIN CHARS. EDGE TEST CASE.)
	 * Output: False
	 */
	
    public void testInvalidTitle() {
    	try {
    	String title = "A";
    	assertFalse(Task.isValidTitle(title));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    /**
	 * Test #5
	 * Objective: Verify Invalid title returns false.
	 * Input: String title = "Go buy some footballs"  (21 Chars > MAX CHARS. EDGE TEST CASE.)
	 * Output: False
	 */
	
    public void testInvalidTitle2() {
    	try {
    	String title = "Go buy some footballs";
    	assertFalse(Task.isValidTitle(title));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
	

	
    /**
	 * Test #6
	 * Objective: Verify Valid description returns true.
	 * Input: String description = "Blue"  (4 Chars = MIN CHARS)
	 * Output: True
	 */
    
    public void testValidDescription1() {
    	try {
    	String description = "Blue";
    	assertTrue(Task.isValidDescription(description));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    
    /**
	 * Test #7
	 * Objective: Verify Valid description returns true.
	 * Input: String description = "52 Dublin Street, collect package"  (33 Chars = IN-RANGE CHARS)
	 * Output: True
	 */
    
    public void testValidDescription2() {
    	try {
    	String description = "52 Dublin Street, collect package";
    	assertTrue(Task.isValidDescription(description));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    /**
	 * Test #8
	 * Objective: Verify Valid description returns true.
	 * Input: String description = "Visit Jason and Samantha in the hospital"  (40 Chars = MAX CHARS)
	 * Output: True
	 */
    
    public void testValidDescription3() {
    	try {
    	String description = "Visit Jason and Samantha in the hospital";
    	assertTrue(Task.isValidDescription(description));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    /**
	 * Test #9
	 * Objective: Verify Invalid description returns false.
	 * Input: String description = ""  (0 CHARS < MIN CHARS)
	 * Output: False
	 */
    
    public void testInvalidDescription1() {
    	try {
    	String description = "";
    	assertFalse(Task.isValidDescription(description));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    
    
    /**
	 * Test #10
	 * Objective: Verify Invalid description returns false.
	 * Input: String description = "Pick Samantha and Jason up from the hospital"  (44 CHARS > MAX CHARS)
	 * Output: False
	 */
    
    public void testInvalidDescription2() {
    	try {
    	String description = "Pick Samantha and Jason up from the hospital";
    	assertFalse(Task.isValidDescription(description));
    	} catch (Exception e) 
    	{
        fail("Exception NOT expected.");
    	}
    }
    
    /**
 	 * Test #11
 	 * Objective: Verify Valid due date returns true
 	 * Input: LocalDate duedate = LocalDate.now();  (DATE IS TODAY = MINIMUM)
 	 * Output: True
 	 */
     
     public void testValidDueDate1() {
     	try {
     	LocalDate duedate = LocalDate.now();
     	assertTrue(Task.isValidDate(duedate));
     	} catch (Exception e) 
     	{
         fail("Exception NOT expected.");
     	}
     }
     
     
     
     /**
  	 * Test #12
  	 * Objective: Verify Valid due date returns true
  	 * Input: LocalDate duedate = currentDate.plusYears(3);  (DATE IS IN THE FUTURE = IN-RANGE)
  	 * Output: True
  	 */
      
      public void testValidDueDate2() {
      	try {
      	LocalDate currentDate = LocalDate.now();
      	LocalDate duedate = currentDate.plusYears(3);
      	assertTrue(Task.isValidDate(duedate));
      	} catch (Exception e) 
      	{
          fail("Exception NOT expected.");
      	}
      }
      
      /**
    	 * Test #13
    	 * Objective: Verify Valid due date returns true
    	 * Input: LocalDate duedate = currentDate.plusYears(150);  (DATE IS CURRENT DATE + 150 YEARS = MAX DATE)
    	 * Output: True
    	 */
        
        public void testValidDueDate3() {
        	try {
        	LocalDate currentDate = LocalDate.now();
            LocalDate duedate = currentDate.plusYears(150);
            assertTrue(Task.isValidDate(duedate));
        	} catch (Exception e) 
        	{
            fail("Exception NOT expected.");
        	}
        }
        
        /**
      	 * Test #14
      	 * Objective: Verify Invalid due date returns true
      	 * Input: LocalDate duedate = currentDate.minusYears(1);  (DUE DATE IS BEFORE THE MINIMUM DATE)
      	 * Output: False
      	 */
          
          public void testInvalidDueDate1() {
          	try {
          	LocalDate currentDate = LocalDate.now();
          	LocalDate duedate = currentDate.minusYears(1);
          	assertFalse(Task.isValidDate(duedate));
          	} catch (Exception e) 
          	{
              fail("Exception NOT expected.");
          	}
          }
          
          /**
        	 * Test #15
        	 * Objective: Verify Invalid due date returns true
        	 * Input: LocalDate duedate = currentDate.plusYears(151);  (DUE DATE IS PAST THE MAXIMUM DATE)
        	 * Output: False
        	 */
            
            public void testInvalidDueDate2() {
            	try {
            	LocalDate currentDate = LocalDate.now();
            	LocalDate duedate = currentDate.plusYears(151);
            	assertFalse(Task.isValidDate(duedate));
            	} catch (Exception e) 
            	{
                fail("Exception NOT expected.");
            	}
            }
            
            /**
          	 * Test #16
          	 * Objective: Verify Valid Priority Level returns true.
          	 * Input: int prioritylevel = 1;  (PRIORITY LEVEL = MIN NUM)
          	 * Output: True
          	 */
              
              public void testValidPriorityLevel1() {
              	try {
              	int prioritylevel = 1;
              	assertTrue(Task.isValidPriorityLevel(prioritylevel));
              	} catch (Exception e) 
              	{
                  fail("Exception NOT expected.");
              	}
              }
              
              /**
            	 * Test #17
            	 * Objective: Verify Valid Priority Level returns true.
            	 * Input: int prioritylevel = 2;  (PRIORITY LEVEL = IN-RANGE)
            	 * Output: True
            	 */
                
                public void testValidPriorityLevel2() {
                	try {
                	int prioritylevel = 2;
                	assertTrue(Task.isValidPriorityLevel(prioritylevel));
                	} catch (Exception e) 
                	{
                    fail("Exception NOT expected.");
                	}
                }
                
                /**
              	 * Test #18
              	 * Objective: Verify Valid Priority Level returns true.
              	 * Input: int prioritylevel = 3;  (PRIORITY LEVEL = MAX NUM)
              	 * Output: True
              	 */
                  
                  public void testValidPriorityLevel3() {
                  	try {
                  	int prioritylevel = 3;
                  	assertTrue(Task.isValidPriorityLevel(prioritylevel));
                  	} catch (Exception e) 
                  	{
                      fail("Exception NOT expected.");
                  	}
                  }
                  
                  /**
                	 * Test #19
                	 * Objective: Verify Invalid Priority Level returns false.
                	 * Input: int prioritylevel = 0;  (PRIORITY LEVEL = BELOW MINIMUM NUM)
                	 * Output: True
                	 */
                    
                    public void testInvalidPriorityLevel1() {
                    	try {
                    	int prioritylevel = 0;
                    	assertFalse(Task.isValidPriorityLevel(prioritylevel));
                    	} catch (Exception e) 
                    	{
                        fail("Exception NOT expected.");
                    	}
                    }
                    
                    /**
                  	 * Test #20
                  	 * Objective: Verify Invalid Priority Level returns false.
                  	 * Input: int prioritylevel = 4;  (PRIORITY LEVEL = ABOVE MAXIMUM NUM)
                  	 * Output: True
                  	 */
                      
                      public void testInvalidPriorityLevel2() {
                      	try {
                      	int prioritylevel = 4;
                      	assertFalse(Task.isValidPriorityLevel(prioritylevel));
                      	} catch (Exception e) 
                      	{
                          fail("Exception NOT expected.");
                      	}
                      }
}
