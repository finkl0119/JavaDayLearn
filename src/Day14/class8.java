package Day14;

import java.util.Scanner;

/**
 * 마트게임
 * @author YU
 *
 */
//1 ��
class Buyer
{
	int money;

	Computer buyCom[] = new Computer[10];
	Aircon buyAir[] = new Aircon[10];
	Ref buyref[] = new Ref[10];
	AirCleaner buyAirC[] = new AirCleaner[10];

}
//2 ��ǻ��
class Computer
{
	String manufacture;
	String cpu;
	int price;
	public void use()
	{
		System.out.println("�����簡 " + manufacture + "�� " + cpu + "��ǻ�͸� ����Ѵ�");
	}
}
//3 ������
class Aircon
{
	String manufacture;
	String kind;
	int price;


	public void start() 
	{
		System.out.println("�����簡 " + manufacture + "�� " + kind +"�������� ����Ѵ�");
	}
}
//4 �����
class Ref
{
	String manufacture;
	String door;
	String L;
	int price;
	public void manage() 
	{
		System.out.println("�����簡 " + manufacture + "�� "+ door +"�� " + L + "����� ��ǰ�� �����Ѵ�");
	}
}
//5 ����û����
class AirCleaner
{
	String manufacture;
	int price;

	public void start() 
	{
		System.out.println("�����簡 " + manufacture + "�� " + "����������� ���⸦ �����ϰ� �Ѵ� ");
	}
}

class MartCon
{
	boolean minusMoney(Buyer[] b,int index, int minus)
	{
		b[index].money = b[index].money - minus;
		if(b[index].money<0)
		{
			System.out.println("��ǰ�� ���Ÿ� �� �� �����ϴ�.");
			b[index].money = b[index].money + minus;
			return false;
		}
		return true;
	}

	void changeCom(Buyer[] b, int index ,Computer[] comArr)
	{
		int j = 0;
		while(comArr[j] == null && j < 10)
		{
			j++;
		}

		if(j>=5)
		{
			System.out.println("��� �����ϴ�.");
		}
		else
		{
			int k =0;
			while(b[index].buyCom[k] !=null)
			{
				k++;
			}
			b[index].buyCom[k] = comArr[j];
			comArr[j] = null;
		}
	}
	void changeAir(Buyer[] b, int index ,Aircon[] airconArr)
	{
		int j = 0;
		while(airconArr[j] == null && j < 10)
		{
			j++;
		}

		if(j>=5)
		{
			System.out.println("��� �����ϴ�.");
		}
		else
		{
			int k =0;
			while(b[index].buyAir[k] !=null)
			{
				k++;
			}
			b[index].buyAir[k] = airconArr[j];
			airconArr[j] = null;
		}
	}
	void changeRef(Buyer[] b, int index ,Ref[] refrigArr)
	{
		int j = 0;
		while(refrigArr[j] == null && j < 10)
		{
			j++;
		}

		if(j>=5)
		{
			System.out.println("��� �����ϴ�.");
		}
		else
		{
			int k =0;
			while(b[index].buyref[k] !=null)
			{
				k++;
			}
			b[index].buyref[k] = refrigArr[j];
			refrigArr[j] = null;
		}
	}
	void changeAirCon(Buyer[] b, int index ,AirCleaner[] airCleanerArr)
	{
		int j = 0;
		while(airCleanerArr[j] == null && j < 10)
		{
			j++;
		}

		if(j>=5)
		{
			System.out.println("��� �����ϴ�.");
		}
		else
		{
			int k =0;
			while(b[index].buyAirC[k] !=null)
			{
				k++;
			}
			b[index].buyAirC[k] = airCleanerArr[j];
			airCleanerArr[j] = null;
		}
	}
}


