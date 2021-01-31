package Day02;

import java.util.Scanner;

/**
 * 입력에 따른 출력
 * <pre>
 * Day2
 * Scanner_Example.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 24.	
 *
 */
public class Scanner_Example {

	public static void main(String[] args) {
		
		//예제 2-4
		System.out.println("이름, 도시, 나이, 체중, 독신여부를 빈칸으로 분리하여 입력하세요.");
		
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.next();
		System.out.println("이름은 " + name + ", " );
		
		String city = scanner.next();
		System.out.println("도시는 " + city + ", " );
		
		int age = scanner.nextInt();
		System.out.println("나이는 " + age+ "살 " );
		
		double weight = scanner.nextDouble();
		System.out.println("몸무게는 " + weight + "kg " );
		
		boolean isSingle = scanner.nextBoolean();
		System.out.println("독신여부는 " + isSingle + "입니다. " );
		
		//예제 2-5
		Scanner scanner1 = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int time = scanner1.nextInt();
		int second = time % 60;
		int minute = (time / 60) % 60;
		int hour = (time / 60) / 60;
		
		System.out.print(time + "초는 ");
		System.out.print(hour + "시간, ");
		System.out.print(minute + "분은, ");
		System.out.println(second + "초입니다.");
		
		
		
	}
}
