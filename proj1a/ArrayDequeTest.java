public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static <T> boolean checkSize(T expected, T actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /*
     * Prints a nice message based on whether a test passed. The \n means newline.
     */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque array = new ArrayDeque();
        boolean passed = checkEmpty(true, array.isEmpty());
        array.addFirst("front");
        passed = checkSize(1, array.getSize()) && passed;
        array.addLast("middle");
        passed = checkSize(2, array.getSize()) && passed;
        array.addLast("back");
        passed = checkSize(3, array.getSize()) && passed;

        passed = checkSize("front", array.get(0)) && passed;
        passed = checkSize("middle", array.get(1)) && passed;
        passed = checkSize("back", array.get(2)) && passed;

        passed = checkSize(null, array.get(3)) && passed;

        System.out.println("Printing out deque: ");
        array.printDeque();

        printTestStatus(passed);
    }

    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        ArrayDeque<Integer> array = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, array.isEmpty());

        array.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, array.isEmpty()) && passed;

        array.removeFirst();
        // should be empty
        passed = checkEmpty(true, array.isEmpty()) && passed;

        printTestStatus(passed);

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}
