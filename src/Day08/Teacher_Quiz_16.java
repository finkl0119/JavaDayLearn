package Day08;

import java.util.Random;
import java.util.Scanner;

public class Teacher_Quiz_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int count = 3;
		
		int hosu[][] = new int[5][5];
		
		for(int i = 0;i<3;i++)
		{
			int x = r.nextInt(5);
			int y = r.nextInt(5);
			if(hosu[x][y] == 0)
			{
				hosu[x][y] = 1;
			}
			else
			{
				i--;
			}
		}
		
		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",hosu[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("���ð��ӽ���");
		
		System.out.print("X�� �Է� : ");
		int userX = sc.nextInt();
		System.out.print("Y�� �Է� : ");
		int userY = sc.nextInt();
		
		while(userX <0 || userX >4 || userY <0 || userY >4)
		{
			System.out.println("�߸��� �Է��Դϴ�.");
			System.out.print("X�� �Է� : ");
			userX = sc.nextInt();
			System.out.print("Y�� �Է� : ");
			userY = sc.nextInt();
		}
		// ������ �ùٸ��� �Է� �ߴ�.
		
		if(hosu[userX][userY] == 1)
		{
			System.out.println("1���� ����⸦ ��ҽ��ϴ�.");
			hosu[userX][userY] = 0;
			count --;
		}
		
		if(hosu[userX][userY] == 0)
		{
			hosu[userX][userY] = -1;
		}
		
		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",hosu[i][j]);
			}
			System.out.println();
		}
		
		
		while(count !=0)
		{
			System.out.print("1. �� 2. �Ʒ� 3. ���� 4. ������ : ");
			int select = sc.nextInt();
			
			if(select == 1)
			{
				userX --;
				if(userX == -1)
				{
					System.out.println("���� ���̻� �̵��� �� �� �����ϴ�.");
					userX = 0;
				}
			}
			else if(select == 2)
			{
				userX ++;
				if(userX == 5)
				{
					System.out.println("�Ʒ��� ���̻� �̵��� �� �� �����ϴ�.");
					userX = 4;
				}
			}
			else if(select == 3)
			{
				userY --;
				if(userY == -1)
				{
					System.out.println("�������� ���̻� �̵��� �� �� �����ϴ�.");
					userY = 0;
				}
			}
			else if(select == 4)
			{
				userY ++;
				if(userY == 5)
				{
					System.out.println("���������� ���̻� �̵��� �� �� �����ϴ�.");
					userY = 4;
				}
			}
			else
			{
				System.out.println("�߸��� �Է��Դϴ�.");
				continue;
			}
			
			
			if(hosu[userX][userY] == 0)
			{
				hosu[userX][userY] = -1;
			}
			
			if(hosu[userX][userY] == 1)
			{
				System.out.println("1���� ����⸦ ��ҽ��ϴ�.");
				hosu[userX][userY] = 0;
				count--;
			}
			
			for(int i = 0;i<5;i++)
			{
				for(int j =0;j<5;j++)
				{
					System.out.printf("%d\t",hosu[i][j]);
				}
				System.out.println();
			}
			
		}
		
		System.out.println("���ϵ帳�ϴ�. ��� ����⸦ ��ҽ��ϴ�.");
		
	}

}
