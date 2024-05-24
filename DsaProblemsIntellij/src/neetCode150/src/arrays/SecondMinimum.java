package arrays;

import java.util.Scanner;

public class SecondMinimum {
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = s.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the array elements");
		for(int i = 0;i<n;i++) {
			a[i] = s.nextInt();
		}
		
		System.out.println("Printing the elements now");
		for(int i = 0 ;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
