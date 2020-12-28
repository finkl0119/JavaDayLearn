package Day3;

public class Loop_Example_1 {

	//예제 3-1 for문
	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i=1; i<=10; i++) {
			sum +=i;
			System.out.print(i);
			if(i<=9) {
				System.out.print("+");
			}else {
				System.out.print("=");
				System.out.print(sum);
			}
		}
	}
	
}
