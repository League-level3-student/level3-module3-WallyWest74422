package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		} else {
			return s2;
		}
	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			String modifieds = s.replace(' ', '_');
			return modifieds;
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		int index1 = s1.indexOf(' ');
		int index2 = s2.indexOf(' ');
		int index3 = s3.indexOf(' ');
		index1 = index1 + 1;
		index2 = index2 + 1;
		index3 = index3 + 1;
		char lastName1 = s1.charAt(index1);
		char lastName2 = s2.charAt(index2);
		char lastName3 = s3.charAt(index3);
		if (lastName1 < lastName2 && lastName1 < lastName3) {
			return s1;
		} else if (lastName2 < lastName1 && lastName2 < lastName3) {
			return s2;
		} else if (lastName3 < lastName1 && lastName3 < lastName2) {
			return s3;
		}
		return null;
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			boolean isNum = Character.isDigit(s.charAt(i));
			if (isNum) {
				int newS = Integer.parseInt(s.substring(i, i + 1));
				total = total + newS;
			}
		}

		return total;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int numOccurances = 0;
		int index = s.indexOf(substring);
		while (index != -1) {
			numOccurances++;
			index = s.indexOf(substring, index + substring.length());
		}
		return numOccurances;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte) key);
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {

		return Utilities.decrypt(s, (byte) key);
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int correctEnding = 0;
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].endsWith(substring)) {
				correctEnding++;
			}
		}
		return correctEnding;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int numOfChars = 0;
		int numOccurances = 0;
		int index = s.indexOf(substring);
		while (index != -1) {
			numOccurances++;
			index = s.indexOf(substring, index + substring.length());
		}
		if (numOccurances != s.length() + 1) {
			for (int i = s.indexOf(substring) + substring.length(); i < s.length() - substring.length(); i++) {
				numOfChars = numOfChars + 1;
			}
			// System.out.println(numOfChars);
			return numOfChars;
		}
		return 0;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String s1 = s.replaceAll(" ", "");
		// System.out.println(s1);
		String s2 = s1.replaceAll(",", "");
		// System.out.println(s2);
		String s3 = s2.replaceAll("-", "");
		// System.out.println(s3);
		String s4 = s3.replaceAll("\\.", "");
		// System.out.println(s4);
		String s5 = s4.replaceAll(":", "");
		// System.out.println(s5);
		String s6 = s5.replaceAll("\\?", "");
		// System.out.println(s6);
		String s7 = s6.toLowerCase();
		System.out.println(s7);
		// String [] s8 = s7.split("");
		int sLength = s7.length();
		for (int i = 0; i < s7.length(); i++) {
			int secondHalf = (sLength - 1);
			System.out.println(s7.charAt(i));
			System.out.println(s7.length());
			System.out.println(s7.charAt(secondHalf));
			 if(s7.charAt(i)!=s7.charAt(secondHalf-i)) {
			 return false;
			 }
		}
		return true;
	}

	static class Utilities {
		// This basic encryption scheme is called single-byte xor. It takes a
		// single byte and uses exclusive-or on every character in the String.
		public static String encrypt(byte[] plaintext, byte key) {
			for (int i = 0; i < plaintext.length; i++) {
				plaintext[i] = (byte) (plaintext[i] ^ key);
			}
			return Base64.getEncoder().encodeToString(plaintext);
		}

		public static String decrypt(String cyphertext, byte key) {
			byte[] b = Base64.getDecoder().decode(cyphertext);
			for (int i = 0; i < b.length; i++) {
				b[i] = (byte) (b[i] ^ key);
			}
			return new String(b);
		}
	}
}
