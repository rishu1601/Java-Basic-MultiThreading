import java.util.*;
public class Lock1
{
	private Random r=new Random();
	private List<Integer> list1=new ArrayList<Integer>();
	private List<Integer> list2=new ArrayList<Integer>();
	private Object lock1=new Object();
	private Object lock2=new Object();
	public void st1()
	{
		synchronized(lock1)
		{
			try
			{
				Thread.sleep(1);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			list1.add(r.nextInt(100));
		}
	}
	public void st2()
	{
		synchronized(lock2)
		{
			try
			{
				Thread.sleep(1);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			list2.add(r.nextInt(100));
		}
	}
	public void pr()
	{
		for(int i=0;i<1000;i++)
		{
			st1();
			st2();
		}
	}
	public void main() {
		System.out.println("Starting the process....");
		//long st_time=System.CurrentTimeMillis();
		//long end_time=System.CurrentTimeMillis();
		Thread t1=new Thread(new Runnable()
			{
				public void run()
				{
					pr();
				}
			});
		Thread t2=new Thread(new Runnable()
			{
				public void run()
				{
					pr();
				}
			});
		t1.start();
		t2.start();
		try
		{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		//System.out.println("Total time taken = "+end_time-st_time);
		System.out.println("List1 : "+list1.size()+" ; List2 : "+list2.size());
	}
}