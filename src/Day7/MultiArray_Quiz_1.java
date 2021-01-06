package Day7;

import java.util.Scanner;

/**
 * 
 * <pre>
 * Day7
 * MultiArray_Quiz_1.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 5.	
 *
 */
public class MultiArray_Quiz_1 {

	public static void main(String[] args) {
		
//		14번 문제
//		비행기 예약 시스템 만들기
//		좌석은 총 18자리 입니다.
//		예약 할 좌석 행의 위치, 예약 할 좌석 열의 위치 두개의 값을 입력 받는다.
//		좌석은 9행 2열로 이루어져 있습니다.
//		좌석의 행과 열을 입력 시 
//		예약 좌석이 0이 되면 프로그램 종료
//		예약이 끝났습니다. 출력
//		예) 예약하실 좌석을 입력해주세요. (총 18좌석) : 
//			5(엔터)
//			1(엔터)
//			5행과 1열에 아무도 예약을 하지 않을 시
//			 ==> 예약 완료 되었습니다.
//			5행과 1열에 아무도 예약을 있을 시
//			 ==> 다시 예약해주세요.
//			 하면서 비어있는 좌석을 알려준다.
//			 비어있는 좌석은 1 1 입니다. 전체 알려줌.
//		행과 열을 입력 시 
//			행은 9보다 크거나 0보다 작거나
//			열은 2보다 크거나 0보다 작으면, 
//			잘못된 입력입니다. 출력.
		
		int lineNumber; 
		int rowNumber;
		int reserveComplete = 18;
		int intArray[][] = new int[9][2]; 
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			if(reserveComplete > 0) {
				System.out.println("예약 좌석을 입력해주세요. (총 18좌석)");
				lineNumber = scanner.nextInt();
				rowNumber = scanner.nextInt();
				
				if ((lineNumber > 9 || lineNumber < 1) || (rowNumber > 2 || rowNumber < 1)){
					System.out.println("잘못된 입력 입니다.");
					System.out.println();
					continue;
				} else if (intArray[lineNumber-1][rowNumber-1] == 0) {
					//값은 10 9 8 이렇게 가기 때문에
					System.out.println("예약 완료 되었습니다.");
					intArray[lineNumber-1][rowNumber-1] = 1;
					reserveComplete --;
					System.out.println("예약이 "+ reserveComplete + "건 남았습니다.");
					System.out.println();
				} else {
					System.out.println("다시 예약해주세요.");
					for(int i=0; i<9; i++) {
						for(int j=0; j<2; j++) {
							if(intArray[i][j] == 0) {
								System.out.println("비어있는 좌석은 " + (i+1) + (j+1) +"입니다.");
							}
						}
					}
					System.out.println();
				}	
			}else {
				System.out.println("예약 끝났습니다.");
				break;
			}
			
		}
		
		
	}
	
}
