package Day03;

import java.util.Random;

/**
 * 
 * <pre>
 * Day3
 * Loop_Quiz_1.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 28.	
 *
 */
public class Loop_Quiz_1 {

	public static void main(String[] args) {
		
//		문자 A(65) ~ Z(90) 랜덤으로 0~25까지 수를 받아서 
//		문자 값에 더하기 연산을해서	문자를 A~Z 중 하나가 출력되도록 하세요.
//		예) 랜덤값이 5가 나오면 
//			65+5 = 70 -> F가 출력
		
		Random random = new Random();
	
		int randomValue = random.nextInt(26);
	
		char alphabet = (char)(('A') + randomValue);
		System.out.println("랜덤 값은 " + randomValue);
		System.out.println("알파벳은 " + alphabet);
		
	}
}
