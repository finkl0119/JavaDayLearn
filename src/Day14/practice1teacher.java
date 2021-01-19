package Day14;

import java.util.Scanner;

class Buyer2{
   int money;

   int comindex = 0; // buyer â�� �ڸ� null
   int airindex = 0;
   int refindex = 0;
   int aircindex = 0;

   Computer2[] ownComs = new Computer2[10];
   Aircon2[] ownAircon = new Aircon2[10];
   Refrig2[] ownRefrig = new Refrig2[10];
   AirCleaner2[] ownAirCleaner = new AirCleaner2[10];
}


class Computer2{
   String manufacture;
   String cpu;
   int price;

   public void use() { System.out.println("�����簡 " + manufacture + "�� " + cpu + "��ǻ�͸� ����Ѵ�");}
}

class Aircon2{
   String manufacture;
   String kind;
   int price;

   public void start() 
   {
      System.out.println("�����簡 " + manufacture + "�� " + kind +"�������� ����Ѵ�");
   }
}

class Refrig2{
   String manufacture;
   String door;
   String L;
   int price;

   public void manage() 
   {
      System.out.println("�����簡 " + manufacture + "�� "+ door +"�� " + L + "����� ��ǰ�� �����Ѵ�");
   }
}

class AirCleaner2{
   String manufacture;
   int price;

   public void start() 
   {
      System.out.println("�����簡 " + manufacture + "�� " + "�������� ���⸦ �����ϰ� �Ѵ� ");
   }
}


public class practice1teacher {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Computer2[] comArr = new Computer2[10];
      Aircon2[] airconArr = new Aircon2[10];
      Refrig2[] refrigArr = new Refrig2[10];
      AirCleaner2[] airCleanerArr = new AirCleaner2[10];
      for(int i = 0; i< 5; ++i)
      {
         comArr[i] = new Computer2();
         comArr[i].manufacture = "Samsung";
         comArr[i].cpu = "i7";
         comArr[i].price = 200;
         airconArr[i] = new Aircon2();
         airconArr[i].kind = "������";
         airconArr[i].manufacture = "Samsung";
         airconArr[i].price = 100;
         refrigArr[i] = new Refrig2();
         refrigArr[i].manufacture = "Samsung";
         refrigArr[i].door = "�繮";
         refrigArr[i].L = "600L";
         refrigArr[i].price = 200;
         airCleanerArr[i] = new AirCleaner2();
         airCleanerArr[i].manufacture = "LG";
         airCleanerArr[i].price = 80;
      }
      for(int i = 5; i<10; ++i)
      {
         comArr[i] = new Computer2();
         comArr[i].manufacture = "LG";
         comArr[i].cpu = "i5";
         comArr[i].price = 150;
         airconArr[i] = new Aircon2();
         airconArr[i].kind = "���ĵ�";
         airconArr[i].manufacture = "LG";
         airconArr[i].price = 250;
         refrigArr[i] = new Refrig2();
         refrigArr[i].manufacture = "LG";
         refrigArr[i].door = "4����";
         refrigArr[i].L = "800L";
         refrigArr[i].price = 350;
         airCleanerArr[i] = new AirCleaner2();
         airCleanerArr[i].manufacture = "���̽�";
         airCleanerArr[i].price = 60;
      }

      Buyer2[] b = new Buyer2[3]; // Buyer 3��

      for(int i =0;i<3;i++)
      {
         b[i] = new Buyer2();
      }

      Scanner sc = new Scanner(System.in);

      int select;

      System.out.print("1�� ���̾� ���� �Է��ϼ��� : "); // Buyer �� ���� ���ϹǷ� �ݺ����� �ȳ־���
      b[0].money = sc.nextInt();
      System.out.print("2�� ���̾� ���� �Է��ϼ��� : ");
      b[1].money = sc.nextInt();
      System.out.print("3�� ���̾� ���� �Է��ϼ��� : ");
      b[2].money = sc.nextInt();
     
