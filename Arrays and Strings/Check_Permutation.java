import java.util.Arrays;
import java.util.Collections;

// Given two strings, write a method to decide if one is a permutation of the other.

public class Check_Permutation {

	// Time complexity: nlogn
	// Space complexity: n
	private static String sort(String string) {
		char[] sortedCharArray = string.toCharArray();
		Arrays.sort(sortedCharArray);
		return String.valueOf(sortedCharArray);
	}

	// Time Complexity: nlogn
	// Space Complexity: n
	private static boolean solve(String string1, String string2) {
		if (string1 == null || string2 == null)
			return false;
		
		if (string1.length() != string2.length())
			return false;

		String sortedString1 = sort(string1);
		String sortedString2 = sort(string2);

		return sortedString1.equals(sortedString2);
	}
	
	// Optimal solution
	// Time Complexity: O(n)
	// Space Complexity: O(c)
	private static boolean solve2(String string1, String string2) {
		if (string1 == null || string2 == null)
			return false;
		
		if (string1.length() != string2.length())
			return false;

		// Assumption: the string is an ASCII string
		final int NUMBER_OF_ASCII_CHARACTERS = 128;
		int[] string1CharacterFrequency = new int[NUMBER_OF_ASCII_CHARACTERS];

		for (int i = 0; i < string1.length(); ++i)
			string1CharacterFrequency[string1.charAt(i)]++;
		
		// Tweak: Minus the frequency from the previous table
		for (int i = 0; i < string2.length(); ++i) {
			string1CharacterFrequency[string2.charAt(i)]--;
			if (string1CharacterFrequency[string2.charAt(i)] < 0)
				return false;
		}
		
		return true;
	}

	public static void main(String... args) {		
		String[][] testCases = {{"same", "same"},
								{"unique", "repeat"},
								{"special", null},
								{"a", "/t"}};

		for (int i = 0; i < testCases.length; ++i)
			System.out.println(solve2(testCases[i][0], testCases[i][1]));
	}
}
