package AwesomePasswordChecker;

import fr.isima.codereview.tp1.*;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void shouldReturnHelloWorldMessage() {
        String expected = "Hello, World!";
        String actual = "Hello, World!";
        assertEquals(expected, actual);
    }

    @Test
    public void testComputeMD5() {
        String input = "Hello World";
        String expectedMD5 = "b10a8db164e0754105b7a99be72e3fe5"; // Precomputed MD5 hash
        String actualMD5 = AwesomePasswordChecker.ComputeMD5(input);
        assertEquals(expectedMD5, actualMD5);
    }

    @Test
    public void testGetInstance() throws Exception {
        File file = new File("src/main/resources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker instance = AwesomePasswordChecker.getInstance(file);
        assertNotNull(instance);
    }

    @Test
    public void testGetInstanceWithDefaultResource() throws Exception {
        AwesomePasswordChecker instance = AwesomePasswordChecker.getInstance();
        assertNotNull(instance);
    }

    @Test
    public void testGetInstanceWithInputStream() throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker instance = AwesomePasswordChecker.getInstance(is);
        assertNotNull(instance);
    }

    @Test
    public void testGetDistance() throws Exception {
        File file = new File("src/main/resources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker instance = AwesomePasswordChecker.getInstance(file);
        String password = "Hello! World°02lk!;:487";
        double distance = instance.getDistance(password);
        assertTrue(distance >= 0);
    }

    @Test
    public void testGetDistanceWithEmptyPassword() throws Exception {
        File file = new File("src/main/resources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker instance = AwesomePasswordChecker.getInstance(file);
        String password = "";
        double distance = instance.getDistance(password);
        assertTrue(distance >= 0);
    }

    @Test
    public void testGetDistanceWithShortPassword() throws Exception {
        File file = new File("src/main/resources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker instance = AwesomePasswordChecker.getInstance(file);
        String password = "a";
        double distance = instance.getDistance(password);
        assertTrue(distance >= 0);
    }

    @Test
    public void testGetDistanceWithLongPassword() throws Exception {
        File file = new File("src/main/resources/cluster_centers_HAC_aff.csv");
        AwesomePasswordChecker instance = AwesomePasswordChecker.getInstance(file);
        String password = "a".repeat(100);
        double distance = instance.getDistance(password);
        assertTrue(distance >= 0);
    }

    @Test
    public void testGetInstanceWithInvalidFile() {
        File file = new File("invalid/path/to/file.csv");
        assertThrows(Exception.class, () -> {
            AwesomePasswordChecker.getInstance(file);
        });
    }

    // @Test
    // public void testComputeMD5Performance() {
    //     String input = "Hello World";
    //     int iterations = 1000000; // Number of iterations for the performance test

    //     long startTime = System.nanoTime();
    //     for (int i = 0; i < iterations; i++) {
    //         AwesomePasswordChecker.ComputeMD5(input);
    //     }
    //     long endTime = System.nanoTime();

    //     long duration = endTime - startTime;
    //     System.out.printf("Time taken for %d iterations: %d nanoseconds\n", iterations, duration);

    //     // Assert that the duration is within an acceptable range (e.g., less than 5 seconds)
    //     assertTrue(duration < 5_000_000_000L, "Performance test took too long");
    // }
    
}