import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CategoryChoice {
	public static void categoryChoice() throws IOException, AnswerException, InterruptedException {
		System.out.print("\t");
		System.out.print("\t");
		System.out.println("English test");
		System.out.println("\nChoose one of the following categories:");
		System.out.println("1) Hobby & Free time;");
		System.out.println("2) Housework;");
		System.out.println("3) Likes and Dislikes;");
		System.out.println("4) Literature, Theatre & Film;");
		System.out.println("5) Music & Dance;");
		System.out.println("6) Working day.");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter the number of the category (1 / 2 / 3 / 4 / 5 / 6).");
		String choice = reader.readLine();
		while (!choice.matches("1|2|3|4|5|6")) {
			System.out.println("Choice must be a number value in the range [1 - 6]. Please try again.");
			choice = reader.readLine();
		}

		switch (choice) {
		case "1":
			startGame();
			Logic.logic(HobbyAndFreeTime.hobbyAndFreeTimeMap());
			break;
		case "2":
			startGame();
			Logic.logic(Housework.houseworkMap());
			break;
		case "3":
			startGame();
			Logic.logic(LikesAndDislikes.likesAndDislikesMap());
			break;
		case "4":
			startGame();
			Logic.logic(LiteratureTheatreFilm.LiteratureTheatreFilmMap());
			break;
		case "5":
			startGame();
			Logic.logic(MusicAndDance.musicAndDanceMap());
			break;
		case "6":
			startGame();
			Logic.logic(WorkingDay.workingDayMap());
			break;
		}
	}
	
	public static void startGame() throws InterruptedException {
		System.out.println("Ready");
		Thread.sleep(1000);
		System.out.println("Set");
		Thread.sleep(1000);
		System.out.println("Go!");
		
	}
}
