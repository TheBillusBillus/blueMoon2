package forest2;

public class Forest2InvWeapons extends Forest2Inv {
	public int p9;
	public int p10;
	public int r556;

	public int charge;

	public Forest2InvWeapons() {
		this.p9 = 1;
		this.p10 = 1;
		this.r556 = 1;

		this.charge = 1;
	}

	public double wepWt() {
		return this.p9 * 3 + this.p10 * 3 + this.r556 * 10 + this.charge * 5;
	}

	public String toString() {
		return this.p9 + " " + this.p10 + " " + this.r556 + " " + this.charge + " ";
	}
}
