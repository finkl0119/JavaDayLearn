package Day18;

import java.util.Random;

//�������
interface Buster
{

}
//Ż��Ŭ����
class Vehicle
{
	private int mileage;//����Ÿ�
	private int gauge;//������

	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage += mileage;//�� ������Ŵ
	}
	public int getGauge() {
		return gauge;
	}
	public void setGauge(int gauge) {
		this.gauge = gauge;
	}
	//�̵��Լ� �������̵�
	public void length() 
	{
		System.out.println("�̵��Ѵ�!");
	}
}

class Car extends Vehicle implements Buster
{
	//�̵��Լ� �������̵�(0~20M)
	public void length() 
	{
		System.out.println("�� �̵��Ÿ���"+getMileage()+"M �Դϴ�.");
	}

}

class Bycle extends Vehicle implements Buster
{	
	//�̵��Լ� �������̵�(0~10)
	public void length()
	{
		System.out.println("������ �̵��Ÿ���"+getMileage()+"M �Դϴ�.");
	}
}

class Auto extends Vehicle implements Buster
{	
	//�̵��Լ� �������̵�(0~15)
	public void length()
	{
		System.out.println("������� �̵��Ÿ���"+getMileage()+"M �Դϴ�.");
	}


}

class Mulbuster 
{
	public void buster(Buster k, int flag) 
	{
		if(k instanceof Car)//�ڵ������
		{
			Car c = (Car)k; // �缱���ؾ� Ŭ���� �Լ� ��������...
			if(flag%4==0)//4�ϸ��� +2
			{
				System.out.println("�ڵ��� �ν���! +2M");
				c.setMileage(2);
			}
		}

		else if(k instanceof Bycle)//�����Ŷ��
		{
			Bycle b = (Bycle)k;
			if(flag%2==0)//2�ϸ��� +5
			{
				System.out.println("������ �ν���! +5M");
				b.setMileage(5);
			}
		}
		else if(k instanceof Auto)//������̶��
		{
			Auto a = (Auto)k;
			if(flag%3==0)//3�ϸ��� +3
			{
				System.out.println("������� �ν���! +3M");
				a.setMileage(3);
			}
		}
		else
		{
			System.out.println("����");
		}
	}
}



public class num40t {
	static void prints(Vehicle k)
	{
		k.length();//�������̵� ����Լ�
	}

	public static void main(String[] args) {
		Random r = new Random();
		int flag = 0;

		Vehicle c = new Car();
		Vehicle b = new Bycle();
		Vehicle a = new Auto();

		Mulbuster mb = new Mulbuster();


		while(true) 
		{
			int index = 0;
			index = r.nextInt(3)+1;//1~3������

			switch(index)
			{
			case 1://�ڵ��� ����
				a.setMileage(r.nextInt(16));//������̴� 0~15
				b.setMileage(r.nextInt(11));//�����Ŵ� 0~10
				break;
			case 2://������ ����
				a.setMileage(r.nextInt(16));//������̴� 0~15
				c.setMileage(r.nextInt(21));//�ڵ����� 0~20
				break;
			case 3://������� ����
				b.setMileage(r.nextInt(11));//�����Ŵ� 0~10
				c.setMileage(r.nextInt(21));//�ڵ����� 0~20
				break;
			}

			
			mb.buster((Auto)a, flag);
			mb.buster((Bycle)b, flag);
			mb.buster((Car)c, flag);
			
			prints(a);//�������̵����� �̵��Ÿ� ��� �ҷ���(�������)
			prints(b);//�������̵����� �̵��Ÿ� ��� �ҷ���(������)
			prints(c);//�������̵����� �̵��Ÿ� ��� �ҷ���(�ڵ���)

			//�ν��� �Լ�(2�ϸ��� ������), (3�ϸ��� �������), (4�ϸ��� �ڵ���)
			//�ڵ���, �������, �����Ŵ� �̹� �������̽� ��ӹ޾��� ����. �������̽��� : Buster
			


			if(a.getMileage()>=500)
			{
				System.out.println("������� ���");
				break;
			}

			else if(b.getMileage()>=500)
			{
				System.out.println("������ ���");
				break;
			}

			else if(c.getMileage()>=500)
			{
				System.out.println("�ڵ��� ���");
				break;
			}

			flag++;
			System.out.println("���� "+flag+"�� �Դϴ�.");
		}

	}

}
