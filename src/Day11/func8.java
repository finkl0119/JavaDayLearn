package Day11;

import java.util.Scanner;

public class func8 {

	static Scanner sc = new Scanner(System.in);  //��������
	//static int cnt = 0; // ��������
	
	public static void run() // 4��
	{
		int row = 9; // ��
		int col = 2; // ��
		int seat[][] = new int[row][col]; //���� ��ü ����
		//9�� 2��
		int cnt = row * col; //18
		
		while(true) //���ѹݺ�
		{
			cnt = res(seat,cnt);  //���� �迭�� res�Լ��� �ް� �� ������� seat �迭�� ���� �մϴ�.
			if(cnt == 0)
			{
				System.out.println("��� ������ �������ϴ�.");
				break;
			}
		}
		sc.close(); // ��ĳ�� ����
	}
	
	public static int res(int seat[][],int cnt) // 1��
	{
		int row = row(); //���� �Է� �޴� �Լ� ȣ�� �Ŀ� row ������ ���� 
		int col = col(); //���� �Է� �޴� �Լ� ȣ�� �Ŀ� col ������ ����
		
		//�Լ�ȭ �ϸ� ����.
		if(seat[row][col] == 0)
		{
			seat[row][col] = 1;
			System.out.println(row + " �� " + col + " ���� ����Ǿ����ϴ�.");
			cnt--;
		}
		else
		{
			System.out.println("�̹� ����� �¼��Դϴ�.");
			noRes(seat); //��� �ִ� �¼��� �˷��ִ� �Լ� ȣ��
		}
		
		return cnt;
	}
	
	public static void noRes(int seat[][]) // 2��
	{
		for(int i = 0; i < seat.length; i++)
		{
			for(int j = 0; j < seat[i].length; j++)
			{
				if(seat[i][j] == 1)
					continue;
				else
					System.out.println("����ִ� �¼��� " + i + " �� " + j + " ���Դϴ�.");
			}
		}
	}
	
	public static int row() // 3��
	{
		int row = 0;
		while(true) //���� �ݺ�
		{
			System.out.print("���� �Է��ϼ���. (0~8) : ");
			row = sc.nextInt();
			if(row > 8 || row < 0)
			{
				err();
			}
			else
				break;
		}
		
		return row;
	}
	
	public static int col() // 3��
	{
		int col = 0;
		while(true)
		{
			System.out.print("���� �Է��ϼ���. (0~1) : ");
			col = sc.nextInt();
			if(col > 1 || col < 0)
			{
				err();				
			}
			else
				break;
		}
		
		return col;
	}
	
	public static void err() // 4��
	{
		System.out.println("�߸��� �Է��Դϴ�.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}
}
