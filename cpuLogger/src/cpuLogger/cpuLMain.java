package cpuLogger;

import java.util.Scanner;

public class cpuLMain {
	public static void main(String args[]) {

		/**
		 * i is the main counter that defines the next empty position that can be filled
		 * to prevent existing entries from being over written
		 */
		int i = 0;
		int maxSize = 10;
		cpuL[] store = new cpuL[maxSize];

		while (true) {
			int opt = 10;
			Scanner sc = new Scanner(System.in);
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
				i = cpuL.takeInput(i, maxSize, store);
			} else if (opt == 2) {
				cpuL.search(store, maxSize);
			} else if (opt == 3) {
				cpuL.print(store);
			} else if (opt == 4) {
				cpuL.read(store);
			} else if (opt == 5) {
				cpuL.write(store, maxSize);
			} else if (opt == 0) {
				System.out.println("END OF PROGRAM");
				System.exit(0);
			} else {
				System.out.println("INVALID INPUT");
			}
		}
	}

	

	
}
