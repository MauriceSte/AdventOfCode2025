package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartOne {

    private static int position = 50;
    private static int result = 0;

    public static void calculatePassword() {
        System.out.println();
        System.out.println("=====PART-1=====");
        long start = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader("src/day1/input"))) {
            String line;
            while ((line = br.readLine()) != null) {
                process(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long finish = System.currentTimeMillis();
        System.out.println("password: " + result);
        long time = finish - start;
        System.out.println("elapsed time: " + time + "ms");
    }

    private static void process(String line) {
        position += Integer.parseInt(line
                .replace('L', '-')
                .replace('R', '0'));
        position = boundary(position);
        if (position == 0) {
            result++;
        }
    }

    private static int boundary(int x) {
        while (x < 0) {
            x += 100;
        }
        while (x > 99) {
            x -= 100;
        }
        return x;
    }
}