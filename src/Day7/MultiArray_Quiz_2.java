package Day7;

/**
 * 
 * <pre>
 * Day7
 * MultiArray_Quiz_2.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 5.	
 *
 */
public class MultiArray_Quiz_2 {

	public static void main(String[] args) {
		
//		15번 문제 배열 값 채우기 (5행 5열 배열)
//		
//		15-1 문제 
//			   0  1  2  3  4 
//			0  1  2  3  4  5 	
//			1  6  7  8  9  10
//			2  11 12 13 14 15
//			3  16 17 18 19 20
//			4  21 22 23 24 25
//	
//		15-2 문제
//			   0  1  2  3  4 
//			0  1  2  3  4  5 	
//			1  10 9  8  7  6
//			2  11 12 13 14 15
//			3  20 19 18 17 16
//			4  21 22 23 24 25
//		
//		15-3 문제
//			   0  1  2  3  4 
//			0  21 16 11 6  1 	
//			1  22 17 12 7  2
//			2  23 18 13 8  3
//			3  24 19 14 9  4
//			4  25 20 15 10 5	
//			
//		2차원 배열 5x5에 
//		조건문과 반복문을 통해	배열 채우기
	
		//========================================
		System.out.println("===== 15-1 문제 =====");
		
		int[][] lineArray_0 = new int[1][5];
		int[][] rowArray_0 = new int[5][1];
		int[][] intArray_0 = new int[5][5];
		
		int plusNumber_0 = 1;
		int lineNumber_0 = 0;
		int rowNumber_0 = 0;
		
		//가로
		for(int i=0; i<lineArray_0.length; i++) {
			for(int j=0; j<lineArray_0[0].length; j++) {
				lineArray_0[i][j] = lineNumber_0;
				lineNumber_0 = lineNumber_0 + 1;
			}
		}
		
		//세로
		for(int i=0; i<rowArray_0.length; i++) {
			for(int j=0; j<rowArray_0[0].length; j++) {
				rowArray_0[i][j] = rowNumber_0;
				rowNumber_0 = rowNumber_0 + 1;
			}
		}
		
		//내부로직
		for(int i=0; i<intArray_0.length; i++){
			for(int j=0; j<intArray_0[0].length; j++){
				intArray_0[i][j] = plusNumber_0;
				plusNumber_0 = plusNumber_0 + 1;
			}
		}
		
		System.out.print("   ");
		
		for(int i=0; i<lineArray_0.length; i++) {
			for(int j=0; j<lineArray_0[0].length; j++) {
				System.out.printf("%2d ", lineArray_0[i][j]);
			}
		}
		System.out.println();
		
		for(int i=0; i<intArray_0.length; i++){
			for(int j=0; j<rowArray_0[0].length; j++) {
				System.out.printf("%2d ",rowArray_0[i][j]);
			}
			for(int j=0; j<intArray_0[0].length; j++){
				System.out.printf("%2d ", intArray_0[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//========================================
		
		System.out.println("===== 15-2 문제 =====");
		
		int[][] lineArray_1 = new int[1][5];
		int[][] rowArray_1 = new int[5][1];
		int[][] intArray_1 = new int[5][5];
		
		int backNumber_1 = 1;
		int plusNumber_1 = 1;
		int lineNumber_1 = 0;
		int rowNumber_1 = 0;
		
		//가로
		for(int i=0; i<lineArray_1.length; i++) {
			for(int j=0; j<lineArray_1[0].length; j++) {
				lineArray_1[i][j] = lineNumber_1;
				lineNumber_1 = lineNumber_1 + 1;
			}
		}
		
		//세로
		for(int i=0; i<rowArray_1.length; i++) {
			for(int j=0; j<rowArray_1[0].length; j++) {
				rowArray_1[i][j] = rowNumber_1;
				rowNumber_1 = rowNumber_1 + 1;
			}
		}
		
		//내부로직
		for(int i=0; i<intArray_1.length; i++){
			if(backNumber_1 == 1){
				for(int j=0; j<intArray_1[0].length; j++){
					intArray_1[i][j] = plusNumber_1;
					plusNumber_1 = plusNumber_1 + 1;
				}
			}else{
				for(int j=intArray_1.length-1; j>=0; j--){
					intArray_1[i][j] = plusNumber_1;
					plusNumber_1 = plusNumber_1 + 1;
				}
			}
			backNumber_1 = backNumber_1 * (-1);
		}
		
		System.out.print("   ");
		
		for(int i=0; i<lineArray_1.length; i++) {
			for(int j=0; j<lineArray_1[0].length; j++) {
				System.out.printf("%2d ", lineArray_1[i][j]);
			}
		}
		System.out.println();
		
		for(int i=0; i<rowArray_1.length; i++){
			for(int j=0; j<rowArray_1[0].length; j++) {
				System.out.printf("%2d ",rowArray_1[i][j]);
			}
			for(int j=0; j<intArray_1[0].length; j++){
				System.out.printf("%2d ", intArray_1[i][j]);
			}
			System.out.println();
		}
			
		System.out.println();
		
		//========================================
		
		System.out.println("===== 15-3 문제 =====");
		
		int[][] lineArray_2 = new int[1][5];
		int[][] rowArray_2 = new int[5][1];
		int[][] intArray_2 = new int[5][5];
		
		int plusNumber_2 = 1;
		int lineNumber_2 = 0;
		int rowNumber_2 = 0;
		
		//가로
		for(int i=0; i<lineArray_2.length; i++) {
			for(int j=0; j<lineArray_2[0].length; j++) {
				lineArray_2[i][j] = lineNumber_2;
				lineNumber_2 = lineNumber_2 + 1;
			}
		}
		
		//세로
		for(int i=0; i<rowArray_2.length; i++) {
			for(int j=0; j<rowArray_2[0].length; j++) {
				rowArray_2[i][j] = rowNumber_2;
				rowNumber_2 = rowNumber_2 + 1;
			}
		}
		
		//내부로직
		for(int i=intArray_2.length-1; i>=0; i--){
			for(int j=0; j<intArray_2[0].length; j++){
				intArray_2[j][i] = plusNumber_2;
				plusNumber_2 = plusNumber_2 + 1;
			}
		}
		
		System.out.print("   ");
		
		for(int i=0; i<lineArray_2.length; i++) {
			for(int j=0; j<lineArray_2[0].length; j++) {
				System.out.printf("%2d ", lineArray_2[i][j]);
			}
		}
		System.out.println();
		
		for(int i=0; i<intArray_2.length; i++){
			for(int j=0; j<rowArray_2[0].length; j++) {
				System.out.printf("%2d ",rowArray_2[i][j]);
			}
			for(int j=0; j<intArray_2[0].length; j++){
				System.out.printf("%2d ", intArray_2[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//========================================
		
		System.out.println("15-2 문제 정보처리기사 실기");
		
		int[][] array = new int[5][5]; // 5x5행
		int R, C, TR, START, END, SW, K; //변수 선언
		TR = 0; // 시작에 대한 변수 
		START = 0; // 초기값
		END=4; // 마지막 값 
		SW=1; // 
		K=0; // 
		for(R=0;R!=5;R++) //시작
		{
			for(C=START;C!=(END+SW);C+=SW) 
				// 0부터 5와 일치하지 않은 경우까지 C = C+SW 그러나 SW : -1 씩 감소
			{
				K++; //값을 더한다.
				array[R][C] = K; // 그값을 배열에 대입한다.
			}
			TR = START; //
			START = END; //
			END = TR; //
			SW = SW*(-1); //지그재그 
		}
		
		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",array[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		
		//========================================
		
		System.out.println("15-1 문제 정보처리기사 실기");
		
		int[][] one = new int [5][5];
		int value = 1;
		for(int i=0; i<one.length; i++)
		{
			for(int j=0; j<one[i].length; j++)
			{
				one[i][j] = value;
				value++;
			}
			System.out.println();
		}

		
		System.out.println("15-3 문제 정보처리기사 실기");		
		
		int[][] arr2 = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= 0; j--) {
				arr2[i][4 - j] = one[j][i]; //00 -> 40 / 01 -> 30  
			}
		}
		
		for(int i = 0;i<5;i++)
		{
			for(int j =0;j<5;j++)
			{
				System.out.printf("%d\t",arr2[i][j]);
			}
			System.out.println();
		}

	}
	
	
	
}
