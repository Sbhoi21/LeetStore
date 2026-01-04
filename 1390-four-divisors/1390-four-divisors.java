class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += sumIfFourDivisors(n);
        }
        return total;
    }

    private int sumIfFourDivisors(int n) {

        for (int p = 2; p * p * p <= n; p++) {
            if (p * p * p == n && isPrime(p)) {
                return 1 + p + (p * p) + n;
            }
        }


        for (int a = 2; a * a <= n; a++) {
            if (n % a == 0) {
                int b = n / a;
                if (a != b && isPrime(a) && isPrime(b)) {
                    return 1 + a + b + n;
                }
                return 0;
            }
        }

        return 0;
    }

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
