package cpuLogger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class cpuLMain {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		/**
		 * i is the main counter that defines the next empty position that can be filled
		 * to prevent existing entries from being over written
		 */
		int i = 0;
		int maxSize = 10;
		cpuL[] store = new cpuL[maxSize];

		while (true) {
			int opt = 10;
			while (opt != 0 && opt != 1 && opt != 2 && opt != 3 && opt != 4 && opt != 5) {
				System.out.println("CPU OVERCLOCKING LOG SYSTEM");
				System.out.println("1. INPUT NEW LOG");
				System.out.println("2. SEARCH EXISTING ENTRIES");
				System.out.println("3. PRINT AN ENTRY");
				System.out.println("4. READ FROM FILE");
				System.out.println("5. WRITE TO FILE");
				System.out.println("0. EXIT PROGRAM");
				opt = sc.nextInt();
			}
			if (opt == 1) {
				i = takeInput(i, maxSize, store);
			} else if (opt == 2) {
				search(store, maxSize);
			} else if (opt == 3) {
				print(store);
			} else if (opt == 4) {
				read(store);
			} else if (opt == 5) {
				write(store, maxSize);
			} else if (opt == 0) {
				System.out.println("END OF PROGRAM");
				System.exit(0);
			} else {
				System.out.println("INVALID INPUT");
			}
		}
	}

	public static int takeInput(int i, int maxSize, cpuL[] store) {
		Scanner sc = new Scanner(System.in);

		System.out.println("INPUT MODE");

		String[] type = new String[maxSize];
		String[] family = new String[maxSize];
		String[] model = new String[maxSize];
		String[] socket = new String[maxSize];
		int[] freq = new int[maxSize];
		int[] freqOC = new int[maxSize];
		int[] fsb = new int[maxSize];
		int[] width = new int[maxSize];
		int[] core = new int[maxSize];
		int[] thread = new int[maxSize];
		float[] multiMin = new float[maxSize];
		float[] multiMax = new float[maxSize];
		float[] vcoreBase = new float[maxSize];
		float[] vcoreMax = new float[maxSize];
		float[] vcoreOC = new float[maxSize];

		boolean read = true;

		while (read == true) {
			System.out.print("Type: ");
			type[i] = sc.next().toUpperCase();
			System.out.print("Family: ");
			family[i] = sc.next().toUpperCase();
			System.out.print("Model: ");
			model[i] = sc.next().toUpperCase();
			System.out.print("Socket: ");
			socket[i] = sc.next().toUpperCase();
			System.out.print("Base Clock Speed (MHz): ");
			freq[i] = sc.nextInt();
			System.out.print("OC Clock Speed (MHz): ");
			freqOC[i] = sc.nextInt();
			System.out.print("Base FSB Speed (MHz): ");
			fsb[i] = sc.nextInt();
			System.out.print("Data Width (bits): ");
			width[i] = sc.nextInt();
			System.out.print("Core Count: ");
			core[i] = sc.nextInt();
			System.out.print("Thread Count: ");
			thread[i] = sc.nextInt();
			System.out.print("Minimum Multiplier: ");
			multiMin[i] = sc.nextFloat();
			System.out.print("Maximum Multiplier: ");
			multiMax[i] = sc.nextFloat();
			System.out.print("Base Vcore (V): ");
			vcoreBase[i] = sc.nextFloat();
			System.out.print("Maximum Rated Vcore (V): ");
			vcoreMax[i] = sc.nextFloat();
			System.out.print("OC Vcore (V): ");
			vcoreOC[i] = sc.nextFloat();

			// end of taking inputs
			i += 1; // shifts counter position for new data set
			String contTest = "a";
			while (!"y".equals(contTest) && !"n".equals(contTest)) {
				System.out.println("Would you like to input another data set? (Y/N)");
				contTest = sc.next().toLowerCase();
			}
			if (contTest.equals("n")) {
				read = false;
				System.out.println("END OF TAKING INPUTS");
			}
		}

		for (int j = 0; j < type.length; j++) {
			store[j] = new cpuL(type[j], family[j], model[j], socket[j], freq[j], freqOC[j], fsb[j], width[j], core[j],
					thread[j], multiMin[j], multiMax[j], vcoreBase[j], vcoreMax[j], vcoreOC[j]);
		}
		return i;
	}

	public static void search(cpuL[] store, int maxSize) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String result = "|";
		System.out.println("SEARCH MODE");
		System.out.println("1. SEARCH BY FAMILY & MODEL");
		System.out.println("2. SEARCH BY BASE CLOCK SPEED");
		System.out.println("3. SEARCH BY OC CLOCK SPEED");
		System.out.println("4. SEARCH FOR MAX OC SPEED");

		int opt = sc.nextInt();

		if (opt == 1) {
			String family = null;
			String model = null;
			System.out.print("FAMILY: ");
			family = sc2.nextLine().toUpperCase();
			System.out.print("MODEL: ");
			model = sc2.nextLine().toUpperCase();
			for (int i = 0; i < maxSize; i++) {
				if (store[i].family == null) {
					break;
				} else if (store[i].family.equals(family) && store[i].model.equals(model)) {
					result = result + i + "|";
				}
				System.out.println(result);
			}
		} else if (opt == 2) {
			System.out.print("Base Clock Speed (MHz): ");
			int freq = sc.nextInt();
			for (int i = 0; i < maxSize; i++) {
				if (store[i].family == null) {
					break;
				} else if (store[i].freq == freq) {
					result = result + i + "|";
				}
			}
			System.out.println(result);
		} else if (opt == 3) {
			System.out.print("OC Clock Speed (MHz): ");
			int freqOC = sc.nextInt();
			for (int i = 0; i < maxSize; i++) {
				if (store[i].family == null) {
					break;
				} else if (store[i].freqOC == freqOC) {
					System.out.println(result);
				}
			}
			result = result + "|";
		} else if (opt == 4) {
			int freqOC = 0;
			for (int i = 0; i < maxSize; i++) {
				if (store[i].family == null) {
					break;
				}
				if (store[i].freqOC > freqOC) {
					freqOC = store[i].freqOC;
				}
			}
			System.out.println(freqOC);
		}
	}

	public static void print(cpuL[] store) {
		System.out.println("PRINT MODE");
		Scanner sc = new Scanner(System.in);
		int in = 0;
		System.out.print("LOG ID: ");
		in = sc.nextInt();
		System.out.println(store[in]);
	}

	public static void read(cpuL[] store) {
		System.out.println("READ MODE");
		/**
		String temp = null;
		try {
			sc = new Scanner(new File("cpuLog.txt"));
		} catch (Exception e) {
			System.out.println("READ ERROR");
		}
		
		String arraySet[] = sc.toString().split("\\");
		String arrayCat[] = null;
		for (int i = 0; arraySet.length > i; i++) {
			temp = arraySet[i];
			arrayCat[i] = temp.split("|");
		}*/
		Scanner sc = null;
		try {
			sc = new Scanner(new File("cpuLog.txt"));
		} catch (Exception e) {
			System.out.println("READ ERROR");
		}
		int i = 0;
		while (sc.hasNext()) {
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
			
			store[i] = new cpuL (type, family, model, socket, Integer.parseInt(freq), Integer.parseInt(freqOC), Integer.parseInt(fsb), Integer.parseInt(width), Integer.parseInt(core), Integer.parseInt(thread), Float.parseFloat(multiMin), Float.parseFloat(multiMax), Float.parseFloat(vcoreBase), Float.parseFloat(vcoreMax), Float.parseFloat(vcoreOC));
		}
		sc.close();
		// System.out.println("DATA HAS BEEN LOADED");
	}

	public static void write(cpuL[] store, int maxSize) {
		System.out.println("WRITE MODE");
		/**
		 * write everything to file on one line
		 */
		Formatter x = null;

		try {
			x = new Formatter("cpuLog.txt");
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		for (int i = 0; i < maxSize; i++) {
			if (store[i].family == null) {
				break;
			} else {
				x.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", store[i].type, " ", store[i].family, " ", store[i].model, " ", store[i].socket, " ", store[i].freq, " ", store[i].freqOC, " ", store[i].fsb, " ", store[i].width, " ", store[i].core, " ", store[i].thread, " ", store[i].multiMin, " ", store[i].multiMax, " ", store[i].vcoreBase, " ", store[i].vcoreMax, " ", store[i].vcoreOC);
			}
		}
		
		x.close();
		System.out.println("DATA HAS BEEN WRITTEN TO FILE");
	}
}
