class RollDice {
    private final static String SEPARATOR = "d";
    private final static String DIGIT_REGEX = "[0-9]+";

    private static Die[] parseArgs(String arg) throws Exception {
        if (! arg.matches(DIGIT_REGEX + SEPARATOR + DIGIT_REGEX)) {
            throw new Exception("ERROR: bad argument format");
        }

        String[] numbers = arg.split(SEPARATOR);
        int numDice = Integer.parseInt(numbers[0]);
        int sides = Integer.parseInt(numbers[1]);
        if (numDice < 1) {
            throw new Exception(
                    "ERROR: number of dices must be greater than 0");
        }

        Die[] dice = new Die[numDice];
        for (int i=0; i<numDice; i++) {
            dice[i] = new Die(sides);
        }
        return dice;
    }

    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("ERROR: wrong number of arguments");
            return;
        }

        Die[] dice;
        try {
            dice = parseArgs(args[0]);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return;
        }

        int sum = 0;
        for (int i=0; i<dice.length; i++) {
            sum += dice[i].roll();
        }

        System.out.println(sum);
    }
}
