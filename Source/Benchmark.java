import org.openjdk.jmh.annotations.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class ArraySortBenchmark
{
    @Param({10, 100, 1000, 10000, 1000000})
    private int size;

    @Benchmark
    public void benchmarkSequentialSort()
    {

    }
}