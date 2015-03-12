// This is by no means a complete test of List implementations, but it is good
// enough to get a hint how good is your imlementation.
//
// This test has 12 test cases, described bellow.
//
// There are much better ways of doing this kind of testing but they are out
// of the scope of this course.
//
// I will be using Integers as the class for generics so I can use autoboxing
// and unboxing in my tests.

import java.util.NoSuchElementException;

class ListTest {
    private static final String ARRAY_LIST = "AL";
    private static final String LINKED_LIST = "LL";

    private static String implementation;

    public static void main(String[] args) {
        if (args.length == 1
                && (args[0].equals(ARRAY_LIST)
                    || args[0].equals(LINKED_LIST))) {
            implementation = args[0];
        } else {
            System.err.println(
                    "ERROR: this program needs one argument: " +
                    ARRAY_LIST + " or " + LINKED_LIST);
            System.exit(-1);
        }

        runTests();
    }

    private static void runTests() {
        if (! test001()) { // ctor
            return;
        }
        if (! test002()) { // size of empty
            return;
        }
        if (! test003()) { // isEmpty of empty
            return;
        }
        if (! test004()) { // add at the beginning and set
            return;
        }
        if (! test005()) { // add at the end
            return;
        }
        if (! test006()) { // add at random
            return;
        }
        if (! test007()) { // clear
            return;
        }
        if (! test008()) { // sets
            return;
        }
        if (! test009()) { // remove
            return;
        }
        if (! test010()) { // contains
            return;
        }
        if (! test011()) { // indexOf
            return;
        }
        if (! test012()) { // exceptions
            return;
        }
    }

    private static <E> List<E> newList() {
        List<E> l;
        switch (implementation) {
            case ARRAY_LIST:
                l = new ArrayList<E>();
                break;
            case LINKED_LIST:
                l = new LinkedList<E>();
                break;
            default:
                throw new TypeNotPresentException(
                    "Unexpected implementantion: " + implementation, null);
        }
        return l;
    }

    // constructor
    private static boolean test001() {
        try {
            List<Integer> list = newList();
            System.out.println("OK: test001");
            return true;
        } catch (Exception e) {
            System.out.println("ERROR: test001: " + e);
            return false;
        }
    }

    // size of empty
    private static boolean test002() {
        List<Integer> list = newList();
        if (list.size() != 0) {
            System.out.println("ERROR: test002");
            return false;
        } else {
            System.out.println("OK: test002");
            return true;
        }
    }

    // isEmpty of empty
    private static boolean test003() {
        List<Integer> list = newList();
        if (list.isEmpty()) {
            System.out.println("OK: test003");
            return true;
        } else {
            System.out.println("ERROR: test003");
            return false;
        }
    }