      while(true)
      {
         for(int i = 0;i<3;i++)
         {
            if(b[i].money >=60) // ���� 60�����̸� ������ �� �ִ� ��ǰ�� �ƹ��͵� ����
            {
               while(true)
               {
                  System.out.print((i+1)+"���̾� ��ǰ�� ���� ���ּ��� 1. ��ǻ�� 2.������ 3.����� 4.����û���� :");
                  select = sc.nextInt();

                  if(select == 1)
                  {
                     while(true)
                     {
                        System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(i7) 2.LG(i5) : ");
                        select = sc.nextInt();
                        if(select == 1)
                        {
                           b[i].money = b[i].money - 200;
                           if(b[i].money <0)
                           {
                              System.out.println("��ǰ�� ���� �� �� �����ϴ�.");
                              b[i].money = b[i].money + 200;
                              break; // ù��° while������ ���ư�
                           }
                           int j = 0; // ���� ���°�� �����Ǿ� �ִ��� ã��
                           while(comArr[j]== null)
                           {
                              j++;
                           }
                           if(j >= 5) // ������� LG ��ǰ (j=5; j<10; j++)
                           {
                              System.out.println("��� �����ϴ�.");
                           }
                           else
                           {
                              b[i].ownComs[b[i].comindex++] = comArr[j]; // comindex ���� ��ǻ�� ���� �� �ִ� ���� ������ �þ
                              comArr[j] = null;
                           }
                           break;
                            
                        }
                        else if(select == 2)
                        {
                           b[i].money = b[i].money - 150;
                           if(b[i].money <0)
                           {
                              System.out.println("��ǰ�� ���� �� �� �����ϴ�.");
                              b[i].money = b[i].money + 150;
                              break;
                           }
                           int j = 5;
                           while(comArr[j]== null)
                           {
                              j++;
                           }
                           if(j >= 10)
                           {
                              System.out.println("��� �����ϴ�.");
                           }
                           else
                           {
                              b[i].ownComs[b[i].comindex++] = comArr[j];
                              comArr[j] = null;
                           }
                           break;
                        }
                        else
                        {
                           System.out.println("�߸��� �Է��Դϴ�.");
                        }
                        break;
                     }
                     break;
                  }
                  else if(select == 2)
                  {
                     while(true)
                     {
                        System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(��������) 2.LG(���ĵ���) : ");
                        select = sc.nextInt();
                        if(select == 1)
                        {
                           b[i].money = b[i].money - 100;
                           if(b[i].money <0)
                           {
                              System.out.println("��ǰ�� ���� �� �� �����ϴ�.");
                              b[i].money = b[i].money + 100;
                              break;
                           }
                           int j = 0;
                           while(comArr[j]== null)
                           {
                              j++;
                           }
                           if(j >= 5)
                           {
                              System.out.println("��� �����ϴ�.");
                           }
                           else
                           {
                              b[i].ownAircon[b[i].airindex++] = airconArr[j];
                              airconArr[j] = null;
                              
                           }
                           break;
                            
                        }
                        else if(select == 2)
                        {
                           b[i].money = b[i].money - 200;
                           if(b[i].money <0)
                           {
                              System.out.println("��ǰ�� ���� �� �� �����ϴ�.");
                              b[i].money = b[i].money + 200;
                              break;
                           }
                           int j = 5;
                           while(airconArr[j]== null)
                           {
                              j++;
                           }
                           if(j >= 10)
                           {
                              System.out.println("��� �����ϴ�.");
                           }
                           else
                           {
                              b[i].ownAircon[b[i].airindex++] = airconArr[j];
                              airconArr[j] = null;
                           }
                           break;
                        }
                        else
                        {
                           System.out.println("�߸��� �Է��Դϴ�.");
                        }
                        break;
                     }
                     break;
                  }
                  else if(select == 3)
                  {
                     while(true)
                     {
                        System.out.print("������ �� ����� �������ּ��� 1.�Ｚ(�繮,600L) 2.LG(4����, 800L) : ");
                        select = sc.nextInt();
                        if(select == 1)
                        {
                           b[i].money = b[i].money - 200;
                           if(b[i].money <0)
                           {
                              System.out.println("��ǰ�� ���� �� �� �����ϴ�.");
                              b[i].money = b[i].money + 200;
                              break;
                           }
                           int j = 0;
                           while(refrigArr[j]== null)
                           {
                              j++;
                           }
                           if(j >= 5)
                           {
                              System.out.println("��� �����ϴ�.");
                           }
                           else
                           {
                              b[i].ownRefrig[b[i].refindex++] = refrigArr[j];
                              refrigArr[j] = null;
                           }
                           break;
                            
                        }
                        else if(select == 2)
                        {
                           b[i].money = b[i].money - 350;
                           if(b[i].money <0)
                           {
                              System.out.println("��ǰ�� ���� �� �� �����ϴ�.");
                              b[i].money = b[i].money + 350;
                              break;
                           }
                           int j = 5;
                           while(refrigArr[j]== null)
                           {
                              j++;
                           }
                           if(j >= 10)
                           {
                              System.out.println("��� �����ϴ�.");
                           }
                           else
                           {
                              b[i].ownRefrig[b[i].refindex] = refrigArr[j];
                              refrigArr[j] = null;
                           }
                           break;
                        }
                        else
                        {
                           System.out.println("�߸��� �Է��Դϴ�.");
                        }
                        break;
                     }
                     break;
                  }
                  else if(select == 4)
                  {
                     while(true)
                     {
                        System.out.print("������ �� ����� �������ּ��� 1.LG 2.���̽� : ");
                        select = sc.nextInt();
                        if(select == 1)
                        {
                           b[i].money = b[i].money - 80;
                           if(b[i].money <0)
                           {
                              System.out.println("��ǰ�� ���� �� �� �����ϴ�.");
                              b[i].money = b[i].money + 80;
                              break;
                           }
                           int j = 0;
                           while(airCleanerArr[j]== null)
                           {
                              j++;
                           }
                           if(j >= 5)
                           {
                              System.out.println("��� �����ϴ�.");
                           }
                           else
                           {
                              b[i].ownAirCleaner[b[i].aircindex++] = airCleanerArr[j];
                              airCleanerArr[j] = null;
                           }
                           break;
                            
                        }
                        else if(select == 2)
                        {
                           b[i].money = b[i].money - 60;
                           if(b[i].money <0)
                           {
                              System.out.println("��ǰ�� ���� �� �� �����ϴ�.");
                              b[i].money = b[i].money + 60;
                              break;
                           }
                           int j = 5;
                           while(airCleanerArr[j]== null)
                           {
                              j++;
                           }
                           if(j >= 10)
                           {
                              System.out.println("��� �����ϴ�.");
                           }
                           else
                           {
                              b[i].ownAirCleaner[b[i].aircindex] = airCleanerArr[j];
                              airCleanerArr[j] = null;
                           }
                           break;
                        }
                        else
                        {
                           System.out.println("�߸��� �Է��Դϴ�.");
                        }
                        break;
                     }
                     break;
                  }
                  else
                  {
                     System.out.println("�߸��� �Է��Դϴ�.");
                  }

               }
               

            }
            for(int x = 0;x<3;x++)
            {
               System.out.println((x+1)+"Buyer�� ���� �ݾ��� "+b[x].money+"�Դϴ�.");
            }
            
         }

         if(b[0].money <60 && b[1].money <60&& b[2].money<60)
         {
            break;
         }
      }
      
      
      for(int i=0;i<3;i++)
      {
         int j = 0;
         while(b[i].ownComs[j]!=null)
         {
            System.out.print((i+1)+"�� ���̾�� ");
            b[i].ownComs[j].use();
            j++;
         }
         j = 0;
         while(b[i].ownAircon[j]!=null)
         {
            System.out.print((i+1)+"�� ���̾�� ");
            b[i].ownAircon[j].start();
            j++;
         }
         j = 0;
         while(b[i].ownRefrig[j]!=null)
         {
            System.out.print((i+1)+"�� ���̾�� ");
            b[i].ownRefrig[j].manage();
            j++;
         }
         j = 0;
         while(b[i].ownAirCleaner[j]!=null)
         {
            System.out.print((i+1)+"�� ���̾�� ");
            b[i].ownAirCleaner[j].start();;
            j++;
         }
      }

            
   }
}