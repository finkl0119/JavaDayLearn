package Day08;

/**
 * 
 * <pre>
 * Day8
 * MultiArray_Quiz_3.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2021. 1. 6.	
 *
 */
public class MultiArray_Quiz_3 {

	public static void main(String[] args) {
	
		//========================================
		
		System.out.println("===== 15-4 문제 =====");	

//		달팽이
		
//		1  2  3  4  5
//		16 17 18 19 6
//		15 24 25 20 7
//		14 23 22 21	8
//		13 12 11 10 9
		
		int intArray_3[][] = new int[5][5];
		int initNumber_3 = 0;
		int plusNumber_3 = 1;
		int endNumber_3 = intArray_3.length-1;
		
		//내부로직
		for(int i=0; i<intArray_3.length; i++){
			
			if((i%2) == 0) {
				//위쪽
				for(int j=initNumber_3; j<=endNumber_3; j++) {
					intArray_3[initNumber_3][j] = plusNumber_3;
					plusNumber_3 = plusNumber_3 + 1;
				}
				initNumber_3++;
			} else {
				//아래쪽
				for(int j=endNumber_3; j>=initNumber_3-1; j--) {
					intArray_3[endNumber_3+1][j] = plusNumber_3;
					plusNumber_3 = plusNumber_3 + 1;
				}
			}
			
			if((i%2) == 0) {
				//오른쪽
				for(int j=initNumber_3; j<=endNumber_3; j++) {
					intArray_3[j][endNumber_3] = plusNumber_3;
					plusNumber_3 = plusNumber_3 + 1;
				}
				endNumber_3--;
			} else {
				//왼쪽
				for(int j=endNumber_3; j>=initNumber_3; j--) {
					intArray_3[j][initNumber_3-1] = plusNumber_3;
					plusNumber_3 = plusNumber_3 + 1;
				}
			}
			
		}
		
		for(int i=0; i<intArray_3.length; i++){
			for(int j=0; j<intArray_3[i].length; j++){
				System.out.printf("%2d ", intArray_3[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		
		//========================================
		
		System.out.println("===== 15-5 문제 =====");	
		
//		마방진
		
//		17 24  1  8 15
//		23  5  7 14 16
//		 4  6 13 20 22
//		10 12 19 21	 3
//		11 18 25  2  9
		
		int intArray_4[][] = new int[5][5];
		
		int centerDivision = 5/2;
		int plusNumber_4 = 0;
		int intLength = intArray_4.length * intArray_4[0].length;
		
		//내부로직
		for (int i=1; i<=intLength; i++){
			intArray_4[plusNumber_4][centerDivision] = i;
	        if (i%5 == 0) {
	        	plusNumber_4++;
	        } else {
	        	plusNumber_4--; 
	        	centerDivision++;
	            if (plusNumber_4 < 0) {
	            	plusNumber_4 = 4;
	            }
	            if (centerDivision > 4) {
	            	centerDivision = 0;
	            }
	        }
	    }
		
		for(int i=0; i<intArray_4.length; i++){
			for(int j=0; j<intArray_4[i].length; j++){
				System.out.printf("%2d ", intArray_4[i][j]);
			}
			System.out.println();
		}
		System.out.println();	
		
		//==============================================
		
		int arr[][] = new int [5][5];
		int x = 0;
		int y = 2;
		int count = 1;
		
		while(count < 26){
			arr[x][y] = count;
			
			int nx = x  - 1;
			int ny = y  + 1;
			
			if(nx == -1){
				nx = 4;
			}
			if(ny == 5){
				ny = 0;
			}
			
			if(arr[nx][ny] == 0){
				x = nx;
				y = ny;
			}
			else{
				x = x +1;
			}
			count++;
		}
		
		for(int i = 0;i<5;i++) {
			for(int j =0;j<5;j++) {
				System.out.printf("%d\t",arr[i][j]);
			}
			System.out.println();
		}

	}	
}
