package Day27;


//서버
public class RCom
{
   int com[]; //정수형 com이라는 배열 선언
   public RCom() { // RCom 인자를 받지 않는 생성자
      // TODO Auto-generated constructor stub
      com = new int[3]; // com 변수에 정수형 배열 객체를 생성 후에 대입


      com[0] =(int)(Math.random()*9+1); // com에 0번 인덱스에 1~9까지 중에 랜덤 값을 대입
      com[1] =(int)(Math.random()*9+1); // com에 1번 인덱스에 1~9까지 중에 랜덤 값을 대입

      while(com[0] == com[1]) // com에 0번 인덱스와 1번 인덱스가 같으면 반복
      {
         com[1] =(int)(Math.random()*9+1); // com에 1번 인덱스에 1~9까지 중에 랜덤 값을 대입
      }
      com[2] =(int)(Math.random()*9+1); // com에 2번 인덱스에 1~9까지 중에 랜덤 값을 대입
      while(com[0] == com[2] || com[1] == com[2])
      // com에 0번 인덱스와 2번 인덱스가 같으면 반복 또는 com에 1번 인덱스와 2번 인덱스가 같으면 반복
      {
         com[2] =(int)(Math.random()*9+1); //com에 2번 인덱스에 1~9까지 중에 랜덤 값을 대입
      }
   }

   public int[] getCom()
   //정수형 배열을 리턴하고 인자를 아무것도 받지않은 getCom 함수
   {
      return com; // com 변수를 리턴
   }
}


