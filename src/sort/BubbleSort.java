package sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {
	Testcases testcases = new Testcases();

	public static void run() {
		BubbleSort bubbleSort = new BubbleSort();
		// bubbleSort.testIterative();
		bubbleSort.testOptimizedForAlreadySorted();
	}

	private void testIterative() {
		System.out.println("[Iterative] Bubble sort");
		for (Testcase testcase : testcases.all) {
			System.out.println(Arrays.toString(testcase.list) + ":");
			iterative(testcase.list);
			System.out.println();
		}
	}

	private void iterative(int[] list) {
		if (list != null) {
			for (int j = list.length - 1; j >= 0; j--) {
				for (int i = 0; i < j; i++) {
					if (list[i] > list[i + 1]) {
						int temp = list[i];
						list[i] = list[i + 1];
						list[i + 1] = temp;
					}
				}
				System.out.println("After Iteration " + (list.length - j) + ": " + Arrays.toString(list));
			}
		}
		System.out.println("Result: " + Arrays.toString(list));
	}

	private void testOptimizedForAlreadySorted() {
		System.out.println("[Optimized for already sorted] Bubble sort");
		for (Testcase testcase : testcases.all) {
			System.out.println(Arrays.toString(testcase.list) + ":");
			optimizedForAlreadySorted(testcase.list);
			System.out.println();
		}
	}

	private void optimizedForAlreadySorted(int[] list) {
		if (list != null) {
			for (int j = list.length - 1; j >= 0; j--) {
				boolean noSwaps = true;
				for (int i = 0; i < j; i++) {
					if (list[i] > list[i + 1]) {
						int temp = list[i];
						list[i] = list[i + 1];
						list[i + 1] = temp;
						noSwaps = false;
					}
				}
				System.out.println("After Iteration " + (list.length - j) + ": " + Arrays.toString(list));
				if (noSwaps) break;
			}
		}
		System.out.println("Result: " + Arrays.toString(list));
	}
}

class Testcases {
	final List<Testcase> all;

	Testcases() {
		all = Arrays.asList(
						new Testcase(null),
						new Testcase(new int[]{}),
						new Testcase(new int[]{1}),
						new Testcase(new int[]{1, 2, 3, 4, 5}),
						new Testcase(new int[]{5, 4, 3, 4, 5}),
						new Testcase(new int[]{-2, 45, 0, 11, -9})
		);
	}
}

class Testcase {
	final int[] list;

	Testcase(int[] list) {
		this.list = list;
	}
}
