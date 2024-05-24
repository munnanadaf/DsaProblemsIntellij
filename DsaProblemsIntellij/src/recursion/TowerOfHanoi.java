package recursion;

public class TowerOfHanoi {
	
	void towerOfHanoi(int n, char a, char b, char c) {
		if(n==1) {
			System.out.println("move "+n+ " from "+a+" to "+c);
			return;
		}
		
		//1st char will be source
		// 2nd char will be destination
		// 3rd char will be auxillary disk
		towerOfHanoi(n-1, a, c, b);
		System.out.println("Move "+n+" from "+a +" to "+c);
		towerOfHanoi(n-1, b, a, c);
	}
	
	public static void main(String[] args) {
		TowerOfHanoi obj = new TowerOfHanoi();
		obj.towerOfHanoi(2, 'A', 'C', 'B');
		
	}

}
