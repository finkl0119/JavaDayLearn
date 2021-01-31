package Day03;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day3
 * Loop_Example_2.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 28.	
 *
 */
public class Loop_Example_2 {

	//예제 3-2 while문
	public static void main(String[] args) {
		
		int count=0;
		int sum=0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하고 마지막에 -1을 입력하세요.");
		
		int n = scanner.nextInt();
		while(n != -1) {
			sum += n;
			count++;
			n = scanner.nextInt();
		}
		if(count==0) {
			System.out.println("입력된 수가 없습니다.");
		}else {
			System.out.print("정수의 개수는 " +count+ "개이며 ");
			System.out.print("평균은 " +(double)sum/count+ "입니다.");
		}
	}
	
}
