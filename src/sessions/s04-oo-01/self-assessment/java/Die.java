import java.util.Random;

class Die {
    private int sides;
    private Random random;
    private static final int MIN_SIDES = 2;
    private static int diceCounter = 0; // for later exercise

    public Die() throws Exception {
        this(6);
    }

    public Die(int n) throws Exception {
        if (n < MIN_SIDES) {
            throw new Exception(
                    "ERROR: number of sides must be >= " + MIN_SIDES);
        }
        this.sides = n;
        this.random = new Random();
        this.diceCounter++; // for later exercise
    }

    public int roll() {
        return 1 + random.nextInt(sides);
    }

    // for later exercise
    public static int howMany() {
        return Die.diceCounter;
    }
}
