class Solution {

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq1 = new PriorityQueue<>();

        PriorityQueue<Long> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        HashSet<Long> set = new HashSet<>();

        pq1.add(1L);
        while (pq2.size() != n) {
            long a = pq1.poll();
            pq2.add(a);
            if (!set.contains(a * 2L)) {
                pq1.add(a * 2L);
                set.add(a * 2L);
            }

            if (!set.contains(a * 3L)) {
                pq1.add(a * 3L);
                set.add(a * 3L);

            }
            if (!set.contains(a * 5L)) {
                pq1.add(a * 5L);
                set.add(a * 5L);

            }

        }

        long k= pq2.peek();
        return (int)k;

    }
}