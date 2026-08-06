class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            int val = map.get(key);

            pq.add(new int[] { key, val });
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            res[i] = curr[0];
        }

        return res;

    }
}