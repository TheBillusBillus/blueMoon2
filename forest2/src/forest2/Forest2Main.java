package forest2;

import java.util.Scanner;

public class Forest2Main {
	public static void main (String[] args) {
		Scanner scanStr = new Scanner(System.in);
		
		Forest2Menu.welcome();
		Forest2Run.main();
		
		System.out.println("Would you like to play again? (Y/N)");
		String choice = scanStr.next().toUpperCase();
		System.out.println("test2");
		while (choice.equals("Y")) {
			Forest2Run.main();
		}
		
		//end of game
		System.out.println("Thank you for playing!");
		scanStr.close();
	}
}
