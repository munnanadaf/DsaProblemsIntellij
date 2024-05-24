package arrays;

public class StockToBuyMaxProfit {
	public static int maxProfit(int a[]) {
		int profit = 0;
		for(int i=1;i<a.length;i++) {
			if(a[i-1]<a[i]) {
				profit = profit+(a[i]-a[i-1]);
			}
		}
		return profit;
	}
	
	public static void main(String[] args) {
		int a [] = {3,3,39,4,6,8};
		System.out.println(maxProfit(a));
	}

}
