package net.syrotskyi.projects.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mapper {

    public void map() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String keyNode = record[0];
            String keyNodeMinDist = record[1];
            String targetNodesRecord = record[2].replaceAll("[{}]", "");
            String[] targetNodes = null;
            System.out.println(input);
            if ("".equals(targetNodesRecord)) {

            } else {
                targetNodes = targetNodesRecord.split(",");
                for (String targetNode : targetNodes) {
                    String targetNodeMinDist = keyNodeMinDist.equals("INF") ?
                            "INF" : String.valueOf(Integer.valueOf(keyNodeMinDist) + 1);
                    System.out.println(targetNode + "\t" + targetNodeMinDist + "\t" + "{}");
                }
            }

            input = reader.readLine();
        }
    }
}
