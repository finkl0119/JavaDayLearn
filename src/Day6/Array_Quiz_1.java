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
public class Array_Quiz_1 {

	public static void main(String[] args) {

//		배열의 크기가 10개인 배열을 만드세요. 
//		그리고 각각의 배열안에 값이 0~10까지 랜덤수를 추출하여 넣어줍니다.
//		배열안의 값중에 가장 큰값이 몇번째 index에 있는지 출력
//		단, 가장 큰값이 같은 값이 있으면, index를 같이 출력해주세요.
//		출력 : 가장 큰 값이 5번 index 입니다.
		
		Random random = new Random();
		
		int intArray[] = new int[10];
		int indexNumber = 0;
		int maxNumber = 0;
		
		for(int i=0; i<intArray.length; i++) {
			intArray[i] = random.nextInt(10)+1;
			System.out.println("랜덤 수 : " + intArray[i]);
			if(intArray[maxNumber] <= intArray[i]) {
				maxNumber = i;
			}	
		}		
		for(int i=0; i<intArray.length; i++) {
			if(intArray[maxNumber] == intArray[i]) {
				indexNumber = i + 1;
				System.out.println("최대값은 " + intArray[maxNumber] + " / index는 " + indexNumber + "번째 입니다.");
			}
		}
	}
}
