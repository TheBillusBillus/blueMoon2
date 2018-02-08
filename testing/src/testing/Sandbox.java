package testing;

import java.util.ArrayList;

public class Sandbox {
	
	public static void mystery1(ArrayList<Integer> list) {
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) < list.get(i - 1)) {
				int element = list.get(i);
				list.remove(i);
				list.add(0, element);
			}
		}
	}
	
	
	public static void removeVowels(ArrayList<String> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == "A") {
				
			}
		}
	}
	
	
	
	public static void main (String[] args) {
		System.out.println("1. ");
		//ArrayList<Integer> list = new ArrayList<Integer>(.asList());
		//mystery1();
	}
}
