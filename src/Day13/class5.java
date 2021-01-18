package Day13;

//28������
//Animal a = new Animal();
//a.name = "������";
class Animal {
	   private String name = "";
	   private String food = "";
	   
	   //�߿� ��¥ ���̾� Spring
	   void SetName(String name) {
		  //����� ���� �� �ִ�.
	      this.name = name;
	   }
	   
	   String GetName() {
	      return this.name;
	   }

	   void SetFood(String Food) {
	      this.food = Food;
	   }
	   
	   String GetFood() {
	      return this.food;
	   }

	   void Display() {
	      System.out.printf("%s�� %s�� ������ �ֽ��ϴ�\n", this.name, this.food);
	   }
	}
public class class5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Animal Monkey = new Animal();
	      Animal Chicken = new Animal();
	      Animal Dog = new Animal();
	      Animal Pig = new Animal();
	      String tmpFood1 = "";
	      
	      //Monkey.name = "������"; �� �ϸ� �ȵ�.
	      Monkey.SetName("������");
	      Dog.SetName("��");
	      Chicken.SetName("��");
	      Pig.SetName("����");
	      
	      Monkey.SetFood("�ٳ���");
	      Dog.SetFood("���ٱ�");
	      Chicken.SetFood("����");
	      Pig.SetFood("����");
	      
	      Monkey.Display();
	      Dog.Display();
	      Chicken.Display();
	      Pig.Display();
	      System.out.println();
	      
	      //ü����
	      tmpFood1 = Pig.GetFood();
	      Pig.SetFood(Chicken.GetFood());
	      Chicken.SetFood(Dog.GetFood());
	      Dog.SetFood(Monkey.GetFood());
	      Monkey.SetFood(tmpFood1);

	      Monkey.Display();
	      Dog.Display();
	      Chicken.Display();
	      Pig.Display();
	}

}
