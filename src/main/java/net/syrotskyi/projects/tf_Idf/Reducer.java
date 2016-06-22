package net.syrotskyi.projects.tf_Idf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reducer {

    public void reduceFirst() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String lastWord = "";
        String lastDocNum = "";
        int counter = 0;

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String pair = record[0];
            String word = pair.split("#")[0];
            String docNum = pair.split("#")[1];

            if ("".equals(lastWord) && "".equals(lastDocNum)) {
                lastWord = word;
                lastDocNum = docNum;
            } else if (lastWord.equals(word) && lastDocNum.equals(docNum)) {

            } else if (lastWord.equals(word) && !lastDocNum.equals(docNum)) {
                System.out.println(lastWord + "\t" + lastDocNum + "\t" + counter);
                counter = 0;
                lastDocNum = docNum;
            } else if (!lastWord.equals(word)) {
                System.out.println(lastWord + "\t" + lastDocNum + "\t" + counter);
                counter = 0;
                lastWord = word;
                lastDocNum = docNum;
            }
            counter++;
            input = reader.readLine();
        }
        System.out.println(lastWord + "\t" + lastDocNum + "\t" + counter);
    }

    public void reduceSecond() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> similarWords = new ArrayList<>();
        String lastWord = "";
        String lastDocNum = "";
        String lastTf = "";
        int counter = 0;

        String input = reader.readLine();
        while (input != null && !"".equals(input)) {
            String word = input.split("\t")[0];
            String[] wordData = input.split("\t")[1].split(";");
            String docNum = wordData[0];
            String tf = wordData[1];

            if ("".equals(lastWord)) {
                lastWord = word;
                lastDocNum = docNum;
                lastTf = tf;
            } else if (lastWord.equals(word)) {
                String outputRecord = String.format("%s#%s\t%s", lastWord, lastDocNum, lastTf);
                similarWords.add(outputRecord);
                lastWord = word;
                lastDocNum = docNum;
                lastTf = tf;
            } else {

                if (similarWords.size() > 0) {
                    for (String record : similarWords) {
                        System.out.printf("%s\t%s\n", record, counter);
                    }
                    similarWords.clear();
                    System.out.printf("%s#%s\t%s\t%s\n", lastWord, lastDocNum, lastTf, counter);
                } else {
                    System.out.printf("%s#%s\t%s\t%s\n", lastWord, lastDocNum, lastTf, counter);
                }

                lastWord = word;
                lastDocNum = docNum;
                lastTf = tf;
                counter = 0;
            }
            counter++;
            input = reader.readLine();
        }

        if (similarWords.size() > 0) {
            for (String record : similarWords) {
                System.out.printf("%s\t%s\n", record, counter);
            }
            similarWords.clear();
            System.out.printf("%s#%s\t%s\t%s\n", lastWord, lastDocNum, lastTf, counter);
        } else {
            System.out.printf("%s#%s\t%s\t%s\n", lastWord, lastDocNum, lastTf, counter);
        }
    }
}
