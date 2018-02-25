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
		return Forest2Menu.menuInput();
	}
	
	public static int consumables() {
		System.out.println("===== Consumables =====");
		System.out.println("1. Food & Water");
		System.out.println("2. Meds");
		System.out.println("3. Special");
		System.out.println("0. Back");
		return Forest2Menu.menuInput();
	}
	
	public static int foodWater() {
		System.out.println("===== Food & Water =====");
		System.out.println("1. Water");
		System.out.println("2. Dried Meat");
		System.out.println("3. Cooked Meat");
		System.out.println("4. MRE");
		System.out.println("0. Back");
		return Forest2Menu.menuInput();
	}
	
	public static int meds() {
		System.out.println("===== Meds =====");
		System.out.println("1. Medkit");
		System.out.println("2. Bandage");
		System.out.println("3. Painkiller");
		System.out.println("0. Back");
		return Forest2Menu.menuInput();
	}
	
	public static int special() {
		System.out.println("1. Bullet");
		System.out.println("0. Back");
		return Forest2Menu.menuInput();
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
		return Forest2Menu.menuInput();
	}

	public static int statsMenu() {
		System.out.println("===== Stats & Inventory =====");
		System.out.println("1. Player Stats");
		System.out.println("2. Weapons");
		System.out.println("3. Armor");
		System.out.println("4. Supplies");
		System.out.println("5. Ammo");
		return Forest2Menu.menuInput();
	}
}
