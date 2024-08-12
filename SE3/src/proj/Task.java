package proj;


import java.time.LocalDate;
import Exceptions.TaskExceptionHandler;

public class Task 
{
	private String title;
	private String description;
	private int prioritylevel;
	private LocalDate duedate;
	
	
	public Task(String title, String description,int prioritylevel,LocalDate duedate) throws TaskExceptionHandler
	{
	        if (!isValidTitle(title)) {
	            throw new TaskExceptionHandler("Invalid title");
	        }
	        if (!isValidDescription(description)) {
	            throw new TaskExceptionHandler("Invalid description");
	        }
	        if (!isValidPriorityLevel(prioritylevel)) {
	            throw new TaskExceptionHandler("Invalid priority level");
	        }
	        if (!isValidDate(duedate)) {
	            throw new TaskExceptionHandler("Invalid due date");
	        }
	        
	        setTitle(title);
	        setDescription(description);
	        setPrioritylevel(prioritylevel);
	        setDuedate(duedate);
	}
	
	public Task()
	{
		
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public int getPrioritylevel() 
	{
		return prioritylevel;
	}
	
	public void setPrioritylevel(int prioritylevel) 
	{
		this.prioritylevel = prioritylevel;
	}
	
	
	public static boolean isValidTitle(String title) 
	{
		return title.length() >= 4 && title.length() <= 20 && title.matches("^[A-Za-z ]*$") && title.replaceAll("[^A-Za-z]", "").length() >= 4;
	}
	
	public static boolean isValidDescription(String description) 
	{
		return description.length() > 3 && description.length() < 41 ;
	}
	
	public static boolean isValidDate(LocalDate dueDate) 
	{
	    LocalDate currentDate = LocalDate.now();
	    LocalDate maxDate = currentDate.plusYears(150);
	    
	    return !dueDate.isBefore(currentDate) && !dueDate.isAfter(maxDate);
	}
		
	public static boolean isValidPriorityLevel(int prioritylevel) 
	{
		return prioritylevel > 0 && prioritylevel < 4;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}


}