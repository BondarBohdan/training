
public class Timer implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 10; i > 0; i--) {
				Thread.sleep(1000);
				System.out.print(i + "...");
			}
		} catch (InterruptedException e) {
			
		}
	}

}
