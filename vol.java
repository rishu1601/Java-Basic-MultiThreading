import java.util.*;
class Processor extends Thread
{
	private volatile boolean runn=true;
	public void run()
	{
		while(runn)
		{
			System.out.println("Hello");
			try{Thread.sleep(100);}
			catch(InterruptedException e){e.printStackTrace();}
		}
	}
	public void shutdown()
	{
		runn=false;
	}
}
public class vol
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Processor prc=new Processor();
		prc.start();
		System.out.println("Press Enter to Stop");
		sc.next();
		prc.shutdown();	
	}
}