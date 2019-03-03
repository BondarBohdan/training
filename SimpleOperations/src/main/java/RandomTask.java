import java.util.Random;

public class RandomTask {
	public static void random(int n) {
		int statisticOfOne = 0;
		for (int i = 0; i < n; i++) {
			if (RandomTask.randomZeroOne() == 1) {
				statisticOfOne++;
			}
		}
		System.out.println("The number 1 ocurres " + statisticOfOne + " times from " + n);

	}

	private static int randomZeroOne() {
		Random ran = new Random();
		return ran.nextInt(2);
	}

}
