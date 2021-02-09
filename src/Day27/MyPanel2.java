package Day27;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;


//클라인언트

public class MyPanel2 extends JPanel{


   JTextField jt; //JTextField형 변수 jt 선언  
   int strike = 0; //정수형 strike 변수를 0으로 초기화
   int ball = 0; //정수형 ball 변수를 0으로 초기화
   int out = 0; //bool형 out 변수를 false로 초기화

   void setData(int strike, int ball, int out)
   //리턴이 없고 인자를 정수형 2개와 bool형 1개를 받는 setData 함수
   {
      this.strike = strike; // 내 strike 변수에 인자 strike를 대입
      this.ball = ball; // 내 ball 변수에 인자 ball을 대입
      this.out = out; // 내 out 변수에 인자 out를 대입
   }
  
  
   @Override
   public void paintComponent(Graphics g){
   //JPanel클래스에 있는 paintComponent 함수를 오버라이딩
   //리턴이 없고 Graphics를 인자로 받는 paintComponet함수

      super.paintComponent(g); //부모 paintComponet에 인자 g를 대입해서 호출

      g.setFont(new Font("맑음고딕",Font.BOLD,20)); 
      //Graphics에 setFont 함수 호출
      //호출신 Font 객체를 생성해서 호출
      //Font를 생성할때 "맑은 고딕"과 BOLD 사이즈는 20
     
      if(strike == 3)
      //strike의 값이 3이면 아래 명령어 실행
      {
         g.setFont(new Font("맑음고딕",Font.BOLD,60));
         //Font를 생성할때 "맑은 고딕"과 BOLD 사이즈는 60
         g.drawString("Home Run!!!!", 30, 180);
         //"Home Run!!!!"문장을 x : 30 y : 100에 문자열을 그린다.
      }
     
      else
      {
      //위 조건이 아니면 아래 명령어 실행
         if(strike == 0)
         //변수 strike가 0이면 아래 명령어 실행
         {
            g.setColor(Color.RED);
            //컬러 레드
            g.drawString("S", 30, 222);
            //"S"를 x : 30 y : 222에 문자열을 그린다.
            g.drawOval(50,200,30,30);
            //비워 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다.
            g.drawOval(90,200,30,30);
            //비워 있는 원을 x : 90 y: 200에 30사이즈에 빈원을 그린다.
         }
         else if(strike == 1)
         //변수 strike가 1이면 아래 명령어 실행
         {
            g.setColor(Color.RED);
            //컬러 레드
            g.drawString("S", 30, 222);
            //"S"를 x : 30 y : 222에 문자열을 그린다.
            g.fillOval(50,200,30,30);
            //꽉차 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다.
            g.drawOval(90,200,30,30);
            //비워 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다.
         }
         else
         //위의 두조건이 모두 아니면 아래 명령어 실행
         {
            g.setColor(Color.RED);
            //컬러 레드
            g.drawString("S", 30, 222);
            //"S"를 x : 30 y : 222에 문자열을 그린다.
            g.fillOval(50,200,30,30);
            //꽉차 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다.
            g.fillOval(90,200,30,30);
            //꽉차 있는 원을 x : 50 y: 200에 30사이즈에 빈원을 그린다.
         }

         if(ball == 0)
         //변수 ball이 0이면 아래 명령어 실행
         {
            g.setColor(Color.BLUE);
            //컬러 블루
            g.drawString("B", 30, 262);
            //"B"를 x : 30 y : 262에 문자열을 그린다.
            g.drawOval(50,240,30,30);
             //비워 있는 원을 x : 50 y: 240에 30사이즈에 빈원을 그린다.
            g.drawOval(90,240,30,30);
            //비워 있는 원을 x : 90 y: 240에 30사이즈에 빈원을 그린다.
            g.drawOval(130,240,30,30);
            //비워 있는 원을 x : 130 y: 240에 30사이즈에 빈원을 그린다.
         }
         else if(ball == 1)
         {
            g.setColor(Color.BLUE);
            //컬러 블루
            g.drawString("B", 30, 262);
            //"B"를 x : 30 y : 262에 문자열을 그린다.
            g.fillOval(50,240,30,30);
             //꽉차 있는 원을 x : 50 y: 240에 30사이즈에 빈원을 그린다.
             g.drawOval(90,240,30,30);
            //비워 있는 원을 x : 90 y: 240에 30사이즈에 빈원을 그린다.
            g.drawOval(130,240,30,30);
            //비워 있는 원을 x : 130 y: 240에 30사이즈에 빈원을 그린다.
         }
         else if(ball == 2)
         {
            g.setColor(Color.BLUE);
            //컬러 블루
            g.drawString("B", 30, 262);
            //"B"를 x : 30 y : 262에 문자열을 그린다.
            g.fillOval(50,240,30,30);
            //꽉차 있는 원을 x : 50 y: 240에 30사이즈에 빈원을 그린다.
            g.fillOval(90,240,30,30);
            //꽉차 있는 원을 x : 90 y: 240에 30사이즈에 빈원을 그린다.
            g.drawOval(130,240,30,30);
            //비워 있는 원을 x : 130 y: 240에 30사이즈에 빈원을 그린다.
         }
         else
         {
            g.setColor(Color.BLUE);
            //컬러 블루
            g.drawString("B", 30, 262);
            //"B"를 x : 30 y : 262에 문자열을 그린다.
            g.fillOval(50,240,30,30);
            //꽉차 있는 원을 x : 50 y: 240에 30사이즈에 빈원을 그린다.
            g.fillOval(90,240,30,30);
            //꽉차 있는 원을 x : 90 y: 240에 30사이즈에 빈원을 그린다.
            g.fillOval(130,240,30,30);
            //꽉차 있는 원을 x : 130 y: 240에 30사이즈에 빈원을 그린다.
         }

         if(out == 0)
         //bool변수 아웃이 false이면 아래 명령어 실행
         {
            g.setColor(Color.ORANGE);
            //컬러 오렌지
            g.drawString("O", 30, 302);
            //"O"를 x : 30 y : 302에 문자열을 그린다.
            g.drawOval(50,280,30,30);
            //비워 있는 원을 x : 50 y: 280에 30사이즈에 빈원을 그린다.
         }
         else
         //위에 조건이 아니면 아래 명령어 실행
         {
            g.setColor(Color.ORANGE);
            //컬러 오렌지
            g.drawString("O", 30, 302);
            //"O"를 x : 30 y : 302에 문자열을 그린다.
            g.fillOval(50,280,30,30);
            //꽉차 있는 원을 x : 50 y: 280에 30사이즈에 빈원을 그린다.
         }
      }
     

   }
}


