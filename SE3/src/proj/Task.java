package proj;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task 
{
	private String title;
	private String description;
	private int prioritylevel;
	private LocalDate duedate;
	
	
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

	}
	
	public static boolean isValidDescription(String description) 
	{

	}
	
	public static boolean isValidDate(LocalDate duedate) 
	{

	}
	
	public static boolean isValidPriorityLevel(int prioritylevel) 
	{

	}

}
