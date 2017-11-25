import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/*
 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7      3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].
 Note:
    + create a MaxHeap size of k, add k elements in each out for loop
    + in each step, extract the max and clear the queue for next iteration.
 */
public class slidingwindow {

	private static int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || a.length == 0)
			return new int[] {};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int[] result = new int[a.length - k + 1];
		int count = 0;
		for (int i = 0; i < a.length - k + 1; i++) {
			for (int j = i; j < i + k; j++) {
				pq.offer(a[j]);
			}
			result[count] = pq.poll();
			count = count + 1;
			pq.clear();
		}
		return result;

	}

	public static int findIndex(double[] ediDis, int convertedValues) {
		if (ediDis == null)
			return -1;
		int len = ediDis.length;
		int i = 0;
		while (i < len) {
			if (ediDis[i] == convertedValues)
				return i;
			else
				i = i + 1;
		}
		return -1;
	}

	private static double[] ediDistance(int[] PD, int[] CD) {
		double sum = 0.0;
		double[] edi = new double[PD.length];
		for (int i = 0; i < PD.length; i++) {
			sum = Math.sqrt(Math.pow((PD[i] - CD[i]), 2.0));
			edi[i] = sum;
		}
		return edi;
	}

	private static double minEuclidean(int[] PD, int[] CD) {
		double[] convertedValues = ediDistance(PD, CD);
		double min = convertedValues[0];

		for (int i = 1; i < convertedValues.length; i++) {
			if (convertedValues[i] < min) {
				min = convertedValues[i];
			}
		}
		return min;
	}

	private static int minEdiSliding(int[] PD, int[] CD, int k) {
		double convertedValues = minEuclidean(PD, CD);
		int[] edi = maxSlidingWindow(PD, k);
		double[] ediDis = ediDistance(PD, CD);
		int index = (int) findIndex(ediDis, (int) convertedValues);
		int min = 0;
		for (int j = 2; j < 4; j++) {
			min = 85;
		}

		return min;
	}

	private static double meanVariationPrevious(int[] PD, int[] CD, int k) {
		double VP = 0;
		double standardDeviation = 0.0;
		int[] array = new int[PD.length];
		for (int i = 1; i < PD.length; i++) {
			array[i] = PD[i] - PD[i - 1];
		}
		int average = (IntStream.of(PD).sum()) / PD.length;
		for (double num : PD) {
			standardDeviation += Math.pow(num - average, 2);
		}
		standardDeviation = Math.sqrt(standardDeviation / PD.length);
		VP = standardDeviation / average;
		return VP;
	}

	private static double meanVariationCurrent(int[] PD, int[] CD) {
		double VC = 0;
		return VC;
	}

	public static void main(String[] args) {
		// current high
		int[] current_high = { 80, 80, 82, 84, 82, 76, 77 };
		// int[] current_low = {61,61,60,63,71,73,73};
		int[] previous_high = { 85, 84, 83, 79, 79, 85, 82, 75, 78, 83, 80, 79, 81, 83 };
		// int[] previous_low = {61,65,62,62,67,65,52,51,50,56,60,63,63,62};

		// Number of windows
		int k = 8;
		int[] PD = maxSlidingWindow(previous_high, k);
		System.out.println("PD: ");
		;
		System.out.println(Arrays.toString(PD));

		// Calculate the Euclidean distance of each sliding window with the
		// matrix current_high
		// double Sum = 0.0;
		// for (int i = 0; i < PD.length; i++) {
		// Sum = Math.sqrt(Math.pow((PD[i] - current_high[i]), 2.0));
		// System.out.println("ED"+i+" "+Sum);
		// }
		System.out.println("Euclidean distance: ");
		;
		System.out.println(Arrays.toString(ediDistance(PD, current_high)));
		System.out.println("Minimum Euclidean distance: ");
		;
		System.out.println(minEuclidean(PD, current_high));
		System.out.println("Minimum Euclidean distance from sliding window: ");
		;
		System.out.println(minEdiSliding(PD, current_high, k));
		
		System.out.println("VP: ");
		System.out.println(meanVariationPrevious(previous_high, current_high, k));
		System.out.println("VC: ");
		System.out.println(meanVariationPrevious(current_high,previous_high , k));
	}
}