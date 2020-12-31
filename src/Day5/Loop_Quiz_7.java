package Day5;

import java.util.Random;
import java.util.Scanner;

public class Loop_Quiz_7 {

	public static void main(String[] args) {
		
		// 10 - 1
		//3개의 변수의 1~9까지 랜덤 수를 부여합니다.
		//각각의 변수의 숫자가 다른게 가질 수 있게 구현
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int random_1;
		int random_2;
		int random_3;
		
		int input_1;
		int input_2;
		int input_3;
		
		int strike;
		int ball;
		
		while(true) {
			
			random_1 = random.nextInt(10);
			random_2 = random.nextInt(10);
			random_3 = random.nextInt(10);
			
			if((random_2 == random_1) || (random_2 == random_3)) {                        //     같은 숫자가 있을 경우 재설정
				random_2 = random.nextInt(10);
            }else if((random_3 == random_1) || (random_3 == random_2)) {
            	random_3 = random.nextInt(10);
            }else {
            	System.out.println("random_1 : " + random_1);
    			System.out.println("random_2 : " + random_2);
    			System.out.println("random_3 : " + random_3);
            	break;
            }
		}
		
		// 10 - 2
		//* 변수만을 이용한 숫자 야구 게임
		// 자리수 3개 일치 여부에 따라 
		// 홈런입니다 / 2Strike / 3B / OUT입니다
		while(true) {
			
			//랜덤 3개 수
			random_1 = random.nextInt(10);
			random_2 = random.nextInt(10);
			random_3 = random.nextInt(10);
			
			if((random_2 == random_1) || (random_2 == random_3)) {                        //     같은 숫자가 있을 경우 재설정
				random_2 = random.nextInt(10);
            }else if((random_3 == random_1) || (random_3 == random_2)) {
            	random_3 = random.nextInt(10);
            }else {
            	System.out.println("random_1 : " + random_1);
    			System.out.println("random_2 : " + random_2);
    			System.out.println("random_3 : " + random_3);
            	break;
            }
			
			//입력 3개수 
			System.out.print("첫번째 수를 입력해주세요 : ");
			input_1 = scanner.nextInt();
			System.out.print("두번째 수를 입력해주세요 : ");
			input_2 = scanner.nextInt();
			System.out.print("세번째 수를 입력해주세요 : ");
			input_3 = scanner.nextInt();
			
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
				System.out.println("홈런 입니다.");
			}
			
			
		}
		
	}
}
