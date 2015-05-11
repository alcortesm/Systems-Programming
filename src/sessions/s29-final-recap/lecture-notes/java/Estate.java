abstract class Estate implements CityCouncilTaxes {

    private String name;
    protected int age; // years since the building was built
    private double area; // in square meters

    Estate(String name, int age, double area) {
        if (name == null || age < 0 || area < 0D) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.area = area;
    }

    public double calculateIBI() {
        return area * CityCouncilTaxes.BASIC_IBI;
    }

    public abstract double calculateTRU();

    static void printAverageIBIMaxTRU(Estate data[]) {
        if (data == null) {
            throw new IllegalArgumentException();
        }

        // calculate average IBI and max TRU in only one loop
        double averageIBI;  // sum of all IBIs / estate count
        double sumIBI = 0D; // IBIs are always > 0D
        int estateCounter = 0;
        double maxTRU = 0D; // TRUs are always > 0D
        double currentTRU;  // avoid calculating twice
        for (int i=0; i<data.length; i++) {
            if (data[i] == null) {
                continue;
            }
            estateCounter++;
            sumIBI += data[i].calculateIBI();
            // BEWARE: Yoda conditional +
            // lvalue of assignment on next line
            // SUPER COMMON IDIOM!
            if (maxTRU < (currentTRU=data[i].calculateTRU())) {
                maxTRU = currentTRU;
            }
        }
        // IMPORTANT: avoid division by zero below
        if (estateCounter == 0) {
            throw new IllegalArgumentException();
        }
        averageIBI = sumIBI / (double) estateCounter;

        System.out.println("Average IBI = " + averageIBI);
        System.out.println("Maximum TRU = " + maxTRU);
    }

    static void printAverageIBIMaxTRU(List<Estate> data) {
        if (data == null || data.size() == 0) {
            throw new IllegalArgumentException();
        }

        // calculate average IBI and max TRU in only one loop
        double averageIBI;  // sum of all IBIs / size
        double sumIBI = 0D; // IBIs are always > 0D
        double maxTRU = 0D; // TRUs are always > 0D
        double currentTRU;  // avoid calculating twice
        Estate current;
        for (int i=0; i<data.size(); i++) {
            current = data.get(i); // avoid getting twice
            sumIBI += current.calculateIBI();
            if (maxTRU < (currentTRU=current.calculateTRU())) {
                maxTRU = currentTRU;
            }
        }
        averageIBI = sumIBI / (double) data.size();

        System.out.println("Average IBI = " + averageIBI);
        System.out.println("Maximum TRU = " + maxTRU);
    }
}
