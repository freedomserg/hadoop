package net.syrotskyi.projects.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reducer {

    public void reduce() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String lastKeyNode = "";
        String lastKeyNodeMinDist = "";
        String lastTargetNodesRecord = "";

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String keyNode = record[0];
            String keyNodeMinDist = record[1];
            String targetNodesRecord = record[2].replaceAll("[{}]", "");

            if ("".equals(lastKeyNode)) {
                lastKeyNode = keyNode;
                lastKeyNodeMinDist = keyNodeMinDist;
                lastTargetNodesRecord = targetNodesRecord;
            } else if (lastKeyNode.equals(keyNode)) {
                if (!"INF".equals(keyNodeMinDist)) {
                    int intKeyNodeMinDist = Integer.valueOf(keyNodeMinDist);
                    if (!lastKeyNodeMinDist.equals("INF")) {
                        int intLastKeyNodeMinDist = Integer.valueOf(lastKeyNodeMinDist);
                        if (intKeyNodeMinDist < intLastKeyNodeMinDist) {
                            lastKeyNodeMinDist = String.valueOf(intKeyNodeMinDist);
                        }
                    } else {
                        lastKeyNodeMinDist = String.valueOf(intKeyNodeMinDist);
                    }
                }
                if (!"".equals(targetNodesRecord)) {
                    lastTargetNodesRecord = targetNodesRecord;
                }
            } else {
                System.out.printf("%s\t%s\t{%s}\n", lastKeyNode, lastKeyNodeMinDist, lastTargetNodesRecord);
                lastKeyNode = keyNode;
                lastKeyNodeMinDist = keyNodeMinDist;
                lastTargetNodesRecord = targetNodesRecord;
            }

            input = reader.readLine();
        }
        System.out.printf("%s\t%s\t{%s}\n", lastKeyNode, lastKeyNodeMinDist, lastTargetNodesRecord);
    }
}
