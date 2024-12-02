package AwesomePasswordChecker;

import fr.isima.codereview.tp1.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class BenchmarkTest {

    private static final int WARM_UP_ITERATIONS = 100_000; // Adjusted for more comprehensive warm-up
    private static final int MEASUREMENT_ITERATIONS = 1_000_000; // Maintain for better granularity
    private String input = "Hello World";

    @BeforeEach
    public void setUp() {
        // Run the method a few times to warm up the JVM and JIT compiler
        for (int i = 0; i < WARM_UP_ITERATIONS; i++) {
            AwesomePasswordChecker.ComputeMD5(input);
        }
    }

    @Test
    public void testComputeMD5Performance() {
        // Start timing
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASUREMENT_ITERATIONS; i++) {
            AwesomePasswordChecker.ComputeMD5(input);
        }
        long endTime = System.nanoTime();

        // Calculate the elapsed time in nanoseconds
        long duration = endTime - startTime;

        // Print the results
        System.out.printf("Time taken for %d iterations: %d nanoseconds\n", MEASUREMENT_ITERATIONS, duration);

        // Calculate average time per call
        double averageTimePerCall = (double) duration / MEASUREMENT_ITERATIONS;
        System.out.printf("Average time per call: %.2f nanoseconds\n", averageTimePerCall);

        // Adjust the performance threshold if needed
        assertTrue(duration < 6_000_000_000L, "Performance test took too long");
    }
}