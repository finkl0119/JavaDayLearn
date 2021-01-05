package Day6;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day6
 * Array_Example_3.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 4.	
 *
 */
public class Array_Example_3 {

	enum Week {월,화,수,목,금,토,일 }
	
	public static void main(String[] args) {
		
		int [] n = {1, 2, 3, 4, 5};
		String names[] = {"사과", "배","바나나", "체리","딸기", "포도"};
		
		int sum = 0;
		for(int k : n) {
			System.out.print(k+ " ");
			sum +=k;
		}
		System.out.println("합은 " + sum);
		
		for(String s : names) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		for(Week day : Week.values()) {
			System.out.print(day + "요일 ");
		}
		System.out.println();
		
	}
	
}
