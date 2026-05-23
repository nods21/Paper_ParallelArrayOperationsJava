package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread) //each Thread will create a new instance of this object
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
public class GranularityBenchmark
{
    @Param({"1000", "2000", "3000", "4090", "4100", "5000", "6000", "7000"})
    private int size;

    private int[] sortingArray;

    private final int RANDOM_SEED = 42;


    //Generate a new array before every benchmark call
    @Setup(Level.Invocation)
    public void setup() {
        //Use a final seed for comparable results of sequential and parallel sort
        sortingArray =
                new Random(RANDOM_SEED)
                .ints(size)
                .toArray();
    }

    @Benchmark
    public void benchmarkParallelSort() {
        Arrays.parallelSort(sortingArray);
    }
}