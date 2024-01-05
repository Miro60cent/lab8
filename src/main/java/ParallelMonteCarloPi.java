public class ParallelMonteCarloPi {
    private final int numThreads;
    private final int iterations;

    public ParallelMonteCarloPi(int numThreads) {
        this.numThreads = numThreads;
        this.iterations = 1_000_000_00;
    }

    public void start() {
        long startTime = System.currentTimeMillis();

        MonteCarloPiCalculator calculator = new MonteCarloPiCalculator(numThreads, iterations);
        double piApproximation = calculator.calculatePi();

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("PI is " + piApproximation);
        System.out.println("THREADS " + numThreads);
        System.out.println("ITERATIONS " + iterations);
        System.out.println("TIME " + elapsedTime / 1000 + "s");
    }
}

