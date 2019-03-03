public class Palindrome {
    public static void palindrome(String str) {
        StringBuffer strBuf = new StringBuffer(str);

        if (strBuf.reverse().toString().equalsIgnoreCase(str)) {
            System.out.println("\nYour string is polindrome");
        } else {
            System.out.println("\nYour string is not polindrome");
        }
    }

}
