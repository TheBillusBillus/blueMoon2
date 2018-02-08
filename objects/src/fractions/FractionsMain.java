package fractions;

public class FractionsMain {
	public static void main(String args[]) {
		Fractions f1 = new Fractions(12);

		System.out.println(f1.printString());

		Fractions[] fractionsArray = new Fractions[10];

		System.out.println("reduced: " + (f1.reduce()).printString());
	}
}