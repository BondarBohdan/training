import java.util.Arrays;

public class Main {


	public static void main(String[] args) {
		String str = "adaptor";
		String[] arr = new String[str.length()];
		String result = "";
		int position = 0;
		 		
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.substring(i, str.length()) + str.substring(0, i);
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			result += arr[i].charAt(arr[i].length() - 1);
			if (arr[i].equals(str)) {
				position = i + 1;
			}
		}
		System.out.println(result + ", " + position);

	}

}
