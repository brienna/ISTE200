/**
 * Purpose:     Creates and runs two simple threads.
 *
 * @author Brienna Herold
 */
public class ThreadPe {

    private int count = 0;

    /** Begins the program */
    public static void main(String[] args) {
        new ThreadPe();
    }

    /** Create and run thread instances */
    public ThreadPe() {
        // Pick names for two threads
        String name1 = "First thread";
        String name2 = "Second thread";

        // Create two instances of inner class ThreadPeInner, passing names
        ThreadPeInner thread1 = new ThreadPeInner(name1);
        ThreadPeInner thread2 = new ThreadPeInner(name2);

        // Run threads in parallel
        thread1.start();
        thread2.start();

        // Wait until each thread has finished executing
        // (printed order for thread1 and thread2 may vary)
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Program finished, count = " + count);
    }

    /** Inner class representing a thread */
    class ThreadPeInner extends Thread {
        private String name;

        /** Constructs thread
         * @param _name the name of the thread
         */
        public ThreadPeInner(String _name) {
            name = _name;
        }

        /**
         * Executes stuff. When this method ends, the thread stops.
         */
        @Override
        public void run() {
            yield();  // let another thread that's ready to execute first
            System.out.println("This ran thread " + name);
            count++;
        }
    }

}
