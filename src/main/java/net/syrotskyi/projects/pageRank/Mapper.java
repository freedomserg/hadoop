package net.syrotskyi.projects.pageRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mapper {

    public void map() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String initNode = record[0];
            String initNodePageRank = record[1];
            String targetNodesRecord = record[2].replaceAll("[{}]", "");
            String[] targetNodes = null;
            System.out.println(input);
            if (!"".equals(targetNodesRecord)) {
                targetNodes = targetNodesRecord.split(",");
                for (String targetNode : targetNodes) {
                    String targetNodePageRank = String.format("%.3f", Double.valueOf(initNodePageRank) / targetNodes.length);
                    System.out.printf("%s\t%s\t{}\n", targetNode, targetNodePageRank);
                }
            }

            input = reader.readLine();
        }
    }
}
