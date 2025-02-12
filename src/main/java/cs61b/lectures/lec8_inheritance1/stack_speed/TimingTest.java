package cs61b.lectures.lec8_inheritance1.stack_speed;


public class TimingTest {
    // Adjust these if you're running out of memory or time
    private static final int NUM_ITERATIONS = 1000;     // How many times to create and fill a new stack
    private static final int ITEMS_PER_STACK = 1_000_000; // How many items to push onto each stack

    public static void main(String[] args) {
        // Test ResizingArrayStack
        int x = 0;
        long startArray = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            Stack<Integer> stack = new ResizingArrayStack<>();
            for (int j = 0; j < ITEMS_PER_STACK; j++) {
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                x += stack.pop();
            }
        }
        System.out.println(x);
        long endArray = System.currentTimeMillis();
        System.out.println("ResizingArrayStack total time: " + (endArray - startArray) + " ms");

        // Test LinkedListStack
        long startLinked = System.currentTimeMillis();
        x = 0;

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            Stack<Integer> stack = new LinkedListStack<>();
            for (int j = 0; j < ITEMS_PER_STACK; j++) {
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                x += stack.pop();
            }
        }
        System.out.println(x);
        long endLinked = System.currentTimeMillis();
        System.out.println("LinkedListStack total time: " + (endLinked - startLinked) + " ms");
    }
}
