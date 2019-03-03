import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] arg) throws NumberFormatException, IOException {
		System.out.println("Please enter number of the task :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		switch (k) {
		case 1:
			System.out.println("Enter number to generate Fibonacci sequence");
			Fibonacci.fibonacci(Integer.parseInt(br.readLine()));
			break;
		case 2:
			System.out.println("Input number to decompose");
			Decomposition.decomposition(Integer.parseInt(br.readLine()));
			break;
		case 3:
			System.out.println("Input string to calculate number of loud letters");
			VowelsCounter.vowelsCounter(br.readLine());
			break;
		case 4:
			System.out.println("Enter string to check palindrome");
			Palindrome.palindrome(br.readLine());
			break;
		case 5:
			System.out.println("Input text to count words quantity");
			WordsCounter.wordsCounter(br.readLine());
			break;
		case 6:
		   	  System.out.println("Input number");
	    	  Calc.calculate(Integer.parseInt( br.readLine())) ;
			break;
		case 7:
			System.out.println("Input number 'n'");
			RandomTask.random(Integer.parseInt(br.readLine()));
			break;
		case 8:
			Multiples.multip();
			break;
		default:
			;
			break;
		}

	}
}
