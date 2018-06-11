package sandbox;

import java.util.Scanner;

public class Lychrel {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input the value you would like to test: ");
		int input = scan.nextInt();
		System.out.println(isLychrel(input));
	}

	public static Boolean isPalindrome(int target) {
		String str = Integer.toString(target);
		if (str.length() == 0 || str.length() == 1)
			return true;
		if (str.charAt(0) == str.charAt(str.length() - 1))
			return isPalindrome(Integer.parseInt(str.substring(1, str.length() - 1)));
		return false;
	}

	public static Boolean isLychrel(int target) {
		if (isPalindrome(target)) {
			return true;
		} else {
			String str = Integer.toString(target);
			String rev = "";
			for (int i = 0; i < str.length(); i++) {
				rev = str.charAt(i) + rev;
			}
			return isLychrel (target + Integer.parseInt(rev));
		}
	}
}
