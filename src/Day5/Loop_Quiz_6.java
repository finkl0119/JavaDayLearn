package Day5;

import java.util.Scanner;

public class Loop_Quiz_6 {

	public static void main(String[] args) {
		
//		회원가입, 로그인 프로그램
//			1. 회원가입
//			2. 로그인
//			3. 종료
//			
//			1번인 경우 
//				id를 입력하세요. :
//				pw를 입력하세요. :
//					pass님 회원가입이 되었습니다.
//			2번인 경우		
//				조건 1. 회원가입을 해서 ID와 PW가 있는 경우
//					id : pass
//					pw : 1234
//					=> pass님 환영합니다
//				조건 2. 회원가입을 하지 않은 경우
//					회원가입이 되지 않았습니다.
//					*1번화면 출력
//					pass님 회원가입이 되었습니다.	
//					첫화면으로.
//				조건 3. ID와 PW가 틀린 경우
//					ID PW가 틀립니다.		
//			3번인 경우
//				안녕히 가세요.
//				프로그램 종료
		
		Scanner scanner = new Scanner(System.in);
		
		int select_0 = 0;
		boolean member = false;
		
		String input_id_0 = "";
		String input_pw_0 = "";
	
		String input_id_1 = "";
		String input_pw_1 = "";
		
		String input_id_2 = "";
		String input_pw_2 = "";
		
		while(true) {
			if(member == false) {
				System.out.print("1. 회원가입, 2. 로그인, 3. 종료 : ");
				select_0 = scanner.nextInt();	
			}
			if((select_0 < 4) && (select_0 > 0)) {
				
				if(select_0 == 1) {
					
					System.out.println();
					System.out.println("==회원가입 화면==");
					System.out.print("ID를 입력하세요. : ");
					input_id_0 = scanner.next();
					System.out.print("PW를 입력하세요. : ");
					input_pw_0 = scanner.next();
					
					System.out.println(input_id_0 + "님 회원가입이 되었습니다.");
					System.out.println();
					
					input_id_2 = input_id_0;
					input_pw_2 = input_pw_0;
					member = false;
				}else if(select_0 == 2) {
					
					System.out.println();
					System.out.println("==로그인 화면==");
					System.out.print("ID를 입력하세요. : ");
					input_id_1 = scanner.next();
					System.out.print("PW를 입력하세요. : ");
					input_pw_1 = scanner.next();
					System.out.println();
					
					if((input_id_2.equals(input_id_1)) && (input_pw_2.equals(input_pw_1))) {
						//로그인
						System.out.println(input_id_1 + "님 로그인이 되었습니다.");
						continue;
					}else if(!input_id_2.equals(input_id_1)) {
						//회원가입을 하지 않은 경우
						System.out.println("회원가입이 되지 않았습니다.");
						//회원가입 화면 으로 이동
						member = true;
						select_0 = 1;
					}else {
						//ID와 PW가 틀린 경우
						if((input_id_1.equals(input_id_2))) {
							if((!input_pw_1.equals(input_pw_2))) {
								System.out.println("ID PW가 틀립니다.");
							}
							member = true;
							continue;
						}
					}
					
				}else if (select_0 == 3) {
					System.out.println("안녕히가세요.");
					System.out.println("프로그램 종료");
					break;
				}
			}else {
				System.out.println("번호를 다시 선택해주세요.");
				continue;
			}
			
		}
	}
}
