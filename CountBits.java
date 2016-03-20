package LeetCode_Ex;

/**
 * Created by onion on 16/3/20.
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int point, i, j = 0;
        result[0] = 0;
        if (num == 0) {

            return result;
        }
        result[1] = 1;
        if (num == 1)
            return result;
        point = 2;
        while (true) {
            for (i = 0; i < point; i++) {
                j = point + i;
                if (j <= num) {
                    result[j] = 1 + result[i];
                } else
                    return result;
            }
            point = j + 1;
        }
    }


}
