package forest2;

public class Forest2MobsAnimals extends Forest2Mobs {
	public void flee(Forest2Player player) {
		if (player.lv + 6 > this.lv) {
			Forest2Menu.flee();
		}
	}

	public void loot() {

	}
}
