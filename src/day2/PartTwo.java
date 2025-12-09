package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartTwo {

    public static void main(String[] args) {

        long result = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/day2/input"))) {

            List<String> lines = new ArrayList<>(List.of(br.readLine().split(",")));
            for (String line : lines) {
                String[] parts = line.split("-");
                for(long id = Long.parseLong(parts[0]); id<=Long.parseLong(parts[1]); id++){

                    for(int divisor : getPossibleLengthDivisors(id)){
                        if(isInvalid(id, divisor)){
                            result += id;
                            break;
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    private static boolean isInvalid(long id, int divisor) {
        String whole = String.valueOf(id);
        String half = whole.substring(0, whole.length()/divisor);
        return whole.equals(half.repeat(divisor));
    }

    private static List<Integer> getPossibleLengthDivisors(long id) {
        List<Integer> divisors = new ArrayList<>();
        for(int d = 2; d <= String.valueOf(id).length(); d++){
            double candidate = (double) String.valueOf(id).length() /d;
            if((int)candidate==candidate){
                divisors.add(d);
            }
        }
        return divisors;
    }
}