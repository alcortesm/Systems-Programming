import java.util.Random;

class SixSidedDie {
    private Random random = new Random();

    public int roll() {
        return 1 + random.nextInt(6);
    }
}
