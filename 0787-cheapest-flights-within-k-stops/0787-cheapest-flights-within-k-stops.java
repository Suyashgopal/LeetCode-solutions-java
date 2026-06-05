class tuple {
    int node;
    int price;
    int stops;

    tuple(int price, int node, int stops) {
        this.price = price;
        this.node = node;
        this.stops = stops;
    }
}

class pair {
    int node;
    int price;

    pair(int node, int price) {
        this.node = node;
        this.price = price;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] mat, int src, int dest, int k) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] x : mat) {
            adj.get(x[0]).add(new pair(x[1], x[2]));
        }


        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;


        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(0, src, 0));


        while (!q.isEmpty()) {

            tuple curr = q.poll();

            int node = curr.node;
            int price = curr.price;
            int stops = curr.stops;


            if (stops > k) continue;


            for (pair a : adj.get(node)) {

                int newPrice = price + a.price;

                if (newPrice < dist[a.node] && stops <= k) {

                    dist[a.node] = newPrice;
                    q.add(new tuple(newPrice, a.node, stops + 1));

                }
            }
        }


        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}