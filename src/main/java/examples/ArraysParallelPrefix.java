package examples;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

public class ArraysParallelPrefix {
    public static void main(String[] args) {
        //the initial array
        int[] exampleArray = {1, 2, 3, 4, 5, 6};

        IntBinaryOperator addOperator = new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        };

        Arrays.parallelPrefix(exampleArray, addOperator);

        Arrays.parallelPrefix(exampleArray, ((left, right) -> left + right));
    }
}
