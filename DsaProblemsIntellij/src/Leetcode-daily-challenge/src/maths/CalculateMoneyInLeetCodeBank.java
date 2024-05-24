package maths;

public class CalculateMoneyInLeetCodeBank {
	public int calculateMoneyInLeetCodeBank(int n) {
		int totalMoney = 0;
		for(int day = 1, dailySum = 0, weeksCount = 0;day<=n;++day) {
			if(day % 7 ==1) {
				weeksCount++;
				dailySum = weeksCount; // reset to lastWeek+1
			}else
				dailySum++; // above starting from 0, so incrementing before adding to totalMoney
			totalMoney = totalMoney+dailySum;
		}
		return totalMoney;
	}
}
