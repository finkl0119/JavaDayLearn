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
		
		int randomNumber = 0;
		String randomNumberValue = "";
		for(int j=1; j<=3; j++) {
			randomNumber = random.nextInt(10);
			randomNumberValue += randomNumber + ""; 
		}
		
		System.out.println("3개 숫자 : " + randomNumberValue);
		
		String number_0 = randomNumberValue.substring(0,1);
		String number_1 = randomNumberValue.substring(1,2);
		String number_2 = randomNumberValue.substring(2,3);
		
		int numberInt = Integer.parseInt(randomNumberValue);
		int numberInt_0 = Integer.parseInt(number_0);
		int numberInt_1 = Integer.parseInt(number_1);
		int numberInt_2 = Integer.parseInt(number_2);
		
		System.out.println("3개 숫자에 따른 알파벳 추출 : " + alphabetValue.substring(numberInt_0, numberInt_0+1) +
				", " + alphabetValue.substring(numberInt_1, numberInt_1+1) +
				", " + alphabetValue.substring(numberInt_2, numberInt_2+1));

	}
}
