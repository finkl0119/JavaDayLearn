package Day17;

class Person { 
	private int weight; // *** student 클래스 접근불가 
	int age; // 디폴트. student 클래스 접근가능 
	protected int height; // student 클래스 접근가능 
	
	public String name; // student 클래스 접근가능 
	
	public void setWeight(int weight) { 
		this.weight = weight; 
	} 
	public int getWeight() { 
		return weight; 
	} 
}

class Student extends Person { 
	public void set() { 
		age = 30; 
		name = "gildong";
		height = 180; 
		setWeight(99); // 간접접근 
		//weight = 99; //슈퍼 클래스의 멤버 접근불가 
	} 
}


public class Extend_example03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student(); 
		s.set();

	}

}
