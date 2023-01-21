package slime;

public class Slime extends CharactersDTO {

	public Slime() {}

	public Slime(String name) {
		setName(name);
		setHp(50);
		setAtk(10);
	}
	
	public Slime getInstance() {
		return new Slime(getName());
	}

	public void attack(Human hunter) {
		attack(hunter, getAtk());
	}

	public void attack(Human hunter, int damage) {
		if (getHp() > 0) {
			hunter.setHp(hunter.getHp() - damage);

			if (hunter.getHp() < 1) {
				System.out.println("Game Over");
				return;
			}

			if (damage < 30) {
				System.out.println(getName() + "의 공격. " + hunter.getName() + "의 체력은 " + hunter.getHp() + "이다.");
			} else {
				System.out.println(getName() + "의 강한 공격. " + hunter.getName() + "의 체력은 " + hunter.getHp() + "이다.");
			}

		}

	}
}
