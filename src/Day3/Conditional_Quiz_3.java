package Day3;

import java.util.Scanner;

public class Conditional_Quiz_3 {

	public static void main(String[] args) {
		
//		세과목의 점수를 입력 받습니다 (국어, 영어, 수학)
//		평균을 소숫점 첫째자리까지 계산을 합니다.
//		그 이후에 평균의 학점을 출력해주세요.
//		(A+ 95점 이상 / A 90점 이상
//		 B+ 85점 이상	/ B 80점 이상
//		 C+ 75점 이상 / C 70점 이상
//		 D 60점 이상 / F 60점 미만)
//		단, 각 점수마다 100점을 초과하는 점수를 입력하면
//		평균을 계산하지 않고 입력된 과목과 함께 점수를 잘못 입력했습니다. 출력 후 프로그램 종료.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 : ");
		int input_1 = sc.nextInt();
		
		System.out.println("영어 : ");
		int input_2 = sc.nextInt();
		
		System.out.println("수학 : ");
		int input_3 = sc.nextInt();
		
		float average = ((float)(input_1 + input_2 + input_3) / 3);
		
		if((input_1 > 100 || input_2 > 100 || input_3 > 100)) {
			if(input_1 > 100) {
				System.out.println("국어점수를 잘못입력하였습니다.");
			}
			if (input_2 > 100) {
				System.out.println("영어점수를 잘못입력하였습니다.");
			}
			if (input_3 > 100)  {
				System.out.println("수학점수를 잘못입력하였습니다.");
			}
		}else {
			
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

	}
}
