class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] edges, int[][] ques) {

        int[] deg = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            deg[v]++;
        }

        boolean[][] reach = new boolean[n][n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.offer(i);
            }
        }


        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int a : adj.get(curr)) {

                // direct prerequisite
                reach[curr][a] = true;

                // transfer curr's prerequisites
                for (int i = 0; i < n; i++) {
                    if (reach[i][curr]) {
                        reach[i][a] = true;
                    }
                }

                deg[a]--;

                if (deg[a] == 0) {
                    q.offer(a);
                }
            }
        }


        List<Boolean> res = new ArrayList<>();

        for (int[] query : ques) {
            res.add(reach[query[0]][query[1]]);
        }

        return res;
    }
}