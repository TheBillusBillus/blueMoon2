package forest2;

import java.util.Scanner;

public class Forest2Menu {

	public static void welcome() {
		System.out.println("WELCOME MISSING!!!!!");
		System.out.println("WELCOME MISSING!!!!!");
		System.out.println("WELCOME MISSING!!!!!");
	}

	public static void rules() {
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
		System.out.println("7. Exit");
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		scanInt.close();
		return choice;
	}
	
	public static void flee() {
		System.out.println("The enemy has fled!");
	}
	
	public static int campMenu() {
		System.out.println("===== Camp =====");
		System.out.println("1. Camp Fire");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("");
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		scanInt.close();
		return choice;
	}
	
	public static int campFireMenu() {
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		scanInt.close();
		return choice;
	}
	
	public static int saveMenu() {
		System.out.println("===== Save & Load =====");
		Scanner scanInt = new Scanner(System.in);
		int choice = scanInt.nextInt();
		scanInt.close();
		return choice;
	}
	
	public static void statsMenu() {
		
	}
}
