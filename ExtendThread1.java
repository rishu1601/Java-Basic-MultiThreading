class Runner extends Thread
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
public class ExtendThread1 
{
    public static void main(String[] args)
    {
        Runner r1=new Runner("Thread1");
        Runner r2=new Runner("Thread2");
        r1.start();
        r2.start();
    }
    
}
