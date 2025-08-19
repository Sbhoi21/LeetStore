class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
         java.util.Arrays.sort(seats);
        java.util.Arrays.sort(students);

        int moves = 0;

        // Calculate the total moves required
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}