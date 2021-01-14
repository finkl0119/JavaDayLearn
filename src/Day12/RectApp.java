package Day12;

import java.util.Scanner;

class Ractangle{
	
	int width;
	int height;
	
	public int getArea() {
		return width * height;
	}
}

public class RectApp {

	public static void main(String[] args) {
		
		Ractangle rect = new Ractangle();
		Scanner scanner = new Scanner(System.in);
		System.out.print(">> ");
		rect.width = scanner.nextInt();
		rect.height = scanner.nextInt();
		System.out.println("사각형의 면적은 " + rect.getArea());
		
	}

}
