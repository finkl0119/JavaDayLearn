package Day15;

import java.util.Random;

/**
 * 올림픽 게임
 * @author YU
 *
 */
class player1{
	private int number;
	private String country;
	private int go;
	private boolean check;

	int getNumber()
	{
		return number;
	}
	void setNumber(int num)
	{
		number = num ;
	}
	String getContury()
	{
		return country;
	}
	void setContury(String con)
	{
		country = con;
	}
	void setCheck(boolean ch)
	{
		check = ch;
	}
	void setGo(int g)
	{
		go = g;
	}


	int goValue()
	{
		Random r = new Random();
		if(!check)
			go += Math.abs(r.nextInt()%9)+1;
		return go;
	}

}



public class ClassQuiz06_Result
{
	public static void main(String args[])
	{	
		int koreaGo = 0;
		int chinaGo = 0;
		int amricaGo = 0;
		int russiaGo = 0;

		player1 korea = new player1();
		player1 china = new player1();
		player1 america = new player1();
		player1 russia = new player1();

		korea.setNumber(1);
		korea.setContury("�ѱ�");
		korea.setGo(0);

		china.setNumber(2);
		china.setContury("�߱�");
		china.setGo(0);

		america.setNumber(3);
		america.setContury("�̱�");
		america.setGo(0);

		russia.setNumber(4);
		russia.setContury("���þ�");
		russia.setGo(0);

		Random r = new Random();

		while(true)
		{

			int ra =Math.abs(r.nextInt()%3)+1; // ���߻�Ȳ

			switch (ra) {
			case 1:
				korea.setCheck(true);
				china.setCheck(false);
				america.setCheck(false);
				russia.setCheck(false);
				break;
			case 2:
				korea.setCheck(false);
				china.setCheck(true);
				america.setCheck(false);
				russia.setCheck(false);
				break;
			case 3:
				korea.setCheck(false);
				china.setCheck(false);
				america.setCheck(true);
				russia.setCheck(false);
				break;
			case 4:
				korea.setCheck(false);
				china.setCheck(false);
				america.setCheck(false);
				russia.setCheck(true);
				break;

			default:
				break;
			}
			koreaGo = korea.goValue();
			chinaGo = china.goValue();
			amricaGo = america.goValue();
			russiaGo = russia.goValue();


			System.out.printf("%s�� %dM�Դϴ�.\n", korea.getContury(),koreaGo);
			System.out.printf("%s�� %dM�Դϴ�.\n", china.getContury(),chinaGo);
			System.out.printf("%s�� %dM�Դϴ�.\n", america.getContury(),amricaGo);
			System.out.printf("%s�� %dM�Դϴ�.\n", russia.getContury(),russiaGo);


			
			if(koreaGo >=100)
			{
				System.out.println("��±��� �ѱ��Դϴ�.");
				break;
			}
			if(chinaGo >=100)
			{
				System.out.println("��±��� �߱��Դϴ�.");
				break;
			}
			if(amricaGo >=100)
			{
				System.out.println("��±��� �̱��Դϴ�.");
				break;
			}
			if(russiaGo >=100)
			{
				System.out.println("��±��� ���þ��Դϴ�.");
				break;
			}

		}
	}
}