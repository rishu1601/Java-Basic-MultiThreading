import java.util.*;
import java.util.concurrent.*;

class Runner implements Runnable
{
    private int id;
    public Runner(int id)
    {
        this.id=id;
    }
    public void run()
    {
        System.out.println("Hello "+id+" Instance ");
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Bye "+id+" Instance ");
    }
}
public class ThreadPool1
{
	public static void main(String[] args) 
	{
		ExecutorService exc=Executors.newFixedThreadPool(3);   //ThreadPool of 3 threads
		for(int i=0;i<10;i++)
		{
			exc.submit(new Runner(i));
		}
		System.out.println("All tasks submitted");
		exc.shutdown();
		System.out.println("Done with Tasks");
		try{exc.awaitTermination(4,TimeUnit.MINUTES);}   //Awaits only for this given time
		catch(Exception e){}
	}
}