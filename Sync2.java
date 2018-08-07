public class Sync2
{
	private int cnt=0;
	public static void main(String[] args) {
		new Sync2().doWork();
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
		try{
			t1.join();
			t2.join();
		}
		catch(Exception e){e.printStackTrace();}
		System.out.println("Count = "+cnt);  //Count = 200,129,190
		//Count is not consistent because there is no syncronisation
	}
}