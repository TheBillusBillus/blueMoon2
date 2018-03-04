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
				Forest2Actions.hunt(player, (Forest2InvAmmo) invAmmo, (Forest2InvWeapons) invWep, (Forest2InvArmor) invArmor, (Forest2InvSupplies) invSup);
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
				player.fire = false;
				break;
			case 5:
				// stats+inventory
				switch(Forest2Menu.statsMenu()) {
				case 1:
					Forest2Menu.statsPlayer(player);
					break;
				case 2:
					Forest2Menu.statsWep((Forest2InvWeapons) invWep);
					break;
				case 3:
					Forest2Menu.statsArmor((Forest2InvArmor) invArmor);
					break;
				case 4:
					Forest2Menu.statsSup((Forest2InvSupplies) invSup);
					break;
				case 5:
					Forest2Menu.statsAmmo((Forest2InvAmmo) invAmmo);
					break;
				case 0:
					break;
				}
				break;
			case 6:
				//save
				Forest2LoadSave.save(player, (Forest2InvAmmo) invAmmo, (Forest2InvArmor) invArmor, (Forest2InvSupplies) invSup, (Forest2InvWeapons) invWep);
				break;
			case 7:
				//load
				Forest2LoadSave.load(player, (Forest2InvAmmo) invAmmo, (Forest2InvArmor) invArmor, (Forest2InvSupplies) invSup, (Forest2InvWeapons) invWep);
			case 8:
				//exit game
				System.exit(0);
			}
		}
		if (Forest2Actions.win(player) == true) {
			System.out.println("Congradulations, You've won the game!");
		}
		if (Forest2Actions.alive(player) == false) {
			if (player.hp < 0) {
				System.out.println("You have been diagnosed with dead!");
			}
			if (player.food < 0) {
				System.out.println("You have been diagnosed with dead from starve!");
			}
			if (player.water < 0) {
				System.out.println("You have been diagnosed with dead from thirst!");
			}
		} 

		// end of main
		// scanStr.close(); do not close here
	}
}
