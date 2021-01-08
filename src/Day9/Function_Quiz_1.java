package Day9;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day8
 * MultiArray_Quiz_3.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 6.	
 *
 */
public class Function_Quiz_1 {

	public static void main(String[] args) {
	
		//========================================
		
		System.out.println("===== 17번 문제 =====");	

// 계산기 함수화
// 예) 연산자 입력 : +
//	  숫자 1입력 : 9
//	  숫자 2입력 : 6
//	  결과값 : 15
//	  단, 연산자가 잘못 입력되면 잘못된 연산자 입니다. 출력
//	  예) 연산자 입력 : a
//		  잘못된 연산자 입니다. 출력
//		  단, 나눗셈은 소숫점 첫자리 까지 출력
//	  1. 더하기 연산 (1번)
//	  2. 곱하기 연산 (2번)
//	  3. 빼기 연산 (3번)
//	  4. 나누기 연산 (4번)
//	  5. 츨력 / 잘못된 출력 (2번, 4번)
//	  6. 입력 (3번)
	  
		Scanner sc = new Scanner(System.in);
		//연산자 입력
		System.out.println("연산자를 입력하세요.");
		String operator =sc.next();
		if(operator.equals("+")) {
			int a = input1();
			int b = input2();
			result(add(a,b));
		}else if(operator.equals("-")) {
			result(min());
		}else if(operator.equals("*")) {
			int a = input1();
			int b = input2();
			mul(a, b);
		}else if(operator.equals("/")) {
			div();
		}else {
			err();
		}
	
	}
	
	//더하기 연산 1번으로 
	public static int add(int a, int b)	{
		return a + b;
	}
	//곱셈 연산 2번으로
	public static void mul(int a, int b){
		result(a*b);
	}
	//빼기 연산 3번으로
	public static int min()	{
		int a = input1();
		int b = input2();
		return a - b;
	}
	//나눗셈 연산 4번으로
	public static void div(){
		int a = input1();
		int b = input2();
		divResult((double)a / (double)b);
	}
	//결과값 출력값
	public static void result(int res){
		System.out.printf("결과값 : %d입니다.", res);
	}
	//나눗셈 출력값
	public static void divResult(double res){
		System.out.printf("나눗셈 결과값 : %.1f입니다.",res);
	}
	//에러 출력값
	public static void err(){
		System.out.println("잘못된 입력값입니다.");
	}
	//입력값_1
	public static int input1(){
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1을 입력해주세요.");
		int calculator_1 = sc.nextInt();
		return calculator_1;
	}
	//입력값_2
	public static int input2(){
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자2를 입력해주세요.");
		int calculator_2 = sc.nextInt();
		return calculator_2;
	}
	
}
