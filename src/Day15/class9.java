package Day15;

import java.util.Random;
import java.util.Scanner;

/**
 * 낚시 게임
 * @author YU
 *
 */
class Fish1
{
	String name;
}

class Human
{
	int index[] = new int[2]; // ���� 0���� ����
	Fish1 f[] = new Fish1[3];// ����� ��ΰ� null ����
	Scanner sc = new Scanner(System.in);
	
	
	int[] casting()
	{
		System.out.print("X�� �Է� : ");
		index[0] = sc.nextInt();
		System.out.print("Y�� �Է� : ");
		index[1] = sc.nextInt();
		
		while(index[0] <0 || index[0] >4 || index[1] <0 || index[1] >4)
		{
			System.out.println("�߸��� �Է��Դϴ�.");
			System.out.print("X�� �Է� : ");
			index[0] = sc.nextInt();
			System.out.print("Y�� �Է� : ");
			index[1] = sc.nextInt();
		}
		return index;
	}
	int[] move()
	{
		System.out.print("1. �� 2. �Ʒ� 3. ���� 4. ������ : ");
		int select = sc.nextInt();
		
		if(select == 1)
		{
			index[0] --;
			if(index[0] == -1)
			{
				System.out.println("���� ���̻� �̵��� �� �� �����ϴ�.");
				index[0] = 0;
			}
		}
		else if(select == 2)
		{
			index[0] ++;
			if(index[0] == 5)
			{
				System.out.println("�Ʒ��� ���̻� �̵��� �� �� �����ϴ�.");
				index[0] = 4;
			}
		}
		else if(select == 3)
		{
			index[1] --;
			if(index[1] == -1)
			{
				System.out.println("�������� ���̻� �̵��� �� �� �����ϴ�.");
				index[1] = 0;
			}
		}
		else if(select == 4)
		{
			index[1] ++;
			if(index[1] == 5)
			{
				System.out.println("���������� ���̻� �̵��� �� �� �����ϴ�.");
				index[1] = 4;
			}
		}
		else
		{
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		return index;
		
	}
	
	void reciveFish1(Fish1 f)
	{
		int i = 0;
		while(this.f[i] != null)
		{
			i++;
		}
		this.f[i] = f;
	}
	//ĳ���� ���
	//�̵� ���
	//����⸦ ��ƾ� �ϴ±��
	
	
}

class Hosu
{
	Fish1 hosu[][] = new Fish1[5][5];
	
	void randomFish1()
	{
		Random r = new Random();
		String name[] = {"��ġ", "����", "��ġ"};
		
		for(int i = 0;i<3;i++)
		{
			int x = r.nextInt(5);
			int y = r.nextInt(5);
			if(hosu[x][y] == null)
			{
				Fish1 f1 = new Fish1();
				f1.name = name[i];
				hosu[x][y] = f1;
			}
			else
			{
				i--;
			}
		}
	}
	void humanFish1XY(Human h)
	{
		if(hosu[h.index[0]][h.index[1]] != null)
		{
			System.out.println("1���� " + hosu[h.index[0]][h.index[1]].name +" ����⸦ ��ҽ��ϴ�.");
			h.reciveFish1(hosu[h.index[0]][h.index[1]]);
			hosu[h.index[0]][h.index[1]] = null;
		}
	}
	
	int Fish1Check()
	{
		int check = 0;
		
		for(int i =0;i<hosu.length;i++)
		{
			for(int j=0;j<hosu[i].length;j++)
			{
				if(hosu[i][j] != null)
				{
					check++;
				}
			}
		}
		
		return check;
	}
}
class FishControl
{
	Hosu h = new Hosu();
	Human hu = new Human();
	
	void printHosu()
	{
		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				if(h.hosu[i][j] != null)
				{
					System.out.printf("%d\t",1);
				}
				else
				{
					System.out.printf("%d\t",0);
				}
				
			}
			System.out.println();
		}
	}
	
	void gameStart()
	{
		h.randomFish1();
		
		printHosu();
		
		System.out.println("���ð��ӽ���");
		
		hu.casting();
		
		h.humanFish1XY(hu);
		
		while(h.Fish1Check() !=0)
		{
			hu.move();
			h.humanFish1XY(hu);
		}
		
		System.out.println("���ϵ帳�ϴ�. ��� ����⸦ ��ҽ��ϴ�.");
	}
}
public class class9 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FishControl fc =  new FishControl();
		fc.gameStart();
	}
	
}
