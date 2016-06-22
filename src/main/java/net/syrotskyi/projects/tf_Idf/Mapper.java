package net.syrotskyi.projects.tf_Idf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mapper {

    public void mapFirst() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {

            String docNumber = "";
            String text = "";
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == ':') {
                    text = input.substring(input.indexOf(ch) + 1);
                    break;
                }
                if (new String(new char[]{ch}).matches("[0-9]")) {
                    docNumber += ch;
                }
            }

            String clearText = text.replaceAll("\t", " ").replaceAll(":", " ").replaceAll("\\p{P}", "");
            String[] words = clearText.split(" ");

            for (String word : words) {
                if (word.equals("")) {
                    continue;
                }
                System.out.println(word.trim() + "#" + docNumber + "\t1");
            }

            input = reader.readLine();
        }
    }

    public void mapSecond() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String word = record[0];
            String docNum = record[1];
            String tf = record[2];

            System.out.printf("%s\t%s;%s;%s\n", word, docNum, tf, 1);

            input = reader.readLine();
        }
    }
}
