public class Sync3
{
	private int cnt=0;
	public synchronized void inc()
	{
		cnt++;
	}
	public static void main(String[] args) {
		new Sync3().doWork();
	}
	public void doWork()
	{
		Thread t1=new Thread(new Runnable(){
			public void run()
			{
				for(int i=0;i<100;i++)inc();  //Synchronized method called
			}
		});
		Thread t2=new Thread(new Runnable(){
			public void run()
			{
				for(int i=0;i<100;i++)inc();   //Synchronized method called
			}
		});
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}
		catch(Exception e){e.printStackTrace();}
		System.out.println("Count = "+cnt);  //Count = 200
		//This works absolutely fine
	}
}