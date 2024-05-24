package arrays;

import java.util.Scanner;

public class FibSeries {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter total number of elements in the series");
		int n = s.nextInt();
//		fibSeries(n);
		fibSeries2(n);
	}

	public static void fibSeries(int n) {
		int fib1 = 0;
		int fib2 = 1;

//		printing first 2 elements manually
		System.out.print(fib1 + " " + fib2 + " ");

		for (int i = 2; i < n; i++) {

//			continuous series elements calculated using fib1 and fib2
			int fib3 = fib1 + fib2;
			System.out.print(fib3 + " ");

//			updating fib1 and fib2
			fib1 = fib2;
			fib2 = fib3;
		}
	}

	public static void fibSeries2(int n) {
		int fib1 = 0, fib2 = 1;
		int count = 0;
		while (count < n) {
			System.out.print(fib1 + " ");
			int fib3 = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib3;
			count++;
		}
	}

}
