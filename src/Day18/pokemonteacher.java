package Day18;

import java.util.Random;
import java.util.Scanner;

class Unit4
{
   int size;
   String type;
}

class Pikachu extends Unit4
{
   Pikachu() 
   {
      super.size = 30;
      super.type = "����";
   }

   void tell()
   {
      System.out.println("��ī��ī~");
   }
}

class Squirtle extends Unit4
{
   public Squirtle() 
   {
      // TODO Auto-generated constructor stub
      super.size = 50;
      super.type ="��";
   }
   void tell()
   {
      System.out.println("���� ����~");
   }
}

class Bulbasaur extends Unit4
{
   public Bulbasaur() 
   {
      // TODO Auto-generated constructor stub
      super.size = 40;
      super.type ="�Ĺ�";
   }
   void tell()
   {
      System.out.println("�̻� �̻��ؾ�~");
   }
}

class Charmander extends Unit4
{
   public Charmander() {
      // TODO Auto-generated constructor stub
      super.size = 45;
      super.type = "��";
   }
   void tell()
   {
      System.out.println("���� ���̸�~");
   }
}

class Jiwoo
{
   PocketBall[] pb = new PocketBall[3]; // ���Ϻ��� ���� ����
   int count = 0;

   public Jiwoo() 
   {
      // TODO Auto-generated constructor stub
      for(int i = 0;i<3;i++)
      {
         pb[i] = new PocketBall();
      }
   }

   String MonsterCheck()
   {
      Scanner s = new Scanner(System.in);
      String str;
      
      while(true)
      {
         System.out.print("���ϴ� ���͸� �Է��ϼ���(��ī��, ���α�, �̻��ؾ�, ���̸�) : ");
         str=s.next();
         if(str.equals("��ī��")||str.equals("���α�")||str.equals("�̻��ؾ�")||str.equals("���̸�")) 
         {
            System.out.println("ok �Ϸ�");
            break;
         }
         else
         {
            System.out.println("�߸��� �Է��Դϴ�.");
         }
      }

      return str;
   }

   PocketBall throwPocketBall()
   {
      if(count <3)
         return pb[count++];
      else
         return null;
   }
}

class PocketBall
{
   Pikachu p = null;
   Squirtle sq = null;
   Bulbasaur bu = null;
   Charmander ch = null;

   int get;

   void randomeCheck()
   {
      Random r = new Random();

      get = r.nextInt(2);
   }
   
   void pocketMoncheck()
   {
      if(p != null)
      {
         System.out.println("��ī���"+p.type+"���ϸ��̰� ũ��� "+p.size+"�Դϴ�.");
         p.tell();
      }
      if(sq != null)
      {
         System.out.println("���α��"+sq.type+"���ϸ��̰� ũ��� "+sq.size+"�Դϴ�.");
         sq.tell();
      }
      if(bu != null)
      {
         System.out.println("�̻��ؾ���"+bu.type+"���ϸ��̰� ũ��� "+bu.size+"�Դϴ�.");
         bu.tell();
      }
      if(ch != null)
      {
         System.out.println("���̸���"+ch.type+"���ϸ��̰� ũ��� "+ch.size+"�Դϴ�.");
         ch.tell();
      }
   }

}

public class pokemonteacher {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Pikachu p = new Pikachu();
      Squirtle sq = new Squirtle();
      Bulbasaur bu = new Bulbasaur();
      Charmander ch = new Charmander();

      Jiwoo j = new Jiwoo();

      PocketBall pb;

      System.out.println("���ӽ���");

      for(int i = 0;i<3;i++)
      {
         String mon = j.MonsterCheck();

         if(mon.equals("��ī��"))
         {
            pb = j.throwPocketBall();

            if(pb !=null)
            {
               pb.randomeCheck();
               if(pb.get == 1)
               {
                  pb.p = p;
                  p = null;
               }
            }
            else
            {
               System.out.println("���Ϻ��� �����ϴ�.");
            }

         }

         if(mon.equals("���α�"))
         {
            pb = j.throwPocketBall();

            if(pb !=null)
            {
               pb.randomeCheck();
               if(pb.get == 1)
               {
                  pb.sq = sq;
                  sq = null;
               }
            }
            else
            {
               System.out.println("���Ϻ��� �����ϴ�.");
            }
         }

         if(mon.equals("�̻��ؾ�"))
         {
            pb = j.throwPocketBall();

            if(pb !=null)
            {
               pb.randomeCheck();
               if(pb.get == 1)
               {
                  pb.bu = bu;
                  bu = null;
               }
            }
            else
            {
               System.out.println("���Ϻ��� �����ϴ�.");
            }
         }

         if(mon.equals("���̸�"))
         {
            pb = j.throwPocketBall();

            if(pb !=null)
            {
               pb.randomeCheck();
               if(pb.get == 1)
               {
                  pb.ch = ch;
                  ch = null;
               }
            }
            else
            {
               System.out.println("���Ϻ��� �����ϴ�.");
            }
         }
      }

      for(int i =0;i<3;i++)
      {
         if(j.pb[i].p == null && j.pb[i].sq == null && j.pb[i].bu == null && j.pb[i].ch == null)
         {
            System.out.println("���ϸ��� ��� �ֽ��ϴ�.");
         }
         else
         {
            j.pb[i].pocketMoncheck();
         }
      }
   }

}