package interview;

public class OddEvenNumbersUsingThreads {
	static int curNum = 1;
	static Object lock = new Object();

	public static void main(String[] args) {
		Thread even = new Thread(new Runnable() {
			@Override
			public void run() {
				while (curNum <= 10) {
					synchronized (lock) {
						if (curNum % 2 == 0) {
							System.out.println(curNum + " even Thread");
							curNum++;
							lock.notify(); // wakes up other thread waiting on lock object
						} else {
							try {
								lock.wait(); // wait makes the thread to release the lock & go into waiting state for
												// lock object
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		});

		Thread odd = new Thread(new Runnable() {
			@Override
			public void run() {
				while (curNum <= 10) {
					synchronized (lock) {
						if (curNum % 2 != 0) {
							System.out.println(curNum + " odd Thread");
							curNum++;
							lock.notify(); // notify makes other waiting thread on lock to wake up
						} else {
							try {
								lock.wait(); // makes current thread to release the lock & go into waiting state
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		});

		odd.start();
		even.start();
		try {
			odd.join();
			even.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
