package arrays;

public class RotateArrayByk {

	static void rotateArr(int arr[], int d, int n) {
		// add your code here
		int i = 0, j = d - 1;
		while (i < j) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
		i = d;
		j = n - 1;
		while (i < j) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}

		i = 0;
		j = n - 1;

		while (i < j) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
	}

	
	// executed solution
	static void rotateArr1(int arr[], int d, int n)
    {
        // add your code here
        if(d>n){
            d = d%n;
        }
        int tmp [] = new int[d];
        
        for(int i= 0;i<d;i++){
            tmp[i] = arr[i];
        }
        
        for(int i =d;i<n;i++){
            arr[i-d] =  arr[i];
        }
        
        for(int i= 0;i<d;i++){
            arr[n-d+i] = tmp[i];
        }
    }

	
//	best solution but took more time
	static void rotateArr11(int arr[], int d, int n) {
		if (d > n) {
			d = d % n;
		}
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);
	}

	static void reverse(int a[], int low, int high) {
		while (low < high) {
			int t = a[low];
			a[low] = a[high];
			a[high] = t;
		}
	}

}
