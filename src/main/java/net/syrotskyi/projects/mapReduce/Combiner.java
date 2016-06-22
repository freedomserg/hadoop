package net.syrotskyi.projects.mapReduce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combiner {

    public void combine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sumPerSimilarKey = 0;
        int counterPerSimilarKey = 0;
        String lastKey = "";

        String input;
        input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] pair = input.split("\t");
            String key = pair[0];
            String time_count = pair[1];
            String[] subPair = time_count.split(";");
            String value = subPair[0];

            if ("".equals(lastKey)) {
                lastKey = key;
                sumPerSimilarKey = Integer.parseInt(value);
                counterPerSimilarKey++;
            } else if (lastKey != null && !"".equals(lastKey) && !lastKey.equals(key)) {
                System.out.println(lastKey + "\t" + sumPerSimilarKey + ";" + counterPerSimilarKey);
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

        System.out.println(lastKey + "\t" + sumPerSimilarKey + ";" + counterPerSimilarKey);
    }
}
