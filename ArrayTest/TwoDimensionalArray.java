package ArrayTest;

import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] myArray = new int[9][9];
        for (int index1D = 0; index1D < 9; index1D++) {
            int a =0;
            for (int index2D = 0; index2D < 9; index2D++) {
                myArray[index1D][index2D] = a;
                a++;
            }
        }

        System.out.println(Arrays.deepToString(myArray));
    }
}
