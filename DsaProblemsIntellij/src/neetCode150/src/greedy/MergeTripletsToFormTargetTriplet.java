package greedy;

class MergeTripletsToFormTargetTriplet {
	public boolean mergeTriplets(int[][] triplets, int[] target) {
		
		int[] resTriplet = new int[3];
		for (int i = 0; i < triplets.length; i++) {
			if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2])
				continue;
			int count = 0;
			for (int j = 0; j < 3; j++) {
				resTriplet[j] = Math.max(resTriplet[j], triplets[i][j]);
				if (resTriplet[j] == target[j])
					count++;

			}

			if (count == 3)
				return true;

		}

		return false;
	}
}