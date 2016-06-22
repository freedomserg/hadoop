package net.syrotskyi.projects.crossCorrelation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Mapper {

    public void map() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] cortege = input.split(" ");

            for (String first : cortege) {
                for (String second : cortege) {
                    if (first.equals(second)) {
                        continue;
                    }
                    System.out.println(first + "," + second + "\t" + 1);
                }
            }
            input = reader.readLine();
        }
    }

    public void mapWithStripes() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] cortege = input.split(" ");

            for (String first : cortege) {
                Map<String, Integer> statistics = new HashMap<>();
                for (String second : cortege) {
                    if (first.equals(second)) {
                        continue;
                    }

                    if (statistics.containsKey(second)) {
                        int value = statistics.get(second);
                        statistics.put(second, value + 1);
                    } else {
                        statistics.put(second, 1);
                    }

                }
                System.out.print(first + "\t");
                int counter = 0;
                for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
                    System.out.print(entry.getKey() + ":" + entry.getValue());
                    counter++;
                    if (counter < statistics.size()) {
                        System.out.print(",");
                    } else {
                        System.out.println();
                    }
                }
            }
            input = reader.readLine();
        }
    }
}
