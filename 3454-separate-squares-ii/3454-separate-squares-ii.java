import java.util.*;

class Solution {
    class Event implements Comparable<Event> {
        double y;
        int type; // +1 for bottom edge, -1 for top edge
        double x1, x2;

        Event(double y, int type, double x1, double x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public int compareTo(Event other) {
            return Double.compare(this.y, other.y);
        }
    }

    int[] count;
    double[] treeLength;
    double[] xCoords;

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        List<Event> events = new ArrayList<>();
        TreeSet<Double> xSet = new TreeSet<>();

        for (int[] s : squares) {
            double x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, 1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
            xSet.add(x);
            xSet.add(x + l);
        }

        Collections.sort(events);
        
        xCoords = new double[xSet.size()];
        int idx = 0;
        for (double x : xSet) xCoords[idx++] = x;
        
        int m = xCoords.length;
        count = new int[4 * m];
        treeLength = new double[4 * m];

        double totalArea = 0;
        double prevY = events.get(0).y;
        
        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            double curY = e.y;
            totalArea += (curY - prevY) * treeLength[1];
            
            update(1, 0, m - 2, e.x1, e.x2, e.type);
            prevY = curY;
        }

        double targetArea = totalArea / 2.0;
        double currentArea = 0;
        Arrays.fill(count, 0);
        Arrays.fill(treeLength, 0);
        prevY = events.get(0).y;

        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            double curY = e.y;
            double stripWidth = treeLength[1];
            double stripArea = (curY - prevY) * stripWidth;

            if (currentArea + stripArea >= targetArea - 1e-11) {
                if (stripWidth == 0) return prevY;
                return prevY + (targetArea - currentArea) / stripWidth;
            }

            currentArea += stripArea;
            update(1, 0, m - 2, e.x1, e.x2, e.type);
            prevY = curY;
        }

        return prevY;
    }

    private void update(int node, int start, int end, double l, double r, int val) {
        if (xCoords[start] >= r || xCoords[end + 1] <= l) {
            return;
        }
        if (xCoords[start] >= l && xCoords[end + 1] <= r) {
            count[node] += val;
        } else {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);
        }

        if (count[node] > 0) {
            treeLength[node] = xCoords[end + 1] - xCoords[start];
        } else {
            if (start == end) {
                treeLength[node] = 0;
            } else {
                treeLength[node] = treeLength[node * 2] + treeLength[node * 2 + 1];
            }
        }
    }
}