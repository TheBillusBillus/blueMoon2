package forest2;

import java.util.Random;

public class Forest2MobsAnimals extends Forest2Mobs {
	public Forest2MobsAnimals(Forest2Player player) {
		super(player);
		this.hp = (int) Math.floor(this.hp*1.5);
		this.dmg = (int) Math.floor(this.dmg*.3);
		// TODO Auto-generated constructor stub
	}
	
	public void type() {
		Random rand = new Random();
		switch (rand.nextInt(5)) {
		case 0:
			System.out.println("You've encountered a wild rabbit.");
			this.hp = (int) Math.floor(this.hp*0.2)+1;
			this.dmg = (int) Math.floor(this.dmg*0);
			this.name = "rabbit";
			break;
		case 1:
			System.out.println("You've encountered a wild duck.");
			this.hp = (int) Math.floor(this.hp*0.3)+1;
			this.dmg = (int) Math.floor(this.dmg*0.2);
			this.name = "duck";
			break;
		case 2:
			System.out.println("You've encountered a squirrel.");
			this.hp = (int) Math.floor(this.hp*0.2)+1;
			this.dmg = (int) Math.floor(this.dmg*0.3);
			this.name = "squirrel";
			break;
		case 3:
			System.out.println("You've encountered a deer.");
			this.hp = (int) Math.floor(this.hp*1.5)+1;
			this.dmg = (int) Math.floor(this.dmg*1.3);
			this.name = "deer";
			break;
		case 4:
			System.out.println("You've encountered a bear.");
			this.hp = (int) Math.floor(this.hp*2)+1;
			this.dmg = (int) Math.floor(this.dmg*4);
			this.name = "bear";
			break;
		}
	}

	public void flee(Forest2Player player) {
		if (player.lv - 3 > this.lv) {
			Forest2Menu.flee();
		}
	}
	
	public Boolean knife(Forest2Player player, Forest2InvSupplies invSup) {
		if (player.lv - 5 > this.lv) {
			System.out.println("You pulled out your knife and carfully snuck up behind the "+this.name+" and poked it to death.");
			loot(invSup);
			return true;
		} else {
			System.out.println("You pulled out your knife and tried to sneak up behind the "+this.name+".....");
			System.out.println("It wasn't very effective.");
			return false;
		}
	}

	public void loot(Forest2InvSupplies invSup) {
		invSup.rawMeat = (int) (invSup.rawMeat + Math.floor(this.lv/3));
	}
}
