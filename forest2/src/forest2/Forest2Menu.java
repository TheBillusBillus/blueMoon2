package forest2;

import java.util.Scanner;

public class Forest2Menu {

	public static void welcome() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println("WELCOME MISSING!!!!!");
	}

	public static void rules() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println("RULES & TUTORIAL MISSING!!!!!");
	}

	public static int menuInput() {
		Scanner scanInt = new Scanner(System.in);
		try {
			int choice = scanInt.nextInt();
			for (int i = 0; i < 50; ++i)
				System.out.println();
			return choice;
		} catch (Exception e) {
			for (int i = 0; i < 50; ++i)
				System.out.println();
			System.out.println("Invalid input!");
			return 0;
		}
	}

	public static int mainMenu() {
		System.out.println("===== Main Menu =====");
		System.out.println("1. Hunt");
		System.out.println("2. Scavenge");
		System.out.println("3. Camp");
		System.out.println("4. Travel");
		System.out.println("5. Stats & Inventory");
		System.out.println("6. Save");
		System.out.println("7. Load");
		System.out.println("8. Exit");
		return Forest2Menu.menuInput();
	}

	public static void flee() {
		System.out.println("The enemy has fled!");
	}

	public static int campMenu() {
		System.out.println("===== Camp =====");
		System.out.println("1. Camp Fire");
		System.out.println("2. Dry meat");
		System.out.println("3. Comsumables");
		System.out.println("4. Sleep");
		System.out.println("0. Back");
		return menuInput();
	}

	public static int consumables() {
		System.out.println("===== Consumables =====");
		System.out.println("1. Food & Water");
		System.out.println("2. Meds");
		System.out.println("3. Special");
		System.out.println("0. Back");
		return menuInput();
	}

	public static int foodWater() {
		System.out.println("===== Food & Water =====");
		System.out.println("1. Water");
		System.out.println("2. Dried Meat");
		System.out.println("3. Cooked Meat");
		System.out.println("4. MRE");
		System.out.println("0. Back");
		return menuInput();
	}

	public static int meds() {
		System.out.println("===== Meds =====");
		System.out.println("1. Medkit");
		System.out.println("2. Bandage");
		System.out.println("3. Painkiller");
		System.out.println("0. Back");
		return menuInput();
	}

	public static int special() {
		System.out.println("===== Specials =====");
		System.out.println("1. Bullet");
		System.out.println("2. Irradiated Rock");
		System.out.println("0. Back");
		return menuInput();
	}

	public static int campFireMenu(Forest2Player player) {
		System.out.println("===== Camp Fire =====");
		if (Forest2Actions.checkFire(player)) {
			System.out.println("1. You already have a fire");
		} else {
			System.out.println("1. Start camp fire");
		}
		System.out.println("2. Cook meat");
		System.out.println("3. Boil water");
		System.out.println("0. Back");
		return menuInput();
	}

	public static int statsMenu() {
		System.out.println("===== Stats & Inventory =====");
		System.out.println("1. Player Stats");
		System.out.println("2. Weapons");
		System.out.println("3. Armor");
		System.out.println("4. Supplies");
		System.out.println("5. Ammo");
		System.out.println("0. Back");
		return menuInput();
	}

	public static void statsPlayer(Forest2Player player) {
		System.out.println("===== Player Stats ======");
		System.out.println("Lv: " + player.lv);
		System.out.println("XP: " + player.xp);
		System.out.println("HP: " + player.hp);
		System.out.println("RP: " + player.rp);
		System.out.println("Food: " + player.food);
		System.out.println("Water: " + player.water);
		System.out.println("Distance Traveled: " + player.distance);
	}

	public static void statsWep(Forest2InvWeapons invWep) {
		System.out.println("===== Weapons =====");
		System.out.println("9mm Pistol: " + invWep.p9);
		System.out.println("10mm Pistol: " + invWep.p10);
		System.out.println("M16: " + invWep.r556);
		System.out.println("Explosive Charge: " + invWep.charge);
	}

	public static void statsArmor(Forest2InvArmor invArmor) {
		System.out.println("===== Armor =====");
		System.out.println("Leather Armor: "+invArmor.leather);
		System.out.println("Lv 2 Chestplate: "+invArmor.plate2);
		System.out.println("Lv 3 Chestplate: "+invArmor.plate3);
		System.out.println("Lv 3A Chestplate: "+invArmor.plate3a);
		System.out.println("Lv 4 Chestplate: "+invArmor.plate4);
	}

	public static void statsSup(Forest2InvSupplies invSup) {
		System.out.println("===== Supplies =====");
		System.out.println("Water: " + invSup.water);
		System.out.println("Wood: " + invSup.wood);
		System.out.println("Raw Meat: " + invSup.rawMeat);
		System.out.println("Cooked Meat: " + invSup.cookedMeat);
		System.out.println("Dried Meat: " + invSup.driedMeat);
		System.out.println("MRE: " + invSup.mre);
		System.out.println("Medkit: " + invSup.medkit);
		System.out.println("Bandages: " + invSup.bandages);
		System.out.println("Painkillers:" + invSup.painkillers);
	}

	public static void statsAmmo(Forest2InvAmmo invAmmo) {
		System.out.println("===== Ammo ====");
		System.out.println("22lr: "+invAmmo.cal22);
		System.out.println("9x19mm: "+invAmmo.cal9);
		System.out.println("10mm: "+invAmmo.cal10);
		System.out.println(".44 cal.: "+invAmmo.cal44);
		System.out.println(".45 cal.: "+invAmmo.cal45);
		System.out.println(".50 AE: "+invAmmo.cal50ae);
		System.out.println("5.56x45mm: "+invAmmo.cal556);
		System.out.println("7.62x39mm: "+invAmmo.cal762x39);
		System.out.println("7.62x51mm: "+invAmmo.cal762x51);
		System.out.println(".50 cal: "+invAmmo.cal50);
	}
	
	public static int combat(int type, Forest2Player player, Forest2InvAmmo invAmmo, Forest2InvWeapons invWep) {
		System.out.println("===== Combat =====");
		System.out.println("1. Attack");
		System.out.println("2. Hide");
		switch(type) {
		case 1:
			System.out.println("3. Knife");
			break;
		case 2:
			System.out.println("3. Threaten");
			break;
		case 3:
			System.out.println("3. Run");
			break;
		}
		return menuInput();
	}
	
	public static int combatAttack(Forest2InvAmmo invAmmo, Forest2InvWeapons invWep) {
		System.out.println("===== Weapons =====");
		System.out.println("1. 9mm Pistol: " + invAmmo.cal9 + " rds");
		System.out.println("2. 10mm Pistol: " + invAmmo.cal10 + " rds");
		System.out.println("3. M16: " + invAmmo.cal556 + " rds");
		return menuInput();
	}
}
