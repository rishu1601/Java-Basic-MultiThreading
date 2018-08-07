public class Sync1
{
	private int cnt=0;
	public static void main(String[] args) {
		new Sync1().doWork();
	}
	public void doWork()
	{
		Thread t1=new Thread(new Runnable(){
			public void run()
			{
				for(int i=0;i<100;i++)cnt++;
			}
		});
		Thread t2=new Thread(new Runnable(){
			public void run()
			{
				for(int i=0;i<100;i++)cnt++;
			}
		});
		t1.start();
		t2.start();
		System.out.println("Count = "+cnt);  //Count = 0
		//This happens because threads return before starting and line 23 is executed before lines 9-20
		//We use join to overcome this problem 
	}
}