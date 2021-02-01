package Day02;

import java.io.*;
import java.util.*;

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

	int menu, i;
	boolean flag = true;
	String input_name, input_number, input_addr, input_gen;

	void myList() throws IOException {
		
		if(!file.exists()) {		//파일이 없으면 파일 생성
			file.createNewFile();
		}
		
		while(true) {
			System.out.println("1.추가\t2.찾기\t3.전체 출력\t4.삭제\t5.종료");
			System.out.print("입력>>");
			menu = sc.nextInt();
			//sc.nextLine();	//엔터값 제거

			if(menu == 1) {
				System.out.println("이름을 입력하세요");
				System.out.print("이름: ");
				input_name = sc.next();

				file_check = new FileReader("D:\\PhoneBook.txt");
				BufferedReader in = new BufferedReader(new FileReader("D:\\PhoneBook.txt"));
				String line;

				while((line = in.readLine()) != null) {
					
					if(line.contains(input_name)) {
						System.out.println("중복된 이름입니다.");
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
				
				if(flag == true) {
					System.out.print("전화번호: ");
					input_number = sc.next();
					System.out.print("주소: ");
					sc.nextLine();
					input_addr = sc.nextLine();

					//list.add(new MyFriendList(input_name, input_number, input_addr));
					String info = input_name+"\t\t"+input_number+"\t\t"+input_addr+"\r\n";

					try {

						fout = new FileWriter("D:\\PhoneBook.txt", true);
						file_check = new FileReader("D:\\PhoneBook.txt");
						
						if(file_check.read() == -1) {
							fout.write("이름\t\t전화번호\t\t주소\r\n");
						}

						fout.write(info);
						fout.close();

					} catch (IOException e) {
						System.out.println("입출력 오류");
					}
				}
			} else if(menu == 2) {

				System.out.println("찾을 이름을 입력하세요.");
				System.out.print("이름: ");
				input_name = sc.next();
				
				file_check = new FileReader("D:\\PhoneBook.txt");
				String line;
				flag = true;
				try {
					BufferedReader in = new BufferedReader(new FileReader("D:\\PhoneBook.txt"));
					
					while((line = in.readLine()) != null) {
						
						if(line.contains(input_name)) {
							System.out.println("이름\t\t전화번호\t\t주소");
							System.out.println(line);
							flag = true;
							break;
						} else {
							flag = false;
						}
					}
					
					if(flag == false ) {
						System.out.println("찾는 사람이 없습니다.");
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
				
				System.out.println("삭제할 이름을 입력하세요.");
				System.out.print("이름: ");
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
							System.out.println(input_name+"님을 삭제합니다.");
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
						System.out.println("찾는 사람이 없습니다.");
					}
					fout.close();
					in.close();
					
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			} else if(menu == 5) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}


public class test42 {

	public static void main(String[] args) throws IOException {

		new MyPhone().myList();
		/*
		 * 42번 문제
		 * <첫화면>
		 * 1.입력  2.검색  3.전체출력  4.삭제  5.종료:
		 * <1 입력시>
		 * 이름: 홍길동 / 전화번호 :010 / 주소: 인천시 =>입력이 끝나면 첫화면으로 이동
		 * <2 입력시>
		 * 이름 입력: 홍길동 -> 저장되어있는 이름, 전화번호, 주소 출력 후 첫화면으로 이동
		 * <3 입력시>
		 * 이름 입력: 홍길동 -> 이름이 같은 데이터가 있으면 삭제 / 없으면 없다고 출력
		 * <4 입력시>
		 * 모든 전화번호를 출력 이후 첫화면
		 * <5 입력시>
		 * 프로그램 종료
		 * 
		 * 1~5값 이외의 값이 입력되면 "잘못된 입력" 출력
		 * 
		 * 모든 전화번호는 하나의 파일에 저장되어야 함, 추가 or 삭제 시 전화번호가 업데이트 되어야 함
		 * 프로그램 종료 후에도 데이터가 보존되어야하고 프로그램이 시작되면 파일에 있는 전화번호부를 읽어서 데이터를 검색하거나 출력해야 함
		 */

	}

}
