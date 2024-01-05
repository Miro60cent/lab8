public class Main {
    public static void main(String[] args) {
        int numThreads = 2;
        ParallelMonteCarloPi program = new ParallelMonteCarloPi(numThreads);
        program.start();
    }
}