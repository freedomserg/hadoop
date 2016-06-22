package net.syrotskyi.projects.relationalFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reducer {

    public void union() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String lastKey = "";

        while (input != null && !"".equals(input)) {
            String[] pair = input.split("\t");
            String key = pair[0];

            if (lastKey.equals(key) || "".equals(lastKey)) {
                lastKey = key;
                input = reader.readLine();
            } else if (!lastKey.equals("")) {
                System.out.println(lastKey);
                lastKey = key;
                input = reader.readLine();
            }
        }
        System.out.println(lastKey);
    }

    public void intersection() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String lastKey = "";
        int counter = 0;

        while (input != null && !"".equals(input)) {
            String[] pair = input.split("\t");
            String key = pair[0];

            if (!lastKey.equals("") && lastKey.equals(key)) {

                if (counter == 0) {
                    System.out.println(lastKey);
                    lastKey = key;
                    counter++;
                }
                input = reader.readLine();

            } else {
                counter = 0;
                lastKey = key;
                input = reader.readLine();
            }
        }
    }

    public void difference() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String lastKey = "";
        String lastValue = "";
        String beforeLastKey = "";

        while (input != null && !"".equals(input)) {
            String[] pair = input.split("\t");
            String key = pair[0];
            String value = pair[1];

            if (!lastKey.equals(key)) {
                if (!beforeLastKey.equals(lastKey) && "A".equals(lastValue)) {
                    System.out.println(lastKey);
                }
            }
            beforeLastKey = lastKey;
            lastKey = key;
            lastValue = value;

            input = reader.readLine();
        }

        if (!beforeLastKey.equals(lastKey) && "A".equals(lastValue)) {
            System.out.println(lastKey);
        }
    }

    public void symmetricDifference() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String lastKey = "";
        String lastValue = "";
        String beforeLastKey = "";

        while (input != null && !"".equals(input)) {
            String[] pair = input.split("\t");
            String key = pair[0];
            String value = pair[1];

            if (!lastKey.equals(key)) {
                if (!beforeLastKey.equals(lastKey)) {
                    System.out.println(lastKey);
                }
            }
            beforeLastKey = lastKey;
            lastKey = key;
            lastValue = value;

            input = reader.readLine();
        }

        if (!beforeLastKey.equals(lastKey)) {
            System.out.println(lastKey);
        }
    }

    public void replicatedJoin() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<String> queries = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        String lastUser = "";

        while (input != null && !"".equals(input)) {
            String[] record = input.split("\t");
            String user = record[0];
            String source = record[1].split(":")[0];

            if (!"".equals(lastUser) && !lastUser.equals(user)) {
                for (String query : queries) {
                    for (String url : urls) {
                        System.out.print(lastUser + "\t");
                        System.out.println(query + "\t" + url);
                    }
                }
                queries = new ArrayList<>();
                urls = new ArrayList<>();
            }

            if ("query".equals(source)) {
                String query = record[1].split(":")[1];
                queries.add(query);
                lastUser = user;
            } else {
                String url = record[1].split(":")[1];
                urls.add(url);
                lastUser = user;
            }
            input = reader.readLine();
        }

        if (queries.size() > 0 && urls.size() > 0) {
            for (String query : queries) {
                for (String url : urls) {
                    System.out.print(lastUser + "\t");
                    System.out.println(query + "\t" + url);
                }
            }
        }
    }
}
