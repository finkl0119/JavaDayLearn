package Day18;

import java.util.ArrayList;
import java.util.Scanner;

class OneTel
{
	private String name;
	private String tel;
	private String address;
	private boolean sung;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isSung() {
		return sung;
	}
	public void setSung(boolean sung) {
		this.sung = sung;
	}
	
	OneTel(String name, String tel, String address, boolean sung)
	{
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.sung = sung;
	}
}


public class num41t {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<OneTel> telbook = new ArrayList<OneTel>();
		
		while(true)
		{
			System.out.print("1.�߰� 2.���� 3.��ȭ��ȣ ã�� 4. ��ü ��� 5. ���� :");
			int num = sc.nextInt();
			boolean check = false;
			if(num == 1)
			{
				System.out.print("1. �̸� :");
				String name = sc.next();
				
				for(int i =0;i<telbook.size();i++)
				{
					if(name.equals(telbook.get(i).getName()))
					{
						System.out.println("���� ����� �����մϴ�.");
						check = true;
						break;
					}
				}
				if(check)
				{
					continue;
				}
				
				System.out.print("2. ��ȭ��ȣ :");
				String tel = sc.next();
				System.out.print("3. �ּ� :");
				sc.nextLine();
				String address = sc.nextLine();
				System.out.print("4. ���� :");
				String sung = sc.next();
				
				boolean checkSung = false;
				if(sung.equals("��"))
				{
					checkSung = false;
				}
				else if(sung.equals("��"))
				{
					checkSung = true;
				}
				else
				{
					System.out.println("��������?");
					continue;
				}
				
				telbook.add(new OneTel(name, tel, address, checkSung));
			}
			else if(num == 2)
			{
				System.out.print("1. �̸� :");
				String name = sc.next();
				int checkNum = -1;
				for(int i =0;i<telbook.size();i++)
				{
					if(name.equals(telbook.get(i).getName()))
					{
						checkNum = i;
						break;
					}
				}
				if(checkNum == -1)
				{
					System.out.println("���� ����Դϴ�.");
				}
				else
				{
					System.out.println(telbook.get(checkNum).getName()+"�����˴ϴ�.");
					telbook.remove(checkNum);
				}
				
			}
			else if(num == 3)
			{
				System.out.print("1. �̸� :");
				String name = sc.next();
				int checkNum = -1;
				for(int i =0;i<telbook.size();i++)
				{
					if(name.equals(telbook.get(i).getName()))
					{
						checkNum = i;
						break;
					}
				}
				
				if(checkNum == -1)
				{
					System.out.println("���� ����Դϴ�.");
				}
				else
				{
					System.out.println("�̸� :"+telbook.get(checkNum).getName()+
							" ��ȭ��ȣ : "+telbook.get(checkNum).getTel()+
							" �ּ� : "+telbook.get(checkNum).getAddress()+
							" ���� : "+(telbook.get(checkNum).isSung()? "��" : "��"));
					
				}
				
				
			}
			else if(num == 4)
			{
				for(int i =0;i<telbook.size();i++)
				{
					System.out.println("�̸� :"+telbook.get(i).getName()+
							" ��ȭ��ȣ : "+telbook.get(i).getTel()+
							" �ּ� : "+telbook.get(i).getAddress()+
							" ���� : "+(telbook.get(i).isSung()? "��" : "��"));
				}
			}
			else if(num == 5)
			{
				System.out.println("�ȳ���������.");
				break;
			}
			else
			{
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

}
