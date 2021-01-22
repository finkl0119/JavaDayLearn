package Day17;

class Point { 
	private int x, y; 
	
	//오버로딩 : 똑같은 생성자 함수인 경우 
	public Point() { 
		this.x = this.y = 0; 
	} 
	//오버로딩 : 똑같은 생성자 함수인 경우 
	public Point(int x, int y) { 
		this.x = x; 
		this.y = y; 
	} 
	
	public void showPoint() { 
		System.out.println("(" + x + "," + y + ")"); 
	} 
}

class ColorPoint extends Point { 
	private String color; 
	
	public ColorPoint(int x, int y, String color) { 
		super(x, y); //부모 Point에 있는 x,y
//		class ColorPoint extends Point{
//			Point(int, int)
//		}
		this.color = color; 
	} 
	
	public void showColorPoint() { 
		System.out.println(color); 
		showPoint(); 
	} 
}

public class Extend_example04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorPoint cp = new ColorPoint(5, 6, "blue"); 
		cp.showColorPoint();

	}

}
