package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread) //each Thread will create a new instance of this object
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class ArraySortBenchmark
{
    @Param({"10", "1000", "100000", "10000000"})
    private int size;

    private int[] sortingArray;

    private final int RANDOM_SEED = 42;


    //Generate a new array before every benchmark call
    @Setup(Level.Invocation)
    public void setup() {
        //Use a final seed for comparable results of sequential and parallel sort
        sortingArray = new Random(RANDOM_SEED).ints(size).toArray();
    }

    @Benchmark
    public void benchmarkSequentialSort() {
        Arrays.sort(sortingArray);
    }

    @Benchmark
    public void benchmarkParallelSort() {
        Arrays.parallelSort(sortingArray);
    }
}