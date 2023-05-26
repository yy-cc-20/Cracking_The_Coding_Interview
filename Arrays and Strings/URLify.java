import java.util.InputMismatchException;

/*
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: if implementing in Java, please use a character array so that you can
perform this operation in place.)
 */

public class URLify {
	// Time Complexity: n
	// Space Complexity: n
	private static char[] solve(char[] url, int urlLength) {
		char[] newUrl = new char[urlLength * 3];
		int i = -1;
		for (char c : url) {
			if (c == ' ') {
				newUrl[++i] = '%';
				newUrl[++i] = '2';
				newUrl[++i] = '0';
			} else {
				newUrl[++i] = c;
			}
		}
		return newUrl;
	}

	// Optimal solution
	// Time complexity: n
	// Space complexity: n
	private static char[] solve2(char[] url, int urlLength) {
		int spaceCount = 0;
		int currentCharIndex;
		for (int i = 0; i < urlLength; ++i) 
			if (url[i] == ' ') {
				spaceCount++;
			}
				
		currentCharIndex = urlLength + spaceCount * 2;

		// Tweak: rewrite the char array from backwards
		for (int i = urlLength - 1; i >= 0; --i) {
			System.out.println(url);
			if (url[i] == ' ') {
				url[--currentCharIndex] = '0';
				url[--currentCharIndex] = '2';
				url[--currentCharIndex] = '%';
			} else {
				url[--currentCharIndex] = url[i];
			}
		}
		return url;
	}

	public static void main(String... args) {		
		char[] url = "Mr John Smith              ".toCharArray();
		int urlLength = 13;

		System.out.println(solve2(url, urlLength));
	}
}
