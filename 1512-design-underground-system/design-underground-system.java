import java.util.*;

class UndergroundSystem {

    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }


    Map<Integer, Pair> checkInMap;

    // route → {totalTime, count}
    Map<String, int[]> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);

        String route = p.station + "-" + stationName;
        int travelTime = t - p.time;

        int[] data = routeMap.getOrDefault(route, new int[2]);
        data[0] += travelTime; // total time
        data[1] += 1;          // count

        routeMap.put(route, data);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        int[] data = routeMap.get(route);

        return (double) data[0] / data[1];
    }
}