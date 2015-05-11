class Housing extends Estate {

    private int rooms;

    Housing(String name, int age, double area, int rooms) {
        super(name, age, area);
        if (rooms < 1) {
            throw new IllegalArgumentException();
        }
        this.rooms = rooms;
    }

    public double calculateIBI() {
        if (age < 10) { // from the problem text
            return super.calculateIBI() * 1.2D; // from the problem text
        } else {
            return super.calculateIBI();
        }
    }

    public double calculateTRU() {
        return rooms * CityCouncilTaxes.ROOM_SUPPLEMENT;
    }
}
