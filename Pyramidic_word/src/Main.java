public class Main {

	public static void main(String[] args) {
		String str = "ABCDEF";
		cycles(str);
	}
	
	public static void cycles(String str) {
		for (int i = middle(str); i >= 0; i--) {
			print(i, str);
		}
		for (int i = 1; i < middle(str); i++) {
			print(i, str);
		}
	}
	
	public static int middle(String str) {
		return str.length() % 2 == 0 ? str.length()/2:(str.length()/2) + 1;
	}
	
	public static void print(int i, String str) {
		int space = i;
		while (space != 0) {
			System.out.print(" ");
			space--;
		}
		for (int j = i; j < str.length() - i; j++) {		
			System.out.print(str.charAt(j));
		}
		System.out.println();
	}
}
