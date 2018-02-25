package forest2;

import java.util.Scanner;

public class Forest2Run {
	public static void main() {
		Scanner scanStr = new Scanner(System.in);

		// Opening, start of every new game
		System.out.println("Would you like to read the rules & tutorial? (Y/N)");
		String choice = scanStr.next().toUpperCase();
		if (choice.equals("Y")) {
			Forest2Menu.rules();
		}

		// create player
		Forest2Player player = new Forest2Player();

		// create inventory
		Forest2Inv invAmmo = new Forest2InvAmmo();
		Forest2Inv invArmor = new Forest2InvArmor();
		Forest2Inv invSup = new Forest2InvSupplies();
		Forest2Inv invWep = new Forest2InvWeapons();
		
		Boolean pass250 = false;
		
		while (Forest2Actions.alive(player) == true && Forest2Actions.win(player) == false) {
			// this runs every turn
			if (pass250 = false && player.distance > 250) {
				pass250 = Forest2Actions.pass250((Forest2InvWeapons) invWep);
			}
			
			switch (Forest2Menu.mainMenu()) {
			case 1:
				// hunt
				Forest2Actions.hunt(player);
				break;
			case 2:
				// scavenge
				Forest2Actions.scavenge(player, (Forest2InvSupplies) invSup);
				break;
			case 3:
				// camp
				Forest2Actions.camp(player, (Forest2InvSupplies) invSup);
				break;
			case 4:
				// travel
				Forest2Actions.travel(player, (Forest2InvAmmo) invAmmo, (Forest2InvArmor) invArmor, (Forest2InvSupplies) invSup, (Forest2InvWeapons) invWep);
				break;
			case 5:
				// stats+inventory
				Forest2Menu.statsMenu();
				break;
			case 6:
				//save
				Forest2LoadSave.save(player, (Forest2InvAmmo) invAmmo, (Forest2InvArmor) invArmor, (Forest2InvSupplies) invSup, (Forest2InvWeapons) invWep);
				break;
			case 7:
				//load
				Forest2LoadSave.load();
			case 8:
				//exit game
				System.exit(0);
			}
		}
		if (Forest2Actions.win(player) == true) {
			System.out.println("Congradulations, You've won the game!");
		}
		if (Forest2Actions.alive(player) == false) {
			System.out.println("You have died");
		} 

		// end of main
		// scanStr.close(); do not close here
	}
}
