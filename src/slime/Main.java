package slime;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Forest forest = new Forest();
		Human hunter = new Human("헌터 지망생");

		int no;

		while (true) {
			
			if(hunter.getHp()<1) {
				hunter.heal();
				System.out.println("죽을 뻔 했군. 좀 더 신중하게 행동해야 겠어.");
			}
			
			System.out.println("==============================");
			System.out.println("슬라임 숲의 입구다.");
			System.out.println("뭘 해야 하지?");
			System.out.println("1. 상태 점검");
			System.out.println("2. 회복");
			System.out.println("3. 사냥");
			System.out.println("9. 돌아가기");
			no = sc.nextInt();

			switch (no) {
			case 1:
				hunter.info();
				break;
			case 2:
				hunter.heal();
				break;
			case 3:
				forest.enter(hunter);
				break;
			case 9:
				System.out.println("오늘은 그만하겠어.");
				return;
			default:
				System.out.println("내가 할 수 없는 행동이야");
				break;
			}

		}
	}

}
