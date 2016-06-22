package net.syrotskyi.projects.mapReduce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reducer {

    public void countReduce() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sumPerSimilarKey = 0;
        int counterPerSimilarKey = 0;
        String lastKey = "";

        String input;
        input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] pair = input.split("\t");
            String key = pair[0];
            String value = pair[1];

            if ("".equals(lastKey)) {
                lastKey = key;
                sumPerSimilarKey = Integer.parseInt(value);
                counterPerSimilarKey++;
            } else if (lastKey != null && !"".equals(lastKey) && !lastKey.equals(key)) {
                int avg = sumPerSimilarKey / counterPerSimilarKey;
                System.out.println(lastKey + "\t" + avg);
                counterPerSimilarKey = 0;

                lastKey = key;
                sumPerSimilarKey = Integer.parseInt(value);
                counterPerSimilarKey++;
            } else {
                sumPerSimilarKey += Integer.parseInt(value);
                counterPerSimilarKey++;
            }
            input = reader.readLine();
        }

        int avg = sumPerSimilarKey / counterPerSimilarKey;
        System.out.println(lastKey + "\t" + avg);
    }
}
