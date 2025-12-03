package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartTwo {

    private static int position = 50;
    private static int result = 0;

    public static void calculatePassword() {
        long start = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader("src/day1/input"))) {
            String line;
            while ((line = br.readLine()) != null) {
                process(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        visualizeResult(System.currentTimeMillis() - start);
    }

    private static void visualizeResult(long msElapsed){
        System.out.println();
        System.out.println("=====PART-2=====");
        System.out.println("Password: " + result);;
        System.out.println("Elapsed time: " + msElapsed + "ms");
    }

    private static void process(String line) {
        position = addMore(position, Integer.parseInt(line
                .replace('L', '-')
                .replace('R', '0')));

    }

    private static int addMore(int x, int value){
        int y = x;
        for (int i = 0; i < Math.abs(value); i++){
            y = add(y, (int)(Math.signum(value)));
        }
        return y;
    }

    private static int add(int x, int value){
        int y = boundary(x+value);
        if(y == 0){
            result++;
        }
        return y;
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