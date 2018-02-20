package forest2;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class Forest2LoadSave {
	public static void load() {
		//System.out.println("READ MODE");
		Scanner sc = null;
		try {
			sc = new Scanner(new File("Forest2Save.txt"));
		} catch (Exception e) {
			System.out.println("READ ERROR");
		}
		int i = 0;
		while (sc.hasNext()) {
			//replace with code to scan for
			
			/**
			String type = sc.next();
			String family = sc.next();
			String model = sc.next();
			String socket = sc.next();
			String freq = sc.next();
			String freqOC = sc.next();
			String fsb = sc.next();
			String width = sc.next();
			String core = sc.next();
			String thread = sc.next();
			String multiMin = sc.next();
			String multiMax = sc.next();
			String vcoreBase = sc.next();
			String vcoreMax = sc.next();
			String vcoreOC = sc.next();

			store[i] = new cpuL(type, family, model, socket, Integer.parseInt(freq), Integer.parseInt(freqOC),
					Integer.parseInt(fsb), Integer.parseInt(width), Integer.parseInt(core), Integer.parseInt(thread),
					Float.parseFloat(multiMin), Float.parseFloat(multiMax), Float.parseFloat(vcoreBase),
					Float.parseFloat(vcoreMax), Float.parseFloat(vcoreOC));
			**/
		}
		sc.close();
		// System.out.println("DATA HAS BEEN LOADED");
	}
	public static void save() {
		System.out.println("WRITE MODE");
		Formatter x = null;

		try {
			x = new Formatter("gameSave.txt");
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		/**
		for (int i = 0; i < maxSize; i++) {
			if (store[i].family == null) {
				break;
			} else {
				x.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", store[i].type, " ", store[i].family, " ", store[i].model, " ", store[i].socket, " ", store[i].freq, " ", store[i].freqOC, " ", store[i].fsb, " ", store[i].width, " ", store[i].core, " ", store[i].thread, " ", store[i].multiMin, " ", store[i].multiMax, " ", store[i].vcoreBase, " ", store[i].vcoreMax, " ", store[i].vcoreOC);
			}
		}
		
		x.close();
		System.out.println("DATA HAS BEEN WRITTEN TO FILE");
		**/
	}
	
}
