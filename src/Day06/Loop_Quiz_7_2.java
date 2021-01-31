package Day06;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * <pre>
 * Day6
 * Loop_Quiz_7_2.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 4.	
 *
 */
public class Loop_Quiz_7_2 {

	public static void main(String[] args) {
		
//		 10 - 2
//		* 변수만을 이용한 숫자 야구 게임
//		 자리수 3개 일치 여부에 따라 
//		 홈런입니다 / 2Strike / 3B / OUT입니다
		
//		컴퓨터가 3개의 1~9까지의 다른숫자가 변수에 담겨있습니다.
//		숫자야구게임을 시작합니다.
//		첫번째 숫자를 입력하세요. : 5
//		두번째 숫자를 입력하세요. : 4
//		세번째 숫자를 입력하세요. : 2
//		out / 1, 2 strike / 1,2,3 ball / 홈런
		
		boolean gameStart = true;
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int random_1 = 0;
		int random_2 = 0;
		int random_3 = 0;
		
		int input_1;
		int input_2;
		int input_3;
		
		int strike = 0;
		int ball = 0;
		
		while(gameStart) {
			
			//랜덤 3개 수
			random_1 = random.nextInt(9)+1;
			random_2 = random.nextInt(9)+1;
			random_3 = random.nextInt(9)+1;
			
			if((random_2 == random_1) || (random_2 == random_3)) {                        //     같은 숫자가 있을 경우 재설정
				random_2 = random.nextInt(9)+1;
            }else if((random_3 == random_1) || (random_3 == random_2)) {
            	random_3 = random.nextInt(9)+1;
            }else {
            	gameStart = false;
            }
		
			System.out.println();
			System.out.println("===== 게임을 시작합니다. =====");
			System.out.println("랜덤숫자 : " + random_1 + random_2 + random_3);
			//입력 3개수 
			System.out.print("첫번째 숫자를 입력해주세요. : ");
			input_1 = scanner.nextInt();
			System.out.print("두번째 숫자를 입력해주세요. : ");
			input_2 = scanner.nextInt();
			System.out.print("세번째 숫자를 입력해주세요. : ");
			input_3 = scanner.nextInt();
			System.out.println("입력한 숫자 : " + input_1 + ", " + input_2 + ", " + input_3);
			System.out.println();
			
			//strike인 경우
			strike = 0;
			if(input_1 == random_1) {
				strike++;
			}
			if(input_2 == random_2) {
				strike++;
			}
			if(input_3 == random_3) {
				strike++;
			}
			
			//ball인 경우
			ball = 0;
			if((input_1 == random_2) || (input_1 == random_3)) {
				ball++;
			}
			if((input_2 == random_1) || (input_2 == random_3)) {
				ball++;
			}
			if((input_3 == random_1) || (input_3 == random_2)) {
				ball++;
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
				}
				gameStart = true;	
			}

		}	
	}
}
