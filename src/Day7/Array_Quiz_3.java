package Day7;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * <pre>
 * Day7
 * Array_Quiz_3.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 5.	
 *
 */
public class Array_Quiz_3 {

	public static void main(String[] args) {

//		13번 문제
//		배열의 크기가 5인 배열이 있습니다.
//		랜덤으로 1 ~ 9 까지의 값을 각 배열에 저장을 합니다.
//		단, 같은 값이 들어 갈 수 없습니다.
//		각각 다른 값으로 배열 5개의 값을 랜덤으로 채워주세요.
//		이렇게 랜덤값을 채워 준 뒤에 값을 오름 차순으로 정렬을 해주세요.
//		예) 
//			a[0] = 5		a[0] = 2
//			a[1] = 3		a[1] = 3
//			a[2] = 2........a[2] = 5
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int[] randomNumber = new int[5];
		
		//중복방지 랜덤값
		for (int i=0; i<randomNumber.length; i++) { 
			randomNumber[i] = random.nextInt(9)+1;
            for(int j=0; j<i; j++) {
                if(randomNumber[i] == randomNumber[j]) {
                    i--; 
                }
            }
		}
		
		for(int i=0; i<randomNumber.length; i++) {
			System.out.print("a["+ i + "] = " + randomNumber[i] + " / ");
		}
		
		System.out.println();
		
		for(int j=0; j<randomNumber.length; j++) {
			for(int k=j; k<randomNumber.length; k++) {
				if(randomNumber[k] < randomNumber[j]) {	
					int sortNumber = randomNumber[j];
					randomNumber[j] = randomNumber[k];
					randomNumber[k] = sortNumber;
				}
			}
		}
		
		for(int j=0; j<randomNumber.length; j++) {
			System.out.print("a["+ j + "] = " + randomNumber[j] + " / ");
		}
	}
}