    private static class JavaArrayList<E> extends java.util.ArrayList<E> {
        public String toString() {
            StringBuilder sb = new StringBuilder("LIST[ ");
            for (int i=0; i<size(); i++) {
                sb.append(get(i));
                if (i != size()-1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public boolean equals(List<E> list) {
            if (size() != list.size()) {
                return false;
            }
            // compare each element
            // ouch, we really need an iterator here,
            // but it is out of the scope of this course
            for (int i=0; i<size(); i++) {
                if (! get(i).equals(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    // add at the end & gets
    private static boolean test004() {
        int n = 1000;
        List<Integer> list = newList();
        JavaArrayList<Integer> java = new JavaArrayList<Integer>();
        if (! java.equals(list)) {
            System.out.println("ERROR: test004: "
                    + " java: " + java
                    + " mine: " + list);
            return false;
        }
        for (int i=0; i<n; i++) {
            list.add(list.size(), i);
            java.add(java.size(), i);
            if (! java.equals(list)) {
                System.out.println("ERROR: test004: "
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
        }
        System.out.println("OK: test004");
        return true;
    }

    // add at the beginning
    private static boolean test005() {
        int n = 1000;
        List<Integer> list = newList();
        JavaArrayList<Integer> java = new JavaArrayList<Integer>();
        for (int i=0; i<n; i++) {
            list.add(0, i);
            java.add(0, i);
            if (! java.equals(list)) {
                System.out.println("ERROR: test005: "
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
        }
        System.out.println("OK: test005");
        return true;
    }

    // returns an array of ints of size "size",
    // each int is a random number between 0 and its index (included)
    private static int[] randomIntArray(int size) {
        java.util.Random randomGenerator = new java.util.Random();
        int[] array = new int[size];
        for (int i=0; i<size; i++) {
            array[i] = randomGenerator.nextInt(i+1);
        }
        return array;
    }

    // returns a List with numbers added according to pos
    private static List<Integer> randomList(int[] pos) {
        List<Integer> list = newList();
        for (int i=0; i<pos.length; i++) {
            list.add(pos[i], i);
        }
        return list;
    }

    // returns a Java ArrayList with numbers added according to pos
    private static JavaArrayList<Integer> randomJava(int[] pos) {
        JavaArrayList<Integer> java = new JavaArrayList<Integer>();
        for (int i=0; i<pos.length; i++) {
            java.add(pos[i], i);
        }
        return java;
    }

    // add at random
    private static boolean test006() {
        int[] random = randomIntArray(1000);
        List<Integer> list = randomList(random);
        JavaArrayList<Integer> java = randomJava(random);
        if (! java.equals(list)) {
            System.out.println("ERROR: test006:"
                    + " java: " + java
                    + " mine: " + list);
            return false;
        } else {
            System.out.println("OK: test006");
            return true;
        }
    }

    // clear
    private static boolean test007() {
        {
            List<Integer> list = newList();
            JavaArrayList<Integer> java = new JavaArrayList<Integer>();
            list.clear();
            java.clear();
            if ((list.size() != java.size())
                    || (list.isEmpty() != java.isEmpty())
                    || ! java.equals(list)) {
                System.out.println("ERROR: test007:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
                    }
        }

        {
            List<Integer> list = newList();
            JavaArrayList<Integer> java = new JavaArrayList<Integer>();
            list.add(0, 45);
            java.add(0, 12);
            java.add(1, 23);
            list.clear();
            java.clear();
            if ((list.size() != java.size())
                    || (list.isEmpty() != java.isEmpty())
                    || ! java.equals(list)) {
                System.out.println("ERROR: test007:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
                    }
        }

        {
            int[] random1 = randomIntArray(1000);
            int[] random2 = randomIntArray(40);

            List<Integer> list = randomList(random1);
            JavaArrayList<Integer> java = randomJava(random2);

            list.clear();
            java.clear();

            if ((list.size() != java.size())
                    || (list.isEmpty() != java.isEmpty())
                    || ! java.equals(list)) {
                System.out.println("ERROR: test007:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
                    }
        }
        System.out.println("OK: test007");
        return true;
    }

    // sets
    private static boolean test008() {
        {
            List<Integer> list = newList();
            JavaArrayList<Integer> java = new JavaArrayList<Integer>();

            list.add(0,0); java.add(0,0);
            list.set(0, 9999); java.set(0, 9999);
            if (! java.equals(list)) {
                System.out.println("ERROR: test008:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }

            list.add(1,1); java.add(1,1);
            list.set(0, 8888); java.set(0, 8888);
            if (! java.equals(list)) {
                System.out.println("ERROR: test008:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }

            list.set(1, 7777); java.set(1, 7777);
            if (! java.equals(list)) {
                System.out.println("ERROR: test008:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }

            list.add(2,2); java.add(2,2);
            list.set(0, 1000); java.set(0, 1000);
            list.set(1, 1001); java.set(1, 1001);
            list.set(2, 1002); java.set(2, 1002);
            list.set(1, 1004); java.set(1, 1004);
            if (! java.equals(list)) {
                System.out.println("ERROR: test008:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }

            list.clear(); java.clear();
            list.add(0,0); java.add(0,0);
            list.add(1,1); java.add(1,1);
            list.add(2,2); java.add(2,2);
            list.set(0, 1000); java.set(0, 1000);
            list.set(1, 1001); java.set(1, 1001);
            list.set(2, 1002); java.set(2, 1002);
            list.set(1, 1004); java.set(1, 1004);
            if (! java.equals(list)) {
                System.out.println("ERROR: test008:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
        }

        {
            int[] random = randomIntArray(1000);
            List<Integer> list = randomList(random);
            JavaArrayList<Integer> java = randomJava(random);
            int[] random2 = randomIntArray(1000);
            for (int i=0; i<random2.length; i++) {
                list.set(random2[i], i);
                java.set(random2[i], i);
            }
            if (! java.equals(list)) {
                System.out.println("ERROR: test008:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
        }
        System.out.println("OK: test008");
        return true;
    }

    // remove
    private static boolean test009() {
        {
            List<Integer> list = newList();
            JavaArrayList<Integer> java = new JavaArrayList<Integer>();
            list.add(0,0); java.add(0,0);
            Integer a = list.remove(0);
            Integer b = java.remove(0);
            if (! java.equals(list)) {
                System.out.println("ERROR: test009:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
            if (! a.equals(b)) {
                System.out.println("ERROR: test009:"
                        + " java: " + b
                        + " mine: " + a);
                return false;
            }
        }

        {
            List<Integer> list = newList();
            JavaArrayList<Integer> java = new JavaArrayList<Integer>();
            list.add(0,0); java.add(0,0);
            list.add(1,1); java.add(1,1);
            Integer a = list.remove(0);
            Integer b = java.remove(0);
            if (! java.equals(list)) {
                System.out.println("ERROR: test009:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
            if (! a.equals(b)) {
                System.out.println("ERROR: test009:"
                        + " java: " + b
                        + " mine: " + a);
                return false;
            }
            a = list.remove(0);
            b = java.remove(0);
            if (! java.equals(list)) {
                System.out.println("ERROR: test009:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
            if (! a.equals(b)) {
                System.out.println("ERROR: test009:"
                        + " java: " + b
                        + " mine: " + a);
                return false;
            }
        }
        { // remove from the head
            int[] random = randomIntArray(1000);
            List<Integer> list = randomList(random);
            JavaArrayList<Integer> java = randomJava(random);
            int size = java.size();
            for (int i=0; i<size; i++) {
                Integer a = list.remove(0);
                Integer b = java.remove(0);
                if (! java.equals(list)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + java
                            + " mine: " + list);
                    return false;
                }
                if (! a.equals(b)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + b
                            + " mine: " + a);
                    return false;
                }
            }
        }

        { // remove from the tail
            int[] random = randomIntArray(1000);
            List<Integer> list = randomList(random);
            JavaArrayList<Integer> java = randomJava(random);
            int size = java.size();
            for (int i=0; i<size; i++) {
                Integer a = list.remove(list.size()-1);
                Integer b = java.remove(java.size()-1);
                if (! java.equals(list)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + java
                            + " mine: " + list);
                    return false;
                }
                if (! a.equals(b)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + b
                            + " mine: " + a);
                    return false;
                }
            }
        }

        { // remove from random
            int[] random = randomIntArray(1000);
            List<Integer> list = randomList(random);
            JavaArrayList<Integer> java = randomJava(random);
            int size = java.size();
            java.util.Random randomGenerator = new java.util.Random();
            for (int i=0; i<size; i++) {
                int where = randomGenerator.nextInt(list.size());
                Integer a = list.remove(where);
                Integer b = java.remove(where);
                // System.out.println(a + " " + b);
                if (! java.equals(list)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + java
                            + " mine: " + list);
                    return false;
                }
                if (! a.equals(b)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + b
                            + " mine: " + a);
                    return false;
                }
            }
        }

        { // random adds and random removes
            int[] random = randomIntArray(100);
            List<Integer> list = randomList(random);
            JavaArrayList<Integer> java = randomJava(random);
            int size = java.size();
            java.util.Random randomGenerator = new java.util.Random();
            for (int i=0; i<size/2; i++) {
                int where = randomGenerator.nextInt(list.size());
                Integer a = list.remove(where);
                Integer b = java.remove(where);
                // System.out.println(a + " " + b);
                if (! java.equals(list)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + java
                            + " mine: " + list);
                    return false;
                }
                if (! a.equals(b)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + b
                            + " mine: " + a);
                    return false;
                }
            }
            random = randomIntArray(100);
            for (int i=0; i<random.length; i++) {
                list.add(random[i], i);
                java.add(random[i], i);
                if (! java.equals(list)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + java
                            + " mine: " + list);
                    return false;
                }
            }
            size = java.size();
            for (int i=0; i<size/2; i++) {
                int where = randomGenerator.nextInt(list.size());
                Integer a = list.remove(where);
                Integer b = java.remove(where);
                //System.out.println(a + " " + b);
                if (! java.equals(list)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + java
                            + " mine: " + list);
                    return false;
                }
                if (! a.equals(b)) {
                    System.out.println("ERROR: test009:"
                            + " java: " + b
                            + " mine: " + a);
                    return false;
                }
            }
        }
        System.out.println("OK: test009");
        return true;
    }

    // contains
    private static boolean testContains(int size) {
        int[] random = randomIntArray(size);
        List<Integer> list = randomList(random);
        JavaArrayList<Integer> java = randomJava(random);
        java.util.Random randomGenerator = new java.util.Random();
        for (int i=0; i<size/2; i++) {
            int where = randomGenerator.nextInt(list.size());
            list.remove(where);
            java.remove(where);
        }
        random = randomIntArray(2*size);
        for (int i=0; i<random.length; i++) {
            list.add(random[i], i);
            java.add(random[i], i);
        }
        size = java.size();
        for (int i=0; i<size/2; i++) {
            int where = randomGenerator.nextInt(list.size());
            list.remove(where);
            java.remove(where);
        }
        for (int i=0; i<java.size(); i++) {
            if (list.contains(i) != java.contains(new Integer(i))) {
                System.out.println("ERROR: test010:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
        }
        if (list.contains(-1) != java.contains(new Integer(-1))) {
            System.out.println("ERROR: test010:"
                    + " java: " + java
                    + " mine: " + list);
            return false;
        }
        return true;
    }

    private static boolean test010() {
        boolean pass = testContains(0);
        pass &= testContains(1);
        pass &= testContains(2);
        pass &= testContains(3);
        pass &= testContains(4);
        pass &= testContains(45);
        pass &= testContains(1000);
        if (pass) {
            System.out.println("OK: test010");
            return true;
        } else {
            return false;
        }
    }

    // indexOf
    private static boolean testIndexOf(int size) {
        int[] random = randomIntArray(size);
        List<Integer> list = randomList(random);
        JavaArrayList<Integer> java = randomJava(random);
        java.util.Random randomGenerator = new java.util.Random();
        for (int i=0; i<size/2; i++) {
            int where = randomGenerator.nextInt(list.size());
            list.remove(where);
            java.remove(where);
        }
        random = randomIntArray(2*size);
        for (int i=0; i<random.length; i++) {
            list.add(random[i], i);
            java.add(random[i], i);
        }
        size = java.size();
        for (int i=0; i<size/2; i++) {
            int where = randomGenerator.nextInt(list.size());
            list.remove(where);
            java.remove(where);
        }
        for (int i=0; i<java.size(); i++) {
            Integer data = java.get(i);
            if (list.indexOf(data) != java.indexOf(data)) {
                System.out.println("ERROR: test011:"
                        + " java: " + java
                        + " mine: " + list);
                return false;
            }
        }
        return true;
    }

    private static boolean test011() {
        boolean pass = testIndexOf(0);
        pass &= testIndexOf(1);
        pass &= testIndexOf(2);
        pass &= testIndexOf(3);
        pass &= testIndexOf(4);
        pass &= testIndexOf(45);
        pass &= testIndexOf(1000);
        if (pass) {
            System.out.println("OK: test011");
            return true;
        } else {
            return false;
        }
    }

    private static boolean test012() {
        // add when i < 0
        {
            List<Integer> list = newList();
            try {
                list.add(-1, 0);
                System.out.println("ERROR: test012: add with negative index");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: add with negative index");
                System.out.println(ex);
                return false;
            }
        }
        // add a null
        {
            List<Integer> list = newList();
            try {
                list.add(0, null);
                System.out.println("ERROR: test012: add a null");
                return false;
            } catch (NullPointerException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: add a null");
                System.out.println(ex);
                return false;
            }
            try {
                list.add(0, 0);
                list.add(1, null);
                System.out.println("ERROR: test012: add a null");
                return false;
            } catch (NullPointerException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: add a null");
                System.out.println(ex);
                return false;
            }
        }
        // add when i > size
        {
            List<Integer> list = newList();
            try {
                list.add(1, 0);
                System.out.println("ERROR: test012: add with index too big");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: add with index too big");
                System.out.println(ex);
                return false;
            }
        }
        // remove negative index
        {
            List<Integer> list = newList();
            try {
                list.add(0, 0);
                list.remove(-1);
                System.out.println("ERROR: test012: remove with negative index");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: remove with negative index");
                System.out.println(ex);
                return false;
            }
            try {
                list.add(1, 1);
                list.remove(-1);
                System.out.println("ERROR: test012: remove with negative index");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: remove with negative index");
                System.out.println(ex);
                return false;
            }
        }
        // get negative index
        {
            List<Integer> list = newList();
            try {
                list.get(-1);
                System.out.println("ERROR: test012: get with negative index");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: get with negative index");
                System.out.println(ex);
                return false;
            }
            try {
                list.add(0, 0);
                list.get(-1);
                System.out.println("ERROR: test012: get with negative index");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: get with negative index");
                System.out.println(ex);
                return false;
            }
        }
        // get index too big
        {
            List<Integer> list = newList();
            try {
                list.get(0);
                System.out.println("ERROR: test012: get with index too big");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: get with index too big");
                System.out.println(ex);
                return false;
            }
            try {
                list.add(0, 0);
                list.get(1);
                System.out.println("ERROR: test012: get with index too big");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: get with index too big");
                System.out.println(ex);
                return false;
            }
        }
        // set negative index
        {
            List<Integer> list = newList();
            try {
                list.set(-1, 0);
                System.out.println("ERROR: test012: set with negative index");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: set with negative index");
                System.out.println(ex);
                return false;
            }
            try {
                list.add(0, 0);
                list.set(-1, 0);
                System.out.println("ERROR: test012: set with negative index");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: set with negative index");
                System.out.println(ex);
                return false;
            }
        }
        // set index too big
        {
            List<Integer> list = newList();
            try {
                list.set(0, 0);
                System.out.println("ERROR: test012: set with index too big");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: set with index too big");
                System.out.println(ex);
                return false;
            }
            try {
                list.add(0, 0);
                list.set(1, 0);
                System.out.println("ERROR: test012: set with index too big");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: set with index too big");
                System.out.println(ex);
                return false;
            }
        }
        // set a null
        {
            List<Integer> list = newList();
            try {
                list.add(0, 0);
                list.set(1, null);
                System.out.println("ERROR: test012: set with index too big");
                return false;
            } catch (IndexOutOfBoundsException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: set with index too big");
                System.out.println(ex);
                return false;
            }
        }
        // indexOf when it does not exits
        {
            List<Integer> list = newList();
            try {
                list.indexOf(-1);
                System.out.println("ERROR: test012: indexOf");
                return false;
            } catch (NoSuchElementException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: indexOf");
                System.out.println(ex);
                return false;
            }
            list.add(0,0);
            try {
                list.indexOf(-1);
                System.out.println("ERROR: test012: indexOf");
                return false;
            } catch (NoSuchElementException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: indexOf");
                System.out.println(ex);
                return false;
            }
            int[] random = randomIntArray(100);
            list = randomList(random);
            try {
                list.indexOf(-1);
                System.out.println("ERROR: test012: indexOf");
                return false;
            } catch (NoSuchElementException ex) {
            } catch (Exception ex) {
                System.out.println("ERROR: test012: indexOf");
                System.out.println(ex);
                return false;
            }
        }
        System.out.println("OK: test012");
        return true;
    }
}
