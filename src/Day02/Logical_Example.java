package Day02;

/**
 * 논리 연산자
 * <pre>
 * Day2
 * Logical_Example.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 24.	
 *
 */
public class Logical_Example {

	public static void main(String[] args) {
			
		//예제 2-7
		//비교연산
		System.out.println('a' > 'b');
		System.out.println(3 >= 2);
		System.out.println(-1 < 0);
		System.out.println(3.45 <= 2);
		System.out.println(3 == 2);
		System.out.println(3 != 2);
		System.out.println(!(3 != 2) + "\n");
		
		//비교연산과 논리연산 복합
		System.out.println((3 > 2) && (3 > 4));
		System.out.println((3 != 2) || (-1 > 0));
		System.out.println((3 != 2) ^ (-1 > 0));
		
		
		/* 결과값 
		 * false true true false false true false
		 * 
		 * false true true
		 */
	}
}
