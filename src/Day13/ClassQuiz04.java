package Day13;

import java.util.Random;
import java.util.Scanner;

//승리
class Win {
	
	void winInput() {
		System.out.println("승리하였습니다");
	}
}

//비김
class Draw {
	
	void drawInput() {
		System.out.println("비겼습니다");
	}
}

//패배
class Lose {
	
	void loseInput() {
		System.out.println("패배하였습니다");
	}
}

class GameStart {
	
	Win win = new Win();
	Draw draw = new Draw();
	Lose lose = new Lose();
	
	Integer hand;
    
	Scanner scanner = new Scanner(System.in);
	public int user() {
		
		while(hand < 1 || hand > 3) {
			System.out.print("1. 가위 / 2. 바위 / 3.보);");
            hand = scanner.nextInt();
		}
        return hand;
    }
	
	Random random = new Random();
    public int com() {
        return random.nextInt(3)+1;
    }
	
    
}

public class ClassQuiz04 {
	
	public static void main(String[] args) {
		
		//========================================
		
		System.out.println("===== 29번 문제 =====");	
		System.out.println();
		
//		가위 바위 보 게임 클래스화
//		가위 바위 보 게임에서 승리, 비김, 짐 이렇게 3개의 클래스로 만들어서
//		유저 숫자와 컴퓨터 숫자를 담을 수 있고 각각의 클래스 마다
//		"이겼습니다." / "비겼습니다." / "졌습니다." 를 출력하는 기능을 추가합니다.
//		게임을 실행을 할 때 승리, 비김, 짐 클래스의 객체를 다 만들어주고 com 값과 user 값을
//		각각의 객체에 대입을 시켜줍니다.
//		그리고 승리시에는 승리 클래스의 함수가 호출 되서 "이겼습니다." 가 출력이되면 된다.
//		누가 승리인지 main문에서 분기를 해주세요.
		
		Scanner scanner = new Scanner(System.in);
		GameStart user = new GameStart();
		GameStart com = new GameStart();
       
		int again = 0;
        while(again == 1) {
        	int computer = com.com();

            // 사람의 손 생성
            int userPerson = user.user();

            // 양쪽 손을 표시
            System.out.println("컴퓨터는 "+ computer+"이고, 당신은 "+ userPerson+" 입니다.");
            
            //판정
            
            int result = (userPerson - computer + 3) %3;
	            switch(result) {
	            case 0: System.out.println("비겼습니다.");break;
	            case 1: System.out.println("당신이 졌습니다.");break;
	            case 2: System.out.println("당신이 이겼습니다.");break;
            }
            while(again != 0 && again != 1) {
	        	
	        	 System.out.print("다시 한번 하시겠습니까? 1.아니오 2. 예 : ");
	        	 again = scanner.nextInt();
	        }
            
	       
            
        }
		
		
	}	
	
	
	
}
