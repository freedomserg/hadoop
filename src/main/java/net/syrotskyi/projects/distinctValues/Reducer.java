package net.syrotskyi.projects.distinctValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Reducer {

    public void reduce() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String lastKey = "";

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String key = record[0];

            if (lastKey.equals("") && !lastKey.equals(key)) {
                lastKey = key;
            } else if (!lastKey.equals(key)) {
                System.out.println(lastKey);
                lastKey = key;
            }

            input = reader.readLine();
        }

        System.out.println(lastKey);
    }

    public void reducePhase2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> groups = new HashMap<>();
        String input = reader.readLine();
        String lastNumber = "";
        String lastGroup = "";

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String number = record[0];
            String group = record[1];

            if (group.equals(lastGroup) && number.equals(lastNumber)) {
                input = reader.readLine();
            } else {
                if (groups.containsKey(group)) {
                    int oldValue = groups.get(group);
                    groups.put(group, oldValue + 1);
                } else {
                    groups.put(group, 1);
                }
                lastGroup = group;
                lastNumber = number;
                input = reader.readLine();
            }
        }

        for (Map.Entry<String, Integer> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
