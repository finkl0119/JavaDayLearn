package Day16;

import java.util.Random;

class Monkey
{
	String color;
	FireBox b;//String box;
	Monkey(String color, FireBox f)
	{
		this.color = color;
		this.b = f;
	}


	void checkBox()
	{
		if(b != null)
		{
			System.out.println(color+"�����̰� ������ ������ �ֽ��ϴ�.");
		}
		else
		{
			System.out.println(color+"�����̰� ������ ������ �����ʽ��ϴ�.");
		}
	}

}

class FireBox
{

}
public class ClassQuiz07_Result {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Monkey[] m = new Monkey[5];
		FireBox b = new FireBox();
		String color[] = {"����","���","�Ķ�","�ʷ�","����"} ;

		for(int i = 0;i<5;i++)
		{
			m[i] = new Monkey(color[i],null); // �������� ��ü�� �迭�� ����
		}

		m[0].b = b; //���� �����̿��� ���̾� �ڽ� ��ü�� �ش�.


		Random r = new Random();

		int d = r.nextInt(2); // ������ ������
		int p = r.nextInt(5)+1; //��������°��� 1~5

		System.out.println(d+"/"+p);


		if(d == 0) //��
		{
			int j = 4;
			m[4].b=m[0].b;
			m[0].b = null;

			m[4].checkBox();

			for(int i = 0;i<p-1;i++)
			{
				m[j-1].b = m[j].b;
				m[j].b = null;
				j--;
				m[j].checkBox();
			}

		}
		else // ��   p : 3
		{
			for(int i =0;i<p;i++)
			{

				if(i+1 == 5)
				{
					m[0].b = m[i].b;
					m[i].b = null;
					m[0].checkBox();
				}
				else
				{
					m[i+1].b = m[i].b;
					m[i].b = null;
					m[i+1].checkBox();
				}

			}
		}
	}

}
