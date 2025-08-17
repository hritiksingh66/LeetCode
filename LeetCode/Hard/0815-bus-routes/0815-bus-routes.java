import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                adj.putIfAbsent(stop, new ArrayList<>());
                adj.get(stop).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedRoutes = new boolean[routes.length];
        Set<Integer> visitedStops = new HashSet<>();

        if (!adj.containsKey(source)) return -1; 
        for (int routeIdx : adj.get(source)) {
            q.add(routeIdx);
            visitedRoutes[routeIdx] = true;
        }

        int buses = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int route = q.poll();

                for (int stop : routes[route]) {
                    if (stop == target) return buses;

                    if (visitedStops.contains(stop)) continue;
                    visitedStops.add(stop);

                    for (int nextRoute : adj.get(stop)) {
                        if (!visitedRoutes[nextRoute]) {
                            visitedRoutes[nextRoute] = true;
                            q.add(nextRoute);
                        }
                    }
                }
            }
            buses++;
        }

        return -1;
    }
}
