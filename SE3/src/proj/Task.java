package proj;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import Exceptions.K_Exception;

public class Task 
{
	private String title;
	private String description;
	private int prioritylevel;
	private LocalDate duedate;
	
	
	public Task(String title, String description,int prioritylevel,LocalDate duedate) throws K_Exception{
		this.title = title;
		this.description = description;
		this.prioritylevel = prioritylevel;
		this.duedate = duedate;
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
		return title.length() > 3 && title.length() < 21;
	}
	
	public static boolean isValidDescription(String description) 
	{
		return description.length() > 3 && description.length() < 41;
	}
	
	public static boolean isValidDate(LocalDate duedate) 
	{
		LocalDate currentDate = LocalDate.now();
        LocalDate maxDate = currentDate.plusYears(150);
        
        return !duedate.isBefore(currentDate.minusDays(1)) && !duedate.isAfter(maxDate);
	}
		
	public static boolean isValidPriorityLevel(int prioritylevel) 
	{
		return prioritylevel > 0 && prioritylevel < 4;
	}

}
