/*******************************************************************************
 * Copyright (c) 2017 University of Luxembourg.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     JAHIC Benjamin - initial API and implementation
 *******************************************************************************/
package lu.uni.lassy.phd.dsl.semkis.common.utils;

//import lu.uni.lassy.proactivity.Global_Vars;

/**
 * @author Sandro Reis
 * @version 3.0 - Sandro Reis � 2012/2013
 * 
 */
public class String_Utils {

	/**
	 * A static empty string to use in every comparison throughout our projects.<br>
	 * static to reduce the overhead of creating an  extra String object ("") for every test.<p>  
	 * To be used as follows: <br><code>StringUtils.EMPTY_STRING.equals(theStringObjectToCompare)</code>
	 * @see <a href="https://confluence.ucdavis.edu/confluence/display/UCDSAKAI/What+is+the+best+way+to+check+if+a+Java+String+object+is+empty">https://confluence.ucdavis.edu/confluence/display/UCDSAKAI/What+is+the+best+way+to+check+if+a+Java+String+object+is+empty</a>
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * A static string to use in every comparison throughout our projects.<br>
	 * static to reduce the overhead of creating an  extra String object ("") for every test.<p>  
	 * To be used as follows: <br><code>StringUtils.ZERO_STRING.equals(theStringObjectToCompare)</code>
	 * @see <a href="https://confluence.ucdavis.edu/confluence/display/UCDSAKAI/What+is+the+best+way+to+check+if+a+Java+String+object+is+empty">https://confluence.ucdavis.edu/confluence/display/UCDSAKAI/What+is+the+best+way+to+check+if+a+Java+String+object+is+empty</a>
	 */
	public static final String ZERO_STRING = "0";

	/**
	 * A static method to use in every comparison throughout our projects.<br>
	 * This method uses a Static empty string for performance reasons and is able do avoid the potential null pointer exception<p>
	 * @param in a string to analyse
	 * @return true if the input String is null or empty
	 */
	public static boolean isEmptyOrNullString (final String in) {
		return ((in == null) || String_Utils.EMPTY_STRING.equals(in));
	}

	/**
	 * A static method to use in every comparison throughout our projects.<br>
	 * This method uses a Static empty string for performance reasons and is able do avoid the potential null pointer exception<p>
	 * @param in a string to analyse
	 * @return true if the input String is "0"
	 */
	public static boolean isZeroString (final String in) {
		return String_Utils.ZERO_STRING.equals(in);
	}

	/**
	 * pad with " " to the right to the given length (n)
	 * @param s the string
	 * @param n the padding size
	 * @return a right-padded string of size n
	 */
	public static String padRightSpaces(final String s, final int n) {
		return String.format("%1$-" + n + "s", s);
	}

	/**
	 * pad with input character to the right to the given length (n)
	 * @param s the string
	 * @param n the padding size
	 * @param c the padding character
	 * @return a right-padded string of size n
	 */
	public static String padRightChar(final String s, final int n, final char c) {
		return padRightSpaces(s, n).replace(' ', c);
	}

	/**
	 * pad with " " to the left to the given length (n)
	 * @param s the string
	 * @param n the padding size
	 * @return a left-padded string of size n
	 */
	public static String padLeftSpaces(final String s, final int n) {
		return String.format("%1$#" + n + "s", s);
	}

	/**
	 * pad with char c to the left to the given length (n)
	 * @param s the string
	 * @param n the padding size
	 * @param c the padding character
	 * @return a left-padded string of size n
	 */
	public static String padLeftChar(final String s, final int n, final char c) {
		return padLeftSpaces(s, n).replace(' ', c);
	}

	/**
	 * Mask the whole string with the provided character
	 * @param s the string
	 * @param c the padding character
	 * @return a left-padded string of size n
	 */
	public static String stringMask(final String s, final char c) {
		return String.format("%" + s.length() + "s", "").replace(' ', c);
	}
	
	/**
	 * Extract the substring before the first occurrence of a given token
	 * @param in the String in to analyse
	 * @param token the token to use to divide the String
	 * @return the initial part of the original String until the first occurrence of the token
	 */
	public static String stringBefore (String in, String token) {
		int index = in.indexOf(token);
		if (index == -1)
			return in; // not found, returning full String
		else
			return in.substring(0, index);
	}

	/**
	 * Extract the substring after the last occurrence of a given token
	 * EDIT (2012-10-16) updated to allow for tokens with length of more than one char
	 * @param in the input String to analyse
	 * @param token the token to use to divide the String
	 * @return the last part of the original String after the last occurrence of token <br>
	 * <b>ex:</b> AbstractRule.class.toString() = "class rules.AbstractRule", therefore <br>
	 * Utils.stringAfter(AbstractRule.class.toString(), ".") <b>returns</b> "AbstractRule"
	 */
	public static String stringAfter (String in, String token) {
		int index = in.lastIndexOf(token);
		if (index == -1)
			return EMPTY_STRING; // not found, returning empty String
		else
			return in.substring(index+token.length(), in.length());
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String args[]) throws Exception {
/*/		Global_Vars.logger.info("This class name: '" + String_Utils.class + "' --> '" + String_Utils.stringAfter(String_Utils.class.toString(), ".") + "'");
		
		Global_Vars.logger.info("*" + String_Utils.padRightSpaces("Howto", 20) + "*");
		Global_Vars.logger.info("*" + String_Utils.padLeftSpaces ("Howto", 25) + "*");
		Global_Vars.logger.info("*" + String_Utils.padLeftSpaces ("Howto", 20) + "*");
		
		Global_Vars.logger.info("*" + String_Utils.padRightChar ("Howto", 25, '+') + "*");
		Global_Vars.logger.info("*" + String_Utils.padLeftChar ("Howto", 20, '+') + "*");
		Global_Vars.logger.info("*" + String_Utils.padLeftChar ("How to pad", 20, '+') + "*");
		
		Global_Vars.logger.info("PASSWORD: 'Howto' = '" + String_Utils.stringMask ("Howto", '+') + "'");
/**/	}
}