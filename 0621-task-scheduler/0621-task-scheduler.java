class Solution {
    public int leastInterval(char[] arr, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int k = arr.length;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }

        for (char c : map.keySet()) {
            int ch = c - 'A';
            int freq = map.get(c);
            pq.offer(new int[] { ch, freq, -(n + 1) });

        }
                    ArrayList<Integer> al = new ArrayList<>();



        while (!pq.isEmpty()) {

            ArrayList<int[]> temp = new ArrayList<>();
            boolean executed = false;

            while (!pq.isEmpty()) {

                int[] cur = pq.poll();

                if (al.size() >= cur[2] + n + 1) {

                    al.add(cur[0]);
                    cur[1]--;

                    if (cur[1] > 0) {
                        cur[2] = al.size() - 1;
                        pq.offer(cur);
                    }

                    executed = true;
                    break;
                }

                temp.add(cur);
            }

            for (int[] x : temp)
                pq.offer(x);

            if (!executed) {
                al.add(-1); // idle interval
            }
        }

        return al.size();

    }
}