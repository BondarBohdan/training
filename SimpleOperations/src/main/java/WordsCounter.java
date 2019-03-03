import java.util.Arrays;
import java.util.List;

public class WordsCounter {
	public static void wordsCounter(String str) {
		List<String> list = Arrays.asList(str.split(" "));
		System.out.println("There is " + list.size() + " words in the text.");
		
	}
}
