package Day04;

/**
 * 
 * <pre>
 * Day4
 * Loop_Quiz_3.java
 * </pre>
 *
 * @Author : '유형민'
 * @Date   : 2020. 12. 29.	
 *
 */
public class Loop_Quiz_3 {
	
	public static void main(String[] args) {
		
//		* 별 찍기 
//		*****		*			  *			*			*
//		*****		**			 **		   ***		   ***
//		*****		***			***		  *****		  *****
//		*****		****	   ****		 *******	   ***
//		*****		*****	  *****		*********	    *
	
		//1번째
		for(int i=0; i<5; i++)  {
		  for(int j=0; j<5; j++)  {
		    System.out.print('*');
		  }
		  System.out.println();
		}
	
		System.out.println();
		
		//2번째
		for(int i=0; i<=5; i++){
			for(int j=0; j<i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//3번째
		for(int i=0; i<=5; i++){
			for(int j=5; j>0; j--){
				if(i < j){
					System.out.print(" ");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		//4번째
		for(int i=0; i<5; i++){
			for(int j=0; j<4-i; j++){
				System.out.print(" "); 
			}
			for(int j=0; j<(2*i)+1; j++){
				System.out.print("*"); 
			}
			System.out.println();
		}
				
		System.out.println();
		
		//5번째		
		//기준점의 위쪽
		for(int i=0; i<3; i++) {   
            for (int j=0; j<=1-i; j++) {
                System.out.print(" "); 
            }
            for (int j=0; j<=i*2; j++) { 
                System.out.print("*");
            }
            System.out.println();
        }
        //기준점의 아래쪽
        for(int i=2; i>0; i--) {    
            for (int j=2; j>=i; j--) {
                System.out.print(" "); 
            }
            for (int j=0; j<=(i*2)-2; j++) {
                System.out.print("*");
                
            }
            System.out.println();
        }
		
	}
}

