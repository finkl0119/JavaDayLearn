package Day7;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day7
 * MultiArray_Quiz_2.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 5.	
 *
 */
public class MultiArray_Quiz_2 {

	public static void main(String[] args) {
		
//		15번 문제 배열 값 채우기 (5행 5열 배열)
//		
//		15-1 문제 
//			   0  1  2  3  4 
//			0  1  2  3  4  5 	
//			1  6  7  8  9  10
//			2  11 12 13 14 15
//			3  16 17 18 19 20
//			4  21 22 23 24 25
//	
//		15-2 문제
//			   0  1  2  3  4 
//			0  1  2  3  4  5 	
//			1  10 9  8  7  6
//			2  11 12 13 14 15
//			3  20 19 18 17 16
//			4  21 22 23 24 25
//		
//		15-3 문제
//			   0  1  2  3  4 
//			0  21 16 11 6  1 	
//			1  22 17 12 7  2
//			2  23 18 13 8  3
//			3  24 19 14 9  4
//			4  25 20 15 10 5	
//			
//		2차원 배열 5x5에 
//		조건문과 반복문을 통해	배열 채우기
	
		
		int[][] lineArray = new int[1][5];
		int[][] rowArray = new int[5][1];
		int[][] intArray = new int[5][5];
		int backNumber = 1;
		int plusNumber = 1;
		
		int lineNumber = 0;
		int rowNumber = 0;
		
		for(int i=0; i<1; i++) {
			for(int j=0; j<5; j++) {
				lineArray[i][j] = lineNumber;
				lineNumber = lineNumber + 1;
			}
		}
		
		for(int i=0; i<1; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%2d ", lineArray[i][j]);
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<1; j++) {
				rowArray[i][j] = rowNumber;
				rowNumber = rowNumber + 1;
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<1; j++) {
				System.out.println(rowArray[i][j]);
			}
		}
		
		
		for(int i=0; i<intArray.length; i++){
			if(backNumber == 1){
				for(int j=0; j<intArray.length; j++){
					intArray[i][j] = plusNumber;
					plusNumber = plusNumber + 1;
				}
			}else{
				for(int j=intArray.length-1; j>=0; j--){
					intArray[i][j] = plusNumber;
					plusNumber = plusNumber + 1;
				}
			}
			backNumber = backNumber * (-1);
		}
			
		for(int i=5; i<0; i--) {
			for(int j=0; j<1; j++) {
				System.out.printf("%2d ", rowArray[i][j]);
			}
		}
		
		System.out.println();
		
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				System.out.printf("%2d ", intArray[i][j]);
			}
			System.out.println();
		}
			
	}
	
}
