package Day3;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day3
 * Loop_Example_5.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 28.	
 *
 */
public class Loop_Example_5 {

	//예제 3-5 continue
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 5개를 입력하세요.");
		int sum = 0;
		for(int i=0; i<5; i++) {
			int n = scanner.nextInt();
			
			if(n<=0) {
				continue;
			}else {
				sum+=n;
			}
			System.out.println("양수의 합은 " +sum );
		}
	}
	
}
