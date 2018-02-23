package forest2;

public class Forest2Player {
	public int lv;
	public int xp;
	public int hp;
	public int food;
	public int water;
	public int distance;
	
	public Forest2Player () {
		this.lv = 1;
		this.xp = 0;
		this.hp = 100;
		this.food = 100;
		this.water = 100;
		this.distance = 0;
	}
	
	public String toString() {
		return (this.lv + " " + this.xp + " " + this.hp + " " + this.food + " " + this.water + " " + this.distance + " ");
	}
}

