package com.example.GenericException;

public class MessageException extends Exception {

	public MessageException(){
		super();
	}
	
	public MessageException(String message){
		super(message);
	}
	
	public MessageException(Exception e){
		super(e);
	}
	
	public MessageException(String message, Exception e){
		super(message, e);
	}
}
