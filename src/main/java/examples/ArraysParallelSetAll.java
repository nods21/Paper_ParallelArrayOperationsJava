package examples;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class ArraysParallelSetAll {
    static public void main(String[] args)
    {
        //array with example values
        int[] exampleArray = {4, 2, 11, 8, 3, 7};

        //new IntUnaryOperator and override the methods which will be called by parallelSetAll()
        IntUnaryOperator squaringGen = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * operand;
            }
        };

        Arrays.parallelSetAll(exampleArray, squaringGen);

        //input with lambda expression
        Arrays.parallelSetAll(exampleArray, (x) -> x * x);
    }
}
