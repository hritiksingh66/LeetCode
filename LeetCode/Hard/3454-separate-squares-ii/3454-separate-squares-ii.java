class Solution {

    static class Event {
        long y, x1, x2;
        int type;
        Event(long y, int type, long x1, long x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static class Slice {
        double y, h, w;
        Slice(double y, double h, double w) {
            this.y = y;
            this.h = h;
            this.w = w;
        }
    }

    private double unionLen(List<long[]> intervals) {
        intervals.sort(Comparator.comparingLong(a -> a[0]));
        double res = 0;
        long end = Long.MIN_VALUE;
        for (long[] it : intervals) {
            long a = it[0], b = it[1];
            if (a > end) {
                res += (double)(b - a);
                end = b;
            } else if (b > end) {
                res += (double)(b - end);
                end = b;
            }
        }
        return res;
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        for (int[] sq : squares) {
            long x = sq[0], y = sq[1], l = sq[2];
            events.add(new Event(y, 1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
        }

        events.sort((a, b) -> {
            if (a.y != b.y) return Long.compare(a.y, b.y);
            return Integer.compare(a.type, b.type);
        });

        List<long[]> active = new ArrayList<>();
        double prevY = events.get(0).y;
        double total = 0.0;
        List<Slice> slices = new ArrayList<>();

        for (Event e : events) {
            double curY = e.y;
            if (curY > prevY && !active.isEmpty()) {
                double h = curY - prevY;
                double w = unionLen(active);
                slices.add(new Slice(prevY, h, w));
                total += h * w;
            }

            if (e.type == 1) {
                active.add(new long[]{e.x1, e.x2});
            } else {
                for (int i = 0; i < active.size(); i++) {
                    long[] it = active.get(i);
                    if (it[0] == e.x1 && it[1] == e.x2) {
                        active.remove(i);
                        break;
                    }
                }
            }
            prevY = curY;
        }

        double half = total / 2.0;
        double acc = 0.0;

        for (Slice s : slices) {
            double area = s.h * s.w;
            if (acc + area >= half) return s.y + (half - acc) / s.w;
            acc += area;
        }

        return 0.0;
    }
}