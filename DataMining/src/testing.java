import java.util.Arrays;
import java.util.stream.IntStream;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double standardDeviation = 0.0;
		int[] PD = {85,84,83,79,79,85,82,75,78,83,80,79,81,83};
		int[] array = new int[PD.length];
		for(int i=1; i < PD.length; i++){
			array[i] = PD[i]-PD[i-1];
	}
		int average=(IntStream.of(PD).sum())/PD.length;
		for(double num: PD) {
            standardDeviation += Math.pow(num - average, 2);
        }
		standardDeviation = Math.sqrt(standardDeviation/PD.length);
		double cv = standardDeviation/average;
		System.out.println(Arrays.toString(array));
		System.out.println(average);
		System.out.println(standardDeviation);
		System.out.println(cv);

}
}
