package Exceptions;

@SuppressWarnings("serial")
public class K_Exception extends Exception 
{
	String message;
	
	public K_Exception(String e) 
	{
		message = e;
	}
	
	public String getMessage() 
	{
		return message;
	}
}