public class class8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer[] comArr = new Computer[10];
		Aircon[] airconArr = new Aircon[10];
		Ref[] refrigArr = new Ref[10];
		AirCleaner[] airCleanerArr = new AirCleaner[10];
		for(int i = 0; i< 5; ++i)
		{
			comArr[i] = new Computer();
			comArr[i].manufacture = "Samsung";
			comArr[i].cpu = "i7";
			comArr[i].price = 200;
			airconArr[i] = new Aircon();
			airconArr[i].kind = "������";
			airconArr[i].manufacture = "Samsung";
			airconArr[i].price = 100;
			refrigArr[i] = new Ref();
			refrigArr[i].manufacture = "Samsung";
			refrigArr[i].door = "�繮";
			refrigArr[i].L = "600L";
			refrigArr[i].price = 200;
			airCleanerArr[i] = new AirCleaner();
			airCleanerArr[i].manufacture = "LG";
			airCleanerArr[i].price = 80;
		}
		for(int i = 5; i<10; ++i)
		{
			comArr[i] = new Computer();
			comArr[i].manufacture = "LG";
			comArr[i].cpu = "i5";
			comArr[i].price = 150;
			airconArr[i] = new Aircon();
			airconArr[i].kind = "���ĵ�";
			airconArr[i].manufacture = "LG";
			airconArr[i].price = 250;
			refrigArr[i] = new Ref();
			refrigArr[i].manufacture = "LG";
			refrigArr[i].door = "4����";
			refrigArr[i].L = "800L";
			refrigArr[i].price = 350;
			airCleanerArr[i] = new AirCleaner();
			airCleanerArr[i].manufacture = "���̽�";
			airCleanerArr[i].price = 60;
		}
		//��Ʈ ��ǰ ����
		Buyer b[] = new Buyer[3];
		MartCon mc = new MartCon();

		for(int i =0;i<3;i++)
		{
			b[i] = new Buyer();
		}

		Scanner sc = new Scanner(System.in);

		for(int i =0;i<3;i++)
		{
			System.out.print((i+1)+"�� ���̾� ���� �Է��ϼ��� : ");
			b[i].money = sc.nextInt();
		}

		int select;

		while(true)
		{
			for(int i =0;i<3;i++)
			{
				if(b[i].money >=60)
				{
					System.out.print((i+1)+"���̾� ��ǰ�� ���� ���ּ��� 1. ��ǻ�� 2.������ 3.����� 4.����û���� :");
					select = sc.nextInt();
					if(select == 1)
					{
						System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(i7) 2.LG(i5) : ");
						select = sc.nextInt();
						if(select == 1)
						{
							if(mc.minusMoney(b, i, 200))
							{
								mc.changeCom(b, i, comArr);
							}
						}
						else if(select == 2)
						{
							if(mc.minusMoney(b, i, 150))
							{
								mc.changeCom(b, i, comArr);
							}
						}
						else
						{
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					}
					else if(select == 2)
					{
						System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(��������) 2.LG(���ĵ���) : ");
						select = sc.nextInt();
						if(select == 1)
						{
							if(mc.minusMoney(b, i, 100))
							{
								mc.changeAir(b, i, airconArr);
							}
						}
						else if(select == 2)
						{
							
							if(mc.minusMoney(b, i, 200))
							{
								mc.changeAir(b, i, airconArr);
							}
						}
						else
						{
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					}
					else if(select == 3)
					{
						System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(�繮,600L) 2.LG(4����, 800L) : ");
						select = sc.nextInt();
						if(select == 1)
						{
							if(mc.minusMoney(b, i, 200))
							{
								mc.changeRef(b, i, refrigArr);
							}
						}
						else if(select == 2)
						{
							if(mc.minusMoney(b, i, 350))
							{
								mc.changeRef(b, i, refrigArr);
							}
						}
						else
						{
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					}
					else if(select == 4)
					{
                        System.out.print("������ �� ����� �������ּ��� 1.LG 2.���̽� : ");
						select = sc.nextInt();
						if(select == 1)
						{
							if(mc.minusMoney(b, i, 80))
							{
								mc.changeAirCon(b, i, airCleanerArr);
							}
						}
						else if(select == 2)
						{
							
							if(mc.minusMoney(b, i, 60))
							{
								mc.changeAirCon(b, i, airCleanerArr);
							}
						}
						else
						{
							System.out.println("�߸��� �Է��Դϴ�.");
						}
					}
					else
					{
						System.out.println("�߸��� �Է��Դϴ�.");
					}
					
					System.out.println((i+1)+"Buyer�� ���� �ݾ��� "+b[i].money+"�Դϴ�.");
				}
			}
	         if(b[0].money <60 && b[1].money <60&& b[2].money<60)
	         {
	            break;
	         }
		}
		for(int i = 0;i<3;i++)
		{
			int j =0;
			while(b[i].buyCom[j]!=null)
			{
				System.out.print((i+1)+"�� ���̾�� ");
				b[i].buyCom[j].use();
				j++;
			}
			while(b[i].buyAir[j]!=null)
			{
				System.out.print((i+1)+"�� ���̾�� ");
				b[i].buyAir[j].start();
				j++;
			}
			while(b[i].buyref[j]!=null)
			{
				System.out.print((i+1)+"�� ���̾�� ");
				b[i].buyref[j].manage();
				j++;
			}
			while(b[i].buyAirC[j]!=null)
			{
				System.out.print((i+1)+"�� ���̾�� ");
				b[i].buyAirC[j].start();
				j++;
			}
		}
	}
}
