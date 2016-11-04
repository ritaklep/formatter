package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * this is formatter interface
 */
public class form implements IFormat {
    /**
     * this is list of chars
     */
    private static List<Character> chars = new ArrayList<>();
    @Override
    public void readFile() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(new File("/home/rita/IdeaProjects/format/docs/name.java")));
                int c;
                while ((c = reader.read()) != -1) {
                    chars.add((char) c);
                }
                reader.close();

            } catch (IOException ex) {
                ex.printStackTrace();


            } finally {

                if (reader != null) {
                    try {
                        reader.close();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

    }

    @Override
    public void writeFile() {
        int n = chars.size();
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("/home/rita/IdeaProjects/format/docs/u.java")))) {
            for (int i = 0 ; i < n; i++) {
                if ((chars .get(i) == '{') && (chars.get(i) == ';')) {
                    printWriter.print(chars.get(i));
                    printWriter.print("\n");

                } else {
                    printWriter.print(chars.get(i));
                }
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
