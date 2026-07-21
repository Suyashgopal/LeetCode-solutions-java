class Solution {
    public List<List<String>> solveNQueens(int n) {
        //hashset of rows, cols, d1, d2

        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> d1 = new HashSet<>();
        HashSet<Integer> d2 = new HashSet<>();
        List<List<String>> outer= new ArrayList<>();
        char[][] board= new char[n][n];
        for(char[] k: board){
            Arrays.fill(k,'.');
        }

        fun(0,n,board,row,col,d1,d2,outer);
        return outer;



    }

    void fun(int r, int n, char[][] board, HashSet<Integer> row, HashSet<Integer> col, HashSet<Integer> d1,
            HashSet<Integer> d2, List<List<String>> outer) {
        if (r == n) {

            /// convert the char array to string
            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            outer.add(new ArrayList<>(list));

            return;

        }

            for (int j = 0; j < n; j++) {

                int diag1 = r - j;
                int diag2 = r + j;

                if ((!row.contains(r)) && (!col.contains(j)) && (!d1.contains(diag1)) && (!d2.contains(diag2))) {
                    board[r][j] = 'Q';
                    row.add(r);
                    col.add(j);
                    d1.add(diag1);
                    d2.add(diag2);

                    fun(r+1,n, board,row, col,d1, d2, outer);

                    //remove
                    board[r][j] = '.';
                    row.remove(r);
                    col.remove(j);
                    d1.remove(diag1);
                    d2.remove(diag2);
                }

            }
        

    }
}