package fractions;

import java.util.Random;

public class Fractions {

	private int num;
	private int denom;

	/**
	 * Fractions is the name of the class and object in the class. when an objectin
	 * in a class is the same as the name of the class, it is recognized as the
	 * constructor (case sensitive).
	 */
	public Fractions(int num, int d) {
		this.num = num;
		this.denom = d;
	}

	/**
	 * random Fraction generator
	 */
	public Fractions(int n) {
		Random rand = new Random();
		int d = rand.nextInt(20) + n * 4;
		this.num = n;
		this.denom = d;
	}

	// access methods
	public int getNum() {
		return this.num;
	}

	public int getDenom() {
		return this.denom;
	}

	// mutator method
	public void changeNum(int a) {
		this.num = a;
	}

	public void changeDenom(int a) {
		while (a != 0) {
			this.denom = a;
		}
	}

	/**
	 * finds GCD recursively
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public Fractions reduce() {
		int d;
		if (this.num == this.denom) {
			this.num = 1;
			this.denom = 1;
			return this;
		}
		if (this.num > this.denom) {
			d = gcd(this.num, this.denom);
			this.num = this.num / d;
			this.denom = this.denom / d;
		} else {
			d = gcd(this.denom, this.num);
			this.num = this.num / d;
			this.denom = this.denom / d;
		}
		return this;
	}

	// print method
	public String printString() {
		return this.num + "/" + this.denom;
	}

	public String printArray() {
		/**
		 * LOOP THROUGH ARRAY AND PRINT EVERYTHING
		 */
		return null;
	}
}
