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

	/**
	 * caps player attributes and updates lv every time the player earns xp or uses
	 * a consumable
	 * 
	 * @param player
	 */
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

		while (player.xp > (int) Math.floor(Math.pow(100, (player.lv / 10 + 1)))) {
			player.xp = (int) (player.xp - Math.floor(Math.pow(100, (player.lv / 10 + 1))));
			player.lv++;
		}
	}

	public static Boolean win(Forest2Player player) {
		if (player.distance > 500) {
			return true;
		} else {
			return false;
		}
	}

	public static void hunt(Forest2Player player, Forest2InvAmmo invAmmo, Forest2InvWeapons invWep,
			Forest2InvArmor invArmor, Forest2InvSupplies invSup) {
		Random rand = new Random();
		int n = rand.nextInt(10);
		Boolean pres = true;
		if (n < 6) {
			int type = 1;
			Forest2MobsAnimals mob = new Forest2MobsAnimals(player);
			mob.type();
			while (mob.hp > 0 && player.hp > 0 && pres == true) {
				switch (Forest2Menu.combat(type, player, invAmmo, invWep)) {
				case 1:
					combatAttack(invAmmo, invWep, mob);
					break;
				case 2:
					if (hide(player, mob)) {
						pres = false;
					}
					break;
				case 3:
					if (mob.knife(player, invSup)) {
						pres = false;
					}
					break;
				}
				System.out.println("You were attacked by the " + mob.name + " and lost " + mob.dmg + " HP.");
				if (mob.hp <= 0) {
					System.out.println("You have killed the "+mob.name+"!");
				}
			}
		} else if (n < 9) {
			int type = 2;
			Forest2MobsHumans mob = new Forest2MobsHumans(player);
			mob.type();
			while (mob.hp > 0 && player.hp > 0 && pres == true) {
				switch (Forest2Menu.combat(type, player, invAmmo, invWep)) {
				case 1:
					combatAttack(invAmmo, invWep, mob);
					break;
				case 2:
					if (hide(player, mob)) {
						pres = false;
					}
					break;
				case 3:
					if (mob.threaten(player, invAmmo, invWep, invArmor)) {
						pres = false;
					}
					break;
				}
				System.out.println("You were attacked by the " + mob.name + " and lost " + mob.dmg + " HP.");
				if (mob.hp <= 0) {
					System.out.println("You have killed the "+mob.name+"!");
				}
			}
		} else {
			int type = 3;
			Forest2MobsAnomalies mob = new Forest2MobsAnomalies(player);
			mob.type();
			while (mob.hp > 0 && player.hp > 0 && pres == true) {
				switch (Forest2Menu.combat(type, player, invAmmo, invWep)) {
				case 1:
					combatAttack(invAmmo, invWep, mob);
					break;
				case 2:
					if (hide(player, mob)) {
						mob.special(player);
						pres = false;
					}
					break;
				case 3:
					if (mob.run(player)) {
						pres = false;
					}
					break;
				}
				player.hp = player.hp - mob.dmg * (invArmor.dt / 10);
				System.out.println("You were attacked by the " + mob.name + " and lost " + mob.dmg + " HP.");
				mob.special(player);
				if (mob.hp <= 0) {
					System.out.println("You have killed the "+mob.name+"!");
				}
			}
		}
	}

	public static void combatAttack(Forest2InvAmmo invAmmo, Forest2InvWeapons invWep, Forest2Mobs mob) {
		switch (Forest2Menu.combatAttack(invAmmo, invWep)) {
		case 1:
			if (invAmmo.cal9 > 0 && invWep.p9 > 0) {
				invAmmo.cal9--;
				mob.hp = mob.hp - 5;
				System.out.println("You attacked the " + mob.name + " and dealt 5 dmg.");
			} else {
				System.out.println("Something's not right!");
			}
			break;
		case 2:
			if (invAmmo.cal10 > 0 && invWep.p10 > 0) {
				invAmmo.cal10--;
				mob.hp = mob.hp - 7;
				System.out.println("You attacked the " + mob.name + " and dealt 7 dmg.");
			} else {
				System.out.println("Something's not right!");
			}
			break;
		case 3:
			if (invAmmo.cal556 > 0 && invWep.r556 > 0) {
				invAmmo.cal556--;
				mob.hp = mob.hp - 12;
				System.out.println("You attacked the " + mob.name + " and dealt 12 dmg.");
			} else {
				System.out.println("Something's not right!");
			}
			break;
		}
	}

	public static Boolean hide(Forest2Player player, Forest2Mobs mob) {
		if (player.lv > mob.lv + 3) {
			System.out.println("You successfully hid from the " + mob.name + ".");
			return true;
		} else {
			System.out.println("You tried to hide from the " + mob.name + " but it clearly failed.");
			return false;
		}
	}

	public static void scavenge(Forest2Player player, Forest2InvSupplies invSup) {
		Random rand = new Random();
		int n = rand.nextInt(7) + 4;
		player.food = player.food - (n * 2);
		player.water = player.water - (n * 3);
		int w = (int) Math.floor(n * rand.nextInt(11) / 10);
		invSup.wood = invSup.wood + w;

		System.out.println("You scavenged for materials for " + n + " hours");
		System.out.println("You found " + w + " peices of wood.");
	}

	public static void camp(Forest2Player player, Forest2InvSupplies invSup) {
		switch (Forest2Menu.campMenu()) {
		case 1:
			Forest2Actions.campFire(player, invSup);
			break;
		case 2:
			// dry meat
			if (invSup.rawMeat > 1) {
				invSup.rawMeat--;
				invSup.driedMeat++;
			} else {
				System.out.println("You have no raw meat to dry!");
			}
			break;
		case 3:
			switch (Forest2Menu.consumables()) {
			case 1:
				switch (Forest2Menu.foodWater()) {
				case 1:
					if (invSup.water > 1) {
						player.water = player.water + 30;
						invSup.water--;
						Forest2Actions.statCap(player);
					} else {
						System.out.println("You have no water!");
					}
					break;
				case 2:
					if (invSup.driedMeat > 1) {
						player.food = player.food + 5;
						invSup.driedMeat--;
						Forest2Actions.statCap(player);
					} else {
						System.out.println("You have no dried meat!");
					}
					break;
				case 3:
					if (invSup.cookedMeat > 1) {
						player.food = player.food + 15;
						invSup.cookedMeat--;
						statCap(player);
					} else {
						System.out.println("You have no cooked meat!");
					}
					break;
				case 4:
					if (invSup.mre > 1) {
						player.food = player.food + 30;
						player.water = player.water + 30;
						invSup.mre--;
						statCap(player);
					} else {
						System.out.println("You have no MRE!");
					}
					break;
				case 0:
					break;
				}
				break;
			case 2:
				switch (Forest2Menu.meds()) {
				case 1:
					if (invSup.medkit > 1) {
						invSup.medkit--;
						player.hp = player.lv * 20 + 100;
					} else {
						System.out.println("You have no medkit!");
					}
					break;
				case 2:
					if (invSup.bandages > 1) {
						invSup.bandages--;
						player.hp = player.hp + 50;
						statCap(player);
					} else {
						System.out.println("You have no bandages!");
					}
					break;
				case 3:
					if (invSup.painkillers > 1) {
						invSup.painkillers--;
						player.hp = player.hp + 25;
						statCap(player);
					} else {
						System.out.println("You have no painkillers!");
					}
					break;
				}
				break;
			case 3:
				switch (Forest2Menu.special()) {
				case 1:
					player.hp = 0;
					break;
				case 2:
					player.xp = player.xp + 1000;
					System.out.println("You studies the rock because of its unique radioactive properties.");
					System.out.println("Documenting your findings, you became more knowledgeable about the anomalies.");
					System.out.println("+1000 xp.");
					statCap(player);
					break;
				case 0:
					break;
				}

			case 0:
				break;
			}
			break;

		case 4:
			sleep(player);
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
				if (invSup.wood > 1 && invSup.rawMeat > 1) {
					invSup.wood--;
					invSup.rawMeat--;
					invSup.cookedMeat++;
					System.out.println("You cooked a piece of meat on the camp fire.");
				} else {
					System.out.println("You are missing resources!");
				}
				break;
			case 3:
				if (invSup.water < 10) {
					invSup.water++;
					System.out.println("You boiled some water and added it to your bottle.");
				} else {
					System.out.println("Your bottle is already full!");
				}
				break;
			case 0:
				loop = 0;
			}
		}
	}

	public static void travel(Forest2Player player, Forest2InvAmmo invAmmo, Forest2InvArmor invArmor,
			Forest2InvSupplies invSup, Forest2InvWeapons invWep) {
		if ((invAmmo.ammoWt() + invArmor.armorWt() + invSup.supWt() + invWep.wepWt()) < player.lv * 10 + 100) {
			if (player.rp > 10) {
				Random rand = new Random();
				int n = rand.nextInt(7) + 4;
				player.rp = player.rp - n;
				player.distance = player.distance + n;
				System.out.println("You traveled " + n + "km.");
			} else {
				System.out.println("You are too tired to travel!");
			}
		} else {
			System.out.println("Your items weigh too much to travel!");
		}
	}

	public static void sleep(Forest2Player player) {
		Random rand = new Random();
		int n = rand.nextInt(7) + 4;
		player.food = (int) (player.food - Math.floor(n / 3));
		player.water = (int) (player.water - Math.floor(n / 2));
		player.rp = player.rp + (n * 3);
		System.out.println("You slept for " + n + " hours.");
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
