// to test theoric efficiency, run this program without
// optimizations, example:
//
//  java -Xint -Djava.compiler=NONE ODTime 100 100

import java.util.Random;
import java.util.NoSuchElementException;

class ODTime {
    private static final int EVEN = 0;
    private static final int ODD = 1;

    private static long seed;
    private static Random random;

    // returns 2xsize array of keys
    private static Integer[][] createKeys(int size) {
        Integer sorted[][] = new Integer[2][size];
        for (int i=0; i<2*size; i++) {
            if (i % 2 == 0) {
                sorted[EVEN][i/2] = i;
            } else {
                sorted[ODD][i/2] = i;
            }
        }
        return sorted;
    }

    private static void printArray(Integer[][] a) {
        for (int i=0; i<a[EVEN].length; i++) {
            if (i>0) {
                System.out.print(", ");
            }
            System.out.print(a[EVEN][i]);
        }
        System.out.println();
        for (int i=0; i<a[ODD].length; i++) {
            if (i>0) {
                System.out.print(", ");
            }
            System.out.print(a[ODD][i]);
        }
        System.out.println();
    }

    private static void swap(Integer[][] a, int i, int j) {
        Integer tmp = a[EVEN][j];
        a[EVEN][j] = a[EVEN][i];
        a[EVEN][i] = tmp;

        tmp = a[ODD][j];
        a[ODD][j] = a[ODD][i];
        a[ODD][i] = tmp;
    }

    private static void shuffle(Integer[][] a) {
        int cycles = 2;
        for (int j=0; j<cycles; j++) {
            for (int i=0; i<a[EVEN].length; i++) {
                swap(a, i, random.nextInt(a[EVEN].length));
            }
        }
    }

    private static void usage() {
        System.err.println("usage:");
        System.err.println("\tODTime size times [seed]");
        System.err.println();
        System.err.println("\t\tsize: the size of the dictionary.");
        System.err.println();
        System.err.println("\t\ttimes: how many times to insert and extract.");
        System.err.println();
        System.err.println("\t\tseed: the random seed to use,");
        System.err.println("\t\t      the current time is used if omitted.");
        System.exit(1);
    }

    private static long test(OrderedDictionary<Integer, Integer> od,
            Integer[][] keys, int size, int times) {
        od.clear();
        for (int i=0; i<keys[EVEN].length; i++) {
            od.insert(keys[EVEN][i], keys[EVEN][i]);
        }

        // measure insert a key not in the dict
        // and remove it
        Integer what;
        long startTime;
        long estimatedTime;
        long accumTime = 0;
        for (int i=0; i<times; i++) {
            // measure insertion of not pressent keys
            what = keys[ODD][i % keys[ODD].length];
            startTime = System.nanoTime();
            od.insert(what, what);
            od.remove(what);
            estimatedTime = System.nanoTime() - startTime;
            accumTime += estimatedTime;
        }
        long mean_nano = accumTime / times;
        long mean_microsecs = mean_nano / ((long) Math.pow(10, 3));
        return mean_microsecs;
    }

    public static void main(String args[]) {
        if (args.length < 2 || args.length > 3) {
            usage();
        }

        int size = 0;
        try {
            size = Integer.parseInt(args[0]);
        } catch (Exception ex) {
            usage();
        }

        int times = 0;
        try {
            times = Integer.parseInt(args[1]);
        } catch (Exception ex) {
            usage();
        }

        if (args.length > 2) {
            try {
                seed = Long.parseLong(args[2]);
            } catch (Exception ex) {
                usage();
            }
        } else {
            seed = System.currentTimeMillis();
        }
        random = new Random(seed);

        Integer[][] keys = createKeys(size);
        // printArray(keys);
        shuffle(keys);
        // printArray(keys);

        OrderedDictionary<Integer, Integer> od;
        long mean;

        // System.out.println("# size\ttimes\tseed\tAL\tLL\tSAL\tSLL\tBST");
        System.out.print("" + size + "\t" + times + "\t" + seed);

        od = new ODArrayList<Integer, Integer>();
        mean = test(od, keys, size, times);
        System.out.print("\t" + mean);

        od = new ODLinkedList<Integer, Integer>();
        mean = test(od, keys, size, times);
        System.out.print("\t" + mean);

        od = new ODSortedArrayList<Integer, Integer>();
        mean = test(od, keys, size, times);
        System.out.print("\t" + mean);

        od = new ODSortedLinkedList<Integer, Integer>();
        mean = test(od, keys, size, times);
        System.out.print("\t" + mean);

        od = new Bst<Integer, Integer>();
        mean = test(od, keys, size, times);
        System.out.print("\t" + mean);
        System.out.println();
    }
}
