package slime;

public class Human extends CharactersDTO {

	public Human(String name) {
		setName(name);
		setHp(100);
		setAtk(10);
	}

	public void info() {
		System.out.println("직업 : " + getName());
		System.out.println("체력 : " + getHp());
		System.out.println("공격력 : " + getAtk());
	}

	public void heal() {
		if (getHp() >= 80) {
			System.out.println("체력은 충분하군.");
		} else {
			System.out.println("체력을 회복합니다.");
			setHp(100);
		}
	}

	public void attack(Slime s) {

		s.setHp(s.getHp() - getAtk());

		if (s.getHp() < 1) {
			System.out.println(s.getName() + "는 사망했다.");
		} else {
			System.out.println(s.getName() + "을 공격했다.");
			System.out.println("현재 " + s.getName() + "의 체력은 " + s.getHp() + "이다.");
		}

	}
}
