package Day15;

import java.util.Random;

class OlympicsController {		
	boolean gameStart(Player[] player) {
		boolean gameEnd = true;	
		for (int i = 0; i < player.length; i++) {
			Random random = new Random();
			int hurdleTime = random.nextInt(3)+1;
			//돌발 상황
			if(hurdleTime != (i+1)) {
				player[i].runPlayer();
				gameEnd = gameEnd && player[i].gameEnd;	
			}
		}
		return gameEnd;
	}
}

class Player {
	String name;
	int distance;
	boolean gameEnd = false;
	
	Player(String name) {
		this.name = name;
	}
	
	void runPlayer() {
		if (!this.gameEnd) {
			Random random = new Random();
			this.distance = this.distance + random.nextInt(9)+1;
			
			
			System.out.println(this.name + " : " + this.distance + "M");		
			this.checkEnd();
		}
	}
	void checkEnd() {
		if (distance >= 100) {
			gameEnd = true;
			System.out.println(this.name + "!! 우승입니다.");
		}
	}
	
	void run() {
		while(true) {
			this.runPlayer();
			if (this.gameEnd) {
				break;
			}
		}
	}
}

public class ClassQuiz06 {
	
	public static void main(String[] args) {
		
		//========================================
		
		System.out.println("===== 32번 문제 =====");	
		System.out.println();
		
//		올림픽게임
//		올림픽선수 : 한국선수 / 중국선수 / 미국선수 / 러시아선수
//		한국선수 : 레인번호(1), 나라명, 전진거리, 돌발상황체크
//		중국선수 : 레인번호(2), 나라명, 전진거리, 돌발상황체크
//		미국선수 : 레인번호(3), 나라명, 전진거리, 돌발상황체크
//		러시아선수 : 레인번호(4), 나라명, 전진거리, 돌발상황체크
//		(돌발상황 체크는 랜덤으로 정해짐)
//		
//		Main 돌발상황주기, 총 전진거리 체크 및 출력(100m 먼저 도착한 선수 우승)
//		전진거리 최대 1M ~ 10M 랜덤으로 숫자를 받아서 진행 
//		우승확정 시 어느나라가 우승인지 Print
//		동시에 100m을 넘는 경우는 결과 값이 가장 큰 나라가 우승
		
		Player[] player = 
			{
				new Player("한국"), 
	   			new Player("중국"),
				new Player("미국"),
				new Player("러시아")
			};
		
		OlympicsController olympicsController = new OlympicsController();
		
		while(true) {
			boolean gameEnd = olympicsController.gameStart(player);
			
			System.out.println("==============================");
			
			if (gameEnd) {
				break;
			}
		}
	}	
}
