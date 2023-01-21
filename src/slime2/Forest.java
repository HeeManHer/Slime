package slime2;

import java.util.Scanner;

public class Forest {

	Scanner sc = new Scanner(System.in);
	
	public void enter(Human hunter) {
		
		if(hunter.getHp()<1) {
			System.out.println("누군가 "+hunter.getName()+"을 숲의 입구까지 옮겼다.");
			return;
		}
		
		System.out.println("갈림길이다. 어떤 슬라임을 잡지?");
		System.out.println("1. 기본 슬라임");
		System.out.println("2. 블루 슬라임");
		System.out.println("3. 레드 슬라임");
		System.out.println("9. 돌아가기");
		int no = sc.nextInt();

		switch (no) {
		case 1:
			System.out.println("기본 슬라임을 잡으러 가자.");
			go(hunter, new Slime("슬림"));
			break;
		case 2:
			System.out.println("블루 슬라임을 잡으러 가자.");
			go(hunter, new BlueSlime("슬람"));
			break;
		case 3:
			System.out.println("레드 슬라임을 잡으러 가자.");
			go(hunter, new RedSlime("슬램"));
			break;
		case 9:
			System.out.println("입구로 돌아가야겠어");
			return;

		default:
			System.out.println("현실을 도피하지 마라. 빨리 정해.");
			break;

		}
		
	}
	
	public void go(Human hunter, Slime s) {

		Slime slime = s.getInstance();
		System.out.println("===== 슬라임 숲 =====");
		System.out.println(s.getName() + "이 나타났다.");
		
		while (true) {
			int no;
			if (slime.getHp() < 1) {
				System.out.println("계속 싸우시겠습니까?");
				System.out.println("1. yes");
				System.out.println("그 외. no");
				no = sc.nextInt();
				
				if(no == 1) {
					slime = s.getInstance();
					System.out.println("새로운 " + slime.getName() + "이 나타났다.");					
				}else {
					System.out.println("힘들어. 이제 그만 할래.");
					return;
				}
			}
			
			System.out.println("1. 공격한다.");
			System.out.println("그 외. 도망간다.");
			no = sc.nextInt();

			switch (no) {
			case 1:
				battle(hunter, slime);
				if(hunter.getHp()<1) {
					System.out.println(hunter.getName()+"은 쓰러졌다.");
					return;
				}
				break;
			case 2:
				System.out.println("무,무서워! 난 못해~~");
				return;
			default:
				System.out.println("내가 할 수 없는 선택이야.");
			}
		}
	}

	public void battle(Human hunter, Slime slime) {
		int rand = (int) (Math.random() * 3);

		if (rand == 0) {
			System.out.println(hunter.getName() + "의 공격은 빗나갔다.");
		} else {
			hunter.attack(slime);
		}

		if (slime.getHp() < 1) {
			return;
		}

		rand = (int) (Math.random() * 3);
		if (rand == 0) {
			if (slime instanceof BlueSlime) {
				((BlueSlime) slime).heal();
			} else if (slime instanceof RedSlime) {
				((RedSlime) slime).attack2(hunter);
			} else {
				System.out.println(slime.getName() + "의 공격이 빗나갔습니다.");
			}
		} else {
			slime.attack(hunter);
		}
	}
}
