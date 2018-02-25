package forest2;

import java.util.Random;

public class Forest2Actions {

	public static Boolean alive(Forest2Player player) {
		if (player.hp > 0 && player.food > 0 && player.water > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void statCap(Forest2Player player) {
		if (player.hp > player.lv * 20 + 100) {
			player.hp = player.lv * 20 + 100;
		}
		if (player.food > player.lv * 30 + 100) {
			player.food = player.lv * 30 + 100;
		}
		if (player.water > player.lv * 30 + 100) {
			player.water = player.lv * 30 + 100;
		}
		if (player.rp > player.lv * 10 + 100) {
			player.rp = player.lv * 10 + 100;
		}
	}

	public static Boolean win(Forest2Player player) {
		if (player.distance > 500) {
			return true;
		} else {
			return false;
		}
	}

	public static void hunt(Forest2Player player) {

	}

	public static void scavenge(Forest2Player player, Forest2InvSupplies invSup) {
		Random rand = new Random();
		int n = rand.nextInt(7) + 4;
		player.food = player.food - (n * 2);
		player.water = player.water - (n * 3);
		invSup.wood = invSup.wood + (n);
	}

	public static void camp(Forest2Player player, Forest2InvSupplies invSup) {
		switch (Forest2Menu.campMenu()) {
		case 1:
			Forest2Actions.campFire(player, invSup);
			break;
		case 2:
			// dry meat
			invSup.rawMeat--;
			invSup.driedMeat++;
			break;
		case 3:
			switch (Forest2Menu.consumables()) {
			case 1:
				switch (Forest2Menu.foodWater()) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 0:
				}

			case 2:
				switch (Forest2Menu.meds()) {
				case 1:
					invSup.medkit--;
					player.hp = player.lv * 20 + 100;
				case 2:
					invSup.bandages--;
					player.hp = player.hp + 50;
					Forest2Actions.statCap(player);

				case 3:
					invSup.painkillers--;
					player.hp = player.hp + 25;
					Forest2Actions.statCap(player);
				}

			case 3:
				switch (Forest2Menu.special()) {
				case 1:
					player.hp = 0;
				case 0:
					break;
				}

			case 0:
				break;
			}

		case 4:
			Forest2Actions.sleep(player);
			break;
		case 0:
			break;
		}
	}

	public static void campFire(Forest2Player player, Forest2InvSupplies invSup) {
		int loop = 1;
		while (loop == 1) {
			switch (Forest2Menu.campFireMenu(player)) {
			case 1:
				if (Forest2Actions.checkFire(player)) {
					break;
				} else {
					// add wood check and remove
					if (invSup.wood > 1) {
						player.fire = true;
						invSup.wood--;
						System.out.println("You used a piece of wood and started a fire.");
					} else {
						System.out.println("You do not have any wood!");
					}
				}
				break;
			case 2:
				// meat - 1, wood - 1, cooked meat + 1
				break;
			case 3:
				if (invSup.water < 10) {
					invSup.water++;
					System.out.println("You boiled some water and added it to your bottle.");
				} else {
					System.out.println("Your bottle is already full!");
				}
			case 0:
				loop = 0;
			}
		}
	}

	public static void travel(Forest2Player player, Forest2InvAmmo invAmmo, Forest2InvArmor invArmor, Forest2InvSupplies invSup, Forest2InvWeapons invWep) {
		if (invAmmo.ammoWt() < player.lv * 10 + 100) {
			Random rand = new Random();
			int n = rand.nextInt(7) + 4;
			System.out.println("You traveled " + n + "km.");
		} else {
			System.out.println("Your items weigh too much to travel");
		}
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

	public static Boolean pass250(Forest2InvWeapons invWep) {
		System.out.println("You've discovered the center of the forest and the reason why you've returned.");
		System.out.println("Your theory about an artifact causing your plane to crash was correct.");
		System.out.println(
				"Pulling out the explosive charge you brought, you set the timer and placed it next to the artifact.");
		invWep.charge--;
		return true;
	}
}
