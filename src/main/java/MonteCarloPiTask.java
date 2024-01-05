import java.util.concurrent.Callable;

public class MonteCarloPiTask implements Callable<Long> {
    private final int startIndex;
    private final int endIndex;

    public MonteCarloPiTask(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public Long call() {
        long insideCircle = 0;
        for (int i = startIndex; i < endIndex; i++) {
            double x = Math.random();
            double y = Math.random();

            double distance = Math.sqrt(x * x + y * y);

            if (distance <= 1.0) {
                insideCircle++;
            }
        }

        return insideCircle;
    }
}