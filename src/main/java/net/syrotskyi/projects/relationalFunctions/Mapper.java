package net.syrotskyi.projects.relationalFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mapper {

    public void selectId() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] tokens = input.split("\t");
            String id = tokens[1];
            if ("user10".equals(id)) {
                System.out.println(input);
            }
            input = reader.readLine();
        }
    }

    public void printUrl() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] tokens = input.split("\t");
            System.out.println(tokens[2]);
            input = reader.readLine();
        }
    }
}
