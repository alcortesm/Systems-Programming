class EstateTest {

    private static void testIBI(Estate estate, double expectedIBI, String error) {
        double calculatedIBI = estate.calculateIBI();
        if (calculatedIBI != expectedIBI) {
            System.err.println(error +
                    " calculated = " + calculatedIBI +
                    ", expected = " + expectedIBI);
        }
    }

    private static void testTRU(Estate estate, double expectedTRU, String error) {
        double calculatedTRU = estate.calculateTRU();
        if (calculatedTRU != expectedTRU) {
            System.err.println(error +
                    " calculated = " + calculatedTRU +
                    ", expected = " + expectedTRU);
        }
    }

    public static void main(String args[]) {
        Estate h1 = new Housing("h1", 5, 100D, 1);
        Estate h2 = new Housing("h2", 10, 100D, 3);
        Estate e1 = new Establishment("e1", 15, 100D, 1D);
        Estate e2 = new Establishment("e2", 20, 100D, 2D);

        // test IBI
        testIBI(h1, 1200D, "ERROR h1 IBI");
        testIBI(h2, 1000D, "ERROR h2 IBI");
        testIBI(e1, 1100D, "ERROR e1 IBI");
        testIBI(e2, 1000D, "ERROR e2 IBI");

        // test TRU
        testTRU(h1, 15D, "ERROR h1 TRU");
        testTRU(h2, 45D, "ERROR h2 TRU");
        testTRU(e1, 20D, "ERROR e1 TRU");
        testTRU(e2, 40D, "ERROR e2 TRU");

        // test static print method
        Estate[] data = {null, h1, h2, null, e1, null, e2};
        Estate.printAverageIBIMaxTRU(data);

        // test static print over a list
        List<Estate> list = new LinkedList<Estate>();
        list.add(0, h1); list.add(1, h2); list.add(2, e1); list.add(3, e2);
        Estate.printAverageIBIMaxTRU(list);

        // must print :
        //   Average IBI = 1075.0
        //   Maximum TRU = 45.0
    }
}
