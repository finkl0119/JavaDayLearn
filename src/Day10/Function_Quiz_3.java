package Day10;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * <pre>
 * Day10
 * Function_Quiz_3.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 11.	
 *
 */
public class Function_Quiz_3 {

	public static void main(String[] args) {
	
		//========================================
		
		System.out.println("===== 19번 문제 =====");	

//		4-1번 문제 함수화		
//		문자 A(65)에서 랜덤에서 0~25값을 추출(3번함수 주고 안받고)
//		이후에 더하기 연산(1번 주고 받고) 해서 
//		문자를 만듭니다.(1번함수 주고 받고)
//		이랜덤한 분자를 만드는 작업을 10번 실행을 하여서(4번 안주고 안받고)
//		10개 문자를 더하기 연산(1번 주고 받고)
//		10개의 문자를 출력해주세요.(2번 안주고 받고)
		
		randomLoop();
		
	}
	
	
	//랜덤 추출 3번으로
	public static int random() {
		
		Random random = new Random();
		int randomValue;
		randomValue = random.nextInt(26);
		
		return randomValue;
	}
	
	//랜덤 더하기 연산 1번으로
	public static char randomPlus(int randomValue) {
		
		char alphabet = (char)(('A') + random());
		
		return alphabet;
	}
	
	//문자 만듬 1번으로
	public static char randomCharMake(char alphabet) {
		
		alphabet = randomPlus(alphabet);
		
		return alphabet;
	}

	//랜덤작업 10번실행 4번으로
	public static void randomLoop() {
		
		char alphabetValue = 0;
		for(int i=0; i<10; i++) {	
			randomCharPlus(alphabetValue);
		}
//		System.out.println("알파벳 : " + randomCharOutput(alphabetValue));
		
	}

	//10개 문자 더하기 연산 1번으로
	public static char randomCharPlus(char alphabetValue) {
		
		alphabetValue += randomCharMake((randomPlus(random())));
		
		return alphabetValue;
	}
	
	//10개 문자 출력 2번으로
	public static void randomCharOutput(char alphabetValue) {
		
		System.out.println("문자 10개 결과는 : " + randomCharPlus(alphabetValue));
		
	}
	
	
}
