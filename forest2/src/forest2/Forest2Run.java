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
		Forest2Inv invAmmo= new Forest2InvAmmo();
		Forest2Inv invArmor= new Forest2InvArmor();
		Forest2Inv invSup= new Forest2InvSupplies();
		Forest2Inv invWep= new Forest2InvWeapons();
		
		while (player.hp > 0) {
			//this runs every turn
		}
		
		
		//end of main
		//scanStr.close(); do not close here
	}
}
