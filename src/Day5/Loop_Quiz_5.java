package Day5;

import java.util.Random;
import java.util.Scanner;

public class Loop_Quiz_5 {

	public static void main(String[] args) {
		
//		** 가위 바위 보 게임
//		    1. 게임 시작 2. 종료 : 
//			1. 가위 2. 바위 3. 보를 선택해주세요 : 
		
//			com의 가위 바위 보는 랜덤으로 구해서 가위, 바위, 보를 정하면 됩니다.
//			게임결과 : user 승 또는 com 승
//			종료되기 전까지 게임이 계속되어야 합니다.

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		while(true) {
				
			System.out.print("1. 게임시작 2. 종료 : ");
			int select_0 = scanner.nextInt();

			//경우의 수 
			//사용자가 승리 확률 
			//	user 1 computer 3 사용자 승리 
			//	user 2 computer 1 사용자 승리
			// 	user 3 computer 2 사용자 승리
			//컴퓨터가 승리 확률 
			//	computer 1 user 3 computer 승리 
			//	computer 2 user 1 computer 승리
			//	computer 3 user 2 computer 승리
			
			if((select_0 < 3) && (select_0 > 0)) {
				
				if(select_0 == 1) {
					
					System.out.print("1.가위, 2.바위, 3.보 무엇을 내시겠습니까? : ");
					
					int user = scanner.nextInt();
					int computer = random.nextInt(3)+1;
					System.out.println("user 값은 : " + user);
					System.out.println("computer 값은 : " + computer);
					
					if((user-computer == -2) || (user-computer == 1)) {
						System.out.println("사용자 승리");
					}else if((computer-user == -2) || (computer-user == 1)){ 
						System.out.println("컴퓨터 승리");
					}else {
						System.out.println("비겼습니다.");
						
					}
					continue;
				}else if (select_0 == 2) {
					System.out.println("종료합니다. ");
					break;
				}
			}else {
				System.out.println("번호를 다시 선택해주세요.");
				continue;
			}
		}
		
	}
}
