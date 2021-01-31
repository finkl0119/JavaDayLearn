package Day03;

/**
 * 
 * <pre>
 * Day3
 * Loop_Example_3.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 28.	
 *
 */
public class Loop_Example_3 {

	//예제 3-3 do while문
	public static void main(String[] args) {
		
		char c= 'a';
		
		do {
			System.out.print(c);
			c=(char) (c+1);
			
		}while(c<='z');
	}
	
}
