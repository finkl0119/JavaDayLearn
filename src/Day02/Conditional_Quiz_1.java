package Day02;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day2
 * Conditional_Quiz_1.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 24.	
 *
 */
public class Conditional_Quiz_1 {

	public static void main(String[] args) {
		
		//1.월을 입력받고 온도를 입력 받습니다.
	    //  3월~5월 봄입니다.
		//  6월~8월 여름입니다.
		//  9월~11월 가을입니다.
		//  12월~2월 겨울입니다.
		// (단, 온도 입력한 값을 같이 출력을 합니다. 
		//	그리고 온도가 각각 계절별 날씨와 맞지 않으면 계절과 온도가 맞지않습니다. 
		//	를 출력해주세요.)
		// 온도 : 봄 3~15도 / 여름 18~37도 / 가을 3~15도 / 겨울 2~-15도 / 온도 ,계절 범위 벗어나면 잘못된 입력입니다. 출력
		// ex)
		// 월 입력 : 3
		// 온도 입력 : 8
		// 계절은 봄입니다. 온도는 8도 입니다. (출력)
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("월 입력(1~12월) : ");
		int month = scanner.nextInt();
		System.out.print("온도 입력 : ");
		int temperature = scanner.nextInt();
		
		//봄
		if((month >= 3 && month <= 5) && (temperature >= 3 && temperature <= 15)) {
			System.out.println("계절은 봄입니다. 온도는 "+temperature+"도 입니다.");
		//여름	
		}else if((month >= 6 && month <= 8) && (temperature >= 18 && temperature <= 37)) {
			System.out.println("계절은 여름입니다. 온도는 "+temperature+"도 입니다.");
		//가을
		}else if( (month >= 9 && month <= 11) && (temperature >= 3 && temperature <= 15)) {
			System.out.println("계절은 가을입니다. 온도는 "+temperature+"도 입니다.");
		//겨울
		}else if((month == 1 && month == 2 && month == 12) && (temperature >= -15 && temperature <= 2)) {
			System.out.println("계절은 겨울입니다. 온도는 "+temperature+"도 입니다.");
		}else if(month > 12 || month < 1 || temperature <-15 || temperature >37){
			System.out.println("온도, 계절 범위 벗어나면 잘못된 입력입니다");
		}else {
			System.out.println("계절과 온도가 맞지않습니다.");
		}
	}
}
