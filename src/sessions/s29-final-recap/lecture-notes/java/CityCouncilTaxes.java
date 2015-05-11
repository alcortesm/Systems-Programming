interface CityCouncilTaxes {
    static final double BASIC_IBI = 10D;
    static final double FACADE_SUPPLEMENT = 20D;
    static final double ROOM_SUPPLEMENT = 15D;
    double calculateIBI(); // area (in square meters) * BASIC_IBI
    double calculateTRU(); // depends on the type of building
}
