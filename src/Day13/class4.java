package Day13;

//27������

class car
{
	String color;
	String manufacturer;
	int maxspeed;

	public void drive()
	{
		System.out.println("���� " + color + "���̰�, ������� " + manufacturer + "�̸� �ִ�ӷ��� " + maxspeed + "�Դϴ�." );
	}
}

class bicycle
{
	String manufacturer;
	String function;

	public void ride()
	{
		System.out.println("�������� ������� " + manufacturer + "�̸� ����� " + function + "�Դϴ�." );
	}
}

class motorcycle
{
	String color;
	String manufacturer;
	int maxspeed;

	public void drive()
	{
		System.out.println("������̴� " + color + "���̰�, ������� " + manufacturer + "�̸� �ִ�ӷ��� " + maxspeed + "�Դϴ�." );
	}
}

class user1
{
	car c1;
	car c2;
}

class user2
{
	bicycle b1;
	motorcycle m;
}

public class class4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		car c1 = new car();
		car c2 = new car();
		car c3 = new car();
		car c4 = new car();

		c1.color =  "��";
		c2.color = "����";
		c3.color = "�Ͼ�";
		c4.color = "����";

		c1.manufacturer = "Ford";
		c2.manufacturer = "BMW";
		c3.manufacturer = "�Ｚ";
		c4.manufacturer = "����";

		c1.maxspeed = 220;
		c2.maxspeed = 240;
		c3.maxspeed = 200;
		c4.maxspeed = 180;

		bicycle b1 = new bicycle();
		bicycle b2 = new bicycle();

		b1.manufacturer = "��õ��";
		b2.manufacturer = "���̾�Ʈ";

		b1.function = "��ǿ�";
		b2.function = "���̽Ŀ�";

		motorcycle m = new motorcycle();

		m.manufacturer = "�븲";
		m.color = "����";
		m.maxspeed = 180;
		
		user1 u1 = new user1();
		user2 u2 = new user2();
		
		u1.c1 = c2;
		u1.c2 = c4;
		
		u1.c1.drive();
		u1.c2.drive();
		
		u2.b1 = b1;
		u2.m = m;
		
		u2.b1.ride();
		u2.m.drive();
	}

}
