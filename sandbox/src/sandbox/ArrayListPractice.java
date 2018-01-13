package sandbox;

import java.util.ArrayList;

public class ArrayListPractice {
	
	/**
	 * mystery2
	 * @param list
	 */
	public static void mystery2(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			if (i % 2 == 0) {
				list.add(list.get(i));
			} else {
				list.add(0, list.get(i));
			}
			System.out.println(list);
		}
	}

	public static void main(String[] args) {
		System.out.println("1. ");
	}
}
