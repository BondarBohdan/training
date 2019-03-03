
public class Decomposition {
    public static void decomposition(int num) {
        System.out.println("Decomposition number into a product of prime numbers with their degrees ");
        int n = 2;
        while (num > 2) {
            if (num % n == 0) {
                System.out.print(n + " ");
                num /= n;
            } else {
                n++;
            }
        }
        System.out.println();
    }
}
