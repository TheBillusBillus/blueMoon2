package forest2;

public class Forest2InvArmor extends Forest2Inv {
	public int leather;
	public int plate2;
	public int plate3;
	public int plate3a;
	public int plate4;
	public int dt;

	public Forest2InvArmor() {
		this.leather = 0;
		this.plate2 = 0;
		this.plate3 = 0;
		this.plate3a = 0;
		this.plate4 = 0;
	}

	public double armorWt() {
		return this.leather * 3 + (this.plate2 + this.plate3 + this.plate3a + this.plate4) * 5;
	}
	
	public void dtUpdate() {
		if (plate4>1) {
			dt = 30;
		} else if (plate3a>1) {
			dt = 25;
		} else if (plate3>1) {
			dt = 20;
		} else if (plate2>1) {
			dt = 10;
		} else if (leather>1) {
			dt = 5;
		}
	}

	public String toString() {
		return this.leather + " " + this.plate2 + " " + this.plate3 + " " + this.plate3a + " " + this.plate4 + " ";
	}
}
