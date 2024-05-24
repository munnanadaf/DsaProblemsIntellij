package arrays;

public class SwappingZerosAndOnes {

	public static void main(String[] args) {
		int a[] = { 0,1, 0, 1, 0, 0, 1, 1, };
		swapZero(a);
	}

	public static void swapZero(int a[]) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			int temp;
			if (!(a[i] == 0))
				i++;
			else {
				if (!(a[j] == 1)) {
					j--;
				} else {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					j--;
				}
				i++;
			}
		}

		for (int nn : a) {
			System.out.print(nn + " ");
		}
	}

}
