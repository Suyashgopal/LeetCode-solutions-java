class Solution {
    public void solveSudoku(char[][] board) {

        HashMap<Integer, Set<Integer>> row = new HashMap<>();
        HashMap<Integer, Set<Integer>> col = new HashMap<>();
        HashMap<Integer, Set<Integer>> box = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            box.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (Character.isDigit(c)) {
                    int dig = c - '0';

                    row.get(i).add(dig);
                    col.get(j).add(dig);
                    int bid = (i / 3) * 3 + (j / 3);
                    box.get(bid).add(dig);
                }

            }
        }

        fun(0, 0, board, row, col, box);

    }

    boolean fun(int r, int c, char[][] board, HashMap<Integer, Set<Integer>> row, HashMap<Integer, Set<Integer>> col,
            HashMap<Integer, Set<Integer>> box) {
        if (r == 9) {
            return true;
        }
        int nr=r;
        int nc= c+1;
        if(nc==9){
            nc=0;
            nr=r+1;
        }

         if (board[r][c] != '.')
        return fun(nr,nc,board,row,col,box);

        for (int i = r; i < 9; i++) {

            for (int j = c; j < 9; j++) {
                char k = board[i][j];

                for (int p = 1; p <= 9; p++) {
                    int bid = (i / 3) * 3 + j / 3;

                    if (!row.get(i).contains(p) && !col.get(j).contains(p) && !box.get(bid).contains(p)) {
                        board[r][j] = (char) (p + '0');
                        row.get(i).add(p);
                        col.get(j).add(p);
                        box.get(bid).add(p);

                        if (c == 8) {
                            if (fun(r + 1, 0, board, row, col, box)) {
                                return true;
                            }
                        } else {
                            if (fun(r, c + 1, board, row, col, box)) {
                                return true;
                            }
                        }

                        board[r][j] = '.';
                        row.get(r).remove(p);
                        col.get(j).remove(p);
                        box.get(bid).remove(p);

                    }

                }
                return false;

            }

        }

        return true;

    }
}