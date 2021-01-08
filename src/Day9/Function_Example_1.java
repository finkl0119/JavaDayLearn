package Day9;

/**
 * 
 * <pre>
 * Day9
 * Function_Example_1.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 8.	
 *
 */
public class Function_Example_1 {
	
//자바는 객체지향언어 - 객체화가 되어야 메모리가 올라간다.         
//static(정적인) : 객체화 유무와 상관없이 바로 메모리에 올라간다. / 
//			특수하기에 함수, 변수 상관없음. / Class에는 붙지 않음.	
	public static void main(String[] args) {
		
		//안녕하세요. 		    1번  주고 받고
		System.out.println(one("안녕하세요."));	
		//저는 유형민 입니다.		2번 안주고 받고
		two("유형민");
		//환영합니다.			3번  주고 안받고
		System.out.println(three());
		//안녕히가세요.			4번 안주고 안받고
		four();
	}
	
	//1번
	public static String one(String str) {
		return str;
	}
	
	//2번
	public static void two(String name) {
		System.out.println("저는 " + name + "입니다.");
	}
	
	//3번
	public static String three() {	
		return "환영합니다.";
	}
	
	//4번
	public static void four() {
		System.out.println("안녕히가세요.");
	}
	
}
