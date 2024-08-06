package Exceptions;

@SuppressWarnings("serial")
public class TaskExceptionHandler extends Exception 
{
	String message;
	
	public TaskExceptionHandler(String e) 
	{
		message = e;
	}
	
	public String getMessage() 
	{
		return message;
	}
}