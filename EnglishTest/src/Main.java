import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			CategoryChoice.categoryChoice();
		} catch (AnswerException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.err.print("IOException");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.print("Unknown Exception");
			e.printStackTrace();
		}
	}

}
