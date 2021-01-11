package Day10;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day10
 * Function_Quiz_2.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 11.	
 *
 */
public class Function_Quiz_2 {

	public static void main(String[] args) {
	
		//========================================
		
		System.out.println("===== 18번 문제 =====");	

//		세과목의 점수 입력(국어, 영어, 수학) 정수로 입력 받으세요.
//		(3번함수 주고 안받고)
//		평균 학점 연산
//		(1번함수 주고 안받고)
//		그 이후 평균의 학점을 출력해주세요.
//		A+ 95이상 / A 90이상
//		B+ 85이상 / B 80이상
//		C+ 75이상 / C 70이상
//		D 60이상 / F 60미만
//		(1번 함수 주고 받고)
//		단, 각 점수마다 100점을 초과하는 점수를 입력하면 
//		평균을 계산하지 않고 입력된 과목과 함께 점수를 잘못입력했습니다. 출력 프로그램 종료
//		잘못된 입력값 확인 (2번 함수 안주고 받고)
//		잘못 입력입니다. (4번 함수 안주고 안받고)
//		평균학점 출력 (2번 함수 안주고 받고)
		
		int koreanScore = korean(); 
		int englishScore = english(); 
		int mathScore = math(); 
		
		errorInput(koreanScore, englishScore, mathScore);
		
	}
	
	//입력값 국어 3번
	public static int korean() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 : ");
		int number_1 = scanner.nextInt();
		
		return number_1;
	}
	
	//입력값 영어 3번
	public static int english() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("영어 : ");
		int number_2 = scanner.nextInt();
		
		return number_2;
	}
	
	//입력값 수학 3번
	public static int math() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수학 : ");
		int number_3 = scanner.nextInt();
		
		return number_3;
	}
	
	//평균 학점 연산 1번
	public static double averageCount(int koreanScore, int englishScore, int mathScore) {
		
		return (double)(koreanScore + englishScore + mathScore)/3;
	}
	
	//학점 출력 1번
	public static double scoreOutput(int koreanScore, int englishScore, int mathScore) {
		
		double average = averageCount(koreanScore, englishScore, mathScore);
		System.out.println("평균 학점은 : " + average + "점 입니다.");
		
		return average;
	}
	
	//평균 학점 출력 2번
	public static void averageOutput(int koreanScore, int englishScore, int mathScore) {
		
		double average = scoreOutput(koreanScore, englishScore, mathScore);
		
		if(average >= 95) {
			System.out.printf("평균점수 : %.1f, 학점은 A+입니다.", average);
		}else if (average >= 90){
			System.out.printf("평균점수 : %.1f, 학점은 A입니다.", average);
		}else if (average >= 85){
			System.out.printf("평균점수 : %.1f, 학점은 B+입니다.", average);
		}else if (average >= 80){
			System.out.printf("평균점수 : %.1f, 학점은 B입니다.", average);
		}else if (average >= 75){
			System.out.printf("평균점수 : %.1f, 학점은 C+입니다.", average);
		}else if (average >= 70){
			System.out.printf("평균점수 : %.1f, 학점은 C입니다.", average);
		}else if (average >= 60){
			System.out.printf("평균점수 : %.1f, 학점은 D입니다.", average);
		}else {
			System.out.printf("평균점수 : %.1f, 학점은 F입니다.", average);
		}
		
	}
	
	//잘못된 입력값 출력 2번
	public static void errorInput(int koreanScore, int englishScore, int mathScore) {
		
		if((koreanScore > 100 || englishScore > 100 || mathScore > 100)) {
			error();
		}else {
			averageOutput(koreanScore, englishScore, mathScore);
		}
	}
	
	//잘못된 입력입니다 문구 출력 4번
	public static void error() {
		System.out.println("잘못입력하였습니다.");
	}
	
}
