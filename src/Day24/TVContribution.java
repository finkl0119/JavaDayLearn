package Day24;

class Account1
{
	private int total = 0;
	synchronized void deposit()
	{
		total = total + 100;
	}
	
	int gettotal()
	{
		return total;
	}
}

class Customer1 extends Thread
{
	Account1 same_a;
	Customer1(Account1 a, String s)
	{
		same_a = a;
		setName(s);
	}

	public void run()
	{
		for (int i = 1; i <=200; i++) 
		{
			System.out.println(getName() + ":" + i + "��°");
			same_a.deposit();
			if(same_a.gettotal() >= 500000)
			{
				break;
			}
		}
	}
}

public class TVContribution {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		
		Account1 same_account = new Account1();
		Customer1 donator1 = new Customer1(same_account, "1��° ������");
		Customer1 donator2 = new Customer1(same_account, "2��° ������");
		Customer1 donator3 = new Customer1(same_account, "3��° ������");
		Customer1 donator4 = new Customer1(same_account, "4��° ������");
		Customer1 donator5 = new Customer1(same_account, "5��° ������");
	
		donator1.start();
		donator2.start();
		donator3.start();
		donator4.start();
		donator5.start();
		
		donator1.join();
		donator2.join();
		donator3.join();
		donator4.join();
		donator5.join();
		
		System.out.println("���� �Ѿ���: " + same_account.gettotal());
	}

}
