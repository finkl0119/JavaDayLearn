package Day2;

import java.util.Scanner;

public class Conditional_Quiz_2 {

	public static void main(String[] args) {
		
//		계산기 만들기
//		예) 숫자 1 입력 : 5
//			숫자 2 입력 : 10
//			연산자 입력 : + 
//			결과값 : 15 입니다.
//		   단, 연산자가 잘못입력되면 잘못된 연산자 입니다.출력
//				예) 연산자 입력 : a
//					잘못된 연산자 입니다. 출력
//					단, 나눗셈은 소수점 첫자리까지 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 숫자 입력 해주세요.");
		Double calculator_1 = sc.nextDouble();
		System.out.printf("숫자1 입력 : %.0f", calculator_1);
		
		System.out.println("두번째 숫자 입력 해주세요.");
		int calculator_2 = sc.nextInt();
		System.out.printf("숫자2 입력 : %.0f", calculator_2);
		
		System.out.println("연산자를 입력하세요.");
		String operator =sc.next();
		System.out.println("연산자 입력 : " + operator);
		
		if(operator.equals("+")) {
			System.out.printf("결과값 : %.0f입니다.", (calculator_1 + calculator_2));
		}else if(operator.equals("-")) {
			System.out.printf("결과값 : %.0f입니다.", (calculator_1 - calculator_2));
		}else if(operator.equals("*")) {
			System.out.printf("결과값 : %.0f입니다.", (calculator_1 * calculator_2));
		}else if(operator.equals("/")) {
			System.out.printf("결과값 : %.1f입니다.",(calculator_1 / calculator_2));
		}else {
			System.out.println("잘못된 연산자 입니다.");
		}
		
		if(operator == "+") // 문자열은 비교가 안됨
		{
			
		}
		if(operator.equals("+")) //문자열 비교가 됨
		{
			
		}
		switch (operator) {
		case "+":  //문자열이 비교됨
			break;
		default:
			break;
		}
		
		/*
		if(operator.equals("+")) {
			System.out.printf("결과값 : %d입니다.", (calculator_1 + calculator_2));
		}else if(operator.equals("-")) {
			System.out.printf("결과값 : %d입니다.", (calculator_1 - calculator_2));
		}else if(operator.equals("*")) {
			System.out.printf("결과값 : %d입니다.", (calculator_1 * calculator_2));
		}else if(operator.equals("/")) {
			System.out.printf("결과값 : %.1f입니다.",((float)calculator_1 / (float)calculator_2));
		}else {
			System.out.println("잘못된 연산자 입니다.");
		}
		*/
		
		
	}
}

