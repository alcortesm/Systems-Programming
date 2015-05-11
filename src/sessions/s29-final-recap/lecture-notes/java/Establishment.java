class Establishment extends Estate {

    private double facadeLength; // in meters

    Establishment(String name, int age, double area, double facadeLength) {
        super(name, age, area);
        if (facadeLength <= 0D) {
            throw new IllegalArgumentException();
        }
        this.facadeLength = facadeLength;
    }

    public double calculateIBI() {
        if (age < 20) { // from the problem text
            return super.calculateIBI() * 1.1D; // from the problem text
        } else {
            return super.calculateIBI();
        }
    }

    public double calculateTRU() {
        return facadeLength * CityCouncilTaxes.FACADE_SUPPLEMENT;
    }
}
