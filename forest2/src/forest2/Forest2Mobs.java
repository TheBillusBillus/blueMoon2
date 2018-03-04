package forest2;

import java.util.Random;

public class Forest2Mobs {
	public int lv;
	public int hp;
	public int dmg;
	public String name;

	public Forest2Mobs(Forest2Player player) {
		Random rand = new Random();
		this.lv = rand.nextInt(player.lv+6) + player.lv-5;
		this.hp = this.lv; // to be finalized by type and class
		this.dmg = this.lv; // to be finalized by type and class
	}
}
