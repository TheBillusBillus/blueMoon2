package forest2;

import java.util.Random;

public class Forest2MobsAnomalies extends Forest2Mobs {

	public Forest2MobsAnomalies(Forest2Player player) {
		super(player);
		// TODO Auto-generated constructor stub
		this.hp = this.hp*5;
		this.dmg = this.dmg*3;
	}
	
	public void type() {
		Random rand = new Random();
		switch (rand.nextInt(1)) {
		case 0:
			System.out.println("You've encountered a Reaper.");
			this.hp = (int) Math.floor(this.hp*1.5);
			this.dmg = (int) Math.floor(this.dmg*1.3);
			this.name = "Reaper";
			break;
		}
	}

	public void special(Forest2Player player) {
		//randomly generate int n for a special effect
		Random rand = new Random();
		switch (rand.nextInt(1)) {
		case 0:
			player.rp = player.rp - 30;
			System.out.println("A strange fog surounds you and slows your movement.");
			System.out.println("- RP 30");
		}	
	}
	
	public Boolean run(Forest2Player player) {
		if (this.lv < player.lv) {
			System.out.println("You managed to out run the anomaly.");
			return true;
		} else {
			System.out.println("You tried to out run the anomaly but it quickly caught up to you.");
			return false;
		}
	}

	public void loot(Forest2InvSupplies invSup) {
		invSup.radRock++;
	}
}
