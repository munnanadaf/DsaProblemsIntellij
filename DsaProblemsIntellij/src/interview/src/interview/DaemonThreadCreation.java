package interview;

public class DaemonThreadCreation {
	public static void main(String[] args) {
		Thread daemonThread = new Thread(new DaemonTask());
		daemonThread.setDaemon(true);
		daemonThread.start();
		System.out.println("Main thread exits");
	}
}

class DaemonTask implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("Daemon Thread running!!!!!!!!!!!!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
