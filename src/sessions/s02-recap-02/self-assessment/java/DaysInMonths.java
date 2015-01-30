class DaysInMonths {

    final static int JAN = 1;
    final static int FEB = 2;
    final static int MAR = 3;
    final static int APR = 4;
    final static int MAY = 5;
    final static int JUN = 6;
    final static int JUL = 7;
    final static int AUG = 8;
    final static int SEP = 9;
    final static int OCT = 10;
    final static int NOV = 11;
    final static int DEC = 12;

    public static void main(String args[]) {
        try {
            for (int i=JAN; i<=DEC; i++) {
                System.out.println(i + " " + daysInMonth(i) +
                        " " + daysInMonth2(i));
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    static int daysInMonth(int month) throws Exception {
        if (month < JAN || month > DEC) {
            throw new Exception("Bad month: " + month);
        }

        int days;
        if (month == FEB) {
            days = 28;
        } else if (month == APR || month == JUN || month == SEP ||
                month == NOV) {
            days = 30;
        } else {
            days = 31;
        }
        return days;
    }

    static int daysInMonth2(int month) throws Exception {
        int days;
        switch (month) {
            case FEB: days=28;
                      break;
            case APR: case JUN: case SEP: case NOV:
                      days=30;
                      break;
            case JAN: case MAR: case MAY: case JUL: case AUG: case OCT: case DEC:
                      days=31;
                      break;
            default:
                      throw new Exception("Bad month: " + month);
        }
        return days;
    }
}
