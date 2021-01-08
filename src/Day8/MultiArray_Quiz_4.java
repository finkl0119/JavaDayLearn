package Day8;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * <pre>
 * Day8
 * MultiArray_Quiz_4.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 6.	
 *
 */
public class MultiArray_Quiz_4 {

	public static void main(String[] args) {
	
		//========================================
		
		System.out.println("===== 16번 문제 =====");	
		
//		* 낚시 게임 
//		호수가 5x5 호수가 있습니다.
//		호수에는 물고기가 3마리가 있습니다.
//		물고기 3마리는 랜덤으로 좌표에 위치해 있습니다.
//		물고기 위치가 지정이 되면 낚시게임이 시작됩니다.
//		(단, 물고기는 같은 위치에 있으면 안됩니다.)
//		그리고 낚시꾼은 미끼가 달린 바늘을 던집니다.(캐스팅)
//		(단, 좌표의 범위를 넘어가지 않게 던져야합니다.
//		  좌표의 범위를 넘으면 다시 캐스팅 해주세요. 출력)
//		그리고 1.위 2.아래 3.왼쪽 4.오른쪽 의 명령을 받아서 낚시바늘 위치를 이동
//		(위 이동시 0보다 작아지면 이동 x -- / 아래 이동 시 4보다 크면 이동 x ++
//		/ 왼쪽 이동 시 0보다 작아지면 이동 x --/ 오른쪽 이동 시 4보다 크면 이동 x ++)
//		낚시바늘이 이동을 하다가 물고기가 있는 좌표와 같아지면 물고기를 잡게 됩니다.
//		그리고 물고기 3마리를 잡을 때까지 낚시게임은 계속 진행 됩니다.
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int lakeArray[][] = new int[5][5];
		int fishNumber = 3;
		int lineRandom = 0;
		int rowRandom = 0;
		
		System.out.print(fishNumber+"마리 물고기 위치는 : ");
		for(int i=0; i<fishNumber; i++) {
			
			lineRandom = random.nextInt(5);
			rowRandom = random.nextInt(5);
			
			while(lakeArray[lineRandom][rowRandom] == 1) {
				lineRandom = random.nextInt(5);
				rowRandom = random.nextInt(5);
			}
			System.out.print("[" + lineRandom + "]" + "[" + rowRandom + "] / ");
			lakeArray[lineRandom][rowRandom] = 1;
		}
		System.out.println();
		System.out.println();
		System.out.println("=== 낚시 게임을 시작합니다. ===");
		System.out.println();

		System.out.println("미끼가 끼워진 낚시대를 캐스팅 입력해주세요.");
		int lineCasting = scanner.nextInt();
		int rowCasting = scanner.nextInt();
		
		if ((lakeArray[lineCasting][rowCasting] == lakeArray[lineRandom][rowRandom])) {
			lakeArray[lineCasting][rowCasting] = 0;
			fishNumber--;
			System.out.println("물고기를 잡았습니다." + fishNumber+ "마리 남았습니다.");
			System.out.println();
			System.out.println("미끼가 끼워진 낚시대를 캐스팅 입력해주세요.");
			lineCasting = scanner.nextInt();
			rowCasting = scanner.nextInt();
		}

		while(true) {

			if(lineCasting > 4 || rowCasting > 4) {
				System.out.println("좌표 범위를 넘어갔습니다. 다시 던져주세요.");
				continue;
			} else {
				
				System.out.println("낚시바늘 위치 입력해주세요.");
				System.out.print("1.위 / 2.아래 / 3.왼쪽 / 4.오른쪽");
				System.out.println();
				
				int moveNumber = scanner.nextInt(); 
				
				//위 입력
				if(moveNumber == 1) {
					lineCasting--;
					if(lineCasting < 0) {
						System.out.println("낚시바늘 범위가 벗어났습니다. 다시 지정해주세요.");
						lineCasting = 0;
						continue;
					}else {
						System.out.println("현재 낚시바늘 위치는 " + "[" + lineCasting + "]" + "[" + rowCasting + "] 입니다.");
						
					}
				} else if (moveNumber == 2) {
					//아래 입력
					lineCasting++;
					if(lineCasting > 4) {
						System.out.println("낚시바늘 범위가 벗어났습니다. 다시 지정해주세요.");
						lineCasting = 4;
						continue;
					}else {
						System.out.println("현재 낚시바늘 위치는 " + "[" + lineCasting + "]" + "[" + rowCasting + "] 입니다.");
					}
				} else if (moveNumber == 3) {
					//왼쪽 입력
					rowCasting--;
					if(rowCasting < 0) {
						System.out.println("낚시바늘 범위가 벗어났습니다. 다시 지정해주세요.");
						rowCasting = 0;
						continue;
					}else {
						System.out.println("현재 낚시바늘 위치는 " + "[" + lineCasting + "]" + "[" + rowCasting + "] 입니다.");
					}
				} else if (moveNumber == 4) {
					//오른쪽 입력
					rowCasting++;
					if(rowCasting > 4) {
						System.out.println("낚시바늘 범위가 벗어났습니다. 다시 지정해주세요.");
						rowCasting = 4;
						continue;
					}else {
						System.out.println("현재 낚시바늘 위치는 " + "[" + lineCasting + "]" + "[" + rowCasting + "] 입니다.");
					}
				} else {
					System.out.println("번호를 잘못입력하였습니다.");
					continue;
				}
				
				//물고기 잡았을 경우
				if(lakeArray[lineCasting][rowCasting] == 1) {
					lakeArray[lineCasting][rowCasting] = 0;
					fishNumber--;
					System.out.println("물고기를 잡았습니다." + fishNumber + "마리 남았습니다.");
					System.out.println();
					//물고기 3마리 모두 잡은 경우
					if(fishNumber == 0) {
						System.out.println("물고기 3마리를 모두 잡았습니다.");
						System.out.println("프로그램을 종료합니다.");
						System.out.println();
						break;
					}
					continue;
				}
			}
		}
	
	}
}
