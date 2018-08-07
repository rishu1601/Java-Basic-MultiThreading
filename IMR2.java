public class IMR2
{
    public static void main(String[] args)
    {
        Thread r1=new Thread(new Runnable()
        	{
        		public void run()
			    {
			        for(int i=0;i<10;i++)
			        {
			            System.out.println("Hello "+i*10);
			            try
			            {
			                Thread.sleep(100);
			            }
			            catch(InterruptedException e)
			            {
			                e.printStackTrace();
			            }
			        }
			    }
        	});
        Thread r2=new Thread(new Runnable()
        {
        	public void run()
			    {
			        for(int i=0;i<10;i++)
			        {
			            System.out.println("Hello "+i);
			            try
			            {
			                Thread.sleep(100);
			            }
			            catch(InterruptedException e)
			            {
			                e.printStackTrace();
			            }
			        }
			    }
        });
        r1.start();
        r2.start();
    }
    
}
