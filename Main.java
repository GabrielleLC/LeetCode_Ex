package LeetCode_Ex;

/**
 * Created by onion on 16/3/20.
 */
public class Main {
    public static void main(String[] args) {
        NumIslands mySol = new NumIslands();
        char[][] grid ={{}};
                //{{'1'}};
                //{{'1','0','1'},{'1','1','0'}};
              //  {{'1', '1', '1', '1', '0'},{'1', '1', '0', '1', '0'},{'1', '1', '0', '0', '0'},{'0', '0', '0', '0', '0'}};
                //{ {'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};

        System.out.println(mySol.numIslands(grid));

        /*CountBits mySol = new CountBits();
        int[] arr;
        arr = mySol.countBits(5);
        for (int i = 0; i <= 5; i++)
            System.out.println(arr[i]);*/
    }
}
