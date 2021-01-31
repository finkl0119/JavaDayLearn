package Day01;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day1
 * Day1.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 22.	
 *
 */
public class Day1 {

	public static void main(String[] args) {
		
		  System.out.println("Hello World");
		  
		//==================================
		  int score = 100; 
		  int score1; score1 = 300;
		
		  System.out.println("스코어 : " + score); //스코어 : 100 
		  System.out.println("스코어1 : " + score1); //스코어 : 300
		  
		  String str = "hellow world"; 
		  char ch = 'a'; //아스키코드 값 97
		  
		  System.out.println(str + score); //197
		  
		//==================================
		  int temp = 11; 
		  String grade = temp%2 == 0 ? "짝수" : "홀수";
		  System.out.println(grade); //홀수
		  
		  int temp1 = 11; 
		  String grade1 = temp1%2 == 0 ? "짝수입니다." : "홀수입니다."; 
		  
		  System.out.println(grade1); //홀수입니다.
		 
		//==================================
		  int a = 10; int b = 20; System.out.print("a+b="+ a+b + "\n"); //a+b=1020
		  System.out.print("a+b="+ (a+b) +"\n"); //a+b=30
		  System.out.println("a+b="+ a+b ); //a+b=1020
		  System.out.printf("a / b = %.2f",(float)a/(float)b); //a / b = 0.50 소수점 2째자리까지
		  System.out.printf("a / b = %.2f\n",(float)a/(float)b);//a / b = 0.50 소수점 2째자리까지
		  
		//==================================
		  //입력 scanner
		  Scanner sc = new Scanner(System.in);
		  
		  //문자열
		  System.out.print("이름을 입력해주세요 : ");
		  String rev = sc.next();
		  System.out.print(rev + "\n"); //문자열 입력값  
		  //정수
		  System.out.print("정수를 입력해주세요 : ");
		  int intRev = sc.nextInt();
		  System.out.print(intRev + "\n"); //정수 입력값

		//==================================
		//정수를 입력 받아 짝수인지 홀수 인지 결정  
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력해주세요 : ");
		int number = scanner.nextInt();
		String oddEven = number % 2 == 0 ? "짝수입니다." : "홀수입니다.";
		System.out.println(oddEven + "\n"); //입력값에 따른 짝수, 홀수

	}

}
