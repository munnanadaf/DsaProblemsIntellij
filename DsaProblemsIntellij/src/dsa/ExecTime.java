package dsa;

import java.util.Iterator;

public class ExecTime {
	public static void main(String[] args) {
		int n =20;
		long startTime = System.nanoTime();
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				
				for(int k=0;k<n;k++) {
					
				}
			}
		}
		
		
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println(duration);
	}

}
