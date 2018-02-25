package forest2;

import java.util.Random;

public class Forest2Actions {
	public static void hunt() {

	}

	public static void scavenge() {

	}

	public static void camp(Forest2Player player) {
		switch (Forest2Menu.campMenu()) {
		case 1:
			Forest2Actions.campFire(player);
			break;
		case 2:
			// dry meat
			break;
		case 3:
			Forest2Actions.sleep(player);
			break;
		case 0:
			break;
		}

	}

	public static void campFire(Forest2Player player) {
		int loop = 1;
		while (loop == 1) {
			switch (Forest2Menu.campFireMenu(player)) {
			case 1:
				if (Forest2Actions.checkFire(player)) {
					break;
				} else {
					// add wood check and remove
					player.fire = true;
				}
				break;
			case 2:
				// meat - 1, wood - 1, cooked meat + 1
				break;
			case 3:
				if (player.water < 10) {
					player.water++;
					System.out.println("You boiled some water and added it to your bottle.");
				} else {
					System.out.println("Your bottle is already full!");
				}
			case 0:
				loop = 0;
			}
		}
	}

	public static void travel(Forest2Player player) {
		Random rand = new Random();
		int n = rand.nextInt(7) + 4;
	}

	public static void sleep(Forest2Player player) {
		Random rand = new Random();
		int n = rand.nextInt(7) + 4;
		player.food = player.food - (n * 2);
		player.water = player.water - (n * 3);
	}

	public static Boolean checkFire(Forest2Player player) {
		if (player.fire) {
			return true;
		} else {
			return false;
		}
	}
}
