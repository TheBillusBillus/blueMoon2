package forest2;

public class Forest2InvSupplies extends Forest2Inv {
	public int water; // cap at 10
	public int wood;
	public int rawMeat;
	public int cookedMeat;
	public int driedMeat;
	public int mre;
	public int medkit;
	public int bandages;
	public int painkillers;
	public int radRock;

	public Forest2InvSupplies() {
		this.water = 10;
		this.wood = 0;
		this.rawMeat = 0;
		this.cookedMeat = 0;
		this.driedMeat = 0;
		this.mre = 5;
		this.medkit = 3;
		this.bandages = 5;
		this.painkillers = 10;
		this.radRock = 0;
	}

	public double supWt() {
		return (this.water + this.wood + this.mre + this.medkit + this.bandages + this.painkillers) * .1
				+ (this.rawMeat + this.cookedMeat + this.driedMeat + this.radRock) * .5;
	}

	public String toString() {
		return this.water + " " + this.wood + " " + this.rawMeat + " " + this.cookedMeat + " " + this.driedMeat + " "
				+ this.mre + " " + this.medkit + " " + this.bandages + " " + this.painkillers + " " + this.radRock + " ";
	}

}
