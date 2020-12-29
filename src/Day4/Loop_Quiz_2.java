package Day4;

import java.util.Scanner;

public class Loop_Quiz_2 {

	public static void main(String[] args) {
		
//		1. 원하는 구구단 출력
//		2. 전체 구구단 출력
//		3. 종료
//		<첫화면>
//		1번 입력 시
//		- 원하는 구구단 : 5 => 5단 출력
//		2번 입력 시 
//		- 전체 구구단 출력
//		3번 입력 시 
//		- 프로그램 종료
//		
//		단, 1번 2번 실행 시 끝나면 첫화면으로 이동
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println();
			
			System.out.println("1. 원하는 구구단 출력");
			System.out.println("2. 전체 구구단 출력");
			System.out.println("3. 종료");
			
			System.out.println();
			System.out.print("번호를 입력해주세요. : ");
			
			int input = scanner.nextInt();
			
			if((input < 4) && (input > 0)) {
				//1번 입력 시 
				if(input == 1) {
					System.out.print("원하는 구구단 : ");
					int input_1 = scanner.nextInt();
					if((input_1 > 1) && (input_1 < 10)) {
						for(int i=1; i<10; i++) {
							System.out.print(input_1+ "*" + i+ "=" + input_1*i);
							System.out.print('\t');
							System.out.println();
						}
					}else {
						System.out.println("구구단 범위가 넘어갔습니다.");
					}
					continue;
				}
				//2번 입력 시
				if(input == 2) {
					for(int i=1; i<10; i++) {
						for(int j=2; j<6; j++) {
							System.out.print(j+ "*" + i+ "=" + j*i);
							System.out.print('\t');						
						}
						System.out.println();
					}
					System.out.println();
					for(int i=1; i<10; i++) {
						for(int j=6; j<10; j++) {
							System.out.print(j+ "*" + i+ "=" + j*i);
							System.out.print('\t');						
						}
						System.out.println();
					}
					continue;
				}
				//3번 입력
				if(input == 3) {
					System.out.println("프로그램 종료 되었습니다.");
					break;
				}
			}else {
				System.out.println("잘못된 입력입니다.");
				continue;
			}	
		}
		
	}
}
