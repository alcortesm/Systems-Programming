import java.util.Random;

class DaysOfTheWeek {
    static String SEPARATOR = ", ";
    static String TERMINATOR = ".";

    public static void main(String args[]) {
        System.out.println("DAYS OF THE WEEK:");
        print(daysOfTheWeek());
        System.out.println();
        System.out.println("IN REVERSE ORDER:");
        print(reverse(daysOfTheWeek()));
        System.out.println();
        System.out.println("IN REVERSE ALPHABETICAL ORDER:");
        print(reverse(sort(daysOfTheWeek())));
        System.out.println();
        System.out.println("FIVE PRINTS IN RANDOM ORDER:");
        print(shuffle(daysOfTheWeek()));
        print(shuffle(daysOfTheWeek()));
        print(shuffle(daysOfTheWeek()));
        print(shuffle(daysOfTheWeek()));
        print(shuffle(daysOfTheWeek()));
        System.out.println();
        System.out.println("SHUFFLE UNTIL SAME ORDER:");
        shuffleUntilSame(daysOfTheWeek());
    }

    static String[] daysOfTheWeek() {
        return new String[]{"Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"};
    }

    static void print(String[] a) {
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(SEPARATOR);
            } else {
                System.out.println(TERMINATOR);
            }
        }
    }

    static String[] reverse(String[] a) {
        String[] retval = new String[a.length];
        for (int i=0; i<a.length; i++) {
            retval[i] = a[a.length-1-i];
        }
        return retval;
    }

    static void swap(String[] a, int i, int j) {
        String tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    // simple bubble sort, not practical for big arrays
    static String[] sort(String[] a) {
        String[] retval = a.clone();

        if (retval.length < 2) {
            return retval;
        }

        for (int j=(retval.length-2); j>=0; j--) {
            for (int i=0; i<=j; i++) {
                if (retval[i].compareTo(retval[i+1]) > 0) {
                    swap(retval, i, i+1);
                }
            }
        }
        return retval;
    }

    static String[] shuffle(String[] a) {
        String[] retval = a.clone();
        Random random = new Random();
        for (int i=0; i<retval.length; i++) {
            swap(retval,
                    random.nextInt(retval.length),
                    random.nextInt(retval.length));
        }
        return retval;
    }

    static boolean sameOrder(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i=0; i<a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    static void shuffleUntilSame(String[] a) {
        String[] random = a.clone();
        do {
            random = shuffle(random);
            print(random);
        } while (! sameOrder(random, a));
    }
}
