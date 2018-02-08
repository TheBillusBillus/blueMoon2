package forest2;

import java.util.Scanner;

public class Forest2Run {
	public static void main() {
		Scanner scanStr = new Scanner(System.in);
		
		//Opening, start of every new game
		System.out.println("Would you like to read the rules? (Y/N)");
		String choice = scanStr.next().toUpperCase();
		if (choice.equals("Y")) {
			Forest2Menu.rules();
		}
		
		
		
		//end of main
		scanStr.close();
	}
}
