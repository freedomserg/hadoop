package net.syrotskyi.projects.distinctValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mapper {

    public void map() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] tokens = input.split("\t");
            String number = tokens[0];
            String groups = tokens[1];
            String[] _groups = groups.split(",");

            for (String group : _groups) {
                System.out.println(number + "," + group + "\t" + 1);
            }

            input = reader.readLine();
        }
    }

    public void mapPhase2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] token = input.split(",");
            String group = token[1];
            System.out.println(group + "\t1");

            input = reader.readLine();
        }
    }
}
