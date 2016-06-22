package net.syrotskyi.projects.pageRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reducer {

    public void reduce() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String lastInitNode = "";
        String lastTargetNodesRecord = "";
        double accumulatedPageRank = 0;

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String initNode = record[0];
            double pageRank = 0;
            String targetNodesRecord = record[2].replaceAll("[{}]", "");
            if ("".equals(targetNodesRecord)) {
                pageRank = Double.valueOf(record[1]);
            }

            if ("".equals(lastInitNode)) {
                lastInitNode = initNode;
                accumulatedPageRank += pageRank;
                lastTargetNodesRecord = targetNodesRecord;
            } else if (lastInitNode.equals(initNode)) {
                accumulatedPageRank += pageRank;
                if (!"".equals(targetNodesRecord)) {
                    lastTargetNodesRecord = targetNodesRecord;
                }
            } else {
                System.out.printf("%s\t%.3f\t{%s}\n", lastInitNode, accumulatedPageRank, lastTargetNodesRecord);
                lastInitNode = initNode;
                accumulatedPageRank = pageRank;
                lastTargetNodesRecord = targetNodesRecord;
            }

            input = reader.readLine();
        }
        System.out.printf("%s\t%.3f\t{%s}\n", lastInitNode, accumulatedPageRank, lastTargetNodesRecord);
    }

    public void modReduce() throws IOException {
        double n = 5;
        double a = 0.1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String lastInitNode = "";
        String lastTargetNodesRecord = "";
        double accumulatedPageRank = 0;

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String initNode = record[0];
            double pageRank = 0;
            String targetNodesRecord = record[2].replaceAll("[{}]", "");
            if ("".equals(targetNodesRecord)) {
                pageRank = Double.valueOf(record[1]);
            }

            if ("".equals(lastInitNode)) {
                lastInitNode = initNode;
                accumulatedPageRank += pageRank;
                lastTargetNodesRecord = targetNodesRecord;
            } else if (lastInitNode.equals(initNode)) {
                accumulatedPageRank += pageRank;
                if (!"".equals(targetNodesRecord)) {
                    lastTargetNodesRecord = targetNodesRecord;
                }
            } else {
                accumulatedPageRank = a * (1 / n) + (1 - a) * accumulatedPageRank;
                System.out.printf("%s\t%.3f\t{%s}\n", lastInitNode, accumulatedPageRank, lastTargetNodesRecord);
                lastInitNode = initNode;
                accumulatedPageRank = pageRank;
                lastTargetNodesRecord = targetNodesRecord;
            }

            input = reader.readLine();
        }
        accumulatedPageRank = a * (1 / n) + (1 - a) * accumulatedPageRank;
        System.out.printf("%s\t%.3f\t{%s}\n", lastInitNode, accumulatedPageRank, lastTargetNodesRecord);

    }
}
