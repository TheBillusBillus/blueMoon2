package forest2;

import java.util.Scanner;

public class Forest2Menu {

	public static void welcome() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println("WELCOME MISSING!!!!!");
		System.out.println("WELCOME MISSING!!!!!");
		System.out.println("WELCOME MISSING!!!!!");
	}

	public static void rules() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
		System.out.println("RULES MISSING!!!!!");
		System.out.println("RULES MISSING!!!!!");
		System.out.println("RULES MISSING!!!!!");
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
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		for (int i = 0; i < 50; ++i)
			System.out.println();
		return choice;
	}

	public static void flee() {
		System.out.println("The enemy has fled!");
	}

	public static int campMenu() {
		System.out.println("===== Camp =====");
		System.out.println("1. Camp Fire");
		System.out.println("2. Dry meat");
		System.out.println("3. Sleep");
		System.out.println("0. Back");
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		for (int i = 0; i < 50; ++i)
			System.out.println();
		return choice;
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
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		for (int i = 0; i < 50; ++i)
			System.out.println();
		return choice;
	}

	public static int saveMenu() {
		System.out.println("===== Save & Load =====");
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		for (int i = 0; i < 50; ++i)
			System.out.println();
		return choice;
	}

	public static void statsMenu() {

	}
}
