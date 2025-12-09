package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartOne {

    public static void main(String[] args) {

        long result = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/day2/input"))) {

            List<String> lines = new ArrayList<>(List.of(br.readLine().split(",")));
            for (String line : lines) {
                String[] parts = line.split("-");
                for(long id = Long.parseLong(parts[0]); id<=Long.parseLong(parts[1]); id++){

                    if(String.valueOf(id).length()%2==1){
                        continue;
                    }

                    if(isInvalid(id)){
                        result += id;
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    private static boolean isInvalid(long id) {
        String whole = String.valueOf(id);
        String half = whole.substring(0, whole.length()/2);
        return whole.equals(half.repeat(2));
    }
}