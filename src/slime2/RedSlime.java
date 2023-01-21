package slime2;

public class RedSlime extends Slime {

	public RedSlime(String name) {
		setName(name);
		setHp(70);
		setAtk(20);
	}
	
	@Override
	public Slime getInstance() {
		return new RedSlime(getName());
	}

	public void attack2(Human hunter) {
		attack(hunter, getAtk() * 2);
	}
}
