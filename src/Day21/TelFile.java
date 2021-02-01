package Day21;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class MyFriendList {
	private String name;
	private String number;
	private String addr;

	MyFriendList(String name, String number, String addr) {
		this.name = name;
		this.number = number;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getAddr() {
		return addr;
	}
}

class MyPhone {

	Scanner sc = new Scanner(System.in);
	ArrayList <MyFriendList> list = new ArrayList<MyFriendList>();

	FileWriter fout = null;
	FileReader file_check = null;
	File file = new File("D:\\PhoneBook.txt");
	//������ ���� ���ؼ� ��ü�� ��������ϴ�.

	int menu, i;
	boolean flag = true;
	String input_name, input_number, input_addr, input_gen;

	//����

	void myList() throws IOException {

		if(!file.exists()) {		//������ ������ ���� ����
			file.createNewFile();
		}

		String line1;
		String [] spliteLine1 = null;

		BufferedReader in1 = new BufferedReader(new FileReader("D:\\PhoneBook.txt"));

		while((line1 = in1.readLine()) != null)
		{
			spliteLine1 = line1.split("\t\t");
			list.add(new MyFriendList(spliteLine1[0], spliteLine1[1], spliteLine1[2]));
		}
		if(list.size() >0)
			list.remove(0);

		while(true) {
			System.out.println("1.�߰�\t2.ã��\t3.��ü ���\t4.����\t5.����");
			System.out.print("�Է�>>");
			menu = sc.nextInt();

			if(menu == 1) {
				System.out.println("�̸��� �Է��ϼ���");
				System.out.print("�̸�: ");
				input_name = sc.next();

				for(int i =0;i<list.size();i++)
				{
					if(input_name.equals(list.get(i).getName()))
					{
						System.out.println("�ߺ��� �̸��Դϴ�.");
						flag = false;
						break;
					}
					else
					{
						flag = true;
					}
				}
				if(flag == true) {
					System.out.print("��ȭ��ȣ: ");
					input_number = sc.next();
					System.out.print("�ּ�: ");
					sc.nextLine();
					input_addr = sc.nextLine();

					list.add(new MyFriendList(input_name, input_number, input_addr));
					String info = input_name+"\t\t"+input_number+"\t\t"+input_addr+"\r\n";

					try {

						fout = new FileWriter("D:\\PhoneBook.txt", true);
						file_check = new FileReader("D:\\PhoneBook.txt");

						if(file_check.read() == -1) {
							fout.write("�̸�\t\t��ȭ��ȣ\t\t�ּ�\r\n");
						}

						fout.write(info);
						fout.close();

					} catch (IOException e) {
						System.out.println("����� ����");
					}
				}
			} else if(menu == 2) {

				System.out.println("ã�� �̸��� �Է��ϼ���.");
				System.out.print("�̸�: ");
				input_name = sc.next();
				flag = true;
				for(int i =0;i<list.size();i++)
				{
					if(input_name.equals(list.get(i).getName()))
					{
						System.out.println(list.get(i).getName() +"\t\t "+
								list.get(i).getNumber()+"\t\t"+list.get(i).getAddr());
						flag = true;
						break;
					}
					else
					{
						flag = false;
					}
				}
				if(flag == false ) {
					System.out.println("ã�� ����� �����ϴ�.");
				}
			} else if(menu == 3) {

				System.out.println("�̸�\t\t��ȭ��ȣ\t\t�ּ�");
				for(int i =0;i<list.size();i++)
				{
					System.out.println(list.get(i).getName() +"\t\t "+
							list.get(i).getNumber()+"\t\t"+list.get(i).getAddr());
				}

			} else if(menu == 4) {

				System.out.println("������ �̸��� �Է��ϼ���.");
				System.out.print("�̸�: ");
				input_name = sc.next();
				int index = -1;
				
				for(int i =0;i<list.size();i++)
				{
					if(input_name.equals(list.get(i).getName()))
					{
						System.out.println(list.get(i).getName()+"�� ������ �ƽ��ϴ�.");
						index = i;
						break;
					}

				}
				if(index == -1)
				{
					System.out.println("ã�� ����� �����ϴ�.");
				}
				else
				{
					list.remove(index);
					fout = new FileWriter("D:\\PhoneBook.txt", false);
					fout.write("�̸�\t\t��ȭ��ȣ\t\t�ּ�\r\n");
					for(int i =0;i<list.size();i++)
					{
						fout.write(list.get(i).getName()+"\t\t"+list.get(i).getNumber()+
								"\t\t"+list.get(i).getAddr()+"\r\n");
					}
				}
				
				fout.close();
			} else if(menu == 5) {
				System.out.println("�����մϴ�.");
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
}

public class TelFile {
	public static void main(String[] args) {
		try {
			new MyPhone().myList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}