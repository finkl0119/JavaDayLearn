package Day11;

import java.util.Random;
import java.util.Scanner;

public class func5 {


	//���ӽ��۸�Ʈ
	public static void baseballgame()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("�迭���� ������ �����ϰڽ��ϴ�.");
		System.out.print("1.���ӽ��� 2.���� : ");
		int select = sc.nextInt();
		int comuser[] = new int[3]; // ��ǻ�� ���� ���� 3��
		if(select == 1)
		{

			int flag = 0;
			comuser = comrandom();
			while(flag != 3)
			{
				flag = 0;//�ʱ�ȭ
				flag = comuser(comuser,userselect());
				//  strike ���� �� flag
				//�������
				// 3 strike ������ flag 3
				//�ݺ�������
			}
			end();
			
		}
		else if(select == 2)
		{
			end();
		}

		else
		{
			err(); //�Լ��� �ݺ��� ó�� �̿�
		}
		
	}
	//���� ������
	public static int[] comrandom()
	{
		Random r = new Random();
		int com[] = new int[3];

		//������ �� �ߺ�����
		for(int i=0; i<com.length; i++)
		{
			com[i] = r.nextInt(9)+1;

			for(int j=0; j<i; j++)
			{
				if(com[i] == com[j])
				{
					i--;
				}
			}

		}
		return com; //1���� �迭 ����
	}//������ ��


	//�迭�� �Լ�
	public static int comuser(int a[]/*�İ�*/, int b[]/*������*/)
	{
		int strike = 0;
		int ball = 0;


		for(int k=0; k<b.length; k++)//��������, �Է¼� ��
		{
			for(int j=0; j<a.length; j++)
			{
				if(b[k]==a[j])
				{

					if(k==j)
					{
						strike++;
					}
					else if(k != j)
					{
						ball++;
					}
				}
			}				
		}
		if(strike==0&&ball==0)
		{
			System.out.println("OUT�Դϴ�.");
		}

		else 
		{
			System.out.println(strike+"S"+ball+"B"+"�Դϴ�.");
		}

		return strike;

	}

	public static int[]	userselect()
	{

		Scanner sc = new Scanner(System.in);
		int user[] = new int[3];

		System.out.print("ù��° ������ �Է��� �ּ��� : ");
		user[0] = sc.nextInt();
		System.out.print("�ι�° ������ �Է��� �ּ��� : ");
		user[1] = sc.nextInt();
		System.out.print("����° ������ �Է��� �ּ��� : ");
		user[2] = sc.nextInt();

		//�ߺ�����
		//10�̻��� ���� �Է���
		//10���� ���� ������ ���� ������ �״�� ����
		while(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
		{
			System.out.println("�ߺ��Ǵ� ���� �����մϴ�.");
			System.out.print("ù��° ������ �Է��� �ּ��� : ");
			user[0] = sc.nextInt();
			System.out.print("�ι�° ������ �Է��� �ּ��� : ");
			user[1] = sc.nextInt();
			System.out.print("����° ������ �Է��� �ּ��� : ");
			user[2] = sc.nextInt();

		}

		while(user[0]>10||user[1]>10||user[2]>10)
		{
			System.out.println("�߸��� �Է��Դϴ�.");

			System.out.print("ù��° ������ �Է��� �ּ��� : ");
			user[0] = sc.nextInt();
			System.out.print("�ι�° ������ �Է��� �ּ��� : ");
			user[1] = sc.nextInt();
			System.out.print("����° ������ �Է��� �ּ��� : ");
			user[2] = sc.nextInt();

		}

		return user;
	}
	//�����Լ�
	public static void end()
	{
		System.out.println("������ �����մϴ�.");
	}

	//�����Լ�
	public static void err()
	{
		System.out.println("�߸��� �Է��Դϴ�.");
		baseballgame();
	}

	//�����Լ�
	public static void main(String[] args){
		baseballgame();
	}

}
