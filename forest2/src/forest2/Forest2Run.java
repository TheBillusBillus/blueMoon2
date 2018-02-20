package forest2;

import java.util.Scanner;

public class Forest2Run {
	public static void main() {
		Scanner scanStr = new Scanner(System.in);
		
		//Opening, start of every new game
		System.out.println("Would you like to read the rules? (Y/N)");
		String choice = scanStr.next().toUpperCase();
		if (choice.equals("Y")){
			Forest2Menu.rules();
		}
		
		//create player
		Forest2Player player = new Forest2Player();
		
		//create inventory
		Forest2Inv inventory= new Forest2Inv();
		
		while (player.hp > 0) {
			
		}
		
		
		//end of main
		//scanStr.close(); do not close here
	}
}
