public class Recursion {
    // Recursive method to calculate factorial
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);  // Recursive call
        }
    }
}
