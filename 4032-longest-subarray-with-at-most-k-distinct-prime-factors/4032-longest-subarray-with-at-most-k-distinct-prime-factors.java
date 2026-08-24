import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        ArrayList<Integer> prime = prime(arr);
        int i = 0;
        int j = 0;

        while (j < n) {
            add(arr[j], prime, map);

            while (map.size() > k) {  // corrected
                remove(arr[i], prime, map);
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }

    void add(int num, ArrayList<Integer> primes,
             HashMap<Integer, Integer> map) {
        int i = 0;
        while (i < primes.size() && primes.get(i) <= num) {
            if (num % primes.get(i) == 0) {
                map.put(primes.get(i),
                        map.getOrDefault(primes.get(i), 0) + 1);
            }
            i++;
        }
    }

    void remove(int num, ArrayList<Integer> primes,
                HashMap<Integer, Integer> map) {
        int i = 0;
        while (i < primes.size() && primes.get(i) <= num) {
            if (num % primes.get(i) == 0) {
                map.put(primes.get(i), map.get(primes.get(i)) - 1);

                if (map.get(primes.get(i)) == 0) {
                    map.remove(primes.get(i));
                }
            }
            i++;
        }
    }

    ArrayList<Integer> prime(int[] arr) {
        int max = 0;
        for (int x : arr) {
            max = Math.max(max, x);
        }

        boolean[] primes = new boolean[max + 1];
        Arrays.fill(primes, true);

        if (max >= 0) primes[0] = false;
        if (max >= 1) primes[1] = false;

        // corrected: only sieve while i * i <= max
        for (int i = 2; i * i <= max; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= max; j += i) {
                    primes[j] = false;
                }
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (primes[i]) {
                al.add(i);
            }
        }

        return al;
    }
}