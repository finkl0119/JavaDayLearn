package Day18;

import java.util.Scanner;

class Unit
{
	int num;
	int price;
	int hp;
	int attack;
	int defense;
	String target;
	double speed;
	String characteristic;
}

class Juggling extends Unit
{
	Juggling(int num) // ������
	{
		super.num = num;
		super.price = 50;
		super.hp = 35;
		super.attack = 5;
		super.defense = 0;
		super.target = "����";
		super.speed = 2.612;
		super.characteristic = "����, ����, ��ü";
	}
	
	void print()
	{
		System.out.println("���۸��� �������� �̳׶� " + super.price + ", ü�� " + super.hp + ", ���ݷ� " + super.attack + " ���� " + super.defense + ", ���ݴ�� " + super.target + ", �̵��ӵ� " + super.speed + ", ���� Ư��" + super.characteristic + "�Դϴ�.");
	}
}

class Hydra extends Unit
{
	Hydra(int num)
	{
		super.num = num;
		super.price = 100;
		super.hp = 80;
		super.attack = 10;
		super.defense = 0;
		super.target = "����, ����";
		super.speed = 1.741;
		super.characteristic = "����, ����, ��ü";
	}
	
	void print()
	{
		System.out.println("������� �������� �̳׶� " + super.price + ", ü�� " + super.hp + ", ���ݷ� " + super.attack + " ���� " + super.defense + ", ���ݴ�� " + super.target + ", �̵��ӵ� " + super.speed + ", ���� Ư��" + super.characteristic + "�Դϴ�.");
	}
}

class Lurker extends Unit
{
	Lurker(int num)
	{
		super.num = num;
		super.price = 250;
		super.hp = 125;
		super.attack = 20;
		super.defense = 1;
		super.target = "����";
		super.speed = 2.813;
		super.characteristic = "����, ����, ��ü";
	}
	
	void print()
	{
		System.out.println("��Ŀ�� �������� �̳׶� " + super.price + ", ü�� " + super.hp + ", ���ݷ� " + super.attack + " ���� " + super.defense + ", ���ݴ�� " + super.target + ", �̵��ӵ� " + super.speed + ", ���� Ư��" + super.characteristic + "�Դϴ�.");
	}
}

class Marine extends Unit
{
	Marine(int num)
	{
		super.num = num;
		super.price = 50;
		super.hp = 50;
		super.attack = 6;
		super.defense = 0;
		super.target = "����, ����";
		super.speed = 1.875;
		super.characteristic = "����, ����, ��ü";
	}
	
	void print()
	{
		System.out.println("������ �������� �̳׶� " + super.price + ", ü�� " + super.hp + ", ���ݷ� " + super.attack + " ���� " + super.defense + ", ���ݴ�� " + super.target + ", �̵��ӵ� " + super.speed + ", ���� Ư��" + super.characteristic + "�Դϴ�.");
	}
}

class Firebat extends Unit
{
	Firebat(int num)
	{
		super.num = num;
		super.price = 75;
		super.hp = 50;
		super.attack = 16;
		super.defense = 1;
		super.target = "����";
		super.speed = 1.875;
		super.characteristic = "����, ����, ��ü";
	}
	
	void print()
	{
		System.out.println("���̾�� �������� �̳׶� " + super.price + ", ü�� " + super.hp + ", ���ݷ� " + super.attack + " ���� " + super.defense + ", ���ݴ�� " + super.target + ", �̵��ӵ� " + super.speed + ", ���� Ư��" + super.characteristic + "�Դϴ�.");
	}
}

class User
{
	Juggling[] j = new Juggling[10];
	Hydra[] h = new Hydra[10];
	Lurker[] l = new Lurker[10];
	Marine[] m = new Marine[10];
	Firebat[] f = new Firebat[10];
}

public class starcraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		User u = new User();
		
		int count = 1;
		int select;
		
		System.out.println("���� ���� �Է��ϼ���: ");
		int money = sc.nextInt();
		
		while(true)
		{
			if(money >=50)
			{
				while(true)
				{
					System.out.println("���� 1. ���۸� 2.����� 3.��Ŀ 4.���� 5.���̾: ");
					select = sc.nextInt();
				
					if(select==1)
					{
						Juggling j = new Juggling(count ++);
						money = money - j.price;
						
						if(money <0)
						{
							System.out.println("������ �Ұ��մϴ�.");
							money = money + j.price;
							j=null;
							count--;
						}
						else
						{
							for(int i=0; i<10; i++)
							{
								if(u.j[i]==null)
								{
									u.j[i]=j;
									break;
								}
							}
						}
					}
	
					else if(select==2)
					{
						Hydra h = new Hydra(count ++);
						money = money - h.price;
						
						if(money <0)
						{
							System.out.println("������ �Ұ��մϴ�.");
							money = money + h.price;
							h=null;
							count--;
						}
						else
						{
							for(int i=0; i<10; i++)
							{
								if(u.h[i]==null)
								{
									u.h[i]=h;
									break;
								}
							}
						}
					}
					
					else if(select==3)
					{
						Lurker l = new Lurker(count ++);
						money = money - l.price;
						
						if(money <0)
						{
							System.out.println("������ �Ұ��մϴ�.");
							money = money + l.price;
							l=null;
							count--;
						}
						else
						{
							for(int i=0; i<10; i++)
							{
								if(u.l[i]==null)
								{
									u.l[i]=l;
									break;
								}
							}
						}
					}
					
					else if(select==4)
					{
						Marine m = new Marine(count ++);
						money = money - m.price;
						
						if(money <0)
						{
							System.out.println("������ �Ұ��մϴ�.");
							money = money + m.price;
							m=null;
							count--;
						}
						else
						{
							for(int i=0; i<10; i++)
							{
								if(u.m[i]==null)
								{
									u.m[i]=m;
									break;
								}
							}
						}	
					}
					
					else if(select==5)
					{
						Firebat f = new Firebat(count ++);
						money = money - f.price;
						
						if(money <0)
						{
							System.out.println("������ �Ұ��մϴ�.");
							money = money + f.price;
							f=null;
							count--;
						}
						else
						{
							for(int i=0; i<10; i++)
							{
								if(u.f[i]==null)
								{
									u.f[i]=f;
									break;
								}
							}
						}	
					}
			else
			{
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

		for(int i=1; i<count; i++)
		{
			for(int j=0; j<10; j++)
			{
				if(u.j[j] != null)
				{
					if(u.j[j].num == i)
					{
						System.out.println(i + "��° : ");
						u.j[j].print();
						break;
					}
				}
			}
			for(int k = 0;k<10;k++)
			{
				if(u.h[k] != null)
				{
					if(u.h[k].num == i)
					{
						System.out.print(i+"��° : ");
						u.h[k].print();
						break;
					}
				}
			}
			for(int x = 0;x<10;x++)
			{
				if(u.l[x] != null)
				{
					if(u.l[x].num == i)
					{
						System.out.print(i+"��° : ");
						u.l[x].print();
						break;
					}
				}
			}
			for(int y = 0;y<10;y++)
			{
				if(u.m[y] != null)
				{
					if(u.m[y].num == i)
					{
						System.out.print(i+"��° : ");
						u.m[y].print();
						break;
					}
				}
			}
			for(int z = 0;z<10;z++)
			{
				if(u.f[z] != null)
				{
					if(u.f[z].num == i)
					{
						System.out.print(i+"��° : ");
						u.f[z].print();
						break;
					}
				}
			}
		}
		
	}
}
}
