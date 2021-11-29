package search;

import java.util.Arrays;

public class BinarySearch {
	public static void run() {
		BinarySearch binarySearch = new BinarySearch();
		binarySearch.testIterative();
	}

	private void testIterative() {
		testIterative(null, 2);
		testIterative(new int[]{}, 2);
		testIterative(new int[]{1}, 2);
		testIterative(new int[]{2}, 2);
		testIterative(new int[]{1, 2, 3, 4, 5}, 2);
		testIterative(new int[]{1, 2, 3, 4, 5}, 5);
	}

	private void testIterative(int[] list, int key) {
		int index = iterative(list, key);
		String result = index == -1 ? "Not Found" : "Found " + key + " at index " + index;
		System.out.println("[Iterative] Search " + key + " in " + Arrays.toString(list) + ": " + result);
	}

	private int iterative(int[] list, int key) {
		if (list != null) {
			int low = 0;
			int high = list.length - 1;

			while (low <= high) {
				int mid = (low + high) / 2;
				if (key == list[mid]) return mid;
				else if (key < list[mid]) high = mid - 1;
				else low = mid + 1;
			}
		}

		return -1;
	}
}
