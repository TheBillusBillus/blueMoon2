package forest2;
	
public class Forest2InvSupplies extends Forest2Inv {
	public int water; //cap at 10
	public int rawMeat;
	public int cookedMeat;
	public int driedMeat;
	public int medkit;
	public int bandages;
	public int painkillers;
	
	public Forest2InvSupplies() {
		this.water = 10;
		this.rawMeat = 0;
		this.cookedMeat = 0;
		this.driedMeat = 0;
		this.medkit = 3;
		this.bandages = 5;
		this.painkillers = 10;
	}
	
}
