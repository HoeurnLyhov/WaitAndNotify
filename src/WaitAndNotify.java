
public class WaitAndNotify 
{
	int goods;
	
	
	public synchronized void producer()
	{
		System.out.println("Hello from producer...");
		for(int i=0;i<10;i++)
			goods++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			wait();
		} catch (InterruptedException e) {
			
		}
		System.out.println("After Wait... Hello from producer");
	}
	
	public synchronized void consumer()
	{
		for(int i=0;i<10;i++)
			goods--;
		notify();
		System.out.println("After Notify...Hello from consumer");
	}
	public static void main(String[] args) 
	{
		final WaitAndNotify ab=new WaitAndNotify();
		Thread leo = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				ab.producer();
			}
		});
		leo.start();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				ab.consumer();
			}
		}).start();
	}

}
