package Day07;

/**
 * 
 * <pre>
 * Day7
 * MultiArray_Example_1.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 5.	
 *
 */
public class MultiArray_Example_1 {

	public static void main(String[] args) {
		
		//4*2 배열
		double score[][] = {
				{3.3, 3.4},
				{3.5, 3.6},
				{3.7, 4.0},
				{4.1, 4.2}
		};
		
		double sum = 0;
		for(int year=0; year<score.length; year++) { //score.length = 4
			for(int term=0; term<score[year].length; term++) { //score[year].length = 2 
				sum += score[year][term];	
			}
		}
		// 6.7 + 7.1 + 7.7 + 8.3
		
		int n = score.length;
		int m = score[0].length;
		System.out.println("4년 전체 평점 평균은 " + sum/(n*m));
		// (8/29.8) = 3.725 
	}
	
}
