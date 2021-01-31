package Day04;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day4
 * Loop_Quiz_4.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 29.	
 *
 */
public class Loop_Quiz_4 {
	
	public static void main(String[] args) {
		
//		약수를 구하는 프로그램을 구현하세요.
//		
//		예)
//			정수를 입력하세요 : 8(엔터)
//			8의 약수 : 1, 2, 4, 8 입니다. (출력)
//			0 이 입력 되기 전까지는 프로그램이 계속 실행되어야 합니다.
//			만약에 음수가 입력 되면 잘못된 입력입니다. (출력)
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("정수를 입력하세요. : ");
			int input = scanner.nextInt();
			
			if(input != 0) {
				if(input > 0) {
					for(int i=1; i<=(input/2); i++) {
						if(input % i == 0) {
							System.out.print(i + ", ");
						}
					}
					System.out.println(input);	
					System.out.println();	
				}else {
					System.out.println("잘못된 입력입니다.");
					System.out.println();
				}
				continue;
			}else {
				System.out.println("프로그램이 종료됩니다.");
				break;
			}	
		}
	}
}

