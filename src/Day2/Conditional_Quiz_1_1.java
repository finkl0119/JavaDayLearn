package Day2;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day2
 * Conditional_Quiz_1_1.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 24.	
 *
 */
public class Conditional_Quiz_1_1 {

	public static void main(String[] args) {
		
		//!(month >12 || month < 1 || temp <-15 || temp >37) 역으로
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
		System.out.println("온도를 입력하세요");
		int temp = sc.nextInt();
		
		if(!(month >12 || month < 1 || temp <-15 || temp >37))
		{
			System.out.println("잘못된 입력입니다.");
		}
		else
		{
			if(month>=3&& month<=5)
			{
				if(temp >= 3 && temp <= 15)
				{
					System.out.println("계절은 봄입니다. 온도는 "+temp+"입니다.");
				}
				else
				{
					System.out.println("계절과 온도가 맞지 않습니다.");
				}
			}
			else if(month>=6&& month<=8)
			{
				if(temp >= 18 && temp <= 37)
				{
					System.out.println("계절은 여름입니다. 온도는 "+temp+"입니다.");
				}
				else
				{
					System.out.println("계절과 온도가 맞지 않습니다.");
				}
			}
			else if(month>=9&& month<=11)
			{
				if(temp >= 3 && temp <= 15)
				{
					System.out.println("계절은 가을입니다. 온도는 "+temp+"입니다.");
				}
				else
				{
					System.out.println("계절과 온도가 맞지 않습니다.");
				}
			}
			else
			{
				if(temp >=-15  && temp <= 2)
				{
					System.out.println("계절은 겨울입니다. 온도는 "+temp+"입니다.");
				}
			}
		}
	}
}

