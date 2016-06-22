package net.syrotskyi.projects.mapReduce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Mapper {

    public void countMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> countTokens = new HashMap<>();

        String input;
        input = reader.readLine();

        while (input != null && !"".equals(input)) {

            String[] tokens = input.split(" ");
            for (String token : tokens) {

                if (countTokens.containsKey(token)) {
                    int value = countTokens.get(token);
                    countTokens.put(token, ++value);
                } else {
                    countTokens.put(token, 1);
                }
            }

            input = reader.readLine();
        }

        for (Map.Entry<String, Integer> entry : countTokens.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + "\t" + value);
        }

    }
}
