package interview;

public class CreatingDeadLock {

	public static void main(String[] args) {

		Object obj1 = new Object();
		Object obj2 = new Object();

		Thread t1 = new Thread(() -> {
			synchronized (obj1) {
				System.out.println("Thread 1 holding lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 1 waiting for lock2");
				synchronized (obj2) {
					System.out.println("Thread 1 holding lock1 and lock2");
				}
			}
		});
		Thread t2 = new Thread(() -> {
			synchronized (obj2) {
				System.out.println("Thread 2 holding lock2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 2 waiting for lock1");
				synchronized (obj1) {
					System.out.println("Thread 2 holding lock1 & lock2");
				}
			}
		});

		t1.start();
		t2.start();

	}
}
