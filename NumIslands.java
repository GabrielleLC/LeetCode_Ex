package LeetCode_Ex;

/**
 * Created by onion on 16/3/15.
 */

public class NumIslands {
    public int numIslands(char[][] grid) {
        int RowSZ = grid.length;
        if (RowSZ == 0)
            return 0;
        int ColSZ = grid[0].length;  //the size of the col
        WeightedQuickUnionUF myUF = new WeightedQuickUnionUF(RowSZ, ColSZ);
        int[] DiffRoot = new int[RowSZ * ColSZ + 1];
        int i, j;
        DiffRoot[0] = -1;
        for (i = 0; i < RowSZ; i = i + 1)
            for (j = 0; j < ColSZ; j = j + 1)
                if (grid[i][j] == '1') {

                    //down
                    if (i + 1 < RowSZ && grid[i + 1][j] == '1') {
                        myUF.union(myUF.xyTo1D(i, j), myUF.xyTo1D(i + 1, j));
                    }
                    //right
                    if (j + 1 < ColSZ && grid[i][j + 1] == '1') {
                        myUF.union(myUF.xyTo1D(i, j), myUF.xyTo1D(i, j + 1));
                    }


                } else {
                    myUF.noRoot(myUF.xyTo1D(i, j));
                }
        for (i = 0; i < RowSZ * ColSZ; i = i + 1) {
            int dRoot = myUF.root(i);
            if (dRoot != -1)
                for (j = 0; j < RowSZ * ColSZ; j = j + 1) {
                    if (DiffRoot[j] == dRoot)
                        break;
                    else if (DiffRoot[j] == -1) {
                        DiffRoot[j] = dRoot;
                        DiffRoot[j + 1] = -1;
                        break;
                    }
                }
        }
        for (j = 0; DiffRoot[j] != -1; j = j + 1) ;
        return j;
    }


    public class WeightedQuickUnionUF {
        private int[] id;
        private int[] sz;
        public int ColSZ;
        public int RowSZ;

        public WeightedQuickUnionUF(int Rowsz, int Colsz) {
            RowSZ = Rowsz;
            ColSZ = Colsz;
            int N = RowSZ * ColSZ;
            id = new int[N];
            sz = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;  //set id of each object to itself (N array accesses)
                sz[i] = 1;
            }
        }

        public int xyTo1D(int i, int j) {
            return i * ColSZ + j;
        }

        public void noRoot(int i) {
            id[i] = -1;
        }

        public int root(int i) {
            if (id[i] == -1)
                return -1;
            while (i != id[i]) i = id[i];
            return i;
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (i == j) return;
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
        }
    }


}





