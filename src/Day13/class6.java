package Day13;

import java.util.Random;
import java.util.Scanner;

class Win1
{
	int com, user;
	
	public void win() {
		// TODO Auto-generated method stub
		System.out.println("������ �̰���ϴ�.");
	}
}

class Tie1
{
	int com, user;
	
	public void tie() {
		// TODO Auto-generated method stub
		System.out.println("�����ϴ�.");
	}
}

class Lose1
{
	int com, user;

	public void lose() {
		// TODO Auto-generated method stub
		System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
	}
}


public class class6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int com , user = 0;
		String temp;
		
		while(true)
		{
			
		System.out.println("���� ���� ���� �Է��ϼ���:");
		temp=sc.next();
		
		if(temp.equals("����"))
		{user= 1; break;}
		else if (temp.equals("����"))	
		{user= 2; break;}
		else if (temp.equals("��"))
		{user= 3; break;}
		else
		{System.out.println("�߸��� �Է��Դϴ�."); continue;}
		
		}
		
		Win1 w = new Win1();
		Tie1 t = new Tie1();
		Lose1 l = new Lose1();
		
		com = r.nextInt(3)+1;
		
		w.com=com;
		w.user=user;
		
		t.com=com;
		t.user=user;
		
		l.com=com;
		l.user=user;
		
		if(user-com == 1 || user-com == -2)
		{
			w.win();
		}
		else if (user-com == 0)
		{
			t.tie();
		}
		else if (user-com == -1 || user-com == 2)
		{
			l.lose();
		}
	}

}
