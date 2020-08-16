package telecom;

/**
 * Simple timer machine used to record elapsed time
 */
public class Timer {
    
    public long startTime, stopTime;

    /**
     * set the start time
     */
    public void start() {
        startTime = System.currentTimeMillis();
        stopTime = startTime;
    }

    /**
     * set the end time
     */
    public void stop() {
        stopTime = System.currentTimeMillis();
    }

    /**
     * set how much time passed between last start and stop?
     */
    public long getTime() {
        return stopTime - startTime;
    }
}


