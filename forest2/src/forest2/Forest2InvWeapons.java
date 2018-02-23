package forest2;

public class Forest2InvWeapons extends Forest2Inv {
	public int p9;
	public int p10;
	public int r556;

	/**
	 * r = rifle
	 * p = pistol
	 */
	public Forest2InvWeapons() {
		this.p9 = 0;
		this.p10 = 0;
		this.r556 = 0;
	}
	
	public String toString() {
		return this.p9 + " " + this.p10 + " " + this.r556 + " ";
	}
}
