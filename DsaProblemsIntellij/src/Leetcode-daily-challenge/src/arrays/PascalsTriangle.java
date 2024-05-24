package arrays;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> allRows = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);
			for (int j = 1; j < row.size() - 1; j++) { // except boundary elements
				row.set(j, row.get(j) + row.get(j + 1)); // bcz of line 6, 0th element is shifted to 1st index. & last
															// element is always 1 from beginning.
			}
			allRows.add(new ArrayList<Integer>(row));
		}
		return allRows;
	}
}