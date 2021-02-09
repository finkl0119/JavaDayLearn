package Day27;

//서버

public class UserCheck
{
	int strike; // 정수 변수 strike 선언
	int ball; // 정수 변수 ball 선언
	int out; // 불 변수 out 선언
	public void check(int[] com, int[] user) {
		//UserCheck 생성자로 인자로 정수형 배열 두개를 받는다.
		// TODO Auto-generated constructor stub
		
		strike = 0;
		ball = 0;
		out = 0;
		
		for(int i = 0; i<3 ; i++) 
			// 정수형 i는 초기화가 0이고 i가 3보다 작으면 반복하고 반복시 i는 1씩 증가한다.
		{
			for(int j = 0; j<3 ; j++)
				// 정수형 j는 초기화가 0이고 j가 3보다 작으면 반복하고 반복시 j는 1씩 증가한다.
			{
				if(com[i] == user[j])
					// com의 i인덱스 값과 user의 j인덱스 값이 같으면 아래 명령어 실행
				{
					if(i==j)
						//정수 값 i와 j가 같으면 아래 명령어 실행
						strike++; // 정수 strike를 1증가
					else
						// 위에 조건이 아니면 실행
						ball++; // 정수 ball을 1증가
				}
			}
		}

		if(strike == 0 && ball== 0)
			out = 1;
	}

	public String getValue()
	{
		
		return strike+""+ball+""+out;
	}


//	public int getStrike()//정수를 반환하고 인자가 없는 getStrike 함수
//	{
//		return strike; // strike 변수 값을 리턴
//	}
//	public int getBall()//정수를 반환하고 인자가 없는 getBall 함수
//	{
//		return ball; // ball 변수 값을 리턴
//	}
//	public boolean getOut() //bool를 반환하고 인자가 없는 getOut 함수
//	{
//		if(strike == 0 && ball== 0)
//			//변수 strike가 0이고 변수 ball이 0이면 아래 명령어 실행
//			return true; //true을 리턴
//		else
//			//위에 조건이 아니면 아래 명령어 실행
//			return false; //false를 리턴
//	}

}


