package com.metanit;

import java.io.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try {

            Stream<String> text = readFromFile("C:\\Users\\USER\\IdeaProjects\\task47\\data\\input_task47.txt");
            int count = getWordCount(text);
            System.out.println(count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static Stream<String> readFromFile(String path) throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "UTF-8"));
        return reader.lines();

    }

    public static int getWordCount(Stream<String> stream) {
        final int[] count = {0};
        stream.forEach(p -> {
            count[0] += p.split("\\s").length;
        });
        return count[0];
    }


    }

