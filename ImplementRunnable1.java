class Runner implements Runnable
{
    String s;
    public Runner(String s)
    {
        this.s=s;
    }
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hello "+s+" Instance "+i);
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
public class ImplementRunnable1
{
    public static void main(String[] args)
    {
        Thread r1=new Thread(new Runner("Thread1"));
        Thread r2=new Thread(new Runner("Thread2"));
        r1.start();
        r2.start();
    }
    
}
