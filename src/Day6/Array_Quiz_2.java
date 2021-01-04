package Day6;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * <pre>
 * Day6
 * Array_Quiz_1.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 4.	
 *
 */
public class Array_Quiz_2 {

	public static void main(String[] args) {

		//숫자게임 배열로 바꿔서 구현
		
		boolean gameStart = true;
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int[] inputNumber = new int[3];
		int[] randomNumber = new int[3];	
		
		int number = 0;
		int strike = 0;
		int ball = 0;
		
		while(gameStart) {
			
			//랜덤 3개 수
			for (int i=0; i<randomNumber.length; i++) { 
				randomNumber[i] = random.nextInt(9)+1;
				System.out.print("랜덤 수는 : " + randomNumber[i] + " / ");
			}

			System.out.println();
			System.out.println("===== 게임을 시작합니다. =====");
			
			for (int i=0; i < inputNumber.length; i++) { 
				System.out.print(i+1 + "번째 숫자를 입력해주세요. : ");
				number = scanner.nextInt();
				inputNumber[i] = number; 
			}
			
			for (int i=0; i<randomNumber.length; i++) { 
				for (int j=0; j<inputNumber.length; j++) { 
					if (randomNumber[i] == inputNumber[j] && i == j) { 
						strike++; 
					} else if (randomNumber[i] == inputNumber[j] && i != j) { 
						ball++;
					}
				}
			} 
			
			if(strike == 3) {
				System.out.println("HomeRun ~~~ 입니다.");
				System.out.println();
				gameStart = false;
			}else {
				if(strike == 0 && ball == 0) {
					System.out.println("Out !! 입니다.");
					System.out.println();
				}else {
					System.out.println("결과 : " + strike + " Strike " + " / " + ball + " Ball " );
					System.out.println();
				}
				gameStart = true;	
			}

		}		
	}
}
