package Day05;

import java.util.Random;
import java.util.Scanner;

public class Loop_Quiz_7_1 {

	public static void main(String[] args) {
		
		// 10 - 1
		//3개의 변수의 1~9까지 랜덤 수를 부여합니다.
		//각각의 변수의 숫자가 다른게 가질 수 있게 구현
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int random_1;
		int random_2;
		int random_3;
		
		while(true) {
			
			random_1 = random.nextInt(9)+1;
			random_2 = random.nextInt(9)+1;
			random_3 = random.nextInt(9)+1;
			
			if((random_2 == random_1) || (random_2 == random_3)) {                        //     같은 숫자가 있을 경우 재설정
				random_2 = random.nextInt(9)+1;
            }else if((random_3 == random_1) || (random_3 == random_2)) {
            	random_3 = random.nextInt(9)+1;
            }else {
            	System.out.println("첫째자리 : " + random_1);
    			System.out.println("둘째자리 : " + random_2);
    			System.out.println("셋째자리 : " + random_3);
            	break;
            }
		}		
	}
}
