package Day3;

public class Loop_Example_3 {

	//예제 3-3 for문
	public static void main(String[] args) {
		
		char c= 'a';
		
		do {
			System.out.print(c);
			c=(char) (c+1);
			
		}while(c<='z');
	}
	
}
