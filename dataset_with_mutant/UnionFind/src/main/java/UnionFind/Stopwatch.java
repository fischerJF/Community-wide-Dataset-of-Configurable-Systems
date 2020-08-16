package UnionFind;
import specifications.Configuration;

public class Stopwatch {
	private  long start;

	public Stopwatch() {
		if (Configuration.tests) {
	        start = System.currentTimeMillis();
	    }
	}

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

}
