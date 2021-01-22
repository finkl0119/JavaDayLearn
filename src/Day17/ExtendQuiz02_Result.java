package Day17;

import java.util.Random;

class Animal1
{
	private String name;
	private String color;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
class Dog extends Animal1
{
	void bark()
	{
		System.out.println(getColor()+"��"+getName()+"�� ¢�´�.");
	}
}

class Cat extends Animal1
{
	void meow()
	{
		System.out.println(getColor()+"��"+getName()+"�� �߿��Ѵ�.");
	}
}

class Bird extends Animal1
{
	void fly()
	{
		System.out.println(getColor()+"��"+getName()+"�� ���ƴٴѴ�.");
	}
}

public class ExtendQuiz02_Result {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		Dog d[] = new Dog[3];
		Cat c[] = new Cat[2];
		Bird b = new Bird();
		
		String[] dsort = {"��Ƽ��","��ũ���׸���","���޶�Ͼ�","�ù�","�����ڱ�"};
		String[] csort = {"��ġŲ","����ũ��","��","��","����"};
		String[] bsort = {"�޹���","����","��","���","��ѱ�"};
		
		String[] color = {"����","������","���","�����","������"};
		
		for(int i =0;i<3;i++)
		{
			int num1 = r.nextInt(5);
			int num2 = r.nextInt(5);
			d[i] = new Dog();
			d[i].setName(dsort[num1]);
			d[i].setColor(color[num2]);
			d[i].bark();
		}
		for(int i=0;i<2;i++)
		{
			int num1 = r.nextInt(5);
			int num2 = r.nextInt(5);
			c[i] = new Cat();
			c[i].setName(csort[num1]);
			c[i].setColor(color[num2]);
			c[i].meow();
		}
		int num1 = r.nextInt(5);
		int num2 = r.nextInt(5);
		
		b.setName(bsort[num1]);
		b.setColor(color[num2]);
		b.fly();
	}

}
