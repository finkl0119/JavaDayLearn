package Day03;

/**
 * 구구단 반복문
 * <pre>
 * Day3
 * Loop_Example_4.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 28.	
 *
 */
public class Loop_Example_4 {

	//예제 3-4 for문
	public static void main(String[] args) {
		
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.print(i+ "*" + j+ "=" + i*j);
				System.out.print('\t');
			}
			System.out.println();
		}
	}
	
}
