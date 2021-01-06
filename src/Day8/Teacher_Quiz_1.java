package Day8;

import java.util.Scanner;

public class Teacher_Quiz_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//14������
		/*
		Scanner v = new Scanner(System.in);

		int [][]seat = new int[9][2]; //�迭����
		//��� �迭���� 0���� �ʱ�ȭ �˴ϴ�.
		int x, y;
		int pax = 18;



		while (pax > 0)
		{
			System.out.print("�����Ͻ� �¼��� �Է����ּ��� (�� 18��): ");
			x = v.nextInt();
			y =v.nextInt();

			if ((y > 8 || y < 0) || (x > 1 || x < 0))
			{
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			if (seat[y][x] == 0)
			{
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				seat[y][x] = 1;
				pax--;
			}
			else
			{
				System.out.println("������ �Ϸ�� �ڸ��Դϴ�. �ٽ� �����ϼ���.");

				for (int i = 0; i < 9; i++)
				{
					for (int j = 0; j < 2; j++)  
					{
						if (seat[i][j] == 0)
						{
							System.out.printf("����ִ� �¼��� %d %d �Դϴ�.", j, i);
						}
					}
				}
			}	
		}
		 */
		
		//15-1
		int[][] one = new int [5][5];
		int value = 1;
		for(int i=0; i<one.length; i++)
		{
			for(int j=0; j<one[i].length; j++)
			{
				one[i][j] = value;
				value++;
			}
			System.out.println();
		}



		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",one[i][j]);
			}
			System.out.println();
		}


		System.out.println();

		//15-2
		int[][] array = new int[5][5];
		int R, C, TR, START, END, SW, K;
		TR = 0;
		START = 0;
		END=4;
		SW=1; 
		K=0;
		for(R=0;R!=5;R++)
		{
			for(C=START;C!=(END+SW);C+=SW)
			{
				K++;
				array[R][C] = K;
			}
			TR = START;
			START = END;
			END = TR;
			SW = SW*(-1);
		}

		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",array[i][j]);
			}
			System.out.println();
		}

		System.out.println();

		//15-3

		int[][] arr2 = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= 0; j--) {
				arr2[i][4 - j] = one[j][i];
			}
		}

		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",arr2[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		
		//15-4
		int arr4[][] = new int [5][5];
		int r = 0; // ��
		int c = -1; // ��
		int k = 5; // �ݺ�Ƚ��
		int sw = 1; // ������ ����
		int n = 1; // ��

		while(true)
		{
			//��
			for(int i = 0;i<k;i++)
			{
				c += sw;
				arr4[r][c] = n++;
			}
			k--;
			if(k == 0)
				break;
			//��
			for(int j = 0;j<k;j++)
			{
				r += sw;
				arr4[r][c] = n++;
			}
			
			sw *= -1;
		}
		
		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",arr4[i][j]);
			}
			System.out.println();
		}
	

	}
}
