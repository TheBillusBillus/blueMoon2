package forest2;

import java.util.Random;

public class Forest2MobsHumans extends Forest2Mobs {
	public Forest2MobsHumans(Forest2Player player) {
		super(player);
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		this.hp = (int) Math.floor(this.hp*2.5);
		this.dmg = (int) Math.floor(this.dmg*.5);
	}
	
	public void type() {
		Random rand = new Random();
		switch (rand.nextInt(1)) {
		case 0:
			System.out.println("You've encounted a Trapper.");
			this.hp = (int) Math.floor(this.hp*1.5)+1;
			this.dmg = (int) Math.floor(this.dmg*1.3);
			this.name = "Trapper";
			break;
		}
	}

	// if lv is higher than enemy, the enemy will disengage. if lv is 7 or more than
	// the enemy, they will flee, dropping the same loot
	public Boolean threaten(Forest2Player player, Forest2InvAmmo invAmmo, Forest2InvWeapons invWep, Forest2InvArmor invArmor) {
		if (player.lv > this.lv) {
			Forest2Menu.flee();
			return true;
		} 
		if (player.lv > this.lv + 7) {
			System.out.println("In a panic, the enemy left behind some of its items.");
			loot(invAmmo, invWep, invArmor);
			return false;
		} else {
			System.out.println("This isn't the best idea.");
			return false;
		}
	}

	public void loot(Forest2InvAmmo invAmmo, Forest2InvWeapons invWep, Forest2InvArmor invArmor) {
		//drop ammo, guns and armor here
	}
}
