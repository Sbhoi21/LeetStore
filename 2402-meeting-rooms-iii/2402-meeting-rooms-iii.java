class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) availableRooms.add(i);

        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));

        long[] roomUsageCount = new long[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

           while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.add((int) busyRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
               int room = availableRooms.poll();
                roomUsageCount[room]++;
                busyRooms.add(new long[]{end, room});
            } else {
               long[] earliestBusy = busyRooms.poll();
                long roomEndTime = earliestBusy[0];
                int room = (int) earliestBusy[1];

                roomUsageCount[room]++;
                busyRooms.add(new long[]{roomEndTime + (end - start), room});
            }
        }

       int resultRoom = 0;
        for (int i = 1; i < n; i++) {
            if (roomUsageCount[i] > roomUsageCount[resultRoom]) {
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}