import java.util.InputMismatchException;

/*
 * There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
 */

public class One_Away {
	private static boolean oneReplace(char[] string1, char[] string2) {
		boolean oneReplace = false;
		for (int i = 0, j = 0; i < string1.length; ++i, ++j) {
			if (string1[i] != string2[j]) {
				if (oneReplace)
					return false;
				else
					oneReplace = true;
			}
		}
		return true;
	}

	// string 1 is longer
	private static boolean oneInsert(char[] string1, char[] string2) {
		for (int i = 0, j = 0; j < string2.length; ++i, ++j) {	
			if (string1[i] != string2[j]) {
				if (i != j)
					return false;
				i++;
			} 
		}
		return true;
	}

	// string 1 is longer
	private static boolean oneInsert2(char[] string1, char[] string2) {
		boolean oneInsert = false;
		for (int i = 0, j = 0; j < string2.length; ++i, ++j) {	
			if (string1[i] != string2[j]) {
				if (oneInsert)
					return false;
				
				oneInsert = true;
				i++;
			} 
		}
		return true;
	}

	// Optimal solution
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private static boolean solve(char[] string1, char[] string2) {
		if (string1 == null || string2 == null)
			throw new InputMismatchException();
		
		if (string1.length - string2.length > 2 || string1.length - string2.length < -2)
			return false;

		boolean oneEdit = false;
		for (int i = 0, j = 0; i < string1.length && j < string2.length; ++i, ++j) {
			if (string1[i] != string2[j]) {
				if (oneEdit)
					return false;
				if (string1.length > string2.length)
					++i;
				else if (string1.length < string2.length)
					++j;
				oneEdit = true;
			}
		}
		return true;
	}

	// Time Complexity: O(n)
	// Space Complexity: O(n)
	private static boolean solve2(char[] string1, char[] string2) {
		if (string1 == null || string2 == null)
			throw new InputMismatchException();
		
		if (string1.length == string2.length)
			return oneReplace(string1, string2);
		else if (string1.length == string2.length + 1)
			return oneInsert(string1, string2);
		else if (string1.length + 1 == string2.length)
			return oneInsert(string2, string1);
		else
			return false;
	}

	public static void main(String... args) {		
		String[][] testCases = {{"same", "same"},
								{"pale", "ple"},
								{"pales", "pale"},
								{"pale", "bale"},
								{"unique", "repeat"},
								{"a", "/t"}};

		for (int i = 0; i < testCases.length; ++i)
			System.out.println(solve(testCases[i][0].toCharArray(), testCases[i][1].toCharArray()));
	}
}
