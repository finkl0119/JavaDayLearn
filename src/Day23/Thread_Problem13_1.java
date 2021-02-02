package Day23;

import java.util.Scanner;

class Plus {
	private int sum = 0; 

	public void add() {
		int n = sum;
		n += 1; 
		sum = n; 
		System.out.print(sum + " ");
	}
}

class Go extends Thread{
	private Plus plus; 
	
	public Go(Plus plus) {
		this.plus = plus;
	}

	@Override
	public void run() {
		System.out.println("스레드 실행 시작");
		for(int i = 0; i<10; i++) {
			plus.add();
		}
		System.out.println();
		System.out.println("스레드 종료");	
	}
}

public class Thread_Problem13_1 {

	public static void main(String[] args) {
	
		Plus plus = new Plus();
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		String input = scanner.nextLine();
		Thread th = new Go(plus);
		th.start();
	}
	
	
}
