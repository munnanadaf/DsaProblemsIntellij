package twoPointers;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int n = height.length;
		int left = 0, right = n - 1;

		while (left < right) {
			int h = Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, h * (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}
}
