package maths;

class MinTimeToMakeRopeColorful {

	public int minCost(String colors, int[] neededTime) {
		if (colors.length() != neededTime.length)
			return 0;
		int reqTime = 0;
		for (int i = 1; i < neededTime.length; i++) {
			char curColor = colors.charAt(i);
			char prevColor = colors.charAt(i - 1);
			int curTime = neededTime[i];
			int prevTime = neededTime[i - 1];
			if (prevColor == curColor) {
				reqTime = reqTime + Math.min(curTime, prevTime);
				neededTime[i] = Math.max(curTime, prevTime); // bcz we need only max value if colors are getting
																// repeated.
			}
		}
		return reqTime;
	}
}