package forest2;

public class Forest2InvAmmo extends Forest2Inv{
	public int cal22;
	public int cal9;
	public int cal10;
	public int cal44;
	public int cal45;
	public int cal50ae;
	public int cal556;
	public int cal762x39;
	public int cal762x51;
	public int cal50;
	
	
	public Forest2InvAmmo () {
		this.cal22 = 0;
		this.cal9 = 20;
		this.cal10 = 50;
		this.cal44 = 0;
		this.cal45 = 0;
		this.cal50ae = 0;
		this.cal556 = 60;
		this.cal762x39 = 0;
		this.cal762x51 = 0;
		this.cal50 = 0;
	}
	
	public String toString() {
		return this.cal22 + " " + this.cal9 + " " + this.cal10 + " " + this.cal44 + " " + this.cal45 + " " + this.cal50ae + " " + this.cal556 + " " + this.cal762x39 + " " + this.cal762x51 + " " + this.cal50 + " ";
	}
}
