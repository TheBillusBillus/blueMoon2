package forest2;

import java.util.Scanner;

public class Forest2Run {
	public static void main() {
		Scanner scanStr = new Scanner(System.in);

		// Opening, start of every new game
		System.out.println("Would you like to read the rules? (Y/N)");
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

		while (player.hp > 0) {
			// this runs every turn
			switch (Forest2Menu.mainMenu()) {
			case 1:
				// hunt
				Forest2Actions.hunt();
				break;
			case 2:
				// scavenge
				Forest2Actions.scavenge();
				break;
			case 3:
				// camp
				Forest2Actions.camp(player);
				break;
			case 4:
				// travel
				Forest2Actions.travel(player);
				break;
			case 5:
				// stats+inventory
				Forest2Menu.statsMenu();
				break;
			case 6:
				//save
				//Forest2LoadSave.save(player, invAmmo, invArmor, invSup, invWep);
				break;
			case 7:
				//load
				Forest2LoadSave.load();
			case 8:
				//exit game
				System.exit(0);
			}
		}

		// end of main
		// scanStr.close(); do not close here
	}
}
