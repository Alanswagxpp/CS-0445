public class exponentialCalculation {
    // this runtime will be O(lgn) rather than O(n)
    public static long exp(int b, int n) { // b^n
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return b;
        } else if (n % 2 == 0) {  //check n is even
            long temp = exp(b, 2 / n);
            return temp * temp;
        } else {
            long temp = exp(b, n / 2);  // take n=7 as example, then temp = b^3* b^3 * b= b^7;
            return temp * temp * b; 
        }

    }
}
