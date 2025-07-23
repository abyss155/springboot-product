package com.kiit.myFirstSpringboot.exception;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException(String errMsg)
	{
	 super(errMsg);
	}
}
