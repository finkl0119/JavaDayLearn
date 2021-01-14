package Day11;

import java.util.Random;

public class func6 {

	public static void start()
	{
		Random r = new Random(); //���� ����
		int num[] = new int[5]; // �迭 ����
		num = randomNum(r,num); //
		inputCheck(num); //���
		sortNum(num); // ����
		resultPrint(num); // ��� ���
	}
	public static void resultPrint(int[] num) {
		for(int i=0 ; i<num.length;i++) 
		{
			System.out.println("a["+i+"] = "+num[i]); 
		}
	}
	public static void sortNum(int[] num) {
		int temp=0;
		for (int i = 0; i < num.length; i++) { // ũ��� 
			for (int j = i; j < num.length; j++) 
			{ 
				if (num[i] > num[j]) 
				{ 
					temp = num[j];
					num[j] = num[i];
					num[i] = temp; 
				} 
			} 
		} 
		
	}
	public static void inputCheck(int[] num) {
		for(int i=0 ; i<num.length;i++) 
		{ 
			System.out.print(num[i]+"   "); 
		}
		System.out.println(); 
	}
	
	public static int[] randomNum(Random r,int[] num)
	{
		
		for(int i=0 ; i<num.length;i++) { //�����Ѽ� ���� 
			num[i] = r.nextInt(9)+1; //������ ���� 1~9
			num = randomCheck(num,i); 
			//num�迭 �־��ִµ�
			//num������ �ߺ� üũ ���Ŀ� num �迭�� �־��ش�.
		}
		return num; // num �迭 ����
	}
	public static int[] randomCheck(int[] num,int i) {
		for (int j = 0; j < i; j++) { //�ߺ��� �ٽ����� 
			if(num[i] == num[j]) 
			{ 
				i--; 
			} 
		}
		//�ߺ�üũ�ؼ�
		//num�迭�� ����
		return num;
	}
	public static void main(String[] args) {
		//////////////////////////////23������
		start();
	}
}
