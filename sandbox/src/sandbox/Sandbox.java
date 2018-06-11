package sandbox;

import java.util.ArrayList;

public class Sandbox {

	public static void main(String[] args) {

		//questionOne(3);

		System.out.println(questionTwo(9));

		//questionThree("asdf");
	}

	public static void questionOne(int n) {
		if (n > 0) {
			questionOne(n - 1);
			System.out.print(n);
			questionOne(n - 1);
		}
	}

	public static int questionTwo(int n) {
		if (n < 0)
			return 1;
		else
			return questionTwo(n - 3) + questionTwo(n - 4);
	}

	public static void questionThree(String s) {
		if (s.length() > 0) {
			questionThree(s.substring(1));
			System.out.print(s.substring(0, 1));
		}
	}

}
