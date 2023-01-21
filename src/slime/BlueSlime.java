package slime;

public class BlueSlime extends Slime {

	public BlueSlime(String name) {
		setName(name);
		setHp(30);
		setAtk(5);
	}
	
	@Override
	public Slime getInstance() {
		return new BlueSlime(getName());
	}
	
	public void heal() {
		if (getHp() > 0) {
			setHp(getHp() + 10);
			if (getHp() > 80) {
				setHp(80);
			}

			System.out.println(getName() + "는 치료를 했다. 그의 체력은" + getHp() + "이다.");
		}
	}
}
