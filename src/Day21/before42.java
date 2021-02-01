package Day21;

import java.io.*;
import java.util.*;

class MyFriendList1 {
	private String name;
	private String number;
	private String addr;

	MyFriendList1(String name, String number, String addr) {
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

class MyPhone1 {

	Scanner sc = new Scanner(System.in);
	ArrayList <MyFriendList1> list = new ArrayList<MyFriendList1>();

	FileWriter fout = null;
	FileReader file_check = null;
	File file = new File("D:\\PhoneBook.txt");

	int menu, i;
	boolean flag = true;
	String input_name, input_number, input_addr, input_gen;

	void myList() throws IOException {
		
		if(!file.exists()) {		//������ ������ ���� ����
			file.createNewFile();
		}
		
		while(true) {
			System.out.println("1.�߰�\t2.ã��\t3.��ü ���\t4.����\t5.����");
			System.out.print("�Է�>>");
			menu = sc.nextInt();
			//sc.nextLine();	//���Ͱ� ����

			if(menu == 1) {
				System.out.println("�̸��� �Է��ϼ���");
				System.out.print("�̸�: ");
				input_name = sc.next();

				file_check = new FileReader("D:\\PhoneBook.txt");
				BufferedReader in = new BufferedReader(new FileReader("D:\\PhoneBook.txt"));
				String line;

				while((line = in.readLine()) != null) {
					
					if(line.contains(input_name)) {
						System.out.println("�ߺ��� �̸��Դϴ�.");
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
				
				if(flag == true) {
					System.out.print("��ȭ��ȣ: ");
					input_number = sc.next();
					System.out.print("�ּ�: ");
					sc.nextLine();
					input_addr = sc.nextLine();

					//list.add(new MyFriendList(input_name, input_number, input_addr));
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
				
				file_check = new FileReader("D:\\PhoneBook.txt");
				String line;
				flag = true;
				try {
					BufferedReader in = new BufferedReader(new FileReader("D:\\PhoneBook.txt"));
					
					while((line = in.readLine()) != null) {
						
						if(line.contains(input_name)) {
							System.out.println("�̸�\t\t��ȭ��ȣ\t\t�ּ�");
							System.out.println(line);
							flag = true;
							break;
						} else {
							flag = false;
						}
					}
					
					if(flag == false ) {
						System.out.println("ã�� ����� �����ϴ�.");
					}
					in.close();
					
				} catch(IOException e) {
					e.printStackTrace();
				}

			} else if(menu == 3) {
				
				try {
					file_check = new FileReader("D:\\PhoneBook.txt");
					int c;
					
					while((c = file_check.read()) != -1) {
						System.out.print((char)c);
					}
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}

			} else if(menu == 4) {
				
				System.out.println("������ �̸��� �Է��ϼ���.");
				System.out.print("�̸�: ");
				input_name = sc.next();
				
				file_check = new FileReader("D:\\PhoneBook.txt");
				String line;
				String temp = "";
				boolean flag = true;
				
				try {
					fout = new FileWriter("D:\\PhoneBook.txt", true);
					BufferedReader in = new BufferedReader(new FileReader("D:\\PhoneBook.txt"));
					
					while((line = in.readLine()) != null) {
						
						if(line.contains(input_name)) {
							System.out.println(input_name+"���� �����մϴ�.");
							flag = true;
						} else {
							temp += line+"\r\n";
							flag = false;
						}
					}
					
					fout = new FileWriter("D:\\PhoneBook.txt", false);
					fout.write(temp);
					
					fout.close();
					
					if(flag == false ) {
						System.out.println("ã�� ����� �����ϴ�.");
					}
					fout.close();
					in.close();
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			} else if(menu == 5) {
				System.out.println("�����մϴ�.");
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
}


public class before42 {

	public static void main(String[] args) throws IOException {

		new MyPhone1().myList();
		/*
		 * 42�� ����
		 * <ùȭ��>
		 * 1.�Է�  2.�˻�  3.��ü���  4.����  5.����:
		 * <1 �Է½�>
		 * �̸�: ȫ�浿 / ��ȭ��ȣ :010 / �ּ�: ��õ�� =>�Է��� ������ ùȭ������ �̵�
		 * <2 �Է½�>
		 * �̸� �Է�: ȫ�浿 -> ����Ǿ��ִ� �̸�, ��ȭ��ȣ, �ּ� ��� �� ùȭ������ �̵�
		 * <3 �Է½�>
		 * �̸� �Է�: ȫ�浿 -> �̸��� ���� �����Ͱ� ������ ���� / ������ ���ٰ� ���
		 * <4 �Է½�>
		 * ��� ��ȭ��ȣ�� ��� ���� ùȭ��
		 * <5 �Է½�>
		 * ���α׷� ����
		 * 
		 * 1~5�� �̿��� ���� �ԷµǸ� "�߸��� �Է�" ���
		 * 
		 * ��� ��ȭ��ȣ�� �ϳ��� ���Ͽ� ����Ǿ�� ��, �߰� or ���� �� ��ȭ��ȣ�� ������Ʈ �Ǿ�� ��
		 * ���α׷� ���� �Ŀ��� �����Ͱ� �����Ǿ���ϰ� ���α׷��� ���۵Ǹ� ���Ͽ� �ִ� ��ȭ��ȣ�θ� �о �����͸� �˻��ϰų� ����ؾ� ��
		 */

	}

}
