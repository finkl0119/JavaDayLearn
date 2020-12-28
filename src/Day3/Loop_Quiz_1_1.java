package Day3;

import java.util.Random;

public class Loop_Quiz_1_1 {

	public static void main(String[] args) {
		
//		문자 A(65) 에서 랜덤에서 0~25값을 추출 이후에 
//		더하기 연산을 해서 랜덤한 문자를 만든다.
//		이 랜덤한 문자를 만드는 작업을 10번 실행해서 
//		10개 문자를 더하기 연산을 하여 하나의 문자열로 만든다.
//		
//		그리고 0~9까지 랜덤 값을 추출하여 
//		위에서 만든 문자열에 있는 자리에 있는 값을 3번은 실행합니다.
//		그리고 위의 내용과 같이 3개의 문자를 문자열로 만들어서 출력을 한다.
		
//		단, 똑같은 랜던 값이 나오면 다시 랜덤값을 추출해서 없는 랜덤이 나올때 까지 반복
		
		Random random = new Random();
		
		int randomValue;
		char alphabet; 
		String alphabetValue = "";
		for(int i=0; i<10; i++) {
			randomValue = random.nextInt(26);
			alphabet = (char)(('A') + randomValue);
			alphabetValue += alphabet;
		}
		System.out.println("알파벳 : " + alphabetValue);
		
		System.out.println();
		
		int randomNumber = 0;
		int randomAllNumber;
		String randomNumberValue = ""; 
		for(int j=1; j<=3; j++) {
			randomNumber = random.nextInt(10);

			randomAllNumber = randomNumber; 
			System.out.println("랜덤 3개 값은 : " + randomAllNumber);
			randomNumberValue += alphabetValue.charAt(randomAllNumber);			
		}
		
		System.out.println("최종 출력 값은 : " + randomNumberValue);
		
		
		
		//System.out.println(alphabetValue.charAt(0));
		
		
//		if(randomNumberValue.equals(randomNumberValue.charAt(0))) {
//			System.out.println("aaa : " + randomNumberValue.charAt(0));
//			String randomAlphabet = alphabet + "";
//			System.out.println(randomAlphabet.charAt(randomNumber));
//		} 

		
		
		
	
		
		
		
	}
}
