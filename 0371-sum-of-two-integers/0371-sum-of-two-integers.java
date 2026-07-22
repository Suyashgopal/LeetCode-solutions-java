class Solution {
    public int getSum(int anum, int bnum) {

        int carry = 0;
        int res = 0;

        for (int i = 0; i < 32; i++) {

            int a = anum & 1;
            int b = bnum & 1;

            if (carry == 0) {

                if (a == 1 && b == 1) {
                    carry = 1;
                } else if (a != b) {
                    res |= (1 << i);
                }

            } else {

                if (a == 0 && b == 0) {
                    res |= (1 << i);
                    carry = 0;
                } else if (a != b) {
                    // sum = 0, carry = 1
                    carry = 1;
                } else { // a == 1 && b == 1
                    res |= (1 << i);
                    carry = 1;
                }
            }

            // unsigned shift
            anum >>>= 1;
            bnum >>>= 1;
        }

        return res;
    }
}