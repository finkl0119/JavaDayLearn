package Day11;

public class func7 {

	
	public static void change(int[] a/*���� ����*/)
	{
		a[0]= 5;
		a[1]= 4;
		a[2]= 3;
		a[3]= 2;
		a[4]= 1;
	}
	
	public static void main(String[] args)
	{
		int a[] = new int[5];
		a[0]= 1;
		a[1]= 2;
		a[2]= 3;
		a[3]= 4;
		a[4]= 5;
		for(int i = 0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println();
		
		change(a);
		
		for(int i = 0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println();
		
	}
	
	
}
