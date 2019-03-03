import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Logic {
	static Object task = null;
	static Object answer1 = null;
	static Object answer2 = null;
	static Object answer3 = null;
	static int turns = 5;
	static int score = 0;
	static ArrayList<Object> variants = new ArrayList<Object>();

	public static void logic(Map map) throws IOException, AnswerException {
		while (turns > 0) {
			variantsGenerator(map);
			taskOutput(map);
			Thread timer = new Thread(new Timer());
			timer.start();
			ExecutorService service = Executors.newSingleThreadExecutor();
			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						checkAnswer(map);
					} catch (IOException e) {
					}
				}
			};
			Future<?> f = service.submit(r);
			try {
				f.get(11, TimeUnit.SECONDS);
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				System.out.println();
				timeIsUp();
				System.exit(0);
			}
			timer.interrupt();
			variants.clear();

		}
		System.out.println("Game over. Your result is: " + score + ".");
	}

	public static void variantsGenerator(Map map) throws AnswerException {
		do {
			if (map.size() > 2) {
				variants.add(map.keySet().toArray()[new Random().nextInt(map.keySet().toArray().length)]);
				variants.add(map.keySet().toArray()[new Random().nextInt(map.keySet().toArray().length)]);
				variants.add(map.keySet().toArray()[new Random().nextInt(map.keySet().toArray().length)]);

				answer1 = variants.get(0);
				answer2 = variants.get(1);
				answer3 = variants.get(2);

			} else {
				throw new AnswerException("You have answered all the questions.");
			}
		} while (checkVariantsOnDuplicates(map) != true);
	}

	public static boolean checkVariantsOnDuplicates(Map map) throws AnswerException {
		int firstCheck = 1;
		int secondCheck = 1;
		do {
			if (variants.get(1).equals(variants.get(0))) {
				variants.set(1, map.keySet().toArray()[new Random().nextInt(map.keySet().toArray().length)]);
			} else {
				firstCheck = 0;
			}
		} while (firstCheck != 0);

		do {
			if (variants.get(2).equals(variants.get(0)) || variants.get(2).equals(variants.get(1))) {
				variants.set(2, map.keySet().toArray()[new Random().nextInt(map.keySet().toArray().length)]);
			} else {
				secondCheck = 0;
			}
		} while (secondCheck != 0);

		return (firstCheck == secondCheck);
	}

	public static void taskOutput(Map map) {

		int rd = (int) (Math.random() * variants.size());
		task = variants.get(rd);
		System.out.println("\n" + task.toString());

		System.out.println("\na) " + map.get(variants.get(0)));
		System.out.println("b) " + map.get(variants.get(1)));
		System.out.println("c) " + map.get(variants.get(2)));
	}

	public static void checkAnswer(Map map) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter your answer (a / b / c).");
		String answer = reader.readLine();
		while (!answer.matches("a|b|c")) {
			System.out.println("Answer must be 'a', 'b' or 'c'. Please try again.");
			answer = reader.readLine();
		}

		switch (answer) {
		case "a":
			if (answer1.toString().equals(task.toString())) {
				rightAnswer(map);
			} else {
				wrongAnswer();
			}
			break;
		case "b":
			if (answer2.toString().equals(task.toString())) {
				rightAnswer(map);
			} else {
				wrongAnswer();
			}
			break;
		case "c":
			if (answer3.toString().equals(task.toString())) {
				rightAnswer(map);
			} else {
				wrongAnswer();
			}
			break;
		}
	}

	public static void rightAnswer(Map map) {
		score++;
		System.out.println("Well done. Your score is " + score);
		map.remove(task);
	}

	public static void wrongAnswer() {
		turns--;
		if (turns >= 1) {
			System.out.println("You are wrong. " + turns + " turns left");
		}
	}

	public static void timeIsUp() {
		System.out.println("Time is up!. Game over.");
		System.out.println("Your score is " + score + ".");
	}
}
