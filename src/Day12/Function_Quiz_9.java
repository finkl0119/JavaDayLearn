package Day12;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * <pre>
 * Day10
 * Function_Quiz_9.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 14.	
 *
 */
public class Function_Quiz_9 {

	public static void main(String[] args) {
	
		//========================================
		
		System.out.println("===== 25번 문제 =====");	

//		16번 문제 낚시게임을 함수화로 구현을 하세요.
//		함수화 진행시 함수 하나의 하나의 기능만 존재하도록 구현을 해주세요.
//		메인함수는 명령어가 무조건 하나여야 합니다.
		
		fishingStart();
		
	}	
	
	public static void fishLocation(int lakeArray[][]) {
		
		int fishNumber = 3;
	
		System.out.print(fishNumber+"마리 물고기 위치는 : ");
		for(int i=0; i<fishNumber; i++) {
			
			int lineRandom = lineRandomNumber();
			int rowRandom = rowRandomNumber();
			
			while(lakeArray[lineRandom][rowRandom] == 1) {
				lineRandom = lineRandomNumber();
				rowRandom = rowRandomNumber();
			}
			System.out.print("[" + lineRandom + "]" + "[" + rowRandom + "] / ");
			lakeArray[lineRandom][rowRandom] = 1;
		}
	}

	public static int lineRandomNumber() {
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int lineRandom = 0;
		lineRandom = random.nextInt(5);
		
		return lineRandom;
	}
	
	public static int rowRandomNumber() {
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int rowRandom = 0;
		rowRandom = random.nextInt(5);
		
		return rowRandom;
	}
	
	public static void fishingStart() {
		
		int lakeArray[][] = new int[5][5];
		int fishingNumber = fishingCount();
		
		fishLocation(lakeArray);
		
		System.out.println();
		System.out.println();
		System.out.println("=== 낚시 게임을 시작합니다. ===");
	
		System.out.println("미끼가 끼워진 낚시대를 캐스팅 입력해주세요.");
		
//		catchAtOnce(lakeArray, fishingNumber, lineRandomNumber(), rowRandomNumber());
		
		fishingLocationInput();
	}
	
	public static int lineCastingNumber() {
		
		Scanner scanner = new Scanner(System.in);
		int lineCasting = 0;
		lineCasting = scanner.nextInt();
		
		return lineCasting;
	}
	
	public static int rowCastingNumber() {
		
		Scanner scanner = new Scanner(System.in);
		int rowCasting = 0;
		rowCasting = scanner.nextInt();
		
		return rowCasting;
	}
	
	public static int fishingCount() {
		
		int fishNumber = 3;
		
		return fishNumber;
	}
	
	//한번에 잡은 경우
	public static int catchAtOnce(int lakeArray[][], int fishNumber, int lineRandom, int rowRandom) {
		
		int lineCasting = lineCastingNumber();
		int rowCasting = rowCastingNumber();
		
		if ((lakeArray[lineCasting][rowCasting] == lakeArray[lineRandom][rowRandom])) {
			lakeArray[lineCasting][rowCasting] = 0;
			fishNumber--;
			System.out.println("물고기를 잡았습니다." + fishNumber+ "마리 남았습니다.");
			System.out.println();
			System.out.println("미끼가 끼워진 낚시대를 캐스팅 입력해주세요.");
			
			Scanner scanner = new Scanner(System.in);
			lineCasting = lineCastingNumber();
			rowCasting = rowCastingNumber();
		}
		
		return fishNumber;
	}
	
	public static void fishingLocationInput() {
		
		int lineCasting = lineCastingNumber();
		int rowCasting = rowCastingNumber();
		
		overNumberError(lineCasting, rowCasting);
		
		System.out.println("낚시바늘 위치 입력해주세요.");
		System.out.print("1.위 / 2.아래 / 3.왼쪽 / 4.오른쪽");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		int moveNumber = scanner.nextInt(); 
		
		//위 입력
		if(moveNumber == 1) {
			lineCasting--;
			if(lineCasting < 0) {
				System.out.println("낚시바늘 범위가 벗어났습니다. 다시 지정해주세요.");
				lineCasting = 0;
			}else {
				System.out.println("현재 낚시바늘 위치는 " + "[" + lineCasting + "]" + "[" + rowCasting + "] 입니다.");
				fishingLocationInput();
			}
		} else if (moveNumber == 2) {
			//아래 입력
			lineCasting++;
			if(lineCasting > 4) {
				System.out.println("낚시바늘 범위가 벗어났습니다. 다시 지정해주세요.");
				lineCasting = 4;
			}else {
				System.out.println("현재 낚시바늘 위치는 " + "[" + lineCasting + "]" + "[" + rowCasting + "] 입니다.");
				fishingLocationInput();
			}
		} else if (moveNumber == 3) {
			//왼쪽 입력
			rowCasting--;
			if(rowCasting < 0) {
				System.out.println("낚시바늘 범위가 벗어났습니다. 다시 지정해주세요.");
				rowCasting = 0;
				
			}else {
				System.out.println("현재 낚시바늘 위치는 " + "[" + lineCasting + "]" + "[" + rowCasting + "] 입니다.");
				fishingLocationInput();
			}
		} else if (moveNumber == 4) {
			//오른쪽 입력
			rowCasting++;
			if(rowCasting > 4) {
				System.out.println("낚시바늘 범위가 벗어났습니다. 다시 지정해주세요.");
				rowCasting = 4;
				
			}else {
				System.out.println("현재 낚시바늘 위치는 " + "[" + lineCasting + "]" + "[" + rowCasting + "] 입니다.");
				fishingLocationInput();
			}
		} else {
			System.out.println("번호를 잘못입력하였습니다.");

		}
		
		
		//물고기 잡았을 경우
//		if(lakeArray[lineCasting][rowCasting] == 1) {
//			lakeArray[lineCasting][rowCasting] = 0;
//			fishNumber--;
//			System.out.println("물고기를 잡았습니다." + fishNumber + "마리 남았습니다.");
//			System.out.println();
//			//물고기 3마리 모두 잡은 경우
//			if(fishNumber == 0) {
//				System.out.println("물고기 3마리를 모두 잡았습니다.");
//				System.out.println("프로그램을 종료합니다.");
//				System.out.println();
//				break;
//			}
//			continue;
//		}
		
		
	}
	
	public static void fishCating(int lakeArray[][], int lineCasting, int rowCasting, int fishNumber) {
		
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
			}
			fishingLocationInput();
		}
		
	}
	
	public static void overNumberError(int lineCasting, int rowCasting) {
		
		if(lineCasting > 4 || rowCasting > 4) {
			System.out.println("좌표 범위를 넘어갔습니다. 다시 던져주세요.");
			fishingLocationInput();
		}
	}
	
	
	
	
}
