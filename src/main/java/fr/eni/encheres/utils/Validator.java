package fr.eni.encheres.utils;

import java.util.regex.Pattern;

public class Validator
{
	private static final String EMAIL_REGEX = "^.+@[a-zA-Z0-9]+\\.[a-z]+$";
	private static final String PHONE_REGEX = "^[0-9]{10}$";
	private static final String ZIPCODE_REGEX = "^[0-9]{5}$";
	
	
	public static boolean isValidEmail(final String email)
	{
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		
		return pattern.matcher(email).matches();
	}
	
	public static boolean isValidPhone(final String phone)
	{
		Pattern pattern = Pattern.compile(PHONE_REGEX);
		
		return pattern.matcher(phone).matches();
	}
	
	public static boolean isValidZipcode(final String zipcode)
	{
		Pattern pattern = Pattern.compile(ZIPCODE_REGEX);
		
		return pattern.matcher(zipcode).matches();
	}
}
