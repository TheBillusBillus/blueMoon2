package forest2;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class Forest2LoadSave {
	public static void load(Forest2Player player, Forest2InvAmmo invAmmo, Forest2InvArmor invArmor,
			Forest2InvSupplies invSup, Forest2InvWeapons invWep) {
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
			player.lv = Integer.parseInt(sc.next());
			player.xp = Integer.parseInt(sc.next());
			player.hp = Integer.parseInt(sc.next());
			player.rp = Integer.parseInt(sc.next());
			player.food = Integer.parseInt(sc.next());
			player.water = Integer.parseInt(sc.next());
			player.distance = Integer.parseInt(sc.next());
			player.fire = Boolean.parseBoolean(sc.next());
			invAmmo.cal22 = Integer.parseInt(sc.next());
			invAmmo.cal9 = Integer.parseInt(sc.next());
			invAmmo.cal10 = Integer.parseInt(sc.next());
			invAmmo.cal44 = Integer.parseInt(sc.next());
			invAmmo.cal45 = Integer.parseInt(sc.next());
			invAmmo.cal50ae = Integer.parseInt(sc.next());
			invAmmo.cal556 = Integer.parseInt(sc.next());
			invAmmo.cal762x39 = Integer.parseInt(sc.next());
			invAmmo.cal762x51 = Integer.parseInt(sc.next());
			invAmmo.cal50 = Integer.parseInt(sc.next());
			invArmor.leather = Integer.parseInt(sc.next());
			invArmor.plate2 = Integer.parseInt(sc.next());
			invArmor.plate3 = Integer.parseInt(sc.next());
			invArmor.plate3a = Integer.parseInt(sc.next());
			invArmor.plate4 = Integer.parseInt(sc.next());
			invSup.water = Integer.parseInt(sc.next());
			invSup.wood = Integer.parseInt(sc.next());
			invSup.rawMeat = Integer.parseInt(sc.next());
			invSup.cookedMeat = Integer.parseInt(sc.next());
			invSup.mre = Integer.parseInt(sc.next());
			invSup.medkit = Integer.parseInt(sc.next());
			invSup.bandages = Integer.parseInt(sc.next());
			invSup.painkillers = Integer.parseInt(sc.next());
			invSup.radRock = Integer.parseInt(sc.next());

		}
		sc.close();
		// System.out.println("DATA HAS BEEN LOADED");
	}

	public static void save(Forest2Player player, Forest2InvAmmo invAmmo, Forest2InvArmor invArmor,
			Forest2InvSupplies invSup, Forest2InvWeapons invWep) {
		System.out.println("WRITE MODE");
		Formatter x = null;

		try {
			x = new Formatter("gameSave.txt");
		} catch (Exception e) {
			System.out.println("ERROR");
		}

		x.format("%s%s%s%s%s", player, invAmmo, invArmor, invSup, invWep);
		x.close();
		System.out.println("DATA HAS BEEN WRITTEN TO FILE");
	}

}
