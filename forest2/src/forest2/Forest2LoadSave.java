package forest2;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class Forest2LoadSave {
	public static void load() {
		// System.out.println("READ MODE");
		Scanner sc = null;
		try {
			sc = new Scanner(new File("gameSave.txt"));
		} catch (Exception e) {
			System.out.println("READ ERROR");
		}
		int i = 0;
		while (sc.hasNext()) {
			// replace with code to scan for
			String lv = sc.next();
			String xp = sc.next();
			String hp = sc.next();
			String food = sc.next();
			String water = sc.next();
			String distance = sc.next();
			
		}
		sc.close();
		// System.out.println("DATA HAS BEEN LOADED");
	}

	public static void save(Forest2Player player, Forest2InvAmmo invAmmo, Forest2InvArmor invArmor, Forest2InvSupplies invSup, Forest2InvWeapons invWep) {
		System.out.println("WRITE MODE");
		Formatter x = null;

		try {
			x = new Formatter("gameSave.txt");
		} catch (Exception e) {
			System.out.println("ERROR");
		}

		x.format("%s", player, invAmmo, invArmor, invSup, invWep);
		x.close();
		System.out.println("DATA HAS BEEN WRITTEN TO FILE");
	}

}
