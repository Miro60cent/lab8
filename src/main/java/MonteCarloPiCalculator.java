import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class MonteCarloPiCalculator {
    private final int numThreads;
    private final int iterations;

    public MonteCarloPiCalculator(int numThreads, int iterations) {
        this.numThreads = numThreads;
        this.iterations = iterations;
    }

    public double calculatePi() {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Long>> results = new ArrayList<>();

        IntStream.range(0, numThreads)
                .forEach(i -> {
                    int startIndex = i * (iterations / numThreads);
                    int endIndex = (i == numThreads - 1) ? iterations : (i + 1) * (iterations / numThreads);
                    Callable<Long> task = new MonteCarloPiTask(startIndex, endIndex);
                    results.add(executor.submit(task));
                });

        executor.shutdown();

        long totalInsideCircle = results.stream()
                .mapToLong(result -> {
                    try {
                        return result.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .sum();

        return (4.0 * totalInsideCircle) / iterations;
    }
}